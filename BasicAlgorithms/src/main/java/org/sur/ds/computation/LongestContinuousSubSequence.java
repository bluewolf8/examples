package org.sur.ds.computation;

public class LongestContinuousSubSequence {

	/**
	 * Longest increasing sub sequence of numbers
	 * @param numbers
	 * @return
	 */
	public int getLongestIncreasingSubSeq(Integer[] numbers){
		Integer[] longestAt = new Integer[numbers.length];
		Integer[] prev = new Integer[numbers.length];

		//Default to one, as longest subsequence is at least 1 number long
		longestAt[0] = 1;
		//Set to -1 so when we are traversing the prev array
		//to find the sequence, -1 can be the stopping condition
		prev[0] = -1;

		for(int i=1;i<numbers.length;i++){
			longestAt[i] = 1;
			prev[i] = -1;
			for(int j=0;j<i;j++){
				if(numbers[i] > numbers[j] //Potential sub sequence as it is increasing
						//Longest so far plus one, check if that is longer than current longest at i
						&& longestAt[j] + 1 > longestAt[i]
						){
					longestAt[i] = longestAt[j] + 1;
					prev[i] = j;
				}
			}
		}
		//Find the longest from the longest Array
		int longest = 0;
		int indexOfLongest = 0;
		for(int i=0;i<longestAt.length;i++){
			if(longestAt[i]>longest){
				longest = longestAt[i];
				indexOfLongest = i;
			}
		}
		//Print longest sub sequence
		int j = indexOfLongest;
		while(j>=0){
			System.out.println(numbers[j]);
			j = prev[j];
		}
		return longest;
	}
}