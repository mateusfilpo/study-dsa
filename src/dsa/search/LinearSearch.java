package dsa.search;

public class LinearSearch {
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		System.out.println(linearSearch(numbers, 5));
		System.out.println(linearSearch(numbers, -1));
		
	}
	
	public static boolean linearSearch(int[] haystack, int needle) {
		
		for (int i = 0; i < haystack.length; i++) {
			if (haystack[i] == needle) {
				return true;
			}
		}
		
		return false;
	}

}
