/**
 * 
 * @author GGPAUE
 *
 * How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 */

public class Solution {
	static class StackNode {
		int data;
		int min;
		
		StackNode next;
		
		public StackNode(int data) {
			this.data = data;
			min = Integer.MAX_VALUE;
			next = null;
		}
	}
	
	static class MinStack {
		StackNode top = null;
		
		public void push(int data) {
			StackNode node = new StackNode(data);
			if(isEmpty()) {
				node.min = node.data;
			} else {
				node.min = Math.min(node.data, top.min);
			}
			node.next = top;
			top = node;
		}
		
		public int pop() {
			int data = top.data;
			top = top.next;
			return data;
		}
		
		public int min() {
			return top.min;
		}
		
		public boolean isEmpty() {
			return top == null;
		}
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(1);
		stack.push(3);
		stack.push(-1);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}

}
