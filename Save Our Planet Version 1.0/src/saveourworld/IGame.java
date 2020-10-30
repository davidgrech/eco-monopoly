/**
 * 
 */
package saveourworld;

import java.util.ArrayList;
import java.util.List;


/**
 * @author padra13
 *
 */
public interface IGame {
	/**
	 * 
	 * @author padra13
	 */
	public void startGame();
	/**
	 * Method quits game, display end game details such as the selected outcome
	 * display all players resources as per the last turn
	 * @author padra13
	 */
	public void quitGame();
	
	
	/**
	 * Method to be ran once one player has sufficent funds,
	 * display all players finals details, such as resources and declares if team has won the battle against climate change 
	 * @author padra13
	 */
	public void endGame(ArrayList<Player> p);
	
	/**
	 * Method allowing player to take turn
	 * gets player position at start of turn and resets once turn is completed
	 * 
	 * @author padra13
	 */
	public void takeTurn();

	
	/**
	 * 
	 * @param p
	 * @param board
	 */
	public void buyArea(Player p, List<Square> board);
	
	
	
	
	public void developArea(Player player, List<Square> board);
	
	
	
	
}
