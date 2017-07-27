public class NonOverlappingPairs {
	public static void main(String[] args) {
		printNonOverlappingPairs("1234", "");
	}

	public static void printNonOverlappingPairs(String input, String prefix) {
		System.out.println(prefix + "(" + input + ")");
		
		for(int i = 1; i < input.length(); i++) {
			String nextPrefix = prefix + "(" + input.substring(0, i) + ")";
			printNonOverlappingPairs(input.substring(i), nextPrefix);
		}
	}
	
}