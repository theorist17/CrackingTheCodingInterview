package ArraysAndStrings;

/**
 * @author theorist
 * Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image
 * by 90 degrees. Can you do this in place.
 */
public class RotateMatrix {

	static int[][][] clockwise (int[][][] matrix){
		int length = matrix.length;
		int[][][] output = new int[length][length][];
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				output[j][length-1-i] = matrix[i][j];
			}
		}
		return output;
	}
	
	static int[][][] anticlock (int[][][] matrix){
		int length = matrix.length;
		int[][][] output = new int[length][length][];
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				output[length-1-j][i] = matrix[i][j];
			}
		}
		return output;
	}
	
	
	static void print(int[][][]matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix.length; j++) {
				System.out.print(matrix[i][j][1]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int[][][] matrix(int N){
		int[][][] matrix = new int[N][N][4];
		
		int index = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				for (int k = 0 ; k<4; k++) {
					matrix[i][j][k] = index;
				}
				index++;
			}
		}
		return matrix;
	}
	public static void main(String[] args) {
		int[][][]matrix = matrix(4);
		print(matrix);
		matrix = clockwise(matrix);
		print(matrix);
		matrix = anticlock(matrix);
		matrix = anticlock(matrix);
		print(matrix);
	}
//	a b c d		d h l p
//	e f g h		c g k o
//	i j k l		b f j n
//	m n o p		a e i m
//	
//	m i e a
//	n j f b
//	o k g c
//	p l h d
	
	
}
