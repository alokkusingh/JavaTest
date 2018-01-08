package alok.test.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

interface MyInterface {
	void sayHello (final String to, final String msg);
}

class MyClass {
	
	private String title;
	
	MyClass ()
	{
		System.out.println("Non-arg constructor called!");
	}
	
	MyClass (String title)
	{
		super();
		System.out.println("Single arg constructor called!");
		this.title = title;
	}
	
	public void sayHello (final String to, final String msg)
	{
		System.out.println(msg + " " + title + " " + to);
	}
}

public class ReflectionTests {

	public static void main(String[] args) {
		try {
			//Class<?> clazz = Class.forName("alok.test.reflection.MyClass");
			//Object obj = clazz.getDeclaredConstructor(String.class)
			//		.newInstance("Mr");	
			//or
			Object obj = Class.forName("alok.test.reflection.MyClass").getDeclaredConstructor(String.class).newInstance("Mr.");	
			System.out.println(obj.getClass().getName());
			
			Method m = obj.getClass().getDeclaredMethod("sayHello", String.class, String.class);
			System.out.println(m.getName() + " " + m.getParameterTypes() + " " + m.getReturnType());
			
			m.invoke(obj, "Alok Singh", "Hello,");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
