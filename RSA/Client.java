
import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Client
{
static int phi,M,n,e,C;
static int d = 0;
public static void decrypt(int d,int n,int C)
{
int i;
M = 1;
for(i=0;i<d;i++)
M = M * C % n;
M = M % n;
System.out.println("\nDecrypted message : " + M);
}
static int modInverse(int a, int m)
{
int m0 = m;
int y = 0, x = 1;
if (m == 1)
return 0;
while (a > 1)
{
int q = a / m;
int t = m;
m = a % m;
a = t;
t = y;
y = x - q * y;
x = t;
}
if (x < 0)
x += m0;
return x;
}
public static void main(String[] args)
{
try
{
Socket client = new Socket("localhost",1234);
OutputStream outToServer = client.getOutputStream();
ObjectOutputStream out = new ObjectOutputStream(outToServer);

InputStream inFromServer = client .getInputStream();
ObjectInputStream in = new ObjectInputStream(inFromServer);
System.out.println("Connected to server");
Client gc = new Client();
Scanner sc = new Scanner(System.in);
int p=0,q=0;
System.out.print("Enter two prime numbers p and q :");
p = sc.nextInt();
q = sc.nextInt();
n = p * q;
phi = (p-1) * (q-1);
System.out.print("Enter e which is a prime number less than phi " + phi + ":");

e = sc.nextInt();
System.out.println("Public Key : "+"(" + e +"," + n + ")");
out.writeObject(e);
out.writeObject(phi);
out.writeObject(n);
d = modInverse(e,phi);
System.out.println("Private Key : "+"(" + d +"," + n + ")");
C = (int)in.readObject();
System.out.println("Encrypted message received: " + C);
gc.decrypt(d,n,C);
}
catch(Exception e)
{
e.printStackTrace();
}
}
}