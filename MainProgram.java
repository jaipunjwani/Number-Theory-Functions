import java.math.BigInteger;

public class MainProgram {
	
	static NumberTheoryFunctions func = NumberTheoryFunctions.newInstance();
	
	public static void main(String[] args) {
		
		
		//euclidExtended(42,5);
		
		System.out.println(func.computeModuloPower(7, 11, 100));
	}
	
	public static void euclidExtended(int a, int b) {
		int[] result = func.extendedEuclideanAlgorithm(a, b);
		System.out.println(result[0] + "*" + a + " + " + result[1] + "*" + b + " = 1");
		
	}

}
