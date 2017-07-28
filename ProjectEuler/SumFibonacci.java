import java.util.ArrayList;

public class SumFibonacci {
	public static int sumEvenValues() {
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(0, 1);
		fib.add(1, 1);
		int sum = 0;

		for(int i = 2; fib.get(i - 1) < 4000000; i++) {
			int val = fib.get(i - 1) + fib.get(i - 2);
			fib.add(i, val);

			if(val % 2 == 0) {
				sum += val;
			}
		}

		return sum;
	}

	public static void main(String args[]) {
		System.out.println(sumEvenValues());
	}
}