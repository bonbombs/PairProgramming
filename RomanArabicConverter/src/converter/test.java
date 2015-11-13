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
		String s1 = "ZZZQMMMDCCCLXXXVIII";
		int d1 = 38888;
		RomanArabicConverter convert = new RomanArabicConverter(s1);
		assertEquals(convert.toArabic(), d1); 
	}
	//test big numbers
	
	//Test
}
