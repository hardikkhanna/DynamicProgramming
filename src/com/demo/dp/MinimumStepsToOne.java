package com.demo.dp;

public class MinimumStepsToOne {

	public static void main(String[] args) {
		int n = 500;
		System.out.println(countMinStepsto1DP(n));
		System.out.println(countMinStepsTo1M(n));
		System.out.println(countMinStepsTo1(n));

	}

	private static int countMinStepsto1DP(int n) {
		int[] storage = new int[n + 1];
		storage[1] = 0;
		for (int i = 2; i <= n; i++) {
			int min = storage[i - 1];
			if (i % 3 == 0) {
				if (min > storage[i / 3]) {
					min = storage[i / 3];
				}
			}
			if (i % 2 == 0) {
				if (min > storage[i / 2]) {
					min = storage[i / 2];
				}
			}
			storage[i] = 1 + min;
		}
		return storage[n];

	}

	private static int countMinStepsTo1M(int n) {
		int[] storage = new int[n + 1];
		return countMinStepsTo1(n, storage);
	}

	private static int countMinStepsTo1(int n, int[] storage) {
		if (n == 1) {
			storage[n] = 0;
			return storage[n];
		}
		if (storage[n] != 0) {
			return storage[n];
		}
		int op1 = countMinStepsTo1(n - 1, storage);
		int minSteps = op1;
		if (n % 3 == 0) {
			int op2 = countMinStepsTo1(n / 3, storage);
			if (op2 < minSteps) {
				minSteps = op2;
			}
		}
		if (n % 2 == 0) {
			int op3 = countMinStepsTo1(n / 2, storage);
			if (op3 < minSteps) {
				minSteps = op3;
			}
		}

		storage[n] = 1 + minSteps;
		return storage[n];
	}

	public static int countMinStepsTo1(int n) {

		if (n == 1) {
			return 0;
		}
		int op1 = countMinStepsTo1(n - 1);
		int minSteps = op1;
		if (n % 3 == 0) {
			int op2 = countMinStepsTo1(n / 3);
			if (op2 < minSteps)
				minSteps = op2;

		}
		if (n % 2 == 0) {
			int op3 = countMinStepsTo1(n / 2);
			if (op3 < minSteps)
				minSteps = op3;
		}
		return 1 + minSteps;
	}

}
