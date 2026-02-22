class BinarySearch
{
public static void main(String[] args)
{
int start=0;
int end = size-1;


while(star <= end)
{
int mid = start+(end-start)/2;

if(element == arr[mid])
{
return mid;
}
else if(element < arr[mid])
{
end = mid-1;
}
else 
{
start = mid+1;
}
}
return -1;
}
}