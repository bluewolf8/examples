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

		for(int i=0;i<prev.length;i++){
			prev[i] = -1;
		}

		maxValueAt[0] = numbers[0];

		for(int i=1;i<numbers.length;i++){
			maxValueAt[i] = numbers[i];
			for(int j=0;j<i;j++){
				int currentMaxVal = maxValueAt[i];
				int valueWithJ=maxValueAt[j] + numbers[i];
				if(numbers[j] < numbers[i] &&
						currentMaxVal < valueWithJ){
					maxValueAt[i] = valueWithJ;
					prev[i] = j;
				}
			}
		}

		int max = 0;
		int indexOfMax = 0;

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
