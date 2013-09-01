/**
 * 
 * @author GGPAUE
 * 
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 * 
 */

public class Solution {
	public static void setZero(int[][] matrix, int m, int n) {
		boolean[] row = new boolean[m];
		boolean[] column = new boolean[n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i = 0; i < m; i++) {
			if(row[i]) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for(int j = 0; j < n; j++) {
			if(column[j]) {
				for(int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int m = 5;
		int n = 5;
		int matrix[][] = new int[][] { {1, 2, 3, 4, 0}, {6, 7, 8, 9, 10}, {11, 0, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		setZero(matrix, m, n);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
