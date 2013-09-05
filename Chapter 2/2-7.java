/**
 * 
 * Implement a function to check if a linked list is a palindrome.
 * 
 */

import java.util.*;
public class Solution {
	public static boolean isPalindrome(ListNode head) {
		ListNode p = head;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(p != null) {
			result.add(p.val);
			p = p.next;
		}
		
		int len = result.size();
		
		for(int i = 0, j = len - 1; i < len / 2; i++, j--) {
			if(result.get(i) != result.get(j)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int num1[] = {1, 3, 5, 7, 9, 7, 5, 3, 1};
		int num2[] = {2, 4, 6, 8, 10, 8, 6, 4, 2};
		int num3[] = {1, 3, 5, 7, 9, 7, 5, 2, 1};
		
		ListNode head1 = ListNode.buildList(num1);
		ListNode head2 = ListNode.buildList(num2);
		ListNode head3 = ListNode.buildList(num3);
		
		ListNode.printList(head1);
		System.out.println("is Palindrome: " + isPalindrome(head1));
		System.out.println();
		
		ListNode.printList(head2);
		System.out.println("is Palindrome: " + isPalindrome(head2));
		System.out.println();
		
		ListNode.printList(head3);
		System.out.println("is Palindrome: " + isPalindrome(head3));
		
	}

}
