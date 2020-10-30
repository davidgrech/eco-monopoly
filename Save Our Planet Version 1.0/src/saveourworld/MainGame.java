/**
 * 
 */
package saveourworld;

import java.util.Scanner;

/**
 * @author padra13
 *
 */
public class MainGame {

	private static Scanner sc;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stubs

		sc = new Scanner(System.in);

		BoardController SOW = new BoardController();

		System.out.println("Do you want to start the game? (y/n)");

		String userInput = sc.next();

		try {
			if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {

				// start game, kickoff registration process
				SOW.startGame();

				// player takes turn, starting game process
				SOW.takeTurn();

		
			}else {
				SOW.GameNotStarted();

			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.err.println("General Error");
			// sc.close();
			ex.printStackTrace();
		}

		

	}

}
