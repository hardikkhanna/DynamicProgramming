package com.demo.dp;

public class Staircase {

	public static void main(String[] args) {
		int n = 100;
		System.out.println(staircaseM(n));
		System.out.println(staircase(n));

	}

	private static int staircaseM(int n) {
		int[] storage = new int[n + 1];
		return staircaseM(n, storage);
	}

	private static int staircaseM(int n, int[] storage) {
		if (n == 1 || n == 0) {
			storage[n] = 1;
			return storage[n];
		}
		if (n == 2) {
			storage[n] = 2;
			return storage[n];
		}
		if (storage[n] != 0) {
			return storage[n];
		}
		storage[n] = staircaseM(n - 1, storage) + staircaseM(n - 2, storage) + staircaseM(n - 3, storage);
		return storage[n];
	}

	private static int staircase(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
	}

}
