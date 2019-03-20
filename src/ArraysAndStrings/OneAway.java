package ArraysAndStrings;

/**
 * @author theorist There are three types of edits that can be performed on
 *         strings: insert a character, remove a character, or replace a
 *         character. Given two strings, write a function to check if they are
 *         one edit (or zero edits) away
 * 
 *         EXAMPLE pale, ple -> true pales, pale -> true pale, bale -> true ple,
 *         pale -> true pale, bake -> false pala, pale
 */

public class OneAway {
	/*
	 * if length = length if wrong if cur ch = next tar ch add remove else if next
	 * ch = next tar ch
	 * 
	 */

	static boolean isOneEdit(String left, String right) {
		// add
		if (left.length() < right.length()) {
			for (int i = 0; i < left.length(); i++) {
				if (left.charAt(i) != right.charAt(i))
					if (left.substring(i).equals(right.substring(i + 1)))
						return true;
					else
						return false;
			}
		}

		// replace
		if (left.length() == right.length()) {
			for (int i = 0; i < left.length(); i++) {
				if (left.charAt(i) != right.charAt(i))
					if (left.substring(i + 1).equals(right.substring(i + 1)))
						return true;
					else
						return false;
			}
			return true;
		}

		// remove
		if (left.length() > right.length()) {
			for (int i = 0; i < right.length(); i++) {
				if (left.charAt(i) != right.charAt(i))
					if (left.substring(i + 1).equals(right.substring(i)))
						return true;
					else
						return false;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		if(isOneEdit("pale", "ple"))
			System.out.println("True.");
		else
			System.out.println("False.");
		

	}

}
