/**
 * 
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * 
 **/

public class Solution {
	public static ListNode findKthToLast(ListNode head, int k) {
		if(head == null || k < 1) return null;
		ListNode p1 = head;
		ListNode p2 = head;
		for(int i = 0; i < k - 1; ++i) {
			if(p2 == null) return null;
			p2 = p2.next;
		}
		
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;	
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		ListNode head = ListNode.buildList(nums);
		ListNode.printList(head);
		
		ListNode kth = findKthToLast(head, 4);
		System.out.println("k=" + 4 + ", " + 4 + "th to last=" + kth.val);
	}

}
