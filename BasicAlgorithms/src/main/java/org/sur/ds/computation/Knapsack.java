package org.sur.ds.computation;

public class Knapsack {
	/**
	 * 
	 * @param weights weight of item by index
	 * @param values value of item by index
	 * @param W maximum weight the Knapsack can hold
	 */
	public int solve(int[] weights, int[] values, int W){
		//2-D array, row represents item number, column represents 
		//best value for weight less than or equal to w
		//Note we create array with length n+1 because we include the case for 0 item/0 weight as well
		//for example in case 4 items are being considered we need an array of size 5
		//in the 0th place of the array will be the case when 0 items are being considered.
		int[][] best = new int[values.length+1][W+1];
		//Iterate through each item one by one
		for(int i= 0;i<=values.length;i++){
			//For each item increase weight from zero to W, current weight we
			//are considering is w
			for(int w=0;w<=W;w++){
				int currentItem = i-1; //since values and weights array is zero indexed
				int currentBest = i; //since best is not zero indexed
				int prevBest = i-1; //since best is not zero indexed, i-1 actually means previous
				if(i==0 || w==0){
					//For 0 items or 0 weight best value is 0
					best[i][w] = 0;
				}
				//If weight of current item  is less than or equal to the current weight we are considering (w)
				else if(weights[currentItem]<=w){
					best[currentBest][w] = 
							Math.max(
									//Previous best for this weight
									best[prevBest][w], 
									//Current value + value of previous best for weight (w - current items weight)
									values[currentItem] + best[prevBest][w - weights[currentItem]]);
				}
				else {
					//We cannot consider current item for this weight w since it's weight is greater
					//so store the previous best item for this weight
					best[currentBest][w] = best[prevBest][w];
				}
				System.out.println("Best value for weight " + w + 
						(i==0?" and considering no items ":" and considering item with index " + (currentItem)) + " is "+ best[i][w]);
			}

		}
		return best[values.length][W];
	}
}