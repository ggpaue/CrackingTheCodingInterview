
public class Queue {
	public ListNode first, last;
	
	public void enqueue(int item) {
		if(first == null) {
			last = new ListNode(item);
			first = last;
		} else {
			last.next = new ListNode(item);
			last = last.next;
		}
	}
	
	public ListNode dequeue() {
		if(first != null) {
			ListNode item = first;
			first = first.next;
			return item;
		}
		return null;
	}

}
