package ArraysAndStrings;

/**
 * @author theorist
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end
 * to hold the additional characters, and that you are given
 * the "true" length of the string. (Note: If implementing in Java,
 * please use a character array so that you can perform 
 * this operation in place. Don't use String related type) 
 * 
 * EXAMPLE
 * Input: "Mr John Smith   ", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {
	static char[] replaceSpaces(char[] input, int length) {
		int spaceNo = 0;
		for (int i =0; i< length; i++) {
			if(input[i] == 0x20)
				spaceNo++;
		}
		
		char[] output = new char[spaceNo*2 + length];
		
		int overhead = 0;
		for (int i = 0; i < input.length; i++) {
			if(input[i] == 0x20) {
				output[i+(overhead++)] = '%';
				output[i+(overhead++)] = '2';
				output[i+(overhead)] = '0';
			} else {
				output[i+overhead] = input[i];
			}
		}
		
		return output;
	}
	public static void main(String[] args) {
		System.out.println(replaceSpaces("Mr John Smith   ".toCharArray(), 13));
		
	}
	
//	static String replaceSpaces(String input, int length) {
//	char[] array = input.toCharArray();
//	StringBuilder sb = new StringBuilder();
//	for(int i = 0; i < length; i++) {
//		if (array[i] == 0x20) {
//			sb.append("%20");
//		} else {
//			sb.append(array[i]);
//		}
//	}
//	return sb.toString();
//}


}
