/**
 * 
 */
package saveourworld;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author padra13
 *
 */

public class BoardController implements IGame {

	private static final int PLAYERS_MIN = 1;
	private static final int PLAYERS_MAX = 4;
	private static final int NUMBER_OF_YEARS_LEFT = 20;
	private static final int LAPMONEY = 500;
	private static final int WINNING_AMOUNT_INDIVIDUAL = 20000;
	private static final int WINNING_AMOUNT_GROUP = 30000;

	private static final int START_BALANCE = 5000;

	private static Scanner sc = new Scanner(System.in);

	public ArrayList<Square> board;

	public ArrayList<Player> players;

	public BoardController() {

	}

	/**
	 * Creating board object
	 */
	public BoardController(ArrayList<Square> board, ArrayList<Player> players) {
		this.board = board;
		this.players = players;

	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub

		printWelcomeMessage();

		// System.out.println("Starting game");

		int failedAttempts = 1;
		boolean valid;
		int playersTotal = 0;

		// limiting player attempts to 3 tries, if fails then no registration occurs
		do {
			// setup game
			System.out.println("Tries left = " + (4 - failedAttempts));

			System.out.println("How many players are there? Please enter a numeric value between 2 and 4");

			try {

				playersTotal = sc.nextInt();

			} catch (Exception e) {
				// TODO: handle exception
				
				//e.printStackTrace();

				
				System.out.println("please enter an numeric value");
				playersTotal = sc.nextInt();

			}

			valid = playersTotal > PLAYERS_MIN && playersTotal <= PLAYERS_MAX;

			failedAttempts++;

//			System.out.println(failedAttempts);

		} while (!valid && failedAttempts <= 3);

		if (!valid) {
			endGameNoPlayersRegistered();
		}

		System.out.println("Player total = " + playersTotal);

		// register players
		players = Player.playerRegistration(playersTotal, sc, START_BALANCE);

		// load board
		board = (ArrayList<Square>) squareArrayList();

	}

	/**
	 * returns an array list of squares
	 * 
	 * @return
	 */
	public static List<Square> squareArrayList() {

		Square sq0 = new Square(0, "Start Square", "Home Square");
		Square sq1 = new Square(1, "Brazil", "South America", "+1 Thousand Acre Reforestation ", 100, 50, 150, false, 0,
				null, 1);
		Square sq2 = new Square(2, "Argentina", "South America", "+1 Million Acre Nature Reserve ", 100, 50, 150, false,
				0, null, 1);
		Square sq3 = new Square(3, "Tanzania", "Africa", "+1 Thousand Methane Biodigesters", 150, 75, 200, false, 0, null, 1);
		Square sq4 = new Square(4, "Kenya", "Africa", "+1 Thousand MW Tidal Energy Machine", 150, 75, 200, false, 0, null, 1);
		Square sq5 = new Square(5, "Ethiopia", "Africa", "+10 Thousand Bio Fuel Cell Generators ", 150, 75, 200, false, 0, null,
				1);
		Square sq6 = new Square(6, "Extreme Weather", "Travel Delays");

		Square sq7 = new Square(7, "India", "Asia", "+5 Thousand Bio Gas Generators", 150, 80, 250, false, 0, null, 1);
		Square sq8 = new Square(8, "Vietnam", "Asia", "+1 Thousand Acre Coral Reef Restoration", 150, 80, 250, false, 0, null,
				1);
		Square sq9 = new Square(9, "Indonesia", "Asia", "+5 Geothermal Power Plants ", 150, 80, 250, false, 0, null, 1);
		Square sq10 = new Square(10, "Spain", "Europe", "+1 Thousand MW Solar Power Farm ", 200, 100, 300, false, 0, null, 1);
		Square sq11 = new Square(11, "Scotland", "Europe", "+1 Thousand MW Wind Farm ", 200, 100, 300, false, 0, null, 1);

		ArrayList<Square> squares = new ArrayList<>();

		squares.add(sq0);
		squares.add(sq1);
		squares.add(sq2);
		squares.add(sq3);
		squares.add(sq4);
		squares.add(sq5);
		squares.add(sq6);
		squares.add(sq7);
		squares.add(sq8);
		squares.add(sq9);
		squares.add(sq10);
		squares.add(sq11);

		return squares;
	}

	/**
	 * Message to be display at start of game, welcoming players and creating
	 * context
	 */
	private void printWelcomeMessage() {

		System.out.println(
				"Welcome players, Scientists predict in less than 20 years increased atmospheric carbon will cause irreversible and catastrophic global warming, triggering a global mass extinction event: \nwith the potential loss of 80% of life on the planet.  \nA new carbon capture technology was discovered that can reduce atmospheric carbon in excess of 70%. \nThe world superpowers are too busy fighting over dwindling oil reserves to invest in this new technology. \nSomething clearly needs to be done.\n");
		System.out
				.println("Alas there is hope, several groups of non-profit organisations have joined together to raise "
						+ WINNING_AMOUNT_INDIVIDUAL
						+ " greencoin through ecological schemes across the globe, with the help from altruistic investors.\nGreencoin is a new cryptocurrency which is backed only by development in green solutions. \nNo other currency will be accepted as to do so may further deepen our decline\n");

		System.out.println("The task is difficult, but possible and with so little time left, " + NUMBER_OF_YEARS_LEFT
				+ " to be exact.. it may be our only chance of saving our world…..\n");

	}

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		
		String userIn;
		
		
		// keep gaming looping
		for (int i = 1; i <= NUMBER_OF_YEARS_LEFT; i++) {

			// loop array of players..

			for (Player player : players) {
				System.out.println("*******************************");

				// details at start of game

				System.out.println(player.getName() + " is at position number " + player.getPosition()
						+ ", name of area is " + board.get(player.getPosition()).getAreaName()
						+ " player has available greencoin resources of " + player.getGreenCoin());

				// ask if player is ready to roll to start turn

				System.out.println("\n" + player.getName() + ", would you like to roll to start your turn? (y/n)");

				userIn = sc.next();

				if (userIn.equalsIgnoreCase("y") || userIn.equalsIgnoreCase("yes")) {

					// move player
					movePlayer(player);

				} else {

					System.out.println(player.getName() + " does not want to continue. Exiting game!!");
					// quitGame();
					// endTurn(player);
					quitGame();

					System.exit(0);

				}

				// use player position to determine available options

				// checking if property owned

				if ((board.get(player.getPosition())).isOwned()) {
					System.out.println(
							"\nThis area already has an investor : " + board.get(player.getPosition()).getOwner());

					// pay rent use case here??

					// making sure player doesnt pay rent to themselves
					if (!(board.get(player.getPosition())).getOwner().equals(player)) {
						System.out.println(player);

						// if player resources are greater than the rent payment
						if (player.getGreenCoin() > (board.get(player.getPosition())).getAreaContribution()) {

							// shows player paying rent to another player
							System.out.println(player.getName()
									+ " after visiting the area, decided to contribute the following greencoin "
									+ (board.get(player.getPosition())).getAreaContribution() + " to "
									+ (board.get(player.getPosition())).getOwner().getName());
							// System.out.println(player);

							// get rent payment, based on standard rent amount multiplied the increased
							// development stage
							int contribution = ((board.get(player.getPosition())).getAreaContribution());
							// * (board.get(player.getPosition()).getRentMultiplier());

							player.reduceFunds(contribution);

							Player owner = (board.get(player.getPosition())).getOwner();

							payAnotherPlayer(owner, contribution);

							// output ammended details for each affected player
							System.out.println("\nAfter transferring funds to " + owner + ", " + player.getName()
									+ " greencoin resource balances are " + player.getGreenCoin());

							System.out.println(
									"\nAfter another player visited " + board.get(player.getPosition()).getAreaName()
											+ ", the assets details are as follows" + owner);

						} else {

							System.out.println(player.getName() + " has ran out of greencoin, time to conclude game..");
							endGame(players);

						}

					} else {
						System.out.println("\n" + player.getName()
								+ " owns the area themselves, and are pleased with the current level of progress in this area");
					}
				} else {
					// option to buy in here
					buyArea(player, board);

					// display to user after purchase has happened
					System.out.println("\nAfter that transaction " + player.getName() + " greencoin resources are : "
							+ player.getGreenCoin());

				}

				/// starting develop area use cases

				// firstly fetch player assets, store in a list
				// qualifying investments

				List<Square> ps = showPlayerAssets(player);

				
				
				
				// check if player has investments

				System.out.println("\nWould you like to see your investments? (y/n)");

				userIn = sc.next();
				if (userIn.equalsIgnoreCase("y") || userIn.equalsIgnoreCase("yes")) {
//					System.out.println(showPlayerAssets(player));

					for (Square tlist : ps) {

						System.out.println(tlist);

					}
					System.out.println();
					// check players assets list for matching invests, if so then development can be
					// started
				}
					checkForMatchingInvestments(ps, player);

				

				System.out.println("\nThe players details at the end of turn are ...");

				System.out.println(player);

				// check player balance at end of turn, if less than 0 end game use case....
			
				
				
				System.out.println("\nEnd of turn : " + i);
				System.out.println("*******************************");
				
				// at end of turn check if player wants to quit game

				// quitGame();
				// -> end game scenario, when run out of turns

				if (i == NUMBER_OF_YEARS_LEFT) {

					endGame(players);
				}
			} // loop --> end game scenario, when run out of turns
				// checking for end game

			// -> end game scenario, when run out of turns

			System.out.println("\nWould you like to see game standings? (y/n)");
			userIn = sc.next();
			
			
			if (userIn.equalsIgnoreCase("y") || userIn.equalsIgnoreCase("yes")) {
				System.out.println("After turn " + i + " the board looks like .... ");
				showAllCurrentPlayerAssets(board);
				System.out.println();

			} else {
				System.out.println();
			}

			// -> end game scenario, when run out of turns

		}
	}

	/**
	 * 
	 * List searchs board owners and returns a list of matching properties
	 * 
	 * @param player
	 * @return a list of assets belonging to that player for further analysis
	 */
	private List<Square> showPlayerAssets(Player player) {
		List<Square> suitableAreasForDevelopment = new ArrayList<>();

		for (int loop = 0; loop < board.size(); loop++) {

			if (board.get(loop).getOwner() == player) {
				suitableAreasForDevelopment.add(board.get(loop));

			}

		}

		return suitableAreasForDevelopment;
	}

	/**
	 * 
	 * @param suitableAreasForDevelopment
	 * @param player
	 */
	private void checkForMatchingInvestments(List<Square> suitableAreasForDevelopment, Player player) {

		int europe = 2;
		int asia = 3;
		int africa = 3;
		int southAmerica = 2;

		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;

		// System.out.println("CYCLE THROUGH LIST LOOKING FOR MORE FIELDS");

		// checking for occurance

		for (Square checkRegions : suitableAreasForDevelopment) {

			if (checkRegions.getRegionName() == "Europe") {
				sum1++;
				// System.out.println("Own " + sum1 + " In europe");
			} else if (checkRegions.getRegionName() == "Asia") {
				sum2++;
				// System.out.println("Own " + sum2 + " in asia");
			} else if (checkRegions.getRegionName() == "Africa") {
				sum3++;
				// System.out.println("Own " + sum3 + " in africa");
			} else if (checkRegions.getRegionName() == "South America") {
				sum4++;
				// System.out.println("Own " + sum4 + " in south america");
			}
		}

		
		if (sum1 >= europe) {
			System.out.println(
					"As you own the required number of areas in the European regions, they now qualify for development\n");

			for (int j = 0; j < board.size(); j++) {

				if (board.get(j).getOwner() == player && board.get(j).getRegionName().equalsIgnoreCase("Europe"))
					System.out.println(board.get(j));
			}

			developArea(player, board);


		}
		if (sum2 >= asia) {
			System.out.println(
					"As you own the required number of areas in Asian regions, they now qualify for development\n");

			for (int j = 0; j < board.size(); j++) {

				if (board.get(j).getOwner() == player && board.get(j).getRegionName().equalsIgnoreCase("asia"))
					System.out.println(board.get(j));
			}

			developArea(player, board);

		}
		if (sum3 >= africa) {
			System.out.println(
					"As you own the required number of areas in African regions, they now qualify for development\n");
			for (int j = 0; j < board.size(); j++) {

				if (board.get(j).getOwner() == player && board.get(j).getRegionName().equalsIgnoreCase("Africa"))
					System.out.println(board.get(j));
			}

			developArea(player, board);

			if (sum4 >= southAmerica) {
				System.out.println(
						"As you own the required number of areas in South American regions, they now qualify for development\n");
				for (int j = 0; j < board.size(); j++) {

					if (board.get(j).getOwner() == player
							&& board.get(j).getRegionName().equalsIgnoreCase("South America"))
						System.out.println(board.get(j));
				}

				developArea(player, board);

			}
		}
	}

	/**
	 * Method for changing player position on board. uses roll dice and player gets
	 * & sets
	 * 
	 * @param player
	 */
	private void movePlayer(Player player) {

		// System.out.println(board.get(player.getPosition()));

		int endPosition = player.getPosition() + rollDice();

		// System.out.println("Details of square " +player.getName()+" has landed on");
		// System.out.println(board.get(player.getPosition()));

		if (endPosition > board.size() - 1) {

			System.out.println(
					"\nCompleted a complete lap of the globe, after passing the home area the player has being given additional greencoin from investors..");
			System.out.println(".. and a message to keep up the good work");

			player.increaseFunds(LAPMONEY);

			System.out.println(player.getName() + " new greencoin balance is " + player.getGreenCoin());

			player.setPosition(endPosition - board.size());

		} else {
			player.setPosition(endPosition);

		}

	}

	/**
	 * Method to determine if game ends after a player completes their turn checks
	 * their resources against the threshold of WINNING_AMOUNT_INDVIDUAL print outs
	 * result to screen in case of reaching end amount print out encouragement
	 * message if game must continue
	 * 
	 * @param player
	 */
	private void endTurn(Player player) {

		if (player.getGreenCoin() >= WINNING_AMOUNT_INDIVIDUAL) {
			System.out.println("\nWell done ..." + player.getName());
			// endGame(player);
		} else if (player.getGreenCoin() <= 0) {
			System.out.println("\nGame ends");

			quitGame();
		} else {
			System.out.println("\nContinue onwards " + player.getName() + " The planet still needs you...");
		}
	}

	/**
	 * 
	 * to be shown at end of a complete cycle of players shows an update ownership
	 * status of all squares on board
	 * 
	 * @param board
	 */
	private void showAllCurrentPlayerAssets(ArrayList<Square> board) {

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		for (int i = 0; i < board.size(); i++) {

			if (board.get(i).getOwner() != null) {

				// if(board.get(i).getOwner().equals(player)) {
				System.out.println(board.get(i).getOwner());

			} else {
				System.out.println(board.get(i).getOwner() + " " + board.get(i).getAreaName());
			}
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

	}

	/**
	 * Roll dice method
	 * 
	 * @return
	 */
	private int rollDice() throws IllegalArgumentException {

		int dice1 = (int) (Math.random() * 6 + 1);
		int dice2 = (int) (Math.random() * 6 + 1);

		System.out.println("\nRolled two dices: rolled " + dice1 + " and " + dice2);

		if ((dice1 + dice2) <= board.size() && (dice1 + dice2 >= 0)) {
			return dice1 + dice2;

		} else {
			throw new IllegalArgumentException("Dice exceed range");
		}

	}

	@Override
	public void endGame(ArrayList<Player> p) {

		int totalFunds = 0;

		for (Player player : players) {

			totalFunds += player.getGreenCoin();

			if (totalFunds >= WINNING_AMOUNT_INDIVIDUAL) {

				System.out.println("\nCongratulation " + player.getName() + " you reached" + WINNING_AMOUNT_INDIVIDUAL
						+ " green coin! "
						+ "The money will be used to create the carbon capture devices. You saved the planet with help "
						+ "from your fellow eco warriors! ");
				System.exit(0);
			}

			if (player.getGreenCoin() < 0) {
				System.out.println(player.getName() + " has ran out of greencoin ");

			}

			if (totalFunds > (WINNING_AMOUNT_GROUP)) {

				System.out.println(
						"\nWell done all the players who worked together to save our planet!! You rose to the \"\r\n"
								+ "challenge and triumphed against all odds. Remember the future of our world is in our hands. \"\r\n"
								+ "Go in peace and enjoy a safe and secure planet for this generation and all future generations.\"");

				System.exit(0);

			} else {
				System.out.println(
						"\nYou were unable to work together successfully and thanks to this the world is going to end due to climate change enjoy"
								+ " the last few days on this once great planet ");
				System.exit(0);

			
			}

		}
	}

	/**
	 * Method to catch instance where players fail registration process in order to
	 * stop game crashing
	 */
	public void endGameNoPlayersRegistered() {

		System.err.println("\nGame never started.. please try again!!");
		System.exit(0);
	}

	/**
	 * Method gives the opportunity to log into the game several times before
	 * closing the game down.
	 * 
	 */
	public void GameNotStarted() {

		boolean valid = false;

		// String decision = sc.next();

		int failedAttempts = 0;
		try {
			/*
			 * do {
			 * 
			 * System.out.
			 * println("\nGame never started.. please try again!! \nDo you still want to start?(y/n)"
			 * );
			 * 
			 * if (decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes")) {
			 * valid = false; startGame(); }
			 * 
			 * failedAttempts++;
			 * 
			 * // System.out.println(failedAttempts);
			 * 
			 * } while (valid && failedAttempts <= 3);
			 */
			// System.err.println("Too many failed attempts, game shutdown..");
			System.err.println("GoodBye!!");

			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buyArea(Player player, List<Square> boardList) {

		int playerPosition = player.getPosition();

		for (Square board : boardList) {

			if (playerPosition == board.getBoardIndex()) {

				System.out.println("\nOn your journey you have visited " + board.getAreaName() + " in the "
						+ board.getRegionName() + " region");

				if (board.getBoardIndex() != 6 && board.getBoardIndex() != 0) {

					System.out.println("\nWith your purchase of an area in " + board.getAreaName()
							+ " \nthe potential development options are as follows: " + board.getSquareDetails()
							+ " \nthe inital cost of this potential development is " + board.getAreaValue()
							+ " greencoin");
				}

				// if square is unowned player now has option to buy the square subject to
				// having the required resources

				// no option to buy if players lands on blank and home square

				if (board.getBoardIndex() != 6 && board.getBoardIndex() != 0) {

					// if square isnt owned
					if ((board).isOwned() == false) {

						// Scanner sc = new Scanner(System.in);
						String decision = "";

						// player asked do they want to buy
						System.out.println("\n" + player.getName() + ", Do you want to buy the area (y/n)");
						decision = sc.next();

						if (decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes")) {

							// compare their resources to board investment value
							if (player.getGreenCoin() > (board).getAreaValue()) {

								// printout message
								System.out.println("\n" + player.getName()
										+ " has decided to invest their greencoin in " + board.getAreaName());
								System.out.println("Well done " + player.getName() + " a great choice of investment");
								// System.out.println(((FieldSquare) board).getAreaValue());

								int purchaseValue = ((board).getAreaValue());
								player.reduceFunds(purchaseValue);

								// System.out.println(player);

								// update the board owned value to true, and updating owner to player
								(board).setOwned(true);
								(board).setOwner(player);

							} else {
								System.out.println(
										"\n" + player.getName() + " doesn't have enough greencoin to buy this area");

								endTurn(player);
							}
						} else {
							System.out.println("\n" + player.getName() + " doesnt want to buy this area at this time");

							endTurn(player);
						}

					}
				}
			}
		}

	}

	/**
	 * Method pays the required amount to another player based on the squares
	 * details
	 * 
	 * @param player
	 * @param amount
	 */
	private void payAnotherPlayer(Player player, int amount) {

		int balance = player.getGreenCoin();

		balance += amount;

		player.setGreenCoin(balance);

		// return balance;
	}

	@Override
	public void developArea(Player player, List<Square> board) {

		int areaToDevelop = 0;

		System.out.println("Do you want to develop your owned areas? (y/n)");

		String decision;

		try {
			// if (sc.next().equalsIgnoreCase("y") || sc.next().equalsIgnoreCase("yes")) {
			decision = sc.next();
			if (decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes")) {

				// System.out.println("which ones do you want to develop in this turn..");
//				developArea(player, board);

				// System.out.println(showPlayerAssets(player));

				System.out.println("which square index do you want to develop?");

				areaToDevelop = sc.nextInt();

				// }else if(sc.next().equalsIgnoreCase("n") ||
				// sc.next().equalsIgnoreCase("no")){

			} else if (decision.equalsIgnoreCase("n") || decision.equalsIgnoreCase("no")) {
				endTurn(player);

			} else {
				System.out.println("\n" + player.getName() + " Doesn't want to develop in this turn");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// check area is not already at max level
		if (board.get(areaToDevelop).getDevelopmentStage() >= 4) {

			System.out.println("This area is at max level, please select another ... ");

			// keep eye on this one
			// developArea(player, board);

			areaToDevelop = sc.nextInt();

		}

		if (player.getGreenCoin() > board.get(areaToDevelop).getDevelopmentCost()) {

			System.out.println("This area costs " + board.get(areaToDevelop).getDevelopmentCost()
					+ " to develop to a stage " + board.get(areaToDevelop).getDevelopmentStage() + " area");

			System.out.println("Are you sure you want to develop? (y/n)");

			decision = sc.next();
			if (decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("yes")) {

				if (areaToDevelop == 0 || areaToDevelop == 6) {

					System.out.println("Invalid selection, please select a different value");
					decision = sc.next();
					// endTurn(player);
				} else {
					// System.out.println("Checking this...");
					// getPlayerDevelopments(board, player);

					if (player.getGreenCoin() > (board.get(areaToDevelop)).getDevelopmentCost()) {

						int developmentCost = board.get(areaToDevelop).getDevelopmentCost();

						// System.out.println(developmentCost);

						System.out.println("You choose " + board.get(areaToDevelop).getAreaName() + " it costs "
								+ board.get(areaToDevelop).getDevelopmentCost() + " for a stage "
								+ board.get(areaToDevelop).getDevelopmentStage() + " development.");

						System.out.println("It's currently at stage " + board.get(areaToDevelop).getDevelopmentStage());

						switch (board.get(areaToDevelop).getDevelopmentStage()) {
						case 0:
							player.reduceFunds(developmentCost);

							(board.get(areaToDevelop)).setDevelopmentStage(1);

							board.get(areaToDevelop).setMultiplier(2);

							// setting rent equal to base rent multiplied by increared upgrade level
							board.get(areaToDevelop).setAreaContribution(board.get(areaToDevelop).getAreaContribution()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setDevelopmentCost(board.get(areaToDevelop).getDevelopmentCost()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setAreaValue(
									board.get(areaToDevelop).getAreaValue() * board.get(areaToDevelop).getMultiplier());

							// System.out.println(player);
							System.out.println(board.get(areaToDevelop).toString());

							System.out.println(player.getName() + " your stage 1 development is complete");

							System.out.println(player.getName() + " Your asset is now at stage "
									+ board.get(areaToDevelop).getDevelopmentStage());

							System.out.println(player.getName() + " has available greencoin resources of "
									+ player.getGreenCoin() + " left");

							break;
						case 1:
							player.reduceFunds(developmentCost);

							(board.get(areaToDevelop)).setDevelopmentStage(2);

							board.get(areaToDevelop).setMultiplier(2);

							// setting rent equal to base rent multiplied by increared upgrade level
							board.get(areaToDevelop).setAreaContribution(board.get(areaToDevelop).getAreaContribution()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setDevelopmentCost(board.get(areaToDevelop).getDevelopmentCost()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setAreaValue(
									board.get(areaToDevelop).getAreaValue() * board.get(areaToDevelop).getMultiplier());

							System.out.println(player);
							System.out.println(board.get(areaToDevelop).toString());

							System.out.println(player.getName() + " your stage 2 development is complete");

							System.out.println(player.getName() + " has available greencoin resources of "
									+ player.getGreenCoin() + " left");

							break;
						case 2:
							player.reduceFunds(developmentCost);

							(board.get(areaToDevelop)).setDevelopmentStage(3);

							board.get(areaToDevelop).setMultiplier(2);

							// setting rent equal to base rent multiplied by increared upgrade level
							board.get(areaToDevelop).setAreaContribution(board.get(areaToDevelop).getAreaContribution()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setDevelopmentCost(board.get(areaToDevelop).getDevelopmentCost()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setAreaValue(
									board.get(areaToDevelop).getAreaValue() * board.get(areaToDevelop).getMultiplier());

							System.out.println(player);
							System.out.println(board.get(areaToDevelop).toString());

							System.out.println(player.getName() + "your stage 3 development is complete");

							System.out.println(player.getName() + " has available greencoin resources of "
									+ player.getGreenCoin() + " left");

							break;
						case 3:
							System.out.println("Can now upgrade to a major development");
							player.reduceFunds(developmentCost);

							(board.get(areaToDevelop)).setDevelopmentStage(4);
							System.out.println(player.getName() + "your investment is at the final stage");

							System.out.println(player.getName() + " has available greencoin resources of "
									+ player.getGreenCoin() + " left");

							board.get(areaToDevelop).setMultiplier(2);

							// setting rent equal to base rent multiplied by increared upgrade level
							board.get(areaToDevelop).setAreaContribution(board.get(areaToDevelop).getAreaContribution()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setDevelopmentCost(board.get(areaToDevelop).getDevelopmentCost()
									* board.get(areaToDevelop).getMultiplier());
							board.get(areaToDevelop).setAreaValue(
									board.get(areaToDevelop).getAreaValue() * board.get(areaToDevelop).getMultiplier());

							System.out.println(player);
							System.out.println(board.get(areaToDevelop).toString());

							break;
						case 4:

							System.out.println("At maximum level");
							System.out.println("No further developments available");
							break;
						default:
							System.err.println("An error has occured");

							break;
						}
					}

				}

			}

		} else {
			System.out.println("Dont have enough greencoin to develop this area");
		}

	}

	// exclude home and blank square from development option

	@Override
	public void quitGame() {

		
		String userInput; 
		
		int totalFunds = 0;
		/*
		 * if (hasGameStarted) { System.out.println("game not started yet"); }
		 */
		System.out.println("Would you like to quit the game?");
		userInput = sc.next();
		
		
		if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {

			System.out.println("Are you sure you want to quit?");
		}
		userInput = sc.next();
		if (userInput.equals("y") || userInput.equalsIgnoreCase("yes")) {

			for (Player player : players) {

				totalFunds += player.getGreenCoin();

				System.out.println(player.getName() + " has finished the game with " + player.getGreenCoin());
			}

			if (totalFunds > WINNING_AMOUNT_GROUP) {

				System.out.println(
						"Although there wasn't a clear winner, Well done all the players who worked together to save our planet! You rose to the \"\r\n"
								+ "+ \"challenge and triumphed against all odds. Remember the future of our planet is in our hands. \"\r\n"
								+ "Go in peace and enjoy a safe and secure planet for this generation and all future generations.\"");

				System.exit(0);

			} else {

				System.out.println(

						"You were unable to work together successfully and thanks to this the planet is going to end due to climate change enjoy"
								+ "the last few days on this once great planet ");

				System.exit(0);

			}

		} else {
			takeTurn();
		}

	}

}
