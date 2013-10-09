/**
 * 
 * @author GGPAUE
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 * 
 */

public class Solution {
	public static int updateBits(int n, int m, int i, int j) {
		if(i >= 32 || j < i) return n;
		int max = ~0;
		int left = max - ((1 << (j + 1)) - 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		return (n & mask) | (m << i);
	}
	
	public static void main(String[] args) {
		int a = 00103217;
		int b = 13;
		int c = updateBits(a, b, 4, 12);
		System.out.println(c);
	}

}
