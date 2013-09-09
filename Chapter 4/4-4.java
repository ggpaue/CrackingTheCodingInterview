/**
 * 
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 * 
 */

import java.util.*;
class Tuple {
	TreeNode bNode;
	int curLevel;
	
	Tuple(TreeNode bNode, int iLevel) {
		this.bNode = bNode;
		this.curLevel = iLevel;
	}
}
public class Solution {
	public static void getDepthListH(TreeNode head, int initLevel, LinkedList<LinkedList<TreeNode>> list) {
		if(head == null) return;
		
		LinkedList<Tuple> q = new LinkedList<Tuple>();
		q.add(new Tuple(head, initLevel));
		while(!q.isEmpty()) {
			Tuple t = q.pop();
			TreeNode b = t.bNode;
			int curLevel = t.curLevel;
			
			System.out.println("b= " + b.val + ", curLevel= " + curLevel);
			
			LinkedList<TreeNode> items = null;
			if(list.size() <= curLevel) {
				items = new LinkedList<TreeNode>();
				list.add(items);
			} else {
				items = list.get(curLevel);
			}
			items.add(t.bNode);
			
			if(b.left != null) {
				q.push(new Tuple(b.left, curLevel + 1));
			}
			
			if(b.right != null) {
				q.push(new Tuple(b.right, curLevel + 1));
			}
		}
	}
	
	public static LinkedList<LinkedList<TreeNode>> getDepthList(TreeNode head) {
		LinkedList<LinkedList<TreeNode>> list = new LinkedList<LinkedList<TreeNode>>();
		getDepthListH(head, 0, list);
		return list;
	}
	
	public static void printDepthList(LinkedList<LinkedList<TreeNode>> list) {
		int i = 0;
		for(LinkedList<TreeNode> depthList : list) {
			System.out.print("Level " + i + ": ");
			for(TreeNode b : depthList) {
				System.out.print(" " + b.val);
			}
			System.out.println();
			i++;
		}
	}
	
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
		
		System.out.println("\n DEPTH LIST \n");
		
		LinkedList<LinkedList<TreeNode>> list = getDepthList(head);
		printDepthList(list);
	}

}
