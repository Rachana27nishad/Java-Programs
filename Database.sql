<!DOCTYPE html>
<html>
<head>
<title>HRMS Lite</title>

<style>
:root {
    --bg: #f4f6fb;
    --card: white;
    --text: black;
    --primary: #4CAF50;
    --danger: #f44336;
}

.dark {
    --bg: #121212;
    --card: #1f1f1f;
    --text: white;
}

body {
    font-family: Segoe UI, sans-serif;
    background: var(--bg);
    margin: 0;
    padding: 20px;
    color: var(--text);
}

.container {
    max-width: 1000px;
    margin: auto;
    background: var(--card);
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

h1 { text-align:center; }

input, select {
    padding: 8px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

button {
    padding: 8px 12px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
    background: var(--primary);
    color: white;
}

button:hover { opacity: 0.9; }
.danger { background: var(--danger); }

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

th {
    background: var(--primary);
    color: white;
}

td, th {
    padding: 8px;
    border: 1px solid #ccc;
    text-align: center;
}

#toast {
    position: fixed;
    top: 20px;
    right: 20px;
    padding: 15px;
    border-radius: 5px;
    color: white;
    display: none;
}
.success { background: green; }
.error { background: red; }

#loader {
    display: none;
    text-align: center;
    margin: 10px;
}

#loader span {
    font-size: 18px;
    animation: blink 1s infinite;
}
@keyframes blink {
    0% {opacity:0.2;}
    50% {opacity:1;}
    100% {opacity:0.2;}
}

.topbar {
    display: flex;
    justify-content: space-between;
}

.form-grid {
    display: grid;
    grid-template-columns: repeat(4,1fr);
    gap: 10px;
}
</style>
</head>

<body>
<div id="toast"></div>

<div class="container">
<div class="topbar">
<h1>HRMS Lite</h1>
<button onclick="toggleDark()">🌙 Dark Mode</button>
</div>

<h2>Employee</h2>
<div class="form-grid">
<input id="emp_id" placeholder="Employee ID">
<input id="name" placeholder="Name">
<input id="email" placeholder="Email">
<input id="dept" placeholder="Department">
</div>

<button onclick="addOrUpdate()">Save</button>
<button onclick="clearForm()">Clear</button>

<br><br>
<input id="search" placeholder="Search..." onkeyup="searchEmp()">

<div id="loader"><span>Loading...</span></div>

<table>
<thead>
<tr>
<th>ID</th><th>Name</th><th>Email</th><th>Dept</th><th>Action</th>
</tr>
</thead>
<tbody id="empTable"></tbody>
</table>

<hr>

<h2>Attendance</h2>
<input id="att_emp_id" placeholder="Employee ID">
<input type="date" id="date">
<select id="status">
<option>Present</option>
<option>Absent</option>
</select>
<button onclick="markAttendance()">Mark</button>

<h3>View Attendance</h3>
<input id="view_emp_id" placeholder="Employee ID">
<button onclick="viewAttendance()">View</button>
<ul id="attendanceList"></ul>

</div>

<script>
const API="http://127.0.0.1:5000";
let editMode=false;

function showToast(msg,type){
    let t=document.getElementById("toast");
    t.innerText=msg;
    t.className=type;
    t.style.display="block";
    setTimeout(()=>t.style.display="none",3000);
}

function toggleDark(){
    document.body.classList.toggle("dark");
}

function showLoader(show){
    loader.style.display= show?"block":"none";
}

function clearForm(){
    document.getElementById("emp_id").value="";
    document.getElementById("name").value="";
    document.getElementById("email").value="";
    document.getElementById("dept").value="";
    editMode=false;
}


function addOrUpdate(){
    let emp = document.getElementById("emp_id").value.trim();
    let n   = document.getElementById("name").value.trim();
    let e   = document.getElementById("email").value.trim();
    let d   = document.getElementById("dept").value.trim();

    if(!emp||!n||!e||!d){
        showToast("Please fill all fields","error");
        return;
    }

    let url = API + "/employees";
    let method = "POST";
    let bodyData = {
        emp_id: emp,
        name: n,
        email: e,
        department: d
    };

    if(editMode){
        url = API + "/employees/" + emp;
        method = "PUT";
        bodyData = {
            name: n,
            email: e,
            department: d
        };
    }

    fetch(url,{
        method:method,
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(bodyData)
    })
    .then(r=>r.json())
    .then(d=>{
        showToast(d.message||d.error,d.message?"success":"error");
        loadEmployees();
        clearForm();
    });
}


function loadEmployees(){
    showLoader(true);
    fetch(API+"/employees")
    .then(r=>r.json())
    .then(data=>{
        empTable.innerHTML="";
        data.forEach(e=>{
            empTable.innerHTML+=`
            <tr>
            <td>${e.emp_id}</td>
            <td>${e.name}</td>
            <td>${e.email}</td>
            <td>${e.department}</td>
            <td>
            <button onclick="editEmp('${e.emp_id}','${e.name}','${e.email}','${e.department}')">Edit</button>
            <button class="danger" onclick="confirmDelete('${e.emp_id}')">Delete</button>
            </td>
            </tr>`;
        });
        showLoader(false);
    });
}

function confirmDelete(id){
    if(confirm("Are you sure to delete employee "+id+" ?")){
        deleteEmp(id);
    }
}

function deleteEmp(id){
    fetch(API+"/employees/"+id,{method:"DELETE"})
    .then(r=>r.json())
    .then(d=>{
        showToast(d.message||d.error,d.message?"success":"error");
        loadEmployees();
    });
}

function editEmp(id,n,e,d){
    document.getElementById("emp_id").value=id;
    document.getElementById("name").value=n;
    document.getElementById("email").value=e;
    document.getElementById("dept").value=d;
    editMode=true;
}


function searchEmp(){
    let filter=search.value.toLowerCase();
    let rows=document.querySelectorAll("#empTable tr");
    rows.forEach(r=>{
        r.style.display=r.innerText.toLowerCase().includes(filter)?"":"none";
    });
}

function markAttendance(){
    let emp=att_emp_id.value.trim();
    let dateVal=date.value;
    let stat=status.value;

    if(!emp||!dateVal){
        showToast("Fill all attendance fields","error");
        return;
    }

    fetch(API+"/attendance",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({emp_id:emp,date:dateVal,status:stat})
    })
    .then(r=>r.json())
    .then(d=>showToast(d.message||d.error,d.message?"success":"error"));
}

function viewAttendance(){
    fetch(API+"/attendance/"+view_emp_id.value)
    .then(r=>r.json())
    .then(data=>{
        attendanceList.innerHTML="";
        data.forEach(a=>{
            attendanceList.innerHTML+=`<li>${a.date} - ${a.status}</li>`;
        });
    });
}

loadEmployees();
</script>
</body>
</html>
class MultiLevel
{
void show A(){
System.out.println("A class");
}
}

class B extends MultiLevel
{
void show B()
{
System.out.println("B class");
}
}

class C extends B
{
void show C()
{
System.out.println("C class");
}
public static void main(String[] args)
{

MultiLevel ob = new MultiLevel();
ob.show A(); 
ob.show B();
ob..show C();



B ob1 = new B();
ob1.show A();
ob1.show B();
ob1.show C();



C ob2 = new C();
ob3.show A();
ob3.show B();
ob3.show C();

}
}