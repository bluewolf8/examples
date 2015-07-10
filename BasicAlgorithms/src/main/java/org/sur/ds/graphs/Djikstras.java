package org.sur.ds.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.sur.ds.graphs.Node;

/**
 * Djikstras shortest path implementation using a priority queue
 *
 */
public class Djikstras {

	public List<Node> getShortestPath(Node source, Node destination) throws Exception{
		//Stores the previous nodes for every node, used for tracing back the shortest path
		Map<Node,Node> prevNodes = new HashMap<>();
		//Stores the minimum cost from the source to every node (initially infinity for all but the source node)
		Map<Node, Integer> minCostFromSource = new HashMap<>();
		//Priority queue used for retrieving the next node having min cost from the source
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new DistanceBasedComparator(minCostFromSource));
		initCostsToInfinity(source,minCostFromSource);
		//For source set the min cost to 0 (from source to source cost can only be 0
		minCostFromSource.put(source, 0);
		addGraphToQueue(source, pq);
		//for source set prev node as itself
		prevNodes.put(source, source);

		while(!pq.isEmpty()){
			//Pick node with smallest distance from source node
			Node node = pq.poll();

			//Get all its neighbors and update their distances and prev nodes as needed
			List<Node> neighbors = node.getNeighbors();
			Map<Node,Integer> ctn = node.getCostToNeighbors();
			neighbors.forEach((neighbor)->{
				int costToNeighbor = ctn.get(neighbor);
				int minCostFromSourceToNode = minCostFromSource.get(node);
				if((minCostFromSourceToNode + costToNeighbor )< minCostFromSource.get(neighbor)){
					//Update the minimum cost for neighbor as we  have found a shorter path from
					//source with current node as the previous node
					minCostFromSource.put(neighbor, minCostFromSourceToNode + costToNeighbor );
					prevNodes.put(neighbor, node);
				}
			});
		}

		//At this point we have the best paths from each node
		//Now trace backwards from the destination using prevnodes
		//to provide the best path back to source
		List<Node> path = new ArrayList<Node>();
		path.add(destination);
		Node n = prevNodes.get(destination);
		while(n!=source){
			path.add(n);
			n = prevNodes.get(n);
		}
		path.add(source);

		//Reverse and return (so that we get path from src to dest not the other way around)
		Collections.reverse(path);
		return path;
	}

	/**
	 * Comparator based on minimum distance from source
	 *
	 */
	private class DistanceBasedComparator implements Comparator<Node>{
		Map<Node, Integer> minCostFromSource;

		public DistanceBasedComparator(Map<Node, Integer> minCostFromSource) {
			this.minCostFromSource = minCostFromSource;
		}

		@Override
		public int compare(Node n1, Node n2) {
			if(minCostFromSource.get(n1) == minCostFromSource.get(n2)){
				return 0;
			}
			else if(minCostFromSource.get(n1) > minCostFromSource.get(n2)){
				return 1;
			}
			else return -1;
		}

	}

	/**
	 * Initializes all costs to infinity
	 * @param nodes
	 * @param costSoFar
	 */
	private void initCostsToInfinity(Node nodes, Map<Node, Integer> minCostFromSource){
		nodes.getNeighbors().forEach((neighbor) ->{
			if(!minCostFromSource.containsKey(neighbor)){
				minCostFromSource.put(neighbor, Integer.MAX_VALUE);
				initCostsToInfinity(neighbor, minCostFromSource);
			}
		}
				);
	}

	/**
	 * Adds the graph to the queue
	 * @param nodes
	 * @param pq
	 */
	private void addGraphToQueue(Node graph, PriorityQueue<Node> pq){
		pq.add(graph);
		graph.getNeighbors().forEach((neighbor) ->{
			if(!pq.contains(neighbor)){
				pq.add(neighbor);
			}
		});
	}
}