package dsa.search;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(numbers, 5));
		System.out.println(binarySearch(numbers, 1));
	}

	private static boolean binarySearch(int[] numbers, int number) {
		
		int lo = 0;
		int hi = numbers.length;
		
		do {
			int m = lo + (hi - lo) / 2;
			int value = numbers[m];
			if (value == number) {
				return true;
			} else if (value > number) {
				hi = m;
			} else {
				lo = m + 1;
			}
		} while (lo < hi);
		
		
		return false;
	}

}
