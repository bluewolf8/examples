package org.sur.ds.computation;

import java.util.Arrays;
import java.util.Set;

public class ThreeSum {

	public boolean containsThreeSum(Set<Integer> numbers, int n){
		boolean containsThreeSum = false;

		Integer[] numbersArr = (Integer[]) numbers.toArray(new Integer[numbers.size()]);
		int size = numbersArr.length;

		//O(Log(n))
		Arrays.sort(numbersArr);

		//O(n^2)
		for(int i = 0;i< size - 2 && !containsThreeSum;i++){
			int firstNumber = numbersArr[i];
			for(int left = i+1,right = size-1;left < right;){
				int secondNumber = numbersArr[left];
				int thirdNumber = numbersArr[right];

				int sum = firstNumber + secondNumber + thirdNumber;
				if(sum == n){
					containsThreeSum = true;
					System.out.println("Triplet is " + firstNumber + "," + secondNumber + "," + thirdNumber);
					break;
				}
				if(sum < n){
					left = left +1;
				}
				else{
					right = right -1;
				}
			}
		}
		return containsThreeSum;
	}

}
