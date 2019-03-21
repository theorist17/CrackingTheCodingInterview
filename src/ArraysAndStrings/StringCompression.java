package ArraysAndStrings;

import java.io.CharArrayWriter;


/**
 * @author theorist Implement a method to perform basic string compression using
 *         the counts of repeated characters. For example, the string
 *         aabcccccaaa would become a2b1c5a3. If the "compressed" string would
 *         not become smaller than the original string, your method should
 *         return the original string. You can assume the string has only upper
 *         case and lower case letters (a-z).
 */
public class StringCompression {

	static String compressString(String input) {
		
		char top = ' ';
		int dpl = 0;
		int index = 0;
		char[] output = new char[input.length()];
		
		for(int i = 0 ; i < input.length(); i++) {
			if(top == input.charAt(i)) {
				dpl++;
			} else {
				if(i!=0) {
					output[index++] = top;		
					output[index++] = (char)(dpl+'0');
				}
				top = input.charAt(i);
				dpl = 1;
			}
		}
		
		return String.copyValueOf(output);
		
	}

	public static void main(String[] args) {
		System.out.println(compressString("aabcccccaaa"));
	}

}
