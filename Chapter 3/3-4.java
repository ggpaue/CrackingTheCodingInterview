/**
 * 
 * @author GGPAUE
 * 
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e. each disk sits on top of an even larger one).
 * You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower
 * (3) A disk can only be placed on top of a larger disk.
 * 
 * Write a program to move the disks from the first town to the last using stacks.
 * 
 */

class Disk {
	public int size;
	public Disk(int s) {
		this.size = s;
	}
		
	public String toString() {
		return "D" + size;
	}
}
	
class Tower {
	ARStack stack = new ARStack();
	int id;
		
	public Tower(int id) {
		this.id = id;
	}
		
	public String toString() {
		return "Tower" + this.id + ":" + stack.toString();
	}
		
	public void add(Disk d) {
		Disk top = (Disk) stack.peek();
		if(top != null && top.size <= d.size) {
			System.out.println("Error placing disk" + d);
		} else {
			stack.push(d);
		}
	}
		
	public void moveTopTo(Tower dest) {
		Disk top = (Disk) stack.pop();
		dest.add(top);
		System.out.println("Move disk " + top + " from " + this.id + " to " + dest.id);
	}
	
	public void moveDisks(int n, Tower dest, Tower buffer) {
		if(n > 0) {
			moveDisks(n - 1, buffer, dest);
			moveTopTo(dest);
			buffer.moveDisks(n - 1, dest, this);
		}
	}
		
}


public class Solution {
	public static void printState(Tower[] towers) {
		for(int i = 0; i < towers.length; i++) {
			System.out.println(towers[i]);
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 5;
		if(args.length > 0) {
			System.out.println("args[0]=" + args[0]);
			n = Math.max(3, Integer.parseInt(args[0]));
		}
		
		Tower[] towers = new Tower[n];
		for(int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		
		for(int i = n - 1; i >= 0; i--) {
			Disk d = new Disk(i);
			towers[0].add(d);
		}
		
		printState(towers);
		towers[0].moveDisks(n, towers[2], towers[1]);
		printState(towers);
		
	}

}
