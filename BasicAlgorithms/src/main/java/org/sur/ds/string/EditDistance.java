package org.sur.ds.string;

/**
 * Implementation of finding Edit Distance (Levenshtein distance) using 
 * dynamic programming
 *
 */
public class EditDistance {

	public int getEditDistance(String str1, String str2){
		int strLen1 = str1.length();
		int strLen2 = str2.length();
		Integer[][] costMatrix = new Integer[strLen1][strLen2];
		for(int i = 0;i<strLen1;i++){
			for(int j = 0;j<strLen2;j++){
				if(i==0 && j == 0){
					//Cost to convert String of length 0 to string of length 0 is 0
					costMatrix[i][j] = 0;
				}
				else if(i==0){
					//Cost to convert String of length 0 to String of length i is zero
					costMatrix[i][j] = i;
				}
				else if(j==0){
					//Cost to convert String of length 0 to String of length j is j
					costMatrix[i][j] = j;
				}
				else{
					int previousCost = costMatrix[i-1][j-1];
					//We've been given 2 new letters to add to each string
					char c1 = str1.charAt(i);
					char c2 = str2.charAt(j);
					int additionalCost;
					if(c1==c2){
						//if both letters are the same, there's no cost
						additionalCost = 0;
					}
					else{
						//Otherwise there is the cost of changing one letter to another
						additionalCost = 1;
					}
					//Minimum of 3 cases
					int minCost = Math.min(
							//cost of moving from [i-1][j-1] to [i][j]  (add one letter to both strings)
							previousCost + additionalCost, 
							Math.min(
									//Cost of moving from [i-j][j] to [i][j] (always costs 1) (Add one letter to str1)
									costMatrix[i-1][j] + 1,
									//Cost of moving from [i][j-1] to [i][j] (always costs 1) (Add one letter to str2)
									costMatrix[i][j-1] + 1));
					costMatrix[i][j] = minCost;
				}
			}
		}
		return costMatrix[strLen1-1][strLen2-1];
	}
}