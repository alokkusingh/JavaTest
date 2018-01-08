package alok.test.clone;

class Base implements Cloneable {
	public String str;
	Base() {
		str = "Alok";
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Derive extends Base  {
	public int x;
	public String str2;
	
	Derive() {
		super();
		x = 10;
		str2 = "Singh";
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setStr2(int x) {
		this.x = x;
	}
	
	public Derive clone() throws CloneNotSupportedException {
		return (Derive) super.clone();
	}

	@Override
	public String toString() {
		return "Derive [x=" + x + ", str=" + str + ", str2=" + str2 +"]";
	}
}

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Derive d = new Derive();
		
		Derive cloned = d.clone();
		cloned.setX(20);
		System.out.println(cloned);
		System.out.println(d);
	}
	
}
