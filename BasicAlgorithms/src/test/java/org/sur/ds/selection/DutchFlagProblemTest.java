package org.sur.ds.selection;

import org.junit.Assert;
import org.junit.Test;

public class DutchFlagProblemTest {

	@Test
	public void testSolve1() {
		Integer[] numbers = new Integer[]{2,1,0,2,0,1};
		DutchFlagProblem dfp = new DutchFlagProblem();
		dfp.solve(numbers);
		Integer[] expected = new Integer[]{0,0,1,1,2,2};
		Assert.assertArrayEquals(expected, numbers);
	}
	
	@Test
	public void testSolve2() {
		Integer[] numbers = new Integer[]{1,0,2,2,0,1};
		DutchFlagProblem dfp = new DutchFlagProblem();
		dfp.solve(numbers);
		Integer[] expected = new Integer[]{0,0,1,1,2,2};
		Assert.assertArrayEquals(expected, numbers);
	}

}
