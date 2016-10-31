
public class NumberTheoryFunctions {

	public static NumberTheoryFunctions newInstance() {
		return new NumberTheoryFunctions();
	}
	
	public int gcd(int a, int b) {
		if (a == b) {
			return a;
		} else if (a ==0 || b ==0) {
			return 0;
		}
		
		if (a <0) {
			a = -1*a;
		} 
		if (b<0) {
			b = -1*b;
		}
		
		int q ,r;
		//use division algorithm to get gcd
		
		
		
		return 0;
	}
	
	/**
	 * Note: Prime factorization could take infinite time and memory, instead use theorem:
	 * p is prime if for all a !(con) 0 mod p , a^(p-1) (con) mod p
	 * @param p - prime number (currently only integer size numbers are supported) (use BigInteger?)
	 * @return
	 */
	public boolean isPrime(int p) {
		// check whether p is in the domain of primes, or whether it is an even number greater than 2
		if (p <=1) {
			return false; 
		} else if(p > 2 && p % 2 ==0) {
			return false;
		} 
		
		//
		return true;
	}
	
	public boolean isCoPrime(int a, int b) {
		if (gcd(a,b) == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Extended Euclidean Algorithm - useful for solving systems of modular arithmetic equations
	 * @param a, b 	numbers that we are dividing by
	 * @return an array of x, y that solves ax + by = gcd(a, b)
	 */
	public int[] extendedEuclideanAlgorithm(int a, int b) {
		int g; // = gcd(a, b);
		int x = 1;
		int y = 0;
		int r = 0;
		int s = 1;
		int q, c;
		
		//current function assumes a is positive
		if (a < 0) {
			System.out.println("Please enter a positive value for a ");
		}
		
		
		while (b != 0) {
			//floor functions differ from operators such as /, % in that it respects the division algorithm 
			//particularly for numbers with opposite signs
			
			//division algorithm quotient and remainder, respectively
			q = Math.floorDiv(a, b);
			c = Math.floorMod(a,  b);
			
			//shifting values (a, b, r, s, x, y) into (b, c, x-qr, y-qs, r, s)
			a = b;
			b = c;
			int newX = r;
			int newY = s;
			r = x-q*r;
			s = y-q*s;
			x = newX;
			y = newY;
			
		}
		
		g = a;
		//System.out.println("xm + yn = g");
		//System.out.println(x + "*" + a + " + " + y + "*" + b + " = " + g);
		return new int[] {x, y};
		
		
	}
}
