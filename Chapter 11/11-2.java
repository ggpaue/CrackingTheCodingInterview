/**
 * 
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 * 
 */

import java.util.*;

public class Solution {
	
	public static String sortChars(String s) {
		char[] letters = s.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
	
	public static void sort(String[] arr) {
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		for(String s : arr) {
			String key = sortChars(s);
			if(!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		
		int index = 0;
		for(String key : hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for(String t : list) {
				arr[index] = t;
				index++;
			}
		}	
	}
	
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sort(array);
		for(String x : array) {
			System.out.print(x + ", ");
		}
	}
		
		
	

}
