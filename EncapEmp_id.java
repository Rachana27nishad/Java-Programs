class EncapEmp_id
{
private int empid;
public void setEmpid(int eid)
{
empid = eid;
}
public int getEmpid()
{
return empid;
}
}
class Company
{
public static void main(String[] args)
{
EncapEmp_id e = new EncapEmp_id();
e.setEmpid(101);
System.out.println(e.getEmpid());
}
}