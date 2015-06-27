package org.sur.ds.computation;

import org.junit.Assert;
import org.junit.Test;

public class KnapsackTest {

	@Test
	public void testSolve() {
		Knapsack k = new Knapsack();
		/**
		 * Item Weight Value
		 * 1 6 $30
		 * 2 3 $14
		 * 3 4 $16
		 * 4 2 $9
		 */
		int[] weights = new int[]{6,3,4,2};
		int[] values = new int[]{30,14,16,9};
		int expected = 46;
		int W = 10;
		Assert.assertEquals(expected, k.solve(weights, values, W));

	}

}
