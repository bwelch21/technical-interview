/*
Find the largest palindrome made from the product of two 3-digit numbers.
*/

public class LargestPalindromeProduct {
	public static int findPalindrome() {
		int palindrome = -1;
		for(int i = 100; i < 999; i++) {
			for(int j = 100; j < 999; j++) {
				if(isPalindrome(i * j)) {
					palindrome = i * j;
				}
			}
		}

		return palindrome;
	}

	public static boolean isPalindrome(int val) {
		String s = Integer.toString(val);
		int len = s.length();
		for(int i = 0; i < len / 2; i++) {
			if(s.charAt(i) != s.charAt(len - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		System.out.println(findPalindrome());
	}
}