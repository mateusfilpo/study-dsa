package dsa.sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 4, 3, 5, 9, 6, 7, 8};
		
		for (int i : numbers) {
			System.out.print(i + ", ");
		}
		
		bubbleSort(numbers);
		
		System.out.println();
		
		for (int i : numbers) {
			System.out.print(i + ", ");
		}
		
		
	}
	
	public static void bubbleSort(int[] numbers) {	
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	
	}
}
