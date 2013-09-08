import java.util.*;
public class TreeNode {
	int val;
	
	TreeNode left;
	TreeNode right;
	
	int level;
	TreeNode parent = null;
	
	TreeNode(int x) {
		val = x;
	}
	
	public TreeNode(int v, int level) {
		this.val = v;
		this.level = level;
	}
	
	public TreeNode(int v, int level, TreeNode parent) {
		this.val = v;
		this.level = level;
		this.parent = parent;
	}
	
	public static TreeNode createBianrySearch(int left, int right, int[] nums, int level) {
		if(left > right) return null;
		
		int mid = (left + right) / 2;
		TreeNode head = new TreeNode(nums[mid], level);
		head.left = TreeNode.createBianrySearch(left, mid - 1, nums, level + 1);
		head.right = TreeNode.createBianrySearch(mid + 1, right, nums, level + 1);
		
		if(head.left != null) head.left.parent = head;
		if(head.right != null) head.right.parent = head;
		
		return head;
	}
	
	public static TreeNode createBinarySearchTree(int[] nums) {
		return TreeNode.createBianrySearch(0, nums.length - 1, nums, 0);
	}
	
	public static void getAllNodes(TreeNode head, ArrayList<TreeNode> list) {
		if(head == null) return;
		
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(head);
		
		while(!q.isEmpty()) {
			TreeNode b = q.pop();
			list.add(b);
			
			if(b.left != null) {
				q.add(b.left);
			}
			
			if(b.right != null) {
				q.add(b.right);
			}
		}
	}
	
	public static void printTree(TreeNode head, int numLevels) {
		if(head == null) return;
		
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode.getAllNodes(head, list);
		
		for(int i = 0; i <= numLevels; i++) {
			for(int j = 0; j < list.size(); j++) {
				TreeNode b = list.get(j);
				if(b.level == i) {
					System.out.print(" " + b.val);
				}
			}
			System.out.println();
		}
	}
	

}
