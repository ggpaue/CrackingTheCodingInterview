/**
 * 
 * @author GGPAUE
 * Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 * 
 */

public class Solution {
	public static void print_binary(int x) {
		System.out.println(Integer.toBinaryString(x));
	}
	
	public static int swapBits(int x) {
		return ((x & 0x55555555) << 1) | ((x >> 1) & 0x55555555);
	}
	
	public static void main(String[] args) {
		int x = 23;
		print_binary(x);
		print_binary(swapBits(x));
	}

}
