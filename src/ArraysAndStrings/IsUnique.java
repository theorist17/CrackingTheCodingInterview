package ArraysAndStrings;

/**
 * @author theorist
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

	/**
	 * @param input
	 * @return
	 * 
	 * O(n)
	 */
	static boolean isUnique(String input) {
		boolean[] alphabet = new boolean[26];

		for (int i = 0; i<input.length();i++) {
			int index = input.charAt(i)-'a';
			if (alphabet[index]) {
				return false;
			}
			alphabet[index] = true;
		}
		return true;
	}
	
	/**
	 * @param input
	 * @return
	 * 
	 * O(N^2)
	 */
	static boolean isUniqueNoDS(String input) {
		for(int i = 0; i < input.length() - 1; i++)
			for(int j = i+1; j < input.length() - 1;j++)
				if(input.charAt(i)==input.charAt(j))
					return false;
		
		return true;
	}
	public static void main(String[] args) {
		
		if(isUnique("dfadsf")) 
			System.out.println("True.");
		else 
			System.out.println("False.");
		
		if(isUniqueNoDS("adsf")) 
			System.out.println("True.");
		else 
			System.out.println("False.");
		
	}
}
