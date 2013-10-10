/**
 * 
 * @author GGPAUE
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * EXAMPLE
 * Input: 31, 14
 * Output: 2
 * 
 */

public class Solution {
	public static int diffBits(int a, int b) {
		int c = a ^ b;
		int count = 0;
		for(; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int result = diffBits(31, 14);
		System.out.println(result);
	}

}
