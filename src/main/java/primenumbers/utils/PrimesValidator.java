package primenumbers.utils;

import java.util.List;

public class PrimesValidator {
	
	public boolean isPrime(long number) {
		if(number <= 0) {
			return false;
		}
		for(long i = 2; i<= Math.sqrt(number); i++) {
			if(number % i == 0 ) {
				return false;
			}
		}
		return true;
	}
}
