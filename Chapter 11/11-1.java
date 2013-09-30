/*
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 * 
 */

public class Solution {
	public static void merge(int[] A, int m, int[] B, int n) {
		int k = m + n - 1;
		int aIndex = m - 1;
		int bIndex = n - 1;
		
		while(aIndex >= 0 && bIndex >= 0) {
			if(A[aIndex] > B[bIndex]) {
				A[k] = A[aIndex];
				aIndex--;
			} else {
				A[k] = B[bIndex];
				bIndex--;
			}
			k--;
		}
		
		while(bIndex >= 0) {
			A[k] = B[bIndex];
			bIndex--;
			k--;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {3, 7, 20, 25, 0, 0, 0, 0, 0};
		int[] B = {1, 2, 6, 10, 16, 30};
		merge(A, 3, B, B.length);
		for(int x : A) {
			System.out.print(x + ", ");
		}
	}

}
