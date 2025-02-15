package com.utk.util;

public class BubbleSort extends AbstractSort {

	public BubbleSort(int[] arr) {
		super(arr);
		name = "Bubble Sort";
	}

	@Override
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
