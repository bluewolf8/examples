package org.sur.ds.selection;

import java.util.Arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
 * The functions should put all 0s first, then all 1s and all 2s in last
 *
 */
public class DutchFlagProblem {

	public void solve(Integer[] numbers){
		int left = 0;
		int mid = 1;
		int right = numbers.length-1;
		System.out.println("Input Array:");
		System.out.println(Arrays.toString(numbers));
		while(mid <= right){
			int value = numbers[mid];
			if(value==0){
				if(left != mid && numbers[left]!=0){
					swap(numbers,left,mid);
				}
				left++;
			}
			else if(value==1){
				mid++;
			}
			else if(value==2){
				if(right != mid && numbers[right]!=2){
					swap(numbers,mid, right);
				}
				right--;
			}
			System.out.println(Arrays.toString(numbers));
		}
	}

	private void swap(Integer[] numbers, int i, int j){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
