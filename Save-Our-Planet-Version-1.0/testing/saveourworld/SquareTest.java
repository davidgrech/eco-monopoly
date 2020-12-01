package saveourworld;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author David tests Board and Square classes
 *
 */
class SquareTest {

	Square fs;

	int validBoardIndexLow, validBoardIndexMed, validBoardIndexHigh;

	int invalidBoardIndexLow, invalidBoardIndexHigh;

	String validAreaNameLow, validAreaNameMed, validAreaNameHigh;

	String invalidAreaNameLow, invalidAreaNameHigh;

	String validFieldNameLow, validFieldNameMed, validFieldNameHigh;

	String invalidFieldNameLow, invalidFieldNameHigh;

	int validDevelpmentCostLow, validDevelopmentCostMed, validDevelopmentCostHigh;

	int invalidDevelopmentCostLow, invalidDevelopmentCostHigh;

	int validDevelopmentStagelow, validDevelopmentStageMed, validDevelopmentStageHigh;

	int invalidDevelopmentStageLow, invalidDevelopmentStageHigh;

	int validAreaValueLow, validAreaValueMed, validAreaValueHigh;

	int invalidAreaValueLow, invalidAreaValueHigh;

	int validAreaRentLow, validAreaRentMed, validAreaRentHigh;

	int invalidAreaRentLow, invalidAreaRentHigh;

	boolean validIsOwnedFalse;
	boolean validIsOwnedTrue;

	Player validOwner;

	Player invalidOwner;

	int rentMultiplier;
	
	String validSquareDetails;
	
	String invalidSquareDetails;

	@BeforeEach
	void setUp() throws Exception {

		fs = new Square();

		validBoardIndexLow = 0;
		validBoardIndexMed = 5;
		validBoardIndexHigh = 11;

		invalidBoardIndexLow = -1;
		invalidBoardIndexHigh = 12;

		validAreaNameLow = "a";
		validAreaNameMed = "Indonesia";
		validAreaNameHigh = "Indonesia-------Bali";

		invalidAreaNameLow = "";
		invalidAreaNameHigh = "Indonesia-------Bali-";

		validFieldNameLow = "a";
		validFieldNameMed = "South America";
		validFieldNameHigh = "South--------America";

		invalidFieldNameLow = "";
		invalidFieldNameHigh = "South--------America-";

		validDevelopmentStagelow = 0;
		validDevelopmentStageHigh = 4;

		invalidDevelopmentStageLow = -1;
		invalidDevelopmentStageHigh = 5;

		validDevelpmentCostLow = 1;
		validDevelopmentCostMed = 100;
		validDevelopmentCostHigh = 1500000;

		invalidDevelopmentCostLow = 0;
		invalidDevelopmentCostHigh = 1500001;

		validAreaValueLow = 0;
		validAreaValueMed = 1500;
		validAreaValueHigh = 20000;

		invalidAreaValueLow = -1;
		invalidAreaValueHigh = 20001;

		validAreaRentLow = 0;
		validAreaRentMed = 2700;
		validAreaRentHigh = 42500;
		
		invalidAreaRentLow = -1;
		invalidAreaRentHigh = 42501;

		validOwner = new Player();
		invalidOwner = null;

		validIsOwnedFalse = false;
		validIsOwnedTrue = true;

		rentMultiplier = 8;
		
		validSquareDetails = "a";
		invalidSquareDetails = "";
		

	}

	/**
	 * tests if default constructor is not null
	 */
	@Test
	void testFieldSquare() {
		assertNotNull(fs = new Square());
	}

	/**
	 * Tests non activity square constructor
	 */
	@Test
	void testNonActivityConstructor() {
		fs = new Square(validBoardIndexLow, validFieldNameLow, validAreaNameLow);

		assertEquals(validBoardIndexLow, fs.getBoardIndex());
		assertEquals(validFieldNameLow, fs.getRegionName());
		assertEquals(validAreaNameLow, fs.getAreaName());
	}

	/**
	 * Tests purchasable fields constructor
	 */
	@Test
	void testConstructorForPurchasableFields() {
		fs = new Square(validBoardIndexLow, validFieldNameLow, validAreaNameLow, validSquareDetails,validAreaValueLow,
				validDevelpmentCostLow, validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner,
				rentMultiplier);

		assertEquals(validBoardIndexLow, fs.getBoardIndex());
		assertEquals(validFieldNameLow, fs.getRegionName());
		assertEquals(validAreaNameLow, fs.getAreaName());
		assertEquals(validSquareDetails, fs.getSquareDetails());
		assertEquals(validAreaValueLow, fs.getAreaValue());
		assertEquals(validDevelpmentCostLow, fs.getDevelopmentCost());
		assertEquals(validAreaRentLow, fs.getAreaContribution());
		assertEquals(validIsOwnedFalse, fs.isOwned());
		assertEquals(validDevelopmentStagelow, fs.getDevelopmentStage());
		assertEquals(validOwner, fs.getOwner());
		assertEquals(rentMultiplier, fs.getMultiplier());
	}

	@Test
	void testInvalidConstructorInvalidBoardIndex() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs = new Square(invalidBoardIndexLow, validFieldNameLow, validAreaNameLow, validSquareDetails, validAreaValueLow,
					validDevelpmentCostLow, validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner,
					rentMultiplier);

		});

		System.out.println(e1.getMessage());
	}

	@Test
	void testInvalidConstructorInvalidFieldName() {

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs = new Square(validBoardIndexLow, invalidFieldNameLow, validAreaNameLow, validSquareDetails, validAreaValueLow,
					validDevelpmentCostLow, validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner,
					rentMultiplier);

		});

		System.out.println(e2.getMessage());

	}

	@Test
	void testInvalidConstructorInvalidAreaName() {

		Exception e3 = assertThrows(IllegalArgumentException.class, () -> {

			fs = new Square(validBoardIndexLow, validFieldNameLow, invalidAreaNameLow, validSquareDetails, validAreaValueLow,
					validDevelpmentCostLow, validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner,
					rentMultiplier);

		});

		System.out.println(e3.getMessage());

	}

	@Test
	void testInvalidConstructorInvalidAReaValue() {

		Exception e4 = assertThrows(IllegalArgumentException.class, () -> {

			fs = new Square(validBoardIndexLow, validFieldNameLow, validAreaNameLow, validSquareDetails, invalidAreaValueLow,
					validDevelpmentCostLow, validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner,
					rentMultiplier);

		});

		System.out.println(e4.getMessage());

	}

	@Test
	void testInvalidConstructorInvalidDevelopmentCost() {

		Exception e5 = assertThrows(IllegalArgumentException.class, () -> {

			fs = new Square(validBoardIndexLow, validFieldNameLow, validAreaNameLow, validSquareDetails, validAreaValueLow,
					invalidDevelopmentCostLow, validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow,
					validOwner, rentMultiplier);

		});

		System.out.println(e5.getMessage());

	}

	@Test
	void testInvalidConstructorInvalidAReaRent() {

		Exception e6 = assertThrows(IllegalArgumentException.class, () -> {

			fs = new Square(validBoardIndexLow, validFieldNameLow, validAreaNameLow, validSquareDetails, validAreaValueLow,
					validDevelpmentCostLow, invalidAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner,
					rentMultiplier);

		});

		System.out.println(e6.getMessage());

	}

	@Test
	void testInvalidConstructorInvalidDevelopmentStage() {

		Exception e7 = assertThrows(IllegalArgumentException.class, () -> {

			fs = new Square(validBoardIndexLow, validFieldNameLow, validAreaNameLow, validSquareDetails, validAreaValueLow,
					validDevelpmentCostLow, validAreaRentLow, validIsOwnedFalse, invalidDevelopmentStageLow, validOwner,
					rentMultiplier);

		});

		System.out.println(e7.getMessage());

	}

	/**
	 * tests get and set owner using a valid owner
	 */
	@Test
	void testValidOwner() {
		fs.setOwner(validOwner);
		assertEquals(validOwner, fs.getOwner());
	}

	/**
	 * test the is owned set and is owned methods
	 */
	@Test
	void testIsOwned() {
		fs.setOwned(validIsOwnedTrue);
		assertEquals(validIsOwnedTrue, fs.isOwned());
	}

	/**
	 * tests development cost get and set methods with valid development costs
	 */
	@Test
	void testValidDevelopmentCost() {

		fs.setDevelopmentCost(validDevelpmentCostLow);
		assertEquals(validDevelpmentCostLow, fs.getDevelopmentCost());

		fs.setDevelopmentCost(validDevelopmentCostMed);
		assertEquals(validDevelopmentCostMed, fs.getDevelopmentCost());

		fs.setDevelopmentCost(validDevelopmentCostHigh);
		assertEquals(validDevelopmentCostHigh, fs.getDevelopmentCost());
	}

	/**
	 * tests set development cost method with invalid development costs
	 */
	@Test
	void testInvalidDevelopmentCost() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setDevelopmentCost(invalidDevelopmentCostLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setDevelopmentCost(invalidDevelopmentCostHigh);

		});

		System.out.println(e2.getMessage());

	}

	/**
	 * tests get and set methods with valid development costs
	 */
	@Test
	void testValidDevelopmentStage() {

		fs.setDevelopmentStage(validDevelopmentStagelow);
		assertEquals(validDevelopmentStagelow, fs.getDevelopmentStage());

		fs.setDevelopmentStage(validDevelopmentStageMed);
		assertEquals(validDevelopmentStageMed, fs.getDevelopmentStage());

		fs.setDevelopmentStage(validDevelopmentStageHigh);
		assertEquals(validDevelopmentStageHigh, fs.getDevelopmentStage());
	}

	/**
	 * tests set development stage method with invalid development stages
	 */
	@Test
	void testInvalidDevelopmentStage() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setDevelopmentStage(invalidDevelopmentStageLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setDevelopmentStage(invalidDevelopmentStageHigh);

		});

		System.out.println(e2.getMessage());
	}

	/**
	 * tests area value get and set methods with valid area values
	 */
	@Test
	void testGetAreaValue() {
		fs.setAreaValue(validAreaValueLow);
		assertEquals(validAreaValueLow, fs.getAreaValue());

		fs.setAreaValue(validAreaValueMed);
		assertEquals(validAreaValueMed, fs.getAreaValue());

		fs.setAreaValue(validAreaValueHigh);
		assertEquals(validAreaValueHigh, fs.getAreaValue());
	}

	/**
	 * tests set area value method with invalid area values
	 */
	@Test
	void testInvalidAreaValue() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setAreaValue(invalidAreaValueLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setAreaValue(invalidAreaValueHigh);

		});

		System.out.println(e2.getMessage());
	}

	/**
	 * tests area rent get and set methods with valid area rent values
	 */
	@Test
	void testValidAreaRent() {
		fs.setAreaContribution(validAreaRentLow);
		assertEquals(validAreaRentLow, fs.getAreaContribution());

		fs.setAreaContribution(validAreaRentMed);
		assertEquals(validAreaRentMed, fs.getAreaContribution());

		fs.setAreaContribution(validAreaRentHigh);
		assertEquals(validAreaRentHigh, fs.getAreaContribution());
	}

	/**
	 * tests set area rent method with invalid area rents
	 */
	@Test
	void testInvalidAreaRent() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setAreaContribution(invalidAreaRentLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setAreaContribution(invalidAreaRentHigh);

		});

		System.out.println(e2.getMessage());

	}

	/**
	 * tests board index get and set methods with valid board index values
	 */
	@Test
	void testValidBoardIndex() {

		fs.setBoardIndex(validBoardIndexLow);
		assertEquals(validBoardIndexLow, fs.getBoardIndex());

		fs.setBoardIndex(validBoardIndexMed);
		assertEquals(validBoardIndexMed, fs.getBoardIndex());

		fs.setBoardIndex(validBoardIndexHigh);
		assertEquals(validBoardIndexHigh, fs.getBoardIndex());
	}

	/**
	 * tests set board index method with invalid board indexes
	 */
	@Test
	void testInvalidBoardIndex() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setBoardIndex(invalidBoardIndexLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setBoardIndex(invalidBoardIndexHigh);

		});

		System.out.println(e2.getMessage());
	}

	/**
	 * tests area name get and set methods with valid area names
	 */
	@Test
	void testValidAreaName() {

		fs.setAreaName(validAreaNameLow);
		assertEquals(validAreaNameLow, fs.getAreaName());

		fs.setAreaName(validAreaNameMed);
		assertEquals(validAreaNameMed, fs.getAreaName());

		fs.setAreaName(validAreaNameHigh);
		assertEquals(validAreaNameHigh, fs.getAreaName());
	}

	/**
	 * tests set area name method with invalid area names
	 */
	@Test
	void testSetAreaName() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setAreaName(invalidAreaNameLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setAreaName(invalidAreaNameHigh);

		});

		System.out.println(e2.getMessage());
	}

	/**
	 * tests field name get and set methods with valid field names
	 */
	@Test
	void testValidFieldName() {

		fs.setRegionName(validFieldNameLow);
		assertEquals(validFieldNameLow, fs.getRegionName());

		fs.setRegionName(validFieldNameMed);
		assertEquals(validFieldNameMed, fs.getRegionName());

		fs.setRegionName(validFieldNameHigh);
		assertEquals(validFieldNameHigh, fs.getRegionName());
	}

	/**
	 * tests set field name method with invalid field names
	 */
	@Test
	void testInvalidFieldName() {

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setRegionName(invalidFieldNameLow);

		});

		System.out.println(e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {

			fs.setRegionName(invalidFieldNameHigh);

		});

		System.out.println(e2.getMessage());
	}

	/**
	 * test returning all fields to String
	 */
	@Test
	void testToString() {

		fs = new Square(validBoardIndexLow, validFieldNameLow, validAreaNameLow, validSquareDetails, validAreaValueLow,
				validDevelpmentCostLow, validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner,
				rentMultiplier);

		assertEquals(
				"Square [Square [squareIndex=0, areaName=a, fieldName=a]developmentCost=1, developmentStage=0, owner=Player [name=null, position=0, greenCoin=0], isOwned=false, AreaValue=0, areaRent=0, rentMultiplier=8, squareDetails=a]",
				fs.toString());
	}

	// Integration Testing

	/**
	 * tests the population of an array list with Square objects
	 */
	@Test
	void testSquareArrayPopulation() {

		ArrayList<Square> fsArray = new ArrayList<Square>();

		for (int loop = 0; loop <= 10; loop++) {

			fs = new Square(loop, validFieldNameLow, validAreaNameLow, validSquareDetails, validAreaValueLow, validDevelpmentCostLow,
					validAreaRentLow, validIsOwnedFalse, validDevelopmentStagelow, validOwner, rentMultiplier);

			fsArray.add(fs);

			assertEquals("Square [Square [squareIndex=" + loop
					+ ", areaName=a, fieldName=a]developmentCost=1, developmentStage=0, owner=Player [name=null, "
					+ "position=0, greenCoin=0], isOwned=false, AreaValue=0, contribution=0, Multiplier=8, squareDetails=a]",
					fsArray.get(loop).toString());

		}

	}

}
