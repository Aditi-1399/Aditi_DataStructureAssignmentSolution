package demoGL.Building;

import java.util.LinkedList;
import java.util.Queue;

public class Building_Order {

	public void buildingOrder(Queue<Integer> input , int noOfFloors) {

		System.out.println("The order of construction is as follows : ");

		// Largest size is assumed to be the same as no. of floors in the building
		int largestNum = noOfFloors;

		// Temporary queue stores the floor sizes that cannot be assembled as of that work day
		Queue<Integer> temp = new LinkedList<>();

		/* For loop is used to print floors that can be assembled on particular work day
		 * 
		 * Each day one value is removed from input queue and is compared to largest value , 
		 * if it is equal it gets printed and we move to next day
		 * else it gets added to temporary queue and we move to next day
		 * 
		 * Each time a value is printed temporary queue is checked and if next largest values are present they also get printed
		 * 
		 * After the last day all remaining values in temporary queue are printed in descending order
		 */
		for (int i = 0 ; i < noOfFloors ; i++) {
			System.out.println();
			System.out.println("Day : " + (i+1));
			int f = input.remove();
			if(f != largestNum) {
				temp.add(f);
			}
			else {
				System.out.print(f +" ");
				largestNum = largestNum - 1;
				int tempLength = temp.size();
				for(int j = 0 ; j < tempLength ; j++) {
					int t = temp.remove();
					if(t == largestNum) {
						System.out.print(t + " ");
						largestNum = largestNum - 1;
						tempLength = tempLength - 1;
						j = -1;
					}
					else {
						temp.add(t);
					}
				}
			}
		}

		while(!temp.isEmpty()) {
			for(int p = 0 ; p < temp.size() ; p++) {
				int tnum = temp.remove();
				if(tnum == largestNum) {
					System.out.print(tnum + " ");
					largestNum = largestNum - 1;
				}
				else {
					temp.add(tnum);
				}
			}
		}

	}

}
