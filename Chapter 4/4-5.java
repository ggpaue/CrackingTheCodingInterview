/**
 * 
 * @author GGPAUE
 * 
 * Implement a function to check if a binary tree is a binary search tree.
 */

public class Solution {
	public static boolean isBinarySearchTree(TreeNode head) {
		return isBinarySearchTree(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBinarySearchTree(TreeNode head, int iMin, int iMax) {
		if(head == null) return true;
		
		if(head.val <= iMin) {
			System.out.println("Failed since "+ head.val +" less than or equal to " + iMin);
			return false;
		}
		
		if(head.val > iMax) {
			System.out.println("Failed since "+ head.val + " greater than " + iMax);
			return false;
		}
		
		if(!isBinarySearchTree(head.left, iMin, head.val) || !isBinarySearchTree(head.right, head.val, iMax)) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		

		int idx = 0;
		int n = 63;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
				//idx += Math.max(1, (int) Math.floor(Math.random()*5));
				++idx;
				nums[i] = idx;
				System.out.print(nums[i] + ",");
		}

		System.out.println("\n ===== \n");

		// Is a binary search tree	
		System.out.println("head:");
		TreeNode head = TreeNode.createBinarySearchTree(nums);
		int numLevels = (int) Math.ceil(Math.log(n)) + 1;
		TreeNode.printTree(head, numLevels);

		// Not a bst since 5 is to left of 4.
		System.out.println("notBST");
		TreeNode notBST = new TreeNode(4, 0);
		notBST.left = new TreeNode(5, 1);
		notBST.right = new TreeNode(6, 1);
		TreeNode.printTree(notBST, 2);

		// Not a bst since 8 is to right of 10.
		System.out.println("notBST2");
		TreeNode notBST2 = new TreeNode(7, 0);
		notBST2.left = new TreeNode(4, 1);
		notBST2.right = new TreeNode(10, 1);
		notBST2.left.left = new TreeNode(2, 2);
		notBST2.left.right = new TreeNode(5, 2);
		notBST2.right.left = new TreeNode(9, 2);
		notBST2.right.right = new TreeNode(8, 2); // causes not being bst
		TreeNode.printTree(notBST2, 3);

		// Not a bst since 14 is to left of 10.
		System.out.println("notBST3");
		TreeNode notBST3 = new TreeNode(10, 0);
		notBST3.left = new TreeNode(5, 1);
		notBST3.right = new TreeNode(12, 1);
		notBST3.left.left = new TreeNode(3, 2);
		notBST3.left.right = new TreeNode(14, 2); // causes not being bst
		notBST3.right.left = new TreeNode(11, 2);
		notBST3.right.right = new TreeNode(13, 2);
		TreeNode.printTree(notBST3, 3);

		// Not a bst since 25 is to left of 20.
		System.out.println("notBST4");
		TreeNode notBST4 = new TreeNode(20, 0);
		notBST4.left = new TreeNode(10, 1);
		notBST4.right = new TreeNode(30, 1);
		notBST4.left.right = new TreeNode(25, 2);
		TreeNode.printTree(notBST4, 3);

		// Not a bst since 15 is to right of 20.
		System.out.println("notBST5");
		TreeNode notBST5 = new TreeNode(20, 0);
		notBST5.left = new TreeNode(10, 1);
		notBST5.right = new TreeNode(30, 1);
		notBST5.right.left = new TreeNode(15, 2);
		TreeNode.printTree(notBST5, 2);				

		System.out.println("\nisBinarySearch head:");System.out.println(isBinarySearchTree(head));
		System.out.println("\nisBinarySearch notBST:");System.out.println(isBinarySearchTree(notBST));
		System.out.println("\nisBinarySearch notBST2:");System.out.println(isBinarySearchTree(notBST2));
		System.out.println("\nisBinarySearch notBST3:");System.out.println(isBinarySearchTree(notBST3));
		System.out.println("\nisBinarySearch notBST4:");System.out.println(isBinarySearchTree(notBST4));
		System.out.println("\nisBinarySearch notBST5:");System.out.println(isBinarySearchTree(notBST5));
}

}
