package com.utk.util;

public class MergeSort extends AbstractSort {

	public MergeSort(int[] arr) {
		super(arr);
		name = "Merge Sort";
	}

	@Override
	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int[] arr, int l, int r) {
		if (l < r) {
			// finding the mid point
			int m = l + (r - l) / 2;

			// sort left and right parts
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// merge the arrays
			merge(arr, l, m, r);
		}
	}

	private void merge(int[] arr, int l, int m, int r) {
		// find sizes of the two arrays
		int n1 = m - l + 1;
		int n2 = r - m;

		// create two new temp arrays
		int[] L = new int[n1];
		int[] R = new int[n2];

		// copy values in the array
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}

		int i = 0, j = 0;

		int k = l;

		// compare and merge
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// copy remaining elements of arrays
		while (i < n1) {
			arr[k] = L[i];
			k++;
			i++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

}
