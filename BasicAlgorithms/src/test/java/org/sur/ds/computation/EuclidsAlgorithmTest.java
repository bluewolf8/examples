package org.sur.ds.computation;

import org.junit.Assert;
import org.junit.Test;

public class EuclidsAlgorithmTest {
	
	EuclidsAlgorithm algo = new EuclidsAlgorithm();

	@Test
	public void testGcd() {
		Assert.assertEquals(4, algo.gcd(8,12));
	}

}
