/**
 * 
 * @author GGPAUE
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x
 * 
 */

public class Solution {
	public static ListNode partition(ListNode head, int x) {
		if(head == null) return null;
		
		ListNode p = head;
		ListNode before = null;
		ListNode after = null;
		ListNode center = null;
		while(p.next != null) {
			if(p.next.val == x) {
				before = p;
				after = p.next.next;
				center = p.next;
				break;
			}
			p = p.next;
		}
		
		if(center == null) return head;
		p = head;
		while(p.next != center) {
			int d = p.next.val;
			if(d > x) {
				ListNode n = p.next;
				p.next = n.next;
				n.next = center.next;
				center.next = n;
			}
			p = p.next;
		}
		
		p = center;
		while(p.next != null) {
			int d = p.next.val;
			if(d < x) {
				ListNode n = p.next;
				
				p.next = n.next;
				n.next = center;
				before.next = n;
				before = n;
			} else {
				p = p.next;
			}
		} 
		
		if(p != null) {
			if(p.val < x) {
				ListNode n = p;
				p.next = center;
				before.next = n;
			}
		}
		return head;
		
	}
	
	public static void main(String[] args) {
		int nums[] = {0, 3, 4, 5, 17, 8, 11, 6, 9, 51, 15, 2, 1, 33};
		ListNode list = ListNode.buildList(nums);
		
		ListNode.printList(list);
		System.out.println("partitioning");
		
		ListNode group = partition(list, 9);
		ListNode.printList(group);
	}

}
