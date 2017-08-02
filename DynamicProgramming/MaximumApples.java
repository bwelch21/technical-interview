import java.lang.Math;

/* 
A table composed of N x M cells, each having a certain quantity of apples, is
given. You start from the upper-left corner. At each step you can go down or
right one cell. Find the maximum number of apples you can collect. 
*/

public class MaximumApples {
	public static void printTable(int[][] dp) {
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static int findMaxApples(int[][] A) {
		int S[][] = new int[A.length][A[0].length];
		S[0][0] = A[0][0];

		int ans = 0;
		for(int i = 0; i < S.length; i++) {
			for(int j = 0; j < S[0].length; j++) {
				int x_delta, y_delta;

				if(i > 0) {
					x_delta = S[i - 1][j];
				} else {
					x_delta = 0;
				}
				if(j > 0){
					y_delta = S[i][j - 1];
				} else {
					y_delta = 0;
				}

				S[i][j] = A[i][j] + Math.max(x_delta, y_delta);
			}
		}
		printTable(S);
		return S[S.length - 1][S[0].length - 1];
	}

	public static void main(String[] args) {
		int table[][] = {
			{1, 3 , 1},
			{3, 6, 1}
		};
		System.out.println(findMaxApples(table));
	}
}

