public class ThreeAndFive {
	public static int sumOfMultiples() {
		int sum = 0;
		for(int i = 3; i < 10; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}

		return sum;

	}

	public static void main(String args[]) {
		System.out.println(sumOfMultiples());
	}
}