/**
 * 
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed. 
 * 
 */

import java.util.*;
public class Solution {
	public static ListNode removeDup(ListNode head) {
		if(head == null) return head;
		HashMap<Integer, Boolean> ht = new HashMap<Integer, Boolean>();
		ListNode p = head;
		ht.put(p.val, true);
		while(p.next != null) {
			int d = p.next.val;
			if(ht.containsKey(d)) {
				ListNode n = p.next;
				p.next = p.next.next;
			} else {
				ht.put(d, true);
				p = p.next;
			}
		}
		return head;
	}
	
	public static ListNode followup(ListNode head) {
		if(head == null) return head;
		ListNode p = head;
		while(p != null) {
			int pd = p.val;
			ListNode f = p;
			while(f.next != null) {
				int fd = f.next.val;
				if(fd == pd) {
					ListNode fn = f.next;
					f.next = f.next.next;
				}
				f = f.next;
			}
			p = p.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int nums[] = {2,3,4,5,6,2,5,10,11,2,5,20,21,3,4,30,31,4,5,6,2,3,40,41};

		ListNode head = ListNode.buildList(nums);

		System.out.println("BEFORE:");
		ListNode.printList(head);

		

		System.out.println("AFTER NO BUFFER:");
		head = removeDup(head);
		ListNode.printList(head);
		
		System.out.println("AFTER BUFFER:");
		head = followup(head);
		ListNode.printList(head);
	}

}
