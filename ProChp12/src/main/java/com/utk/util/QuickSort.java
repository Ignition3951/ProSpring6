package com.utk.util;

public class QuickSort extends AbstractSort {

	public QuickSort(int[] arr) {
		super(arr);
		name = "Quick Sort";
	}

	@Override
	public void sort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	private void quicksort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			quicksort(arr, low, pi - 1);
			quicksort(arr, pi + 1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i=low-1;
		
		for(int j=low;j<=high-1;j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
