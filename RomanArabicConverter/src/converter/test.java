package converter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class test extends TestCase{
	@Rule
	  public final ExpectedException thrown = ExpectedException.none();
    
    //Test Roman numerals
    //test the biggest number
	@Test
    public void test1() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "ZZZQMMMDCCCLXXXVIII";
        int d1 = 38888;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    //test the empty string
	@Test
    public void test2() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "";
        thrown.expect(MalformedNumberException.class);
        RomanArabicConverter convert = new RomanArabicConverter(s);
        convert.toArabic();
    }
    //test with white space
    
    //test small numbers
	@Test
    public void test3() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "VI";
        int d1 = 6;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
	@Test
    public void test4() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "XXXIV";
        int d1 = 34;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
	@Test
    public void test5() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "XC";
        int d1 = 90;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    //test big numbers
	@Test
    public void test6() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "";
        int d1 = 0;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    //Test Arabic to Roman
	@Test
    public void test7() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "VI";
        String d1 = "6";
        RomanArabicConverter convert = new RomanArabicConverter(d1);
        assertEquals(convert.toRoman(), s1);
    }
    @Test
    public void test8() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "";
        String d1 = "";
        thrown.expect(MalformedNumberException.class);
        RomanArabicConverter convert = new RomanArabicConverter(d1);
    }
}