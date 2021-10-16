package demoGL.Driver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import demoGL.Building.Building_Order;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of floors in the building :");
		int noOfFloors = scan.nextInt();
		if (noOfFloors <= 0) {
			// Checking input to make sure its greater than 0
			while(noOfFloors <= 0) {
				System.out.println("Please enter a number greater than 0");
				noOfFloors = scan.nextInt();
			}
		}

		// 2 queues one to accept input and the other to check that input is correct
		Queue<Integer> input = new LinkedList<>();
		Queue<Integer> checkInput = new LinkedList<>();

		// For loop to accept the floors in the size they are given each day
		for (int i = 0 ; i < noOfFloors ; i++) {
			System.out.println("Enter the floor size given on day : "+(i+1));
			int floorSize = scan.nextInt();

			/* While loop checks that :
			 * 1. The number is between 1 and no. of floors previously entered 
			 * 2. No size is repeated
			 */
			while(i < noOfFloors) {

				// First check for range

				if (floorSize <= 0 || floorSize > noOfFloors) {
					System.out.println("Please enter a size between 1 and " + noOfFloors);
					floorSize = scan.nextInt();
					continue;
				}

				//Second check to ensure each value is entered only once

				else if ( 0 < floorSize && floorSize <= noOfFloors) {
					if(checkInput.isEmpty()) {
						checkInput.add(floorSize);
						break;
					}
					else {
						int count = 0;
						for(int j = 0 ; j < checkInput.size() ; j++) {
							int temp = checkInput.remove();
							if(floorSize != temp) {
								checkInput.add(temp);
								count = count + 1;
							}
							else
								checkInput.add(temp);

						}

						if(count == checkInput.size()) {
							checkInput.add(floorSize);
						}

						else {
							System.out.println("This size already exists please enter another size from 1 to " + noOfFloors);
							floorSize = scan.nextInt();
							continue;
						}

						break;

					}
				}

			}


			input.add(floorSize);

		}

		// Building Order method is called to show the order in which the construction can be done

		Building_Order obj = new Building_Order();
		obj.buildingOrder(input, noOfFloors);

		System.out.println();
	}

}
