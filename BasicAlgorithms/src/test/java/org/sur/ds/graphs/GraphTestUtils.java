package org.sur.ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphTestUtils {
	
	public static Node getBinaryTree(){
		List<Node> nb6 = new ArrayList<Node>();
		Node n6 = new Node(nb6, "6");
		
		List<Node> nb7 = new ArrayList<Node>();
		Node n7 = new Node(nb7, "7");
		
		List<Node> nb3 = new ArrayList<Node>();
		Node n3 = new Node(nb3, "3");
		nb3.add(n6);
		nb3.add(n7);
		
		List<Node> nb4 = new ArrayList<Node>();
		Node n4 = new Node(nb4, "4");
		
		List<Node> nb5 = new ArrayList<Node>();
		Node n5 = new Node(nb5, "5");
		
		List<Node> nb2 = new ArrayList<Node>();
		Node n2 = new Node(nb2, "2");
		nb2.add(n4);
		nb2.add(n5);
		
		List<Node> nb1 = new ArrayList<Node>();
		nb1.add(n2);
		nb1.add(n3);
		Node n1 = new Node(nb1, "1");
		
		return n1;
	}

}
