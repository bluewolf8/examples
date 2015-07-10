package org.sur.ds.computation;

import java.util.Arrays;
import java.util.Set;

/**
 * Find 3 numbers such that the sum of these is 3
 *
 */
public class ThreeSum {

	/**
	 * Generic method, when n is 3 this finds the 3 sum
	 * @param numbers
	 * @param n
	 * @return
	 */
	public boolean containsNSum(Set<Integer> numbers, int n){
		boolean containsThreeSum = false;

		Integer[] numbersArr = (Integer[]) numbers.toArray(new Integer[numbers.size()]);
		int size = numbersArr.length;

		//Sort the array  O(Log(n))
		Arrays.sort(numbersArr);

		for(int i = 0;i< size - 2 && !containsThreeSum;i++){
			int firstNumber = numbersArr[i];
			//For each number, look for a pair of numbers such that the sum of these 2 with firstNumber is n
			//O(n^2)
			for(int left = i+1,right = size-1;left < right;){
				//The fact that this array is sorted lets us look for the pair in a single loop
				int secondNumber = numbersArr[left];
				int thirdNumber = numbersArr[right];

				int sum = firstNumber + secondNumber + thirdNumber;
				if(sum == n){
					containsThreeSum = true;
					System.out.println("Triplet is " + firstNumber + "," + secondNumber + "," + thirdNumber);
					break;
				}
				if(sum < n){
					//Increase
					left = left +1;
				}
				else{
					//Reduce
					right = right -1;
				}
			}
		}
		return containsThreeSum;
	}
}