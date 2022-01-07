package stream;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Recovery {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		BufferedInputStream bis = null;
		Address addr = null;
		
		try {
			fis = new FileInputStream("address.txt");
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
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
				bis.close();
				fis.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
