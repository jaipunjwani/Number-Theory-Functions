import java.math.BigInteger;

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
	
	public int bruteForce() {
	
		BigInteger left = BigInteger.valueOf(102).pow(70).add(BigInteger.valueOf(1));
		
		for (int i = 0; i<113; i++) {
			
			BigInteger base = BigInteger.valueOf(i);
			BigInteger result = base.pow(37).mod(BigInteger.valueOf(113));
			
			if (left.mod(BigInteger.valueOf(113)).equals(result)) {
				return i;
			}
			
		}
		return -1;
		
	}
	
	/**
	 * Converts an integer to binary (represented as a String)
	 * CAVEAT - returns string in standard binary format causing 0th character to be highest binary power
	 * @param dec a standard integer in decimal representation
	 * @return the integer converted to binary as a string in standard representation
	 */
	public String decimalToBinary(int dec) {
		// use division algorithm to repeatedly divide by 2 and get each binary digit 
		String binaryStr = "";
		int dividend, quotient, remainder;
		remainder = quotient = -1;
		dividend = dec;
		
		
		while (quotient != 0) {
			quotient = dividend/2;
			remainder = dividend % 2;
			binaryStr =  remainder + binaryStr;
			dividend = quotient;
		}
		
		return binaryStr;
	}
	
	/**
	 * Computes a^m mod n
	 * @param a base
	 * @param m exponent
	 * @param n modulus
	 * @return a^m (mod n) 
	 */
	public int computeModuloPower(int a, int m, int n) {
		
		// step 1 - convert exponent to binary
		String binaryStr = decimalToBinary(m);
		
		// step 2 - compute powers using binary representation of exponent
		// for efficiency we use square previous powers of 2 to compute subsequent powers 
		
		int[] powersOf2 = new int[binaryStr.length()];
		powersOf2[0] = Math.floorMod(a, n);
		for(int i = 1; i < binaryStr.length(); i++) {
			// squares previous binary power of a 
			powersOf2[i] = Math.floorMod((int)Math.pow(powersOf2[i-1], 2), n);
		}
		
		// step 3 - multiply the powers together
		// traverse through binary string and corresponding representation of each power in array
		int result = 1;
		for (int i = binaryStr.length()-1, j = 0; i>=0 && j<binaryStr.length(); i--, j++) {
			int bit = Character.getNumericValue(binaryStr.charAt(i));
			if (bit == 1) {
				result *= powersOf2[j];
			}
		}
		
		return Math.floorMod(result, n);
		
	}
		
	
}
