package com.demo.dp;

public class FibonacciM {

	public static void main(String[] args) {
		int n = 45;
		System.out.println(fibDP(n));
		System.out.println(fibm(n));
		System.out.println(fib(n));

	}

	private static int fibDP(int n) {
		int[] storage = new int[n + 1];
		storage[0] = 0;
		storage[1] = 1;
		for (int i = 2; i <= n; i++) {
			storage[i] = storage[i - 1] + storage[i - 2];
		}
		return storage[n];
	}

	private static int fibm(int n) {
		int[] storage = new int[n + 1];
		for (int i = 0; i < storage.length; i++) {
			storage[i] = -1;
		}
		return fibm(n, storage);
	}

	private static int fibm(int n, int[] storage) {
		if (n == 1 || n == 0) {
			storage[n] = n;
		}
		if (storage[n] != -1) {
			return storage[n];
		}
		storage[n] = fibm(n - 1, storage) + fibm(n - 2, storage);
		return storage[n];
	}

	private static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

}
