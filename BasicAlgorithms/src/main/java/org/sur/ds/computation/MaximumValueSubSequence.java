package org.sur.ds.computation;

public class MaximumValueSubSequence {

	/**
	 * Max value increasing sub sequence of numbers
	 * @param numbers
	 * @return
	 */
	public int getMaxValueSubSeq(Integer[] numbers){
		Integer[] maxValueAt = new Integer[numbers.length];
		Integer[] prev = new Integer[numbers.length];

		//Initialize the prev array to all -1
		for(int i=0;i<prev.length;i++){
			prev[i] = -1;
		}

		//Max subsequence at index 0 can only be the number at index 0 as there are
		//no numbers before it
		maxValueAt[0] = numbers[0];

		for(int i=1;i<numbers.length;i++){
			//Initially the max value at index i is the number i itself
			maxValueAt[i] = numbers[i];
			//Consider each number from 0 to i-1, to see if including it in 
			//the sub-sequence provides better results
			for(int j=0;j<i;j++){
				int currentMaxVal = maxValueAt[i];
				int valueWithJ=maxValueAt[j] + numbers[i];
				//Ensure the sequence is increasing
				if(numbers[j] < numbers[i] &&
						//ensure that including j will yield a higher max
						currentMaxVal < valueWithJ){
					maxValueAt[i] = valueWithJ;
					prev[i] = j;
				}
			}
		}

		int max = 0;
		int indexOfMax = 0;

		//Find the max and corresponding index
		for(int i=0;i<maxValueAt.length;i++){
			if(max < maxValueAt[i]){
				max =maxValueAt[i];
				indexOfMax = i;
			}
		}

		while(indexOfMax>0){
			System.out.println(numbers[indexOfMax]);
			indexOfMax = prev[indexOfMax];
		}
		return max;
	}

}
