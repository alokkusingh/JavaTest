package alok.test.Callable;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {

	Integer a;
	Integer b;
	Sum(Integer a, Integer b) {
		this.a = a;
		this.b = b;		
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(100);
		return a + b;
	}

}
