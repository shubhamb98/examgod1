

import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Server
{
static int phi,M,n,e,C;
public void encrypt()
{
int i;
C = 1;
for(i=0;i<e;i++)
C = C * M % n;
C = C % n;

System.out.println("\nEncrypted message: " + C);
}
public static void main(String [] args)
{
try
{
ServerSocket sc = new ServerSocket(1234);
Socket s = sc.accept();
System.out.println("Connected to client");
Scanner scan = new Scanner(System.in);
OutputStream outToServer = s.getOutputStream();
ObjectOutputStream out = new ObjectOutputStream(outToServer);
InputStream inFromServer = s.getInputStream();
ObjectInputStream in = new ObjectInputStream(inFromServer);
Server gs = new Server();
e = (int)in.readObject();
phi = (int)in.readObject();
int sw = 0;
n=(int)in.readObject();
System.out.println("\n\tPublic Key : " + "(" + e + "," + n + ")");
System.out.print("Enter the plain text : ");
M = scan.nextInt();
gs.encrypt();
out.writeObject(C);
}
catch(Exception e)
{
e.printStackTrace();
}
}
}