/**
 * 
 * @author GGPAUE
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c form the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 * 
 */

public class Solution {
	public static void deleteMiddleNode(ListNode middleNode) {
		if(middleNode == null || middleNode.next == null) return;
		
		ListNode tempNode = middleNode.next;
		middleNode.val = tempNode.val;
		middleNode.next = tempNode.next;
		tempNode.next = null;
	}
	
	public static void main(String[] args) {
		int nums[] = {1, 2, 3, 4, 5};
		ListNode head = ListNode.buildList(nums);
		ListNode c = ListNode.findNode(head, 3);
		System.out.println("c=" + c.val);
		deleteMiddleNode(c);
		ListNode.printList(head);
	}

}
