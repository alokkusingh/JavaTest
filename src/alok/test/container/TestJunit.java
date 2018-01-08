package alok.test.container;

import org.junit.Test;

import junit.framework.TestCase;

public class TestJunit extends TestCase {
   	
   @Test
   public void testMyClone() {
	   MyHashSet mClass = new MyHashSet();
		
		assertTrue(mClass.runMyClone());
   }
}