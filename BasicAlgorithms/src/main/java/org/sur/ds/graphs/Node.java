package org.sur.ds.graphs;

import java.util.List;
import java.util.Map;

public class Node {

	private final List<Node> neighbors;
	private boolean traversed = false;
	private final String value;
	private Map<Node, Integer> costToNeighbors;

	public Node(List<Node> neighbors, String value){
		this.neighbors = neighbors;
		this.value = value;
	}

	public boolean isTraversed() {
		return traversed;
	}

	public void setTraversed(boolean traversed) {
		this.traversed = traversed;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public String getValue() {
		return value;
	}

	public String toString(){
		return value;
	}

	public Map<Node, Integer> getCostToNeighbors() {
		return costToNeighbors;
	}

	public void setCostToNeighbors(Map<Node, Integer> costToNeighbors) {
		this.costToNeighbors = costToNeighbors;
	}
}