package org.sur.ds.string;

import org.junit.Assert;
import org.junit.Test;
import org.sur.ds.string.EditDistance;


public class EditDistanceTest {

	@Test
	public void testGetEditDistance1() {
		EditDistance dist = new EditDistance();
		int editDistance = dist.getEditDistance("computer", "commuter");
		Assert.assertEquals(1, editDistance);
	}
	
	@Test
	public void testGetEditDistance2() {
		EditDistance dist = new EditDistance();
		int editDistance = dist.getEditDistance("test", "tester");
		Assert.assertEquals(2, editDistance);
	}

}
