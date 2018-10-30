import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Client {
static int p,q,n,phi;
static Basic_algo m1 = new Basic_algo();
public static int public_key_generation(int phi)
{
int e=0,key_chk=1;
Scanner s1 = new Scanner(System.in);
while(key_chk==1)
{
System.out.println("Enter public key : ");
e = s1.nextInt();
if(e<phi && e>1 && m1.euclidian_gcd(e,phi)==1)
{
key_chk=0;
} else
{
System.out.println("Invalid key! Please enter again");
}
}
return e;
}
public static int private_key_generation(int phi, int e)
{
int d=0;
d = m1.multiplicative_inverse(phi, e);
return d;
}
public static long decrypt(long c, int d, int n)
{
long m=1;
int i=d;
for(;i!=0;--i)
{
m=m*c;
m=m%n;
}
return m;
}
public static void main(String[] args) {
// TODO Auto-generated method stub
try {
ServerSocket sc = new ServerSocket(1234);
Socket sender = sc.accept();
OutputStream outToServer = sender.getOutputStream();
ObjectOutputStream out = new ObjectOutputStream(outToServer);
ObjectOutputStream out2 = new ObjectOutputStream(outToServer);
InputStream inFromServer = sender.getInputStream();
ObjectInputStream in = new ObjectInputStream(inFromServer);
System.out.println();
Scanner s1 = new Scanner(System.in);
int e,d;
long m = -1;
int key_chk=1;
while(key_chk==1)
{
System.out.println("Enter first prime no: ");
p = s1.nextInt();
if(m1.chk_prime(p)==1)
{
key_chk=0;
} else
{
System.out.println("Invalid key! Please enter again");
}
}
key_chk=1;
while(key_chk==1)
{
System.out.println("Enter second prime no: ");
q = s1.nextInt();
if(m1.chk_prime(q)==1)
{
key_chk=0;
} else
{
System.out.println("Invalid key! Please enter again");
}
}
n=p*q;
phi = (p-1)*(q-1);
e=public_key_generation(phi);
System.out.println("Public key is :" + e);
d=private_key_generation(phi,e);
System.out.println("Private key is :" + d);
System.out.println("Sending public key...");
out.writeObject(e);
out2.writeObject(n);
System.out.println("Receiving encrypted message...");
long c = (long)in.readObject();
System.out.println("Encrypted Text is : "+c);
m = decrypt(c,d,n);
System.out.println("Plain Text is = "+m);
} catch(Exception ex)
{
ex.printStackTrace();
}
//m=Send.send_func(e, n, d);
}
}