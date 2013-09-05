/**
 * 
 * @author GGPAUE
 * 
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * 
 * FOLLOWUP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 * 
 */

public class Solution {
	public static ListNode addLinkedList(ListNode a, ListNode b) {
		ListNode result = null, pointer = result, pExtra;
		int carry = 0;
		while(a != null && b != null) {
			int sum = a.val + b.val + carry;
			if(result == null) {
				pointer = result = new ListNode(sum % 10);
			} else {
				pointer.next = new ListNode(sum % 10);
				pointer = pointer.next;
			}
			carry = sum / 10;
			a = a.next;
			b = b.next;
		}
		if(a != null || b != null) {
			pExtra = a != null ? a : b;
			while(pExtra != null && carry > 0) {
				int sum = pExtra.val + carry;
				carry = sum / 10;
				pointer.next = new ListNode(sum % 10);
				pointer = pointer.next;
				pExtra = pExtra.next;
			}
		}
		
		if(carry > 0) pointer.next = new ListNode(carry);
		return result;
	}
	
	public static ListNode reverse(ListNode head) {
		ListNode post = null, prev = null;
		while(head != null) {
			post = head;
			head = head.next;
			post.next = prev;
			prev = post;
		}
		return post;
	}
	
	public static ListNode followup(ListNode a, ListNode b) {
		return reverse(addLinkedList(reverse(a), reverse(b)));
	}
	
	public static void main(String[] args) {
		int num1[] = {7, 1, 9, 2};
		int num2[] = {5, 9, 2, 3};
		
		ListNode l1 = ListNode.buildList(num1);
		ListNode l2 = ListNode.buildList(num2);
		
		ListNode sum = addLinkedList(l1, l2);
		ListNode sum2 = followup(l1, l2);
		
		ListNode.printList(l1);
		ListNode.printList(l2);
		ListNode.printList(sum);
		ListNode.printList(sum2);
	}

}
