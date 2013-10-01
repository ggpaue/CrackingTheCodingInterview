/**
 * 
 * @author GGPAUE
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a method to find the location of a given string.
 * EXAMPLE
 * Input: find "ball" in {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * Output: 4
 * 
 */

public class Solution {
	public static int search(String[] strings, String str) {
		if(strings == null || str == null || str.isEmpty()) return -1;
		return searchR(strings, str, 0, strings.length - 1);
	}
	
	public static int searchR(String[] strings, String str, int first, int last) {
		if(first > last) return -1;
		
		int mid = (last + first) / 2;
		
		if(strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while(true) {
				if(left < first && right > last) {
					return -1;
				} else if(right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if(left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		
		if(str.equals(strings[mid])) {
			return mid;
		} else if(strings[mid].compareTo(str) < 0) {
			return searchR(strings, str, mid + 1, last);
		} else {
			return searchR(strings, str, first, mid - 1);
		}
	}
	
	public static void main(String[] args) {
		String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "banana"));
	}

}
