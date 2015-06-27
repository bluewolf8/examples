package org.sur.ds.computation;


import org.junit.Assert;
import org.junit.Test;

public class LongestContinuousSubSequenceTest {

	@Test
	public void testGetLongestIncreasingSubSeq() {
		Integer[] numbers = new Integer[]{5, 2, 8, 6, 3, 6, 9, 7};
		LongestContinuousSubSequence sub = new LongestContinuousSubSequence();
		int actual = sub.getLongestIncreasingSubSeq(numbers);
		System.out.println(" Longest: " + actual);
		Assert.assertEquals(4, actual);
	}

}
