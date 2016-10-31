
public class MainProgram {
	
	static NumberTheoryFunctions func = NumberTheoryFunctions.newInstance();
	
	public static void main(String[] args) {
		
		
		euclidExtended(42,5);
		
	}
	
	public static void euclidExtended(int a, int b) {
		int[] result = func.extendedEuclideanAlgorithm(a, b);
		System.out.println(result[0] + "*" + a + " + " + result[1] + "*" + b + " = 1");
		
	}

}
