package alok.test.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Base {
	public int x;
	
	Base() {
		System.out.println("Base constructor called");
	}
	
	Base(int x) {
		System.out.println("Base param constructor called");
		this.x = 10;
	}
}

class Derive extends Base implements Serializable {
	Derive() {
		System.out.println("Derive constructor called");
	}
	
	Derive(int x) {

		super(x);
		System.out.println("Derive param constructor called");
	}
	

}


public class SerializableTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("SerializableTest.file");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Base obj = new Derive(10);
		System.out.println(obj.x);
		oos.writeObject(obj);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		obj = (Derive) ois.readObject();
		
		System.out.println(obj.x);
		
		
	}

}
