/**
 * 
 * Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 * 
 */

import java.util.*;
public class Solution {
	public static TreeNode getNextNode(TreeNode node) {
		if(node == null) return null;
		if(node.right != null) {
			TreeNode b = node.right;
			while(b.left != null) {
				b= b.left;
			}
			return b;
		} else {
			TreeNode q = node;
			TreeNode x = q.parent;
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
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

		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode.getAllNodes(head, list);
		for (int j = 0; j < list.size(); j++) {
			TreeNode b = list.get(j);
				TreeNode next = getNextNode(b);
				String nextV = (next!=null) ? next.val+"" : "null";
				System.out.println("nextNode of "+b.val+" is "+nextV);
		}

}

}
