package com.utk.util;

public class InsertionSort extends AbstractSort {

	public InsertionSort(int[] arr) {
		super(arr);
		name = "Insertion Sort";
	}

	@Override
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
			}
		}
	}
