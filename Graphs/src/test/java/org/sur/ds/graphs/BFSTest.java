package org.sur.ds.graphs;

import org.junit.Test;

public class BFSTest {

	@Test
	public void testTraverse() {
		BFS bfs = new BFS();
		bfs.traverse(GraphTestUtils.getBinaryTree());
	}

}
