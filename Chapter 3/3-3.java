
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
