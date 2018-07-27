package alok.test.random;


import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TestJunit extends TestCase {
   	
   @Test
   public void testIsValidFormat() {
      assertTrue(ValidateBrackets.isValidFormat("{{[a]()}}"));
      assertTrue(ValidateBrackets.isValidFormat("{{[a]()}}{}(){{[]}}"));
      assertFalse(ValidateBrackets.isValidFormat("{{[a()}}"));
      assertFalse(ValidateBrackets.isValidFormat("}}}}})]"));
   }
}