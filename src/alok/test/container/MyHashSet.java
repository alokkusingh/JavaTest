package alok.test.container;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class MyClass implements Cloneable {
	String str1;
	int abc;
	int[] intArr = new int[3];

	MyClass(String str, int xyz) {
		str1 = str;
		abc = xyz;
		intArr[0] = 0;
		intArr[1] = 1;
		intArr[2] = 2;
	}

	@Override
	public String toString() {
		return "MyClass [str1=" + str1 + ", abc= " + abc + ", intArr=" + Arrays.toString(intArr) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(intArr);
		result = prime * result + ((str1 == null) ? 0 : str1.hashCode());
		System.out.println("hashCode result: " + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		if (!Arrays.equals(intArr, other.intArr))
			return false;
		if (str1 == null) {
			if (other.str1 != null)
				return false;
		} else if (!str1.equals(other.str1) || abc != other.abc)
			return false;
		
		return true;
	}

	//@Override
	protected Object clone() throws CloneNotSupportedException {
		MyClass clone = (MyClass) super.clone();
		clone.str1 = new String(str1);
		return clone;
	}
	
	
	
}

public class MyHashSet {
	public boolean runMyClone() {
		HashSet<MyClass> setMyClass = new HashSet<MyClass>();
		setMyClass.add(new MyClass("Alok", 1));
		setMyClass.add(new MyClass("Singh", 2));
				
		System.out.println(setMyClass);
		
		HashSet<MyClass> setMyClassClone = (HashSet<MyClass>) setMyClass.clone();
		System.out.println(setMyClassClone);
		
		//setMyClass.add(new MyClass("Singh", 3));
		//System.out.println(setMyClass);
		//System.out.println(setMyClassClone);
		
		Iterator<MyClass> itr = setMyClass.iterator();
		while(itr.hasNext()) {
			MyClass mClass = itr.next();
			System.out.println(mClass);
			if (mClass.abc==2)
				mClass.abc = 3;
		}
		
		System.out.println(setMyClass);
		System.out.println(setMyClassClone);
		
		MyClass mClass = new MyClass("India", 1);
		MyClass cloneClass = null;
		System.out.println(mClass);
		try {
			cloneClass = (MyClass) mClass.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cloneClass);
		
		mClass.abc = 2;
		System.out.println(mClass);
		System.out.println(cloneClass);
		
		return true;
	}

	
}
