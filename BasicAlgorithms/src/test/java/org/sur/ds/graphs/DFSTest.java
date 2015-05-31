package org.sur.ds.graphs;

import org.junit.Test;

public class DFSTest {

	@Test
	public void test() {
		DFS bfs = new DFS();
		bfs.traverse(GraphTestUtils.getBinaryTree());
	}

}
