package stream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Recovery {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Address addr = null;
		
		try {
			fis = new FileInputStream("address.txt");
			ois = new ObjectInputStream(fis);
			while(true) {
				addr = (Address)ois.readObject();
				System.out.println(addr.getMobile() + " | " + addr.getAddress());
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
				fis.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
