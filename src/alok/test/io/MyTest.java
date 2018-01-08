package alok.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class MyTest {

	public static void main(String[] args) {
		//try (OutputStream os = new FileOutputStream("MyFile.txt")) {
		try (OutputStream os = new BufferedOutputStream(new FileOutputStream("MyFile.txt"))) {
			byte[] data = (new String("alok singh")).getBytes();
			os.write(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Write completed!");
		
		//try (InputStream is = new FileInputStream("MyFile.txt")) {
		try (InputStream is = new BufferedInputStream(new FileInputStream("MyFile.txt"))) {
			/*byte[] data =  new byte[100];
			while(is.read(data) != -1) {
				System.out.println(Arrays.toString(data));
			}*/
			
			byte b;
			while((b = (byte) is.read()) != -1) {
				System.out.print(b);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
