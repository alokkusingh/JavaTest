package alok.test.random;

import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
        System.out.println("-- Running Tests: StringTestsTest::getStringLexicographicallySorted");
        assertEquals("onethreetwo", StringTests.getStringLexicographicallySorted("one", "two", "three"));
        assertEquals("onetwo", StringTests.getStringLexicographicallySorted("one", "two", null));
        assertEquals("onethree", StringTests.getStringLexicographicallySorted("one", null, "three"));
        assertEquals("threetwo", StringTests.getStringLexicographicallySorted(null, "two", "three"));
    }

    @Test
    void revNumber() {
        System.out.println("-- Running Tests: StringTestsTest::revNumber");
        assertEquals(321, StringTests.revNumber(123));
        assertEquals(204, StringTests.revNumber(402));
        assertEquals(402, StringTests.revNumber(204));
        assertEquals(1, StringTests.revNumber(100));
        assertEquals(0, StringTests.revNumber(0));
        assertEquals(-1, StringTests.revNumber(-1));
        assertEquals(-321, StringTests.revNumber(-123));
    }
}