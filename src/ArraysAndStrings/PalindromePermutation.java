package ArraysAndStrings;

/**
 * @author theorist
 * Given a string, write a function to check if it is
 * a permutation of a palindrome. A palindrome is a word or phrase
 * that is the same forwards and backwards. A permutation is a 
 * rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 * 
 * EXAMPLE 
 * Input:	Tact Coa
 * Output: 	True (permutations: "taco cat", "atco cta", etc.)
 */
public class PalindromePermutation {
	
	static boolean isPalindrome(String input) {
		int[] alphabet = new int[26];
		
		for(int i = 0 ; i < input.length(); i++) {
			if(97<=input.charAt(i)&&input.charAt(i)<123)
				alphabet[input.charAt(i)-97]++;
			else if(65<=input.charAt(i)&&input.charAt(i)<91)
				alphabet[input.charAt(i)-97]++;
		}
		
		int oddNo = 0;
		for(int i = 0 ; i < 26; i++) {
			if(alphabet[i]%2==1)
				oddNo++;
		}
		return oddNo==1? true: false;
	}

	public static void main(String[] args) {
		
		if(isPalindrome("ztac tcoaz"))
			System.out.println("True.");
		else
			System.out.println("False");
	}

}
