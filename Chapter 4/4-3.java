/**
 * 
 * @author GGPAUE
 * 
 * Given a sorted (increasing order) array, write an algorithm to create a binary search tree with minimal height.
 * 
 */

public class Solution {
	public static void main(String[] args) {
		
		int index = 0;
		int n = 63;
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			++index;
			nums[i] = index;
			System.out.print(nums[i] + ",");
		}
		
		System.out.println("\n ===== \n");
		
		TreeNode head = TreeNode.createBinarySearchTree(nums);
		int numLevels = (int) Math.ceil(Math.log(n)) + 1;
		TreeNode.printTree(head, numLevels);
	}

}
