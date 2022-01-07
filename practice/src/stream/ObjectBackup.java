package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream; //serialize objects

public class ObjectBackup {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("address.txt", false);
			out = new ObjectOutputStream(fos);
			Address addr = new Address("510-000-0000", "Jersey City, NJ");
			out.writeObject(addr);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				out.close();
				fos.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
