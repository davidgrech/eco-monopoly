/**
 * 
 */
package saveourworld;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author David Holds player information
 */
public class Player {

	private static final int NAME_MIN = 1;
	private static final int NAME_MAX = 20;
	private static final int POSITION_MIN = 0;
	private static final int POSITION_MAX = 11;
	private static final int GREEN_COIN_MIN = 0;
	private static final int GREEN_COIN_MAX = 20000;

	private String name;
	private int position;
	private int greenCoin;

	/**
	 * Default constructor
	 */
	public Player() {

	}

	/**
	 * Constructor with fields
	 * 
	 * @param name
	 * @param position
	 * @param greenCoin
	 */
	public Player(String name, int position, int greenCoin) {
		this.setName(name);
		this.setPosition(position);
		this.setGreenCoin(greenCoin);
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", position=" + position + ", greenCoin=" + greenCoin + "]";
	}

	/**
	 * set player name
	 * 
	 * @param name must be set between 1 and 20 characters
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name.trim().length() >= NAME_MIN && name.trim().length() <= NAME_MAX) {
			this.name = name;
		} else {
			throw new IllegalArgumentException(
					"Name must be set between " + NAME_MIN + " and " + NAME_MAX + " characters long, try again.");
		}
	}

	/**
	 * 
	 * @return position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * set player position
	 * 
	 * @param position must be set between 0 and 11
	 */
	public void setPosition(int position) throws IllegalArgumentException {
		if (position >= POSITION_MIN && position <= POSITION_MAX) {
			this.position = position;
		} else {
			throw new IllegalArgumentException(
					"Position must be set between " + POSITION_MIN + " and " + POSITION_MAX + ", try again.");
		}
	}

	/**
	 * 
	 * @return greenCoin
	 */
	public int getGreenCoin() {
		return greenCoin;
	}

	/**
	 * set greenCoin
	 * 
	 * @param greenCoin must be set between 0 and 20,000
	 */
	public void setGreenCoin(int greenCoin) {
		if (greenCoin >= GREEN_COIN_MIN && greenCoin <= GREEN_COIN_MAX) {
			this.greenCoin = greenCoin;
		} else {
			throw new IllegalArgumentException(
					"Greencoin must be set between " + GREEN_COIN_MIN + " and " + GREEN_COIN_MAX + ", try again.");
		}
	}

	/**
	 * increases a players funds by a chosen amount
	 * 
	 * @param add
	 * @return
	 */
	public int increaseFunds(int add) {
		return this.greenCoin += add;
	}

	/**
	 * method for reducing greencoin to pay rent
	 * 
	 * @param rent
	 * @return
	 */
	public int reduceFunds(int reduce) {

		return this.greenCoin -= reduce;

	}

	/**
	 * This method registers a chosen number of players, between 2 and 4
	 * 
	 * @param numPlayers
	 * @param sc
	 * @param balance    - start balance
	 * @return list of players
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Player> playerRegistration(int numPlayers, Scanner sc, int balance)
			throws IllegalArgumentException {

		ArrayList<Player> players = new ArrayList<Player>();

		for (int i = 1; i <= numPlayers; i++) {

			System.out.printf("Player %d, what is your name?\n", (i));

			String playerName = sc.next();

			// check arraylist to make sure no duplicates exist

			for (Player p : players) {
				

				if (p.getName().contains(playerName)) {

					System.out.println("That name is taken, please enter a new name");

					playerName = sc.next();

					
					if (p.getName().contains(playerName)) {

					
						System.err.println("Could resolve error.. GoodBye!!");
						System.exit(0);
					}//end inside if

				} // end if

			} // end for

			Player player = new Player(playerName, 0, balance);

			players.add(player);

		}
		return players;

	}

}