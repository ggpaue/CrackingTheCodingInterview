
public class Stack {
	public ListNode top;
	public Object pop() {
		if(top != null) {
			int item = top.val;
			top = top.next;
			return item;	
		}
		return null;
	}
	
	public void push(int item) {
		ListNode t = new ListNode(item);
		t.next = top;
		top = t;	
	}
	
	public int peek() {
		return top.val;
	}

}
