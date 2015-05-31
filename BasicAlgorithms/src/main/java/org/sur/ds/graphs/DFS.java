package org.sur.ds.graphs;

import java.util.List;
import java.util.Stack;

/**
 * Depth-first search implementation
 *
 */
public class DFS {
	public void traverse(Node start){
		Stack<Node> stack = new Stack<Node>();
		stack.add(start);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			node.setTraversed(true);
			System.out.println(node.getValue());
			List<Node> neighbors = node.getNeighbors();
			neighbors.forEach((n)->{
				if(!n.isTraversed()){
					stack.add(n);
				}
			});
		}
	}
}
