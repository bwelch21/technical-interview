/*
	take an array and print non over lapping in order pairs. example:


	[1,2,3,4] => input

	output below is in order combination

	(1234)
	(1)(234)
	(1)(23)(4)
	(1)(2)(34)
	(12)(34)
	(12)(3)(4)
	(123)(4)
	(1)(2)(3)(4)
*/

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