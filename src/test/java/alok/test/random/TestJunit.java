package alok.test.random;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJunit {
   	
   @Test
   public void testIsValidFormat() {
      assertTrue(ValidateBrackets.isValidFormat("{{[a]()}}"));
      assertTrue(ValidateBrackets.isValidFormat("{{[a]()}}{}(){{[]}}"));
      assertFalse(ValidateBrackets.isValidFormat("{{[a()}}"));
      assertFalse(ValidateBrackets.isValidFormat("}}}}})]"));
   }
}