/*
Given a sequence of N numbers – A[1] , A[2] , …, A[N] . Find the length of the longest non-decreasing sequence.

For example the sequence {5, 3, 4, 8, 6, 7} should return 4 because 3, 4, 6, 7.

5 3 4 8 6 7
1 1 2 3 3 4 
*/

public class NonDecreasingSequence {
	public static int maxInt(int[] arr) {
		int max = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int findNonDecreasingSequence(int[] sequence) {
		int dp[] = new int[sequence.length];

		for(int i = 0; i < sequence.length; i++) {
			dp[i] = 1;
		}

		for(int i = 1; i < sequence.length; i++) {
			for(int j = 0; j < i; j++) {
				if(sequence[i] >= sequence[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		return maxInt(dp);
	}

	public static void main(String[] args) {
		int sequence[] = {5, 3, 4, 8, 6, 7};
		System.out.println(findNonDecreasingSequence(sequence));
	}
}

    
