package com.demo.dp;

public class MinimumCountOfSquares {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(minCount(n));

	}

	private static int minCount(int n) {
		if (n <= 3) {
			return n;
		}
		int op1 = minCount(n - 1);
		int min = op1;
		
		int op2 = (int) Math.pow(n, 2) + minCount(n - (int)Math.pow(n, 2));
		if (op2 < min) {
			min = op2;
		}
		return min;
	}

}
