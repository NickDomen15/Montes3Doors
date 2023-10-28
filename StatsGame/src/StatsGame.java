import java.util.Random;

/**
 * StatsGame --- program to attempt the 
 * Monte's 3 Doors problem and prints results
 * @author Nick Domenico
 */
public class StatsGame {
	
	Random rand = new Random();
	
	/**
	 * Attempts the Monte's 3 Doors game "int numberOfAttempts" times 
	 * without changing the door selected after removing an incorrect door.
	 * Counts the number of wins and losses and prints the results.
	 * @param int numberOfAttempts
	 */
	public void noChange(int numberOfAttempts) {
		int wins = 0;
		int losses = 0;
		
		// randomizes picked door and correct door, if they are the same, adds 1 to wins
		for (int i = 0; i < numberOfAttempts; i++ ) {
			int correctDoor = rand.nextInt(3) + 1;
			int pickedDoor = rand.nextInt(3) + 1;
			if (pickedDoor == correctDoor) {
				wins++;
			}
			else {
				losses++;
			}
		}
		
		System.out.println(numberOfAttempts + " attempts without changing door:\nNumber of wins: " + wins + "\nNumber of losses: " + losses);
	}
	
	
	/**
	 * Attempts the Monte's 3 Doors game "int numberOfAttempts" times 
	 * and changes the door selected after removing an incorrect door.
	 * Counts the number of wins and losses and prints the results.
	 * @param int numberOfAttempts
	 */
	public void changeDoor(int numberOfAttempts) {
		int wins = 0;
		int losses = 0;
		
		for (int i = 0; i < numberOfAttempts; i++) {
			int correctDoor = rand.nextInt(3) + 1;
			int pickedDoor = rand.nextInt(3) + 1;
			int originalPick = pickedDoor; // when changing picked door, cannot pick the original choice
			int incorrectDoor = rand.nextInt(3) + 1;
			
			// if the incorrect door to be eliminated is the correct door, randomize incorrect door again
			while (incorrectDoor == correctDoor) {
				incorrectDoor = rand.nextInt(3) + 1;
			}
			
			do {
				pickedDoor = rand.nextInt(3) + 1; // changes the picked door
			} while (pickedDoor == incorrectDoor || pickedDoor == originalPick); 
			/* if the new picked door is the incorrect door (which cannot be picked) 
			 * or if the new pick is the original pick, change picked door again
			 */
			
			if (pickedDoor == correctDoor) {
				wins++;
			}
			else {
				losses++;
			}
		}
		
		System.out.println("\n" + numberOfAttempts + " attempts with changing door:\nNumber of wins: " + wins + "\nNumber of losses: " + losses);
	}
} 