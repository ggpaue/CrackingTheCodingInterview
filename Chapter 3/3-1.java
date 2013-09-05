/**
 * 
 * @author GGPAUE
 * 
 * Describe how you could use a single array to implement three stacks.
 * 
 */

public class Solution {
	static final int NUM_STACK = 3;
	static final int STACK_SIZE = 300;
	int array[] = new int[STACK_SIZE * 3];
	int pointer[] = {0, STACK_SIZE, STACK_SIZE * 2};
	
	void push(int stackNum, int data) throws Exception {
		if(pointer[stackNum - 1] >= STACK_SIZE * stackNum)
			throw new Exception("Stack Overflow");
		array[pointer[stackNum - 1]++] = data;
	}
	
	boolean isEmpty(int stackNum) {
		return pointer[stackNum - 1] == (stackNum - 1) * STACK_SIZE;
	}
	
	int pop(int stackNum) throws Exception {
		if(isEmpty(stackNum))
			throw new Exception("Stack Underflow");
		return array[--pointer[stackNum - 1]];
	}
	
	int peek(int stackNum) throws Exception {
		if(isEmpty(stackNum))
			throw new Exception("Empty Stack");
		return array[pointer[stackNum - 1] - 1]; 
	}
	
	public static void main(String[] args) throws Exception {
		Solution stack = new Solution();
		stack.push(1, 1);
		stack.push(1, 2);
		stack.push(1, 3);
		stack.push(2, 5);
		stack.push(3, 3);
		
		System.out.println(stack.pop(1));
		System.out.println(stack.peek(2));
		System.out.println(stack.peek(3));
	}

}
