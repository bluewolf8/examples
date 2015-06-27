package org.sur.ds.arrays;

/**
 * Maximize the Sum of the subarray 
 *
 */
public class LargestContinuousSubArray {

	public int getLargestContinuousSubArray(Integer[] arr){
		int length = arr.length;
		int i =0;
		int max = arr[i++];
		int currentMax = max;
		for(;i<length;i++){
			 currentMax = Math.max(currentMax+arr[i], arr[i]);
			 max = Math.max(currentMax, max);
		}
		
		return max;
	}

}
