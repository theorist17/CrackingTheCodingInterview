package ArraysAndStrings;

/**
 * @author theorist
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (e.g., "waterbottlewaterbottle" is
 * a rotation of "erbottlewat").
 */
public class StringRotation {

	public static boolean isSubstring(String s1, String s2) {
		if(s2.contains(s1))
			return true;
		else
			return false;
	}
	public static boolean isRotation(String s1, String s2) {
		if(isSubstring(s1, s2+s2))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		
		System.out.println(isSubstring("abc", "xyzabcdef"));
		System.out.println(isRotation("waterbottle", "erbottlewat"));
		
	}

}
