/*
What is the largest prime factor of the number 600851475143 ?
*/

public class PrimeFactorization {
	public static boolean isPrime(int n) {
		for(int i = 0; i < n / 2; i++) {
			if(i % n == 0) {
				return false;
			}
		}

		return true;
	}

	public static void primeFactors(int n, int m) {
		if(isPrime(n) || n == 1 || m == 1) {
			System.out.println(n);
		} else {
			if(n % m == 0) {
				primeFactors(m, m - 1);
				primeFactors(n / m, (n / m) - 1);
			} else {
				primeFactors(n, m - 1);
			}
		}
	}

	public static void findLargestPrimeFactor(int num) {
		primeFactors(num, num - 1);
	}

	public static void main(String args[]) {
		findLargestPrimeFactor(600851475143);
	}
}