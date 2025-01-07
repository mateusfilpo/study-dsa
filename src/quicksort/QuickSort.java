package quicksort;

public class QuickSort {
	
	private static void qs(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int pivotIdx = partition(arr, lo, hi);
		
		qs(arr, lo, pivotIdx - 1);
		qs(arr, pivotIdx + 1, hi);
	}
	
	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		
		int idx = lo -1;
		
		for (int i = lo; i < hi; i++) {
			if (arr[i] <= pivot) {
				idx++;
				int tmp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = tmp;
			}
		}
		
		idx++;
		arr[hi] = arr[idx];
		arr[idx] = pivot;
		
		return idx;
	}
	
	private static void quickSort(int[] arr) {
		qs(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {9, 3, 7, 4, 69, 420, 42};
		
		for (int n : arr) {
			System.out.print(n + ", ");
		}
		
		System.out.println();
		
		quickSort(arr);
		
		for (int n : arr) {
			System.out.print(n + ", ");
		}
	}

}
