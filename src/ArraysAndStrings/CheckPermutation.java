package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author theorist Given two strings, write a method to decide if one is a
 *         permutation of the other
 */
public class CheckPermutation {

	static void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}

		int pivot = array[(left + right) / 2];
		int index = partition(array, left, right, pivot);

		quickSort(array, left, index - 1);
		quickSort(array, index, right);
	}

	static int partition(int[] array, int left, int right, int pivot) {
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (pivot < array[right]) {
				right--;
			}

			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	static boolean isPermutation(String a, String b) {
		if (a.length()!= b.length())
			return false;
		
		int[] strarr1 = new int[a.length()];
		int[] strarr2 = new int[b.length()];
		for(int i = 0; i< a.length(); i++) {
			strarr1[i] = a.charAt(i);
			strarr2[i] = b.charAt(i);
		}
		quickSort(strarr1, 0, strarr1.length-1);
		quickSort(strarr2, 0, strarr2.length-1);
		
		if(Arrays.equals(strarr1, strarr2))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		if (isPermutation("abcdz", "zabcd"))
			System.out.println("True.");
		else
			System.out.println("False.");
	}

}
