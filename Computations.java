/*
A prime number (or a prime) is a natural number greater than 1 that is divisible only by itself and by 1. For example, 7 is a prime since it can be divided only by 1 and by 7. The number 8 is not a prime, since it is divisible by 1 and by 8, but also by 2 and by 4.
How can we determine if a given number, say n, is a prime? We can try to divide n by each one of the numbers 2, 3, ..., n-1. If any one of these numbers divides n without a remainder, n is not a prime. Otherwise, n is a prime. Here is a method designed to carry out this test:
 */
public class Computations {

    /*
     * Test wheter a given integer n is prime or not.
     * 
     * Returns true if n is prime, false otherwise.
     */
    public static boolean isPrime(int n){
	if(n == 0 || n == 1){
	    return false;
	}
	if(n == 2){
	    return true;
	}
	// We won't check even number - officient way
	if(n % 2 == 0){
	    return false;
	}
	// Run up until sqrt(n)
	double sqrt = Math.sqrt(n);
	for (int i = 3; i <= sqrt; i += 2){
	    if (n % i == 0){
		return false;
	    }
	}

	return true;
    }

    /*
     * Returns the number of prime numbers smaller than a given
     * integer, n.
     */
    public static int nPrimes(int n) {
	int counter = 0;
	for (int i = 2; i < n; i++) {
	    if(isPrime(n)){
		counter++;
	    }
	}	
	return counter;
    }
}
