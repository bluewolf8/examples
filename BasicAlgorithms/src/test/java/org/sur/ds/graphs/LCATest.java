package org.sur.ds.graphs;


import org.junit.Assert;
import org.junit.Test;

public class LCATest {

	@Test
	public void testGetLCA1() {
		Node tree = GraphTestUtils.getBinaryTree();
		LCA lca = new LCA();
		Node node = lca.getLCA(tree, "5", "7");
		Assert.assertEquals("1", node.getValue());
	}
	
	@Test
	public void testGetLCA2() {
		Node tree = GraphTestUtils.getBinaryTree();
		LCA lca = new LCA();
		Node node = lca.getLCA(tree, "4", "5");
		Assert.assertEquals("2", node.getValue());
	}

}
