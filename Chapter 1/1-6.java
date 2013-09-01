/**
 * 
 * @author GGPAUE
 * 
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 *
 */

public class Solution {
	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		for(int i = 0; i < len / 2; i++) {
			for(int j = i; j < len - i - 1; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = matrix[len - i - 1][len - j - 1];
				matrix[len - i - 1][len - j - 1] = matrix[len - j - 1][i];
				matrix[len - j - 1][i] = t;
			}
		}
	}
	
	public static void main(String[] args) {
		int matrix[][] = new int[][] { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		rotate(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
