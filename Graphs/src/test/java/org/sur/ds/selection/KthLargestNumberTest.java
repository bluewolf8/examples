package org.sur.ds.selection;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestNumberTest {

	@Test
	public void testPartition() {
		Integer[] numbers = new Integer[]{5,3,7,2,1};
		KthLargestNumber largestNumber = new KthLargestNumber();
		largestNumber.partition(numbers, 5, 0, numbers.length-1);
		Assert.assertTrue(Arrays.asList(numbers).indexOf(5)==3);
	}

	@Test
	public void testGetKthNumber() {
		Integer[] numbers = new Integer[]{5,3,7,2,1};
		KthLargestNumber largestNumber = new KthLargestNumber();
		int kthLargest = largestNumber.getKthLargest(numbers, 0, numbers.length-1,2);
		Assert.assertEquals(5,kthLargest);
	}

	@Test
	public void testGetMedian(){
		Integer[] numbers = new Integer[]{22,5,10,11,23,15,9,8,2,0,4,20,25,1,29,24,3,12,28,14,27,19,17,21,18,6,7,13,16,26};
		KthLargestNumber largestNumber = new KthLargestNumber();
		int median = largestNumber.getMedian(numbers,0,numbers.length-1);
		System.out.println(median);
		Assert.assertEquals(13,median);
	}
}
