package ArraysAndStrings;

/**
 * @author theorist Write an algorithm such that if an element in an MxN matrix
 *         is 0, its entire row and column are set to 0.
 */

class Node {
	int x;
	int y;
	Node below;
	public Node(int x, int y, Node below) {
		super();
		this.x = x;
		this.y = y;
		this.below = below;
	}
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void print() {
		System.out.println("("+x+", "+y+")");
	}
}
class Stack {
	Node top = null;
	int length = 0;
	void push(int x, int y) {
		 Node newTop = new Node(x, y, top);
		 top = newTop;
		 length++;
	}
	Node pop() {
		if(top==null)
			return null;
		Node temp = top;
		top = top.below;
		length--;
		return temp;
	}
}
public class ZeroMatrix {

	static Stack coordZero(int[][] matrix) {
		Stack stack = new Stack();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]==0) {
					stack.push(j, i);
				}
			}
		}
		
		return stack;
	}

	static void extendZero(int [][]matrix, int x, int y, int dx, int dy) {
		if(x<0||y<0||x==matrix[0].length||y==matrix.length) {
			return;
		} else {
			matrix[y][x] = 0;
			extendZero(matrix, x+dx, y+dy, dx, dy);
		}
		
	}
	
	static int[][] matrix(int M, int N){
		int[][] matrix = new int[M][N];
		
		int index = -10;
		for(int i = 0; i < M; i++) {
			for(int j = 0 ; j < N; j++) {
				matrix[i][j] = index%27;
				index++;
			}
		}
		return matrix;
	}
	
	static void print(int[][]matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[][]matrix = matrix(10, 6);
		print(matrix);
		Stack stack = coordZero(matrix);
		while(stack.top!=null) {
			Node node = stack.pop();
			extendZero(matrix, node.x, node.y, 1, 0);
			extendZero(matrix, node.x, node.y, -1, 0);
			extendZero(matrix, node.x, node.y, 0, 1);
			extendZero(matrix, node.x, node.y, 0, -1);
		}
		print(matrix);
		
	}

}
