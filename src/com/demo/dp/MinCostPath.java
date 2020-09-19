package com.demo.dp;

import java.util.Scanner;

public class MinCostPath {

	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int m = s.nextInt();
		int n = s.nextInt();
		int input[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = s.nextInt();
			}
		}
		System.out.println(minCostPath(input));
		System.out.println(minCostPathM(input));
		System.out.println(minCostPathDP(input));
	}

	private static int minCostPathDP(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int[][] storage = new int[input.length][input[0].length];
		storage[m - 1][n - 1] = input[m - 1][n - 1];
		for (int i = m - 2; i >= 0; i--) {
			storage[i][n - 1] = storage[i + 1][n - 1] + input[i][n - 1];
		}
		for (int j = n - 2; j >= 0; j--) {
			storage[m - 1][j] = storage[m - 1][j + 1] + input[m - 1][j];
		}
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				storage[i][j] = input[i][j]
						+ Math.min(storage[i][j + 1], Math.min(storage[i + 1][j + 1], storage[i + 1][j]));
			}
		}
		return storage[0][0];
	}

	private static int minCostPathM(int[][] input) {
		int[][] storage = new int[input.length][input[0].length];
		return minCostPathM(input, 0, 0, storage);
	}

	private static int minCostPathM(int[][] input, int i, int j, int[][] storage) {
		if (i == input.length - 1 && j == input[0].length - 1) {
			storage[input.length - 1][input[0].length - 1] = input[i][j];
			return storage[i][j];
		}
		if (i >= input.length || j >= input[0].length) {
			return Integer.MAX_VALUE;
		}
		if (storage[i][j] != 0) {
			return storage[i][j];

		}
		int op1 = minCostPathM(input, i, j + 1, storage);
		int op2 = minCostPathM(input, i + 1, j, storage);
		int op3 = minCostPathM(input, i + 1, j + 1, storage);
		storage[i][j] = input[i][j] + Math.min(op1, Math.min(op2, op3));
		return storage[i][j];
	}

	private static int minCostPath(int[][] input) {
		return minCostPath(input, 0, 0);
	}

	private static int minCostPath(int[][] arr, int i, int j) {
		if (i == arr.length - 1 && j == arr[0].length - 1) {
			return arr[i][j];
		}
		if (i >= arr.length || j >= arr[0].length) {
			return Integer.MAX_VALUE;
		}

		int op1 = minCostPath(arr, i, j + 1);
		int op2 = minCostPath(arr, i + 1, j);
		int op3 = minCostPath(arr, i + 1, j + 1);
		return arr[i][j] + Math.min(op1, Math.min(op2, op3));
	}

}
