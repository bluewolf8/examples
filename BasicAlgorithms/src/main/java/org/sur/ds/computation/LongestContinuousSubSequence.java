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

		longestAt[0] = 1;
		prev[0] = -1;

		for(int i=1;i<numbers.length;i++){
			//Default to one, as longest subsequence is at least 1 number long
			longestAt[i] = 1;
			prev[i] = -1;

			for(int j=0;j<i;j++){
				if(numbers[i] > numbers[j] //Potential sub sequence
						//Longest so far plus one, check if that is longer than current longest at i
						&& longestAt[j] + 1 > longestAt[i]
						){
					longestAt[i] = longestAt[j] + 1;
					prev[i] = j;
				}
			}
		}
		int max = 0;
		int lastIndex = 0;
		for(int i=0;i<longestAt.length;i++){
			if(longestAt[i]>max){
				max = longestAt[i];
				lastIndex = i;
			}
		}
		//Print longest sub sequence
		int j = lastIndex;
		while(j>=0){
			System.out.println(numbers[j]);
			j = prev[j];
		}
		return max;
	}
}