package org.sur.ds.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	
	public void traverse(Node start){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(start);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			node.setTraversed(true);
			System.out.println(node.getValue());
			List<Node> neighbors = node.getNeighbors();
			neighbors.forEach((n)->{
				if(!n.isTraversed()){
					queue.add(n);
				}
			});
		}
	}
}
