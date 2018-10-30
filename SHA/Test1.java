import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Digester
{
	static String hexDigest(String str, String digestName)
     	{
        	try
        	{
            		MessageDigest md = MessageDigest.getInstance(digestName);
            		byte[] digest = md.digest(str.getBytes(StandardCharsets.UTF_8));
            		char[] hex = new char[digest.length * 2];
            		for (int i = 0; i < digest.length; i++) 
            		{
                		hex[2 * i] = "0123456789abcdef".charAt((digest[i] & 0xf0) >> 4);
                		hex[2 * i + 1] = "0123456789abcdef".charAt(digest[i] & 0x0f);
            	
            		}
            		System.out.println(hex);
          		return new String(hex);
        	} 
        	catch (NoSuchAlgorithmException e) 
        	{
            		throw new IllegalStateException(e);
        	}
    }
    
}



public class Test1
{     
	public static void main(String[] args)
	{
		String path = "/home/dell/Desktop"; 
    		String file = "abc"; 
      		try
      		{
      			FileInputStream in = new FileInputStream(path + "/" + file);
      			BufferedReader br = new BufferedReader(new InputStreamReader(in));
      			String strLine; 
      			while((strLine = br.readLine())!= null)
      			{ 
      				Digester obj = new Digester();
      				obj.hexDigest(strLine, "SHA-1");
      
     			}
      		}
      		catch(Exception e)
      		{
       			System.out.println(e);
      		}       
	}  
}
