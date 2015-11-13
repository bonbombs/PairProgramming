package converter;

import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class test extends TestCase{
    
    //Test Roman numerals
    //test the biggest number
    public ExpectedException thrown = ExpectedException.none();
    public void test1() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "ZZZQMMMDCCCLXXXVIII";
        int d1 = 38888;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    //test the empty string
    public void test2() throws MalformedNumberException, ValueOutOfBoundsException{
        String s = "";
        RomanArabicConverter convert = new RomanArabicConverter(s);
        thrown.expect(MalformedNumberException.class);
        convert.toArabic();
    }
    //test with white space
    
    //test small numbers
    public void test3() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "VI";
        int d1 = 6;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    public void test4() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "XXXIV";
        int d1 = 34;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    public void test5() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "XC";
        int d1 = 90;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    //test big numbers
    public void test6() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "";
        int d1 = 0;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    public void test7() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "";
        int d1 = 0;
        RomanArabicConverter convert = new RomanArabicConverter(s1);
        assertEquals(convert.toArabic(), d1);
    }
    
    //Test Arabic to Roman
    public void test8() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "VI";
        String d1 = "6";
        RomanArabicConverter convert = new RomanArabicConverter(d1);
        assertEquals(convert.toRoman(), s1);
    }
    public void test9() throws MalformedNumberException, ValueOutOfBoundsException{
        String s1 = "";
        String d1 = "";
        RomanArabicConverter convert = new RomanArabicConverter(d1);
        assertEquals(convert.toArabic(), s1); 
    }
}