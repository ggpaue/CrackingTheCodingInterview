/**
 * 
 * Implement a function to check if a binary tree is balanced.
 * For the purpose of this question, a balanced tree is defined to be a tree such that the height of the two subtrees of any node never differ by more than one.
 * 
 */
 
public class Solution {
	int val;
	TreeNode left;
	TreeNode right;
	
	public static int checkHeight(TreeNode root) {
		if(root == null) return 0;
		int leftHeight = checkHeight(root.left);
		int rightHeight = checkHeight(root.right);
		
		if(leftHeight == -1) return -1;
		if(rightHeight == -1) return -1;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		if(checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append(val);
		
		if(left != null) {
			sb.append(left.toString());
		}
		
		if(right != null) {
			sb.append(right.toString());
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		TreeNode t1_0 = new TreeNode(1);
		TreeNode t1_1_0 = new TreeNode(2);
		TreeNode t1_1_1 = new TreeNode(3);
		TreeNode t1_2_0 = new TreeNode(4);
		TreeNode t1_2_1 = new TreeNode(5);
		TreeNode t1_2_2 = new TreeNode(6);
		TreeNode t1_2_3 = new TreeNode(7);
		TreeNode t1_3_0 = new TreeNode(8);
		TreeNode t1_3_1 = new TreeNode(9);
		t1_0.left = t1_1_0;
		t1_0.right = t1_1_1;
		t1_1_0.left = t1_2_0;
		t1_1_0.right = t1_2_1;
		t1_1_1.left = t1_2_2;
		t1_1_1.right = t1_2_3;
		t1_2_0.left = t1_3_0;
		t1_2_0.right = t1_3_1;

		System.out.println("t1=" + t1_0.toString());
		System.out.println("Balanced t1 = " + isBalanced(t1_0));

		TreeNode t2_0 = new TreeNode(1);
		TreeNode t2_1_0 = new TreeNode(2);
		TreeNode t2_1_1 = new TreeNode(3);
		TreeNode t2_2_0 = new TreeNode(4);
		TreeNode t2_2_1 = new TreeNode(5);
		TreeNode t2_2_2 = new TreeNode(6);
		TreeNode t2_2_3 = new TreeNode(7);
		TreeNode t2_3_0 = new TreeNode(8);
		TreeNode t2_4_0 = new TreeNode(9);
		t2_0.left = t2_1_0;
		t2_0.right = t2_1_1;
		t2_1_0.left = t2_2_0;
		t2_1_0.right = t2_2_1;
		t2_1_1.left = t2_2_2;
		t2_1_1.right = t2_2_3;
		t2_2_0.left = t2_3_0;
		t2_3_0.right = t2_4_0;

		System.out.println("t2=" + t2_0.toString());
		System.out.println("Balanced t2 = " + isBalanced(t2_0));

	}

}
