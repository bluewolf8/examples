package org.sur.ds.computation;


import org.junit.Assert;
import org.junit.Test;

public class MaximumValueSubSequenceTest {

	@Test
	public void testGetMaxValueSubSeq() {
		Integer[] numbers = new Integer[]{1, 101, 2, 3, 100, 4, 5};
		MaximumValueSubSequence maxSubSeq = new MaximumValueSubSequence();
		Assert.assertEquals(106, maxSubSeq.getMaxValueSubSeq(numbers));
	}

}
