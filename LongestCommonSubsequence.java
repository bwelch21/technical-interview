public class LongestCommonSubsequence {

	public static int[][] findLongestCommonSubsequence(String a, String b) {
		
		// Create dynamic programming table
		int dp[][] = new int[a.length() + 1][b.length() + 1];

		// Initialize all values in table to 0
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = 0;
			}
		} 

		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {

				// Add 1 current length of common substring if current characters are equal
				if(a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					// If characters aren't equal, copy largest length of common substring
					if(dp[i - 1][j] > dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}

		return dp;
	}

	public static void printTable(int[][] dp) {
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void printLongestCommonSubsequence(int[][] dp, int i, int j, String a, String b) {
		if(dp[i - 1][j - 1] == 0) {
			System.out.print(a.charAt(i - 1));
		} else {
			if(a.charAt(i - 1) == b.charAt(j - 1)) {
				printLongestCommonSubsequence(dp, i - 1, j - 1, a, b);
				System.out.print(a.charAt(i - 1));
			} else {
				if(dp[i - 1][j] > dp[i][j - 1]) {
					printLongestCommonSubsequence(dp, i - 1, j, a, b);
				} else {
					printLongestCommonSubsequence(dp, i, j - 1, a, b);
				}
			}
			
		}
	}

	public static void main(String args[]) {
		String a = "DCBAABC";
		String b = "ABCDCBA";
		int table[][] = findLongestCommonSubsequence(a, b);
		printLongestCommonSubsequence(table, a.length(), b.length(), a, b);
		System.out.println("");
	}

}