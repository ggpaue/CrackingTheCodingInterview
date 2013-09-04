public class ListNode{
		int val;
		ListNode next;
		//if there is constructor, should use separate class
		ListNode (int x) {
			val = x; 
		}
		ListNode(int x, ListNode n) { 
			val = x; 
			next = null;
		}
		
		
		
		public void appendToTail(int d) {
			ListNode end = new ListNode(d);
			ListNode n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		public void printNode() {
			System.out.print(this.val);
			if(this.next != null) {
				System.out.print(" -> ");
				this.next.printNode();
			}
		}
		
		public static ListNode buildList(int[] nums) {
			ListNode head = null;
			for(int i = 0; i < nums.length; i++) {
				if(head == null) {
					head = new ListNode(nums[i]);
				} else {
					head.appendToTail(nums[i]);
				}
			}
			return head;
		}
		
		public static ListNode findNode(ListNode head, int d) {
			ListNode result = null;
			if(head.val == d) {
				result = head;
			} else if(head.next != null) {
				result = ListNode.findNode(head.next, d);
			}
			return result;
		}
		
		public static void printList(ListNode head) {
			if(head == null) return;
			head.printNode();
			System.out.println();
		}

	}