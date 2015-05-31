package org.sur.ds.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class DjikstrasTest {

	@Test
	public void testGetShortestPath() throws Exception {
		Djikstras dj = new Djikstras();

		List<Node> nba = new ArrayList<Node>();
		Map<Node, Integer> ctna = new HashMap<>();
		Node a = new Node(nba, "a");
		a.setCostToNeighbors(ctna);

		List<Node> nbb = new ArrayList<Node>();
		Map<Node, Integer> ctnb = new HashMap<>();
		Node b = new Node(nbb, "b");
		b.setCostToNeighbors(ctnb);

		List<Node> nbc = new ArrayList<Node>();
		Map<Node, Integer> ctnc = new HashMap<>();
		Node c = new Node(nbc, "c");
		c.setCostToNeighbors(ctnc);

		List<Node> nbd = new ArrayList<Node>();
		Map<Node, Integer> ctnd = new HashMap<>();
		Node d = new Node(nbd, "d");
		d.setCostToNeighbors(ctnd);

		List<Node> nbe = new ArrayList<Node>();
		Map<Node, Integer> ctne = new HashMap<>();
		Node e = new Node(nbe, "e");
		e.setCostToNeighbors(ctne);

		nba.add(b);
		ctna.put(b, 10);
		nba.add(c);
		ctna.put(c, 3);

		nbb.add(c);
		ctnb.put(c, 1);

		nbc.add(b);
		nbc.add(d);
		nbc.add(e);
		ctnc.put(b, 4);
		ctnc.put(d, 8);
		ctnc.put(e, 2);

		nbd.add(e);
		ctnd.put(e, 7);

		nbe.add(d);
		ctne.put(d, 9);

		List<Node> nodes = dj.getShortestPath(a, e);
		Assert.assertTrue(nodes.get(0) == a);
		Assert.assertTrue(nodes.get(1) == c);
		Assert.assertTrue(nodes.get(2) == e);
	}

}
