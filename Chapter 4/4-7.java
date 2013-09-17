/**
 * 
 * @author GGPAUE
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 */

class Result {
	public TreeNode node;
	public boolean isAncestor;
	public Result(TreeNode n, boolean isAnc) {
		node = n;
		isAncestor = isAnc;
	}
}


public class Solution {
	
	static String dbg(TreeNode b) {
		if (b == null) return "null";
		return b.val + "";
}
	public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q, String indent) {
		System.out.println(indent+"root="+dbg(root)+",p="+dbg(p)+",q="+dbg(q));
		if(root == null) {
			System.out.println(indent+"\t1) root is null");
			return new Result(null, false);
		}
		
		if (root == p && root == q) {
			System.out.println(indent+"\t2) root is both p and q");
			return new Result(root, true);
	    }
		
		System.out.println(indent+"\t2.5) Check Left...");
		Result rx = Solution.commonAncestorHelper(root.left, p, q, indent + "\t");
		if(rx.isAncestor) {
			System.out.println(indent+"\t3) rx:" + dbg(rx.node));
			return rx;
		}
		
		System.out.println(indent+"\t3.5) Check Right...");
		Result ry = Solution.commonAncestorHelper(root.right, p, q, indent + "\t");
		if(ry.isAncestor) {
			System.out.println(indent+"\t4) ry:" + dbg(ry.node));
			return ry;
		}
		
		if(rx.node!= null && ry.node != null) {
			System.out.println(indent+"\t5) root:" + dbg(root));
			return new Result(root, true);
		} else if(root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null ? true:false;
			System.out.println(indent+"\t6) root:" + dbg(root));
			return new Result(root, isAncestor);
		} else {
			TreeNode n = rx.node != null ? rx.node : ry.node;
			System.out.println(indent+"\t7) n:" + dbg(n));
			return new Result(n, false);
		}
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = Solution.commonAncestorHelper(root, p, q, "");
		if (r.isAncestor) {
				return r.node;
		}
		return null;
	}
	
	public static void main(String[] args) {
		

		// Not a bst since 8 is to right of 10.
		System.out.println("\tnotBST3");
		TreeNode notBST3 = new TreeNode(10, 0, null);
		notBST3.left = new TreeNode(5, 1, notBST3);
		notBST3.right = new TreeNode(12, 1, notBST3);
		notBST3.left.left = new TreeNode(3, 2, notBST3.left);
		notBST3.left.right = new TreeNode(14, 2, notBST3.left); // causes not being bst
		notBST3.right.left = new TreeNode(11, 2, notBST3.right);
		notBST3.right.right = new TreeNode(13, 2, notBST3.right);
		TreeNode.printTree(notBST3, 3);

		TreeNode cA = Solution.commonAncestor(notBST3, notBST3.left, notBST3.right.right);
		System.out.println("\tcommonAncestor of 5, 13 is " + dbg(cA));

}

}
