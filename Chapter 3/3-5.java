
class MyQueue {
	ARStack stack1 = new ARStack();
	ARStack stack2 = new ARStack();
	
	int lastAction = 0; // 0 = push, 1 = pop
	
	public void enqueue(Object newItem) {
		if(lastAction == 0) {
			stack1.push(newItem);
		} else {
			while(stack2.peek() != null) {
				stack1.push(stack2.pop());
			}
			stack1.push(newItem);
			lastAction = 0;
		}
	}
	
	public Object dequeue() {
		if(lastAction == 1) {
			return stack2.pop();
		} else {
			while(stack1.peek() != null) {
				stack2.push(stack1.pop());
			}
			lastAction = 1;
			return stack2.pop();
		}
	}
	
	public String toString() {
		return "Stack1: " + stack1.toString() + ", Stack2: " + stack2.toString();
	}
}

public class Solution {
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		
		for(int i = 0; i < 30; i++) {
			q.enqueue(i);
		}
		
		System.out.println("q = " + q.toString());
		
		for(int i = 0; i < 5; i++) {
			Integer front = (Integer) q.dequeue();
			System.out.println(front + " dequeued");
		}
		
		System.out.println("q = " + q.toString());
		
		for(int i = 30; i < 40; i++) {
			q.enqueue(i);
		}
		
		System.out.println("q = " + q.toString());
		
		for(int i = 0; i < 5; i++) {
			Integer front = (Integer) q.dequeue();
			System.out.println(front + " dequeued");
		}
		
		System.out.println("q = " + q.toString());
		
		System.out.println("POP the rest");
		
		Integer o = (Integer)q.dequeue();
		while(o != null) {
			System.out.println(o + " dequeued");
			o = (Integer) q.dequeue();
		}
	}
}
