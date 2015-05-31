package org.sur.ds.computation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumTest {

	@Test
	public void testContainsThreeSum() {
		Integer[] numbers = new Integer[]{-25,-10, -7, -3, 2, 4, 8, 10};
		ThreeSum threeSum = new ThreeSum();
		Set<Integer> numbersSet = new HashSet<Integer>(Arrays.asList(numbers));
		Assert.assertTrue(threeSum.containsThreeSum(numbersSet, 0));
	}

}
