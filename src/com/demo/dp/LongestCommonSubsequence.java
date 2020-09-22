package com.demo.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s = "dgeigeigeigeigeigeigeigeigeigeigeigeigeigeigei";
		String t = "begigeigeigeigeigeigeigeigeigeigeigeigeigeigeigeigeigeigeigei";
		System.out.println(lcsM(s, t));
		System.out.println(lcsDP(s, t));
		System.out.println(lcs(s, t));
		
	}

	private static int lcsDP(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] storage = new int[s.length() + 1][t.length() + 1];
//		for (int i = 0; i <= m; i++) {
//			storage[i][0] = 0;
//		}
//		for (int i = 0; i <= n; i++) {
//			storage[0][i] = 0;
//		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(m - i) == t.charAt(n - j)) {
					storage[i][j] = 1 + storage[i - 1][j - 1];
				} else {
					storage[i][j] = Math.max(storage[i][j - 1], storage[i - 1][j]);
				}
			}
		}
		return storage[m][n];
	}

	private static int lcsM(String s, String t) {
		int[][] storage = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[i].length; j++) {
				storage[i][j] = -1;
			}
		}
		return lcsM(storage, s, t);
	}

	private static int lcsM(int[][] storage, String s, String t) {
		int m = s.length();
		int n = t.length();
		if (storage[m][n] != -1) {
			return storage[m][n];
		}
		if (m == 0 || n == 0) {
			storage[m][n] = 0;
			return storage[m][n];
		}
		if (s.charAt(0) == t.charAt(0)) {
			storage[m][n] = 1 + lcsM(storage, s.substring(1), t.substring(1));
		} else {
			int op1 = lcsM(storage, s, t.substring(1));
			int op2 = lcsM(storage, s.substring(1), t);
			storage[m][n] = Math.max(op1, op2);
		}
		return storage[m][n];
	}

	public static int lcs(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == t.charAt(0)) {
			return 1 + lcs(s.substring(1), t.substring(1));
		} else {
			int op1 = lcs(s, t.substring(1));
			int op2 = lcs(s.substring(1), t);
			// int op3 = lcs(s.substring(1), t.substring(1)); // we dont need to add op3 as
			// it will get covered in op1 and op2
			return Math.max(op1, op2);
		}

	}

}
