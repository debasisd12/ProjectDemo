package com.pra.Exception;

public class stringToNumberWithoutMethod {
	public static int convert_String_To_Number(String numStr) {
		char ch[] = numStr.toCharArray();
		int sum = 0;
		
		//get ascii value for zero
		int zeroAscii = (int)'0';
		System.out.println("zeroAscii----"+zeroAscii);
		
		for (char c:ch) {
			System.out.println("char of each string-"+c);
			int tmpAscii = (int)c;
			
			sum = (sum*10)+(tmpAscii-zeroAscii);
		}
		return sum;
	}
	public static void main(String[] args) {

		System.out.println("\"3256\" == "+convert_String_To_Number("3256"));
		System.out.println("\"76289\" == "+convert_String_To_Number("76289"));
		System.out.println("\"90087\" == "+convert_String_To_Number("90087"));
	}

}
