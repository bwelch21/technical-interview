/* Given a list of N coins, their values (V1, V2, … , VN), and the total sum S.
Find the minimum number of coins the sum of which is S (we can use as many coins
of one type as we want), or report that it’s not possible to select coins in
such a way that they sum up to S. */

import java.lang.Math;

public class MinimumCoins {
	

	public static int[][] findMinNumberOfCoins(int s, int[] coins) {
		int dp[][] = new int[coins.length + 1][s + 1];

		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for(int j = 0; j < dp[0].length; j++) {
			dp[0][j] = 0;
		}

		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(j % coins[i - 1] == 0) {
					dp[i][j] = j / coins[i - 1];

				} 
				else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1] + 1);
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

	public static void main(String args[]) {
		int coins[] = {1, 3, 5};
		int sum = 11;
		int table[][] = findMinNumberOfCoins(sum, coins);
		System.out.println(table[coins.length][sum]);
	}
}
