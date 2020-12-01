package saveourworld;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saveourworld.Player;

/**
 * 
 * @author David tests the player class
 *
 */
class PlayerTest {

	Player pl;

	String validNameLow, validNameMed, validNameHigh;

	String invalidNameLow, invalidNameHigh;

	int validPositionLow, validPositionMed, validPositionHigh;

	int invalidPositionLow, invalidPositionHigh;

	int validGCoinLow, validGCoinMed, validGCoinHigh;

	int invalidGCoinLow, invalidGCoinHigh;

	@BeforeEach
	void setUp() throws Exception {

		pl = new Player();

		validNameLow = "a";
		validNameMed = "David Green";
		validNameHigh = "David----------Green";

		invalidNameLow = "";
		invalidNameHigh = "David----------Green_";

		validPositionLow = 0;
		validPositionMed = 5;
		validPositionHigh = 11;

		invalidPositionLow = -1;
		invalidPositionHigh = 12;

		validGCoinLow = 0;
		validGCoinMed = 10000;
		validGCoinHigh = 20000;

		invalidGCoinLow = -1;
		invalidGCoinHigh = 20001;

	}

	/**
	 * tests if default constructor is not null
	 */
	@Test
	void testPlayer() {
		assertNotNull(pl = new Player());
	}

	/**
	 * tests constructor using valid fields
	 */
	@Test
	void testConstructorValid() {

		pl = new Player(validNameLow, validPositionLow, validGCoinLow);

		assertEquals(validNameLow, pl.getName());
		assertEquals(validPositionLow, pl.getPosition());
		assertEquals(validGCoinLow, pl.getGreenCoin());

	}

	/**
	 * tests constructor using an invalid name
	 */
	@Test
	void testConstructorInvalidName() {

		Exception e = assertThrows(IllegalArgumentException.class, () -> {

			pl = new Player(invalidNameLow, validPositionLow, validGCoinLow);

		});

		System.out.println(e.getMessage());

	}

	/**
	 * tests constructor using an invalid position
	 */
	@Test
	void testConstructorInvalidPosition() {

		Exception e = assertThrows(IllegalArgumentException.class, () -> {

			pl = new Player(validNameLow, invalidPositionLow, validGCoinLow);

		});

		System.out.println(e.getMessage());

	}

	/**
	 * tests constructor using invalid green coin
	 */
	@Test
	void testConstructorInvalidCoin() {

		Exception e = assertThrows(IllegalArgumentException.class, () -> {

			pl = new Player(validNameLow, validPositionLow, invalidGCoinLow);

		});

		System.out.println(e.getMessage());

	}

	/**
	 * tests the to String method
	 */
	@Test
	void testToString() {

		pl = new Player(validNameLow, validPositionLow, validGCoinLow);

		assertEquals("[name=a, position=0, greenCoin=0]", pl.toString());

	}

	/**
	 * tests get name and set name methods with valid names
	 */
	@Test
	void testValidNames() {

		pl.setName(validNameLow);
		assertEquals(validNameLow, pl.getName());

		pl.setName(validNameMed);
		assertEquals(validNameMed, pl.getName());

		pl.setName(validNameHigh);
		assertEquals(validNameHigh, pl.getName());

	}

	/**
	 * tests the set name method with invalid names
	 */
	@Test
	void testInvalidNames() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			pl.setName(invalidNameLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			pl.setName(invalidNameHigh);

		});

		System.out.println(e2.getMessage());

	}

	/**
	 * tests get position and set position methods using valid positions
	 */
	@Test
	void testValidPosition() {

		pl.setPosition(validPositionLow);
		assertEquals(validPositionLow, pl.getPosition());

		pl.setPosition(validPositionMed);
		assertEquals(validPositionMed, pl.getPosition());

		pl.setPosition(validPositionHigh);
		assertEquals(validPositionHigh, pl.getPosition());

	}

	/**
	 * tests the set position method with invalid positions
	 */
	@Test
	void testInvalidPosition() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			pl.setPosition(invalidPositionLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			pl.setPosition(invalidPositionHigh);

		});

		System.out.println(e2.getMessage());

	}

	/**
	 * tests get green coin and set green coin methods with valid green coin values
	 */
	@Test
	void testValidGreenCoin() {

		pl.setGreenCoin(validGCoinLow);
		assertEquals(validGCoinLow, pl.getGreenCoin());

		pl.setGreenCoin(validGCoinMed);
		assertEquals(validGCoinMed, pl.getGreenCoin());

		pl.setGreenCoin(validGCoinHigh);
		assertEquals(validGCoinHigh, pl.getGreenCoin());

	}

	/**
	 * tests set green coin method with invalid green coin values
	 */
	@Test
	void testInvalidGreenCoin() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			pl.setGreenCoin(invalidGCoinLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			pl.setGreenCoin(invalidGCoinHigh);

		});

		System.out.println(e2.getMessage());
	}

	/**
	 * tests the increase funds method that adds extra funds to a player and returns
	 * that amount
	 */
	@Test
	void testIncreaseFunds() {

		int add = 100;

		pl.setGreenCoin(validGCoinLow);

		assertEquals(validGCoinLow + add, pl.increaseFunds(add));

	}

	/**
	 * tests the pay rent method that reduces a players green coin and returns how
	 * much was reduced
	 */
	@Test
	void testReduceFunds() {

		int rent = 200;

		pl.setGreenCoin(validGCoinMed);

		assertEquals(validGCoinMed - rent, pl.reduceFunds(rent));
	}

	/**
	 * Tests the player registration method. An array list of players is created as
	 * the expected results. The actual result is the execution of the player
	 * registration using the name "a", then "b".
	 */
	@Test
	void testValidPlayerRegistration1() {

		Scanner sc = new Scanner(System.in);
		
		int numPlayers = 2;
		
		int balance = 1000;
		
		ArrayList<Player> playersExpected = new ArrayList<Player>();

		Player player1 = new Player("a", 0, 1000);
		Player player2 = new Player("b", 0, 1000);

		playersExpected.add(player1);
		playersExpected.add(player2);

		ArrayList<Player> playersActual = Player.playerRegistration(numPlayers, sc, balance);

		try {

			assertEquals(playersExpected.toString(), playersActual.toString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	/*
	/**
	 * Tests the player registration method using invalid player values, high and low.
	 */
	/*
	@Test
	void testInvalidPlayerRegistration() {

		Scanner sc = new Scanner(System.in);
		
		int balance = 1000;
		
		int invalidPlayersLow = 0;
		
		int invalidPlayersHigh = 5;
		

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			Player.playerRegistration(invalidPlayersLow, sc, balance);

		});

		System.out.println(e1.getMessage());
		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			Player.playerRegistration(invalidPlayersHigh, sc, balance);

		});

		System.out.println(e2.getMessage());
		
		
	}
	*/


}
