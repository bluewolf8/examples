package org.sur.ds.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Djikstras {

	public List<Node> getShortestPath(Node source, Node destination) throws Exception{
		//Stores the previous nodes for every node, used for tracing back the shortest path
		Map<Node,Node> prevNodes = new HashMap<>();
		Map<Node, Integer> minCostFromSource = new HashMap<>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new DistanceBasedComparator(minCostFromSource));
		initCostsToInfinity(source,minCostFromSource);
		//For source set the min cost to 0 (from source to source cost can only be 0
		minCostFromSource.put(source, 0);
		addAllNodesToQueue(source, pq);

		//for source set prev node as itself
		prevNodes.put(source, source);

		while(!pq.isEmpty()){
			//Pick node with smallest distance from current node
			Node node = pq.poll();

			//Get all its neighbors and update their distances and prev nodes as needed
			List<Node> neighbors = node.getNeighbors();
			Map<Node,Integer> ctn = node.getCostToNeighbors();
			neighbors.forEach((neighbor)->{
				int costToNeighbor = ctn.get(neighbor);
				int minCostFromSourceToNode = minCostFromSource.get(node);
				if((minCostFromSourceToNode + costToNeighbor )< minCostFromSource.get(neighbor)){
					minCostFromSource.put(neighbor, minCostFromSourceToNode + costToNeighbor );
					prevNodes.put(neighbor, node);
				}
			});
		}

		List<Node> path = new ArrayList<Node>();

		path.add(destination);
		Node n = prevNodes.get(destination);
		while(n!=source){
			path.add(n);
			n = prevNodes.get(n);
		}
		path.add(source);

		Collections.reverse(path);
		return path;
	}

	private class DistanceBasedComparator implements Comparator<Node>{
		Map<Node, Integer> costSoFar;

		public DistanceBasedComparator(Map<Node, Integer> costSoFar) {
			this.costSoFar = costSoFar;
		}

		@Override
		public int compare(Node n1, Node n2) {
			if(costSoFar.get(n1) == costSoFar.get(n2)){
				return 0;
			}
			else if(costSoFar.get(n1) > costSoFar.get(n2)){
				return 1;
			}
			else return -1;
		}

	}


	private void initCostsToInfinity(Node nodes, Map<Node, Integer> costSoFar){
		nodes.getNeighbors().forEach((neighbor) ->{
			if(!costSoFar.containsKey(neighbor)){
				costSoFar.put(neighbor, Integer.MAX_VALUE);
				initCostsToInfinity(neighbor, costSoFar);
			}
		}
				);
	}


	private void addAllNodesToQueue(Node nodes, PriorityQueue<Node> pq){
		pq.add(nodes);
		nodes.getNeighbors().forEach((neighbor) ->{
			if(!pq.contains(neighbor)){
				pq.add(neighbor);
			}
		});
	}
}