public class Basic_algo {
public int multiplicative_inverse(int m, int b)
{
int A[]={1,0,m}, B[]={0,1,b};
int Q,T[]=new int[3];
while(true)
{
if(B[2]==0)
{
System.out.println("gcd("+b+","+m+") = "+A[2]+"\n");
return -1;
} if(B[2]==1)
{
System.out.println("gcd("+b+","+m+") = "+B[2]+"\n");
if(B[1]<0)
B[1]=B[1]+m;
return B[1];
}
Q = A[2]/B[2];
T[0] = A[0]-(Q*B[0]); T[1] = A[1]-(Q*B[1]); T[2] = A[2]-(Q*B[2]);
A[0] = B[0]; A[1] = B[1]; A[2] = B[2];
B[0] = T[0]; B[1] = T[1]; B[2] = T[2];
}
}
int euclidian_gcd(int a, int b)
{
int r = a%b;
while(r!=0)
{
a=b;
b=r;
r = a%b;
}
return b;
}
int chk_prime(int n)
{
int val=1,i;
for(i=2;i<n;i++)
{
if(n%i==0)
{
val=0;
break;
}
}
return val;
}
int coprime(int a,int b)
{
int gcd = euclidian_gcd(a, b);
if(gcd == 1)
return 1;
else
return 0;
}
}