package alok.test.random;

import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringTestsTest {

    @org.junit.jupiter.api.Test
    void getLongestUniqueSubString() {
        System.out.println("-- Running Tests: StringTestsTest::getLongestUniqueSubString");

        new MockUp<StringTests>() {
            @Mock
            public void meStatic() {
                System.out.println("Alok - meStatic() mock called");
            }
        };

        assertEquals(7, StringTests.getLongestUniqueSubString("alokkumar"));
        assertEquals(0, StringTests.getLongestUniqueSubString(""));
        assertEquals(0, StringTests.getLongestUniqueSubString(null));
    }

    @Test
    void getStringLexicographicallySorted() {
        System.out.println("-- Running Tests: StringTestsTest::getStringLexicographicallySorted" );
        assertEquals("onethreetwo", StringTests.getStringLexicographicallySorted("one", "two", "three"));
        assertEquals("onetwo", StringTests.getStringLexicographicallySorted("one", "two", null));
        assertEquals("onethree", StringTests.getStringLexicographicallySorted("one", null, "three"));
        assertEquals("threetwo", StringTests.getStringLexicographicallySorted(null, "two", "three"));
    }
}