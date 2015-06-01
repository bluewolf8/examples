package org.sur.ds.graphs;

/**
 * Gets the least common ancestor using recursion
 *
 */
public class LCA {

	public Node getLCA(Node node, String value1, String value2){
		if(node.getValue().equals(value1) || node.getValue().equals(value2)){
			//return then node itself to tell caller that one of the nodes being searched has been found
			return node;
		}
		else if(node.getNeighbors().size()==0){
			return null;
		}
		Node left = getLCA(node.getNeighbors().get(0), value1, value2);
		Node right = getLCA(node.getNeighbors().get(1), value1, value2);

		if(left!=null && right!=null){
			return node;
		}
		else if(left!=null){
			return left;
		}
		else if(right!=null){
			return right;
		}
		return null;
	}

}
