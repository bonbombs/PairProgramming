package converter;
import java.util.Scanner;
import java.util.HashMap;

/**
 * This class implements a converter that takes a string that represents a
 * number in either Arabic or Roman numeral form and offers methods that will
 * return either the integer value or a string representing the value in Roman
 * numeral form.
 * 
 * @version Nov 6, 2015
 */
public class RomanArabicConverter {
    public static String s;
    private static HashMap<Character,Integer> dictionary;
    
	public static void main(String args[]) throws MalformedNumberException, ValueOutOfBoundsException{
		 
		 
		
	      Scanner in = new Scanner(System.in);
	 
	      System.out.println("Enter a string");
	      s = in.nextLine();
	      
	      
	      RomanArabicConverter a = new RomanArabicConverter(s);
	      
	}
    /**
     * Constructor that takes in a string. The string should contain either a
     * valid Roman numeral or a valid Arabic numeral. The string can have
     * leading and/or trailing spaces. There are no spaces within the actual
     * number characters. If the string represents an Arabic number, it may be
     * positive or negative. It will never be larger than a value that can fit
     * into an int.
     * 
     * @param value The string representing the Roman or Arabic number.
     * @throws MalformedNumberException if the string (less leading and trailing
     *             spaces) does not represent a valid Roman or Arabic number.
     * 
     *             NOTE: an Arabic number may be out of the acceptable range and
     *             will still be accepted by this constructor.
     * @throws ValueOutOfBoundsException 
     */
    public RomanArabicConverter(String value) throws MalformedNumberException, ValueOutOfBoundsException {
    	boolean isArabic = true;
    	value = value.trim();
    	String convertedValue;
    	int arabicValue;
    	dictionary = new HashMap<Character, Integer>();
    	BuildDictionary(dictionary);
    	s = value;
    	try{
    		Integer.parseInt(value);
    	
    	} catch(NumberFormatException e){
    		isArabic = false;
    	}
    	//if Roman
    	if (isArabic != true){
    		arabicValue = toArabic();
    		System.out.printf("The converted Arabic number is: %d \n",arabicValue);
    	}else{
    	//if Arabic
    		convertedValue = toRoman();
    		System.out.printf("The converted Roman Numeral is: %s \n",convertedValue);
    	}	
    }

    /**
     * Returns the value of this object as an Arabic number.
     * 
     * @return The integer value of the number
     */
    public int toArabic() throws MalformedNumberException{
    	String value = s;
    	int num = 0;
    	char[] vArray = value.toCharArray();
    	int result = 0;
    	//Check if valid Roman numeral
    	for(int i = 0; i < vArray.length; i++){
    		if(dictionary.containsKey(vArray[i])){
    			result++;
    		}
    	}
    	if(result > 0 && result < vArray.length){
    		throw new MalformedNumberException("Not a valid input!");
    	} else {
    		int qCt = 0, dCt = 0, lCt = 0, vCt = 0;
			int zCt = 0, mCt = 0, cCt = 0, xCt = 0, iCt = 0;
    		//Valid Roman Numeral
			int prev = 0;
			int current = dictionary.get(vArray[0]);
    		for(int i = 0; i < vArray.length; i++){
    			current = dictionary.get(vArray[i]);
    			//System.out.printf("current: %d, prev: %d", current, prev);
    			num = num + dictionary.get(vArray[i]);
    			switch (vArray[i]){
    			case 'Q': qCt++;
    				break;
    			case 'D': dCt++;
    				break;
    			case 'L': lCt++;
    				break;
    			case 'V': vCt++;	
    				break;
    			case 'Z': zCt++;
    			if (zCt > 1){
					if (prev != 10000 && prev != 1000) 
						throw new MalformedNumberException("Not a valid input");
				}
					break;
    			case 'M': mCt++;
    			if (mCt > 1){
					if (prev != 1000 && prev != 100) 
						throw new MalformedNumberException("Not a valid input");
				}
					break;
    			case 'C': cCt++;
	    			if (cCt > 1){
						if (prev != 100 && prev != 10)
							throw new MalformedNumberException("Not a valid input");
					}
	    				break;
    			case 'X': xCt++;
	    			if (xCt > 1){
						if (prev != 10 && prev != 1) {
							throw new MalformedNumberException("Not a valid input");
						}
					}
					break;
    			case 'I': iCt++;
    				if (iCt > 1){
    					if (prev != 1) throw new MalformedNumberException("Not a valid input");
    				}
					break;
    			default:
    					break;
    			}
  
    			if (prev < current){
    				num = num - 2*prev;
    			}
    			if(qCt > 1 || dCt > 1 || lCt > 1 || vCt > 1){
    				throw new MalformedNumberException("Not a valid input");
    			}else if (zCt > 3 || mCt > 3 || cCt > 3 || xCt > 3 || iCt > 3 ){
    				throw new MalformedNumberException("Not a valid input: a letter cannot be repeated more than three times!");
    			}
    			if (i != 0) {
	    			if (prev < current){
	    				if (prev*1.0 / current*1.0 != 0.1 && prev*1.0 / current*1.0 != 0.2){
	    					throw new MalformedNumberException("Not a valid input");
	    				}
	    			}
    			}
    			
    			prev = current;
    			
    		}//end for loop
    	return num;
    	}
    	

    }

    /**
     * Returns the value of this object as a Roman Numeral
     * 
     * @return
     * @throws ValueOutOfBoundsException if the number is too small or too large
     *             to be represented using Roman numerals
     */
    public String toRoman() throws ValueOutOfBoundsException {
    	String s1 = s;
    	char[] vArray = s.toCharArray();
    	int len = vArray.length;
    	int current = Integer.parseInt(s1);
    	String roman = "";
    	int i,j;
    	
    	if(current < 0) throw new ValueOutOfBoundsException("Invalid Input: Value cannot be negative");
    	if(current > 38888) throw new ValueOutOfBoundsException("Invalid Input: Exceeds the maximum value.");

    	for (i=0;i<len;i++){
    		int x = Character.getNumericValue(vArray[i]);
    		//System.out.printf("i= %d \n", i);
    		//System.out.printf("x= %d \n", x);
	    	switch(len-i){
	    	case 5:
	    		if (x == 3){
	    			roman = roman.concat("ZZZ");	    		
	    		}else if (x == 2){
	    			roman = roman.concat("ZZ");
	    		}else roman = roman.concat("Z");
	    		break;
	    	case 4:
	    		if (x < 4){
	    			for (j=0;j<x;j++)
	    				roman = roman.concat("M");
	    		}else if (x <= 8){
	    			if (x == 4)
	    				roman = roman.concat("MQ");
	    			else
	    			{
	    				roman = roman.concat("Q");
	    				for (j=0;j<x-5;j++)
	    					roman = roman.concat("M");
	    			}
	    		}else{
	    			roman = roman.concat("MZ");
	    		}
	    		break;
	    	case 3:  
	    		if (x < 4){
	    			for (j=0;j<x;j++)
	    				roman = roman.concat("C");
	    		}else if (x <= 8){
	    			if (x == 4)
	    				roman = roman.concat("CD");
	    			else
	    			{
	    				roman = roman.concat("D");
	    				for (j=0;j<x-5;j++)
	    					roman = roman.concat("C");
	    			}
	    		}else{
	    			roman = roman.concat("CM");
	    		}
	    		break;
	    	case 2:
	    		if (x < 4){
	    			for (j=0;j<x;j++)
	    				roman = roman.concat("X");
	    		}else if (x <= 8){
	    			if (x == 4)
	    				roman = roman.concat("XL");
	    			else
	    			{
	    				roman = roman.concat("L");
	    				for (j=0;j<x-5;j++)
	    					roman = roman.concat("X");
	    			}
	    		}else{
	    			roman = roman.concat("XC");
	    		}
	    		break;
	    	case 1:
	    		if (x < 4){
	    			for (j=0;j<3;j++)
	    				roman = roman.concat("I");
	    		}else if (x <= 8){
	    			if (x == 4)
	    				roman = roman.concat("IV");
	    			else
	    			{
	    				roman = roman.concat("V");
	    				for (j=0;j<x-5;j++)
	    					roman = roman.concat("I");
	    			}
	    		}else{
	    			roman = roman.concat("IX");
	    		}
	    		break;
	    	default:  
	    		break;
	    	}

    
    	}
    	return roman;
    }
    
    private static void BuildDictionary(HashMap<Character, Integer> dictionary){
    	dictionary.put('Z', 10000);
    	dictionary.put('Q', 5000);
    	dictionary.put('M', 1000);
    	dictionary.put('D', 500);
    	dictionary.put('C', 100);
    	dictionary.put('L', 50);
    	dictionary.put('X', 10);
    	dictionary.put('V', 5);
    	dictionary.put('I', 1);
    	
    }
}

