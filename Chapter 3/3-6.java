
public class Solution {
	public static ARStack sortStack(ARStack stack) {
		ARStack sorted = new ARStack();
		ARStack temp = new ARStack();
		
		while(!stack.isEmpty()) {
			Integer o = (Integer) stack.pop();
			
			System.out.println("o = " + o);
			
			if(sorted.isEmpty()) {
				sorted.push(o);
			} else {
				boolean bAdded = false;
				while(!sorted.isEmpty()) {
					Integer top = (Integer) sorted.peek();
					if(o > top) {
						sorted.push(o);
						bAdded = true;
						break;
					} else {
						temp.push(sorted.pop());
					}
				}
				
				if(!bAdded) {
					sorted.push(o);
				}
				
				while(!temp.isEmpty()) {
					sorted.push(temp.pop());
				}
			}
		}
		return sorted;
	}
	
	public static ARStack sortStack2(ARStack stack) {
		ARStack result = new ARStack();
		while(!stack.isEmpty()) {
			Integer temp = (Integer) stack.pop();
			
			System.out.println("\n\nSTEP1");
			System.out.println("temp = " + temp);
			System.out.println("s= " + stack.toString());
			System.out.println("result= " + result.toString());
			
			while(!result.isEmpty() && (Integer) result.peek() > temp) {
				System.out.println("STEP2");
				System.out.println("result.peek() = " + result.peek());
				
				stack.push(result.pop());
				
				System.out.println("s= " + stack.toString());
				System.out.println("result= " + result.toString());
			}
			result.push(temp);
			
			System.out.println("STEP3");
			System.out.println("s= " + stack.toString());
			System.out.println("result= " + result.toString());
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] nums = {4, 10, 7, 9, 3, 5};
		ARStack stack = new ARStack();
		for(int i = 0; i < nums.length; i++) {
			stack.push(nums[i]);
		}
		/*
		System.out.println("Stack= " + stack.toString());
		
		ARStack sortedStack = Solution.sortStack(stack);
		System.out.println("AFTER SORT");
		System.out.println("Stack = " + sortedStack.toString());
		*/
		System.out.println("Stack= " + stack.toString());
		
		ARStack sortedStack2 = Solution.sortStack2(stack);
		System.out.println("AFTER SORT");
		System.out.println("Stack2 = " + sortedStack2.toString());
	}

}
