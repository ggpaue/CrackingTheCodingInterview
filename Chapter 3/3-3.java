/**
 * Imagine a (literal) stack of plates.  If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack
 * exceeds some threshold.  Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks and should create a new stack
 * once the previous one exceeds capacity.  SetOfStacks.push() and SetOfStacks.pop()
 * should behave identically to a single stack (that is, pop() should return the same
 * values as it would if there were just a single stack).
 * 
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack
 * 
 */
 
public class Solution {
	public static void main(String[] args) {
		SetOfStacks ss = new SetOfStacks(20);
		for(int i = 0; i < 80; i++) {
			ss.push(i);
		}
		ss.printState();
		
		for(int i = 0; i < 10; i++) {
			Object pop = ss.pop();
			System.out.println("popped: " + pop.toString() + ", peek is:" + ss.peek());
		}
		ss.printState();
		
		for(int i = 0; i < 5; i++) {
			Object pop = ss.popAt(2);
			System.out.println("popped: " + pop.toString());
		}
		ss.printState();
		
		for(int i = 0; i < 13; i++) {
			Object pop = ss.popAt(1);
			System.out.println("popped: " + pop.toString());
		}
		ss.printState();
		
		for(int i = 0; i < 4; i++) {
			Object pop = ss.popAt(0);
			System.out.println("popped: " + pop.toString());
		}
		ss.printState();
	}

}
