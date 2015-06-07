package org.sur.ds.computation;

public class EuclidsAlgorithm {
	/**
	 * “Given two positive integers m and n, finds their greatest common divisor, 
	 * that is, the largest positive integer that evenly divides both m and n”
	 */
	public int gcd(int m, int n){
		int larger = m;
		int smaller = n;
		if(m==n){
			return m;
		}
		else if(m<n){
			larger = n;
			smaller = m;
		}
		int remainder = larger%smaller;
		if(remainder==0){
			return smaller;
		}
		else{
			return gcd(smaller, remainder);
		}
	}

}
