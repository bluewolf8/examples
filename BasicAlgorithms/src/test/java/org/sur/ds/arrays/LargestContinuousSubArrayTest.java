package org.sur.ds.arrays;

import org.junit.Assert;
import org.junit.Test;

public class LargestContinuousSubArrayTest {

	LargestContinuousSubArray lcsa = new LargestContinuousSubArray();
	
	@Test
	public void testGetLargestContinuousSubArray() {
		Integer[] numbers = new Integer[]{-2, -3, 4, -1, -2, 1, 5, -3};
		Assert.assertEquals(7, lcsa.getLargestContinuousSubArray(numbers));
	}

}
