package soc;
//javac --add-modules java.xml.bind

import java.nio.file.*;
import java.security.MessageDigest;


public class Test1
{
	public static void main(String[] args)
	{
		
		try
		{
			
			String str = ""; 
			str = new String(Files.readAllBytes(Paths.get("C:/Users/HP/Desktop/input.txt"))); 
			
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] digest = md.digest(str.getBytes());

			System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(digest));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
