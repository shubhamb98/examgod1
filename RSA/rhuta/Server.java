	import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
static long encrypt(int e, int n)
{
Scanner s1 = new Scanner(System.in);
System.out.println("Enter plain text: ");
long m = s1.nextInt();
long c=1;
int i=e;
for(;i!=0;i--)
{
c=c*m;
c=c%n;
}
return c;
}
public static void main(String[] args) {
try {
Socket receiver = new Socket("localhost",1234);
OutputStream outToServer = receiver.getOutputStream();
ObjectOutputStream out = new ObjectOutputStream(outToServer);
InputStream inFromServer = receiver .getInputStream();
ObjectInputStream in = new ObjectInputStream(inFromServer);
ObjectInputStream in2 = new ObjectInputStream(inFromServer);
int e = (int)in.readObject();
int n = (int)in.readObject();
System.out.println("Public key received e ="+e);
long c = encrypt(e,n);
System.out.println("Sending encrypted message c ="+c);
out.writeObject(c);
System.out.println("Encrypted message sent");
} catch(Exception ex)
{
ex.printStackTrace();
}
}
}