package org.sur.ds.selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthLargestNumber {

	/**
	 * Gets the kth largest number from the sub array defined by [start,end]
	 * @param numbers
	 * @param start
	 * @param end
	 * @param k
	 * @return
	 */
	public int getKthLargest(Integer[] numbers, int start, int end, int k){
		return getKthSmallest(numbers, start, end, (end-k)+1);
	}

	public int getKthSmallest(Integer[] numbers, int start, int end, int k){
		//find median
		int median = getMedian(numbers, start, end);
		//Rearrange numbers around pivot
		partition(numbers, median, start, end);	
		int m = Arrays.asList(numbers).indexOf(median);

		//At this point the median is at it's correct place in the array
		//with smaller elements to the left and larger ones to the right
		if(k == m){
			return median;
		}
		else if(k<m){
			//Recursively call for left sub array
			return getKthSmallest(numbers,start,m-1,k);
		}
		else{
			//recursively call for right sub-array
			return getKthSmallest(numbers,m+1,end,k);
		}
	}

	/**
	 * Rearranges the subarray defined by left and right around the pivot
	 * such that all elements smaller than the pivot are to the left of it
	 * and all elements larger than the pivot are to the right of it
	 * @param numbers
	 * @param pivot
	 * @param start
	 * @param end
	 */
	protected void partition(Integer[] numbers, int pivot, int left, int right){
		//move other elements around pivot
		while(left < right){
			while(numbers[left] < pivot){
				left++;
			}
			while(numbers[right] > pivot){
				right--;
			}
			swap(numbers, left, right);
		}
	}

	/**
	 * Swaps the numbers at the given indexes
	 * @param numbers
	 * @param left
	 * @param right
	 */
	private void swap(Integer[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i]=numbers[j];
		numbers[j] = temp;
	}

	/**
	 * Gets the median of the numbers in the subarray
	 * defined by [start,end]. Uses the median of medians method.
	 * The complexity is n * 5 log(5) = O(n) as we use sub groups of
	 * size 5 in this method.
	 * @param numbers
	 * @param start
	 * @param end
	 * @return
	 */
	protected int getMedian(Integer[] numbers,int start, int end){
		List<Integer> medians = new ArrayList<Integer>();
		if(end<5){
			return getMedian(Arrays.asList(numbers).subList(start, end+1));
		}
		else{
			//split into sub-arrays of size 5 each
			int i = start;
			int j = start;
			int splitSize = end/5;
			do{
				//move indexes to point to next sub array
				i = j;
				j = i+splitSize;
				if(j>end){
					j = end;
				}
				Integer[] subArray = Arrays.copyOfRange(numbers, i, j+1);
				List<Integer> asList = Arrays.asList(subArray);
				int median = getMedian(asList);
				medians.add(median);
			}while(j < end);
		}
		return getMedian(medians);
	}

	/**
	 * Gets the median of the given numbers.
	 * For a list of even number of elements this
	 * method selects the first element of the middle 2.
	 * so for example for the set [1,3,5,8] this method will
	 * return 3 as the median
	 * @param numbers
	 * @return
	 */
	private int getMedian(List<Integer> numbers) {
		Collections.sort(numbers);
		int index = numbers.size()/2;
		if(numbers.size()%2==0){
			index = index-1;
		}
		int median = numbers.get(index);
		return median;
	}
}