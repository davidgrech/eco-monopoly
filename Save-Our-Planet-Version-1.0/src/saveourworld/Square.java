/**
 * 
 */
package saveourworld;

/**
 * @author michaelcarey-small and David Grech
 *
 */
public class Square extends Board {

	private int developmentCost;
	private int developmentStage;
	private Player owner;
	private boolean isOwned;
	private int AreaValue;
	private int areaContribution;
	private int multiplier;
	private String squareDetails;

	/**
	 * Default Constructor
	 */
	public Square() {
	}

	/**
	 * Constructor for non activity Fields
	 * 
	 * @param squareIndex
	 * @param fieldName
	 * @param areaName
	 */
	public Square(int boardIndex, String fieldName, String areaName) {
		super(boardIndex, fieldName, areaName);
	}

	/**
	 * Constructor for purchasable fields
	 * 
	 * @param squareIndex
	 * @param fieldName
	 * @param areaName
	 * @param value
	 * @param developmentCost
	 * @param areaRent
	 * @param owned
	 * @param developmentStage
	 * @param owner
	 */
	public Square(int boardIndex, String fieldName, String areaName, String squareDetails, int value,
			int developmentCost, int areaRent, boolean owned, int developmentStage, Player owner, int rentMultiplier) {

		super(boardIndex, fieldName, areaName);
		this.setSquareDetails(squareDetails);
		this.setAreaValue(value);
		this.setDevelopmentCost(developmentCost);
		this.setAreaContribution(areaRent);
		this.setDevelopmentStage(developmentStage);
		this.setOwner(owner);
		this.setMultiplier(rentMultiplier);

	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * 
	 * @param owner
	 * @throws IllegalArgumentException
	 */
	public void setOwner(Player owner) {

		this.owner = owner;

	}

	/**
	 * 
	 * @return
	 */
	public int getDevelopmentCost() {
		return developmentCost;
	}

	/**
	 * 
	 * @param developmentCost the developmentCost to set
	 * @throws IllegalArgumentException
	 */
	public void setDevelopmentCost(int developmentCost) throws IllegalArgumentException {
		if (developmentCost >= 1 && developmentCost <= 1500000) {
			this.developmentCost = developmentCost;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * @return the developmentStage
	 */
	public int getDevelopmentStage() {
		return developmentStage;
	}

	/**
	 * 
	 * @param developmentStage
	 * @throws IllegalArgumentException must be set between 0 and 4
	 */
	public void setDevelopmentStage(int developmentStage) throws IllegalArgumentException {

		if (developmentStage >= 0 && developmentStage <= 4) {
			this.developmentStage = developmentStage;

		} else {
			throw new IllegalArgumentException("Must be set between 0 and 4");
		}

	}
	/**
	 * 
	 * @return
	 */
	public boolean isOwned() {
		return isOwned;
	}

	/**
	 * 
	 * @param isOwned
	 * @throws IllegalArgumentException must be set to true or false
	 */
	public void setOwned(boolean isOwned) throws IllegalArgumentException {
		if (isOwned == true || isOwned == false) {
			this.isOwned = isOwned;
		} else {
			throw new IllegalArgumentException("Must be set to true or false");
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getAreaValue() {
		return AreaValue;
	}

	/**
	 * 
	 * @param areaValue
	 * @throws IllegalArgumentException must be set between 100 and 200
	 */
	public void setAreaValue(int areaValue) throws IllegalArgumentException {
		if (areaValue >= 0 && areaValue <= 20000) {
			AreaValue = areaValue;
		} else {
			throw new IllegalArgumentException("Must be set between 100 and 200");
		}

	}

	/**
	 * 
	 * @return
	 */
	public int getAreaContribution() {
		return areaContribution;
	}

	/**
	 * 
	 * @param areaContribution
	 * @throws IllegalArgumentException must bet set between 50 and 42500
	 */
	public void setAreaContribution(int areaContribution) throws IllegalArgumentException {
		if (areaContribution >= 0 && areaContribution <= 42500) {
			this.areaContribution = areaContribution;
		} else {
			throw new IllegalArgumentException("Must be set between 50 and 42500");
		}
	}
	/**
	 * 
	 * @return
	 */
	public int getMultiplier() {
		return multiplier;
	}
	
	/**
	 * Sets a multiplier for when area gets developed
	 * @param multiplier
	 * @throws IllegalArgumentException
	 */
	public void setMultiplier(int multiplier) throws IllegalArgumentException {
		if(multiplier>0) {
			this.multiplier = multiplier;
		} else {
			throw new IllegalArgumentException("Must be greater than 0");
		}
	}

	@Override
	public String toString() {
		return "[" + super.toString() + "developmentCost=" + developmentCost + ", developmentStage="
				+ developmentStage + ", owner=" + owner + ", isOwned=" + isOwned + ", AreaValue=" + AreaValue
				+ ", contribution=" + areaContribution + ", Multiplier=" + multiplier + ", squareDetails=" + squareDetails
				+ "]";
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub

		System.out.println();

	}

	/**
	 * @return the squareDetails
	 */
	public String getSquareDetails() {

		return squareDetails;
	}

	/**
	 * @param squareDetails the squareDetails must be set to 1 or more
	 */
	public void setSquareDetails(String squareDetails) throws IllegalArgumentException {
		if (squareDetails.length() >= 1) {
			this.squareDetails = squareDetails;
		} else {
			throw new IllegalArgumentException("Must be set to 1 or more, try again");
		}
	}

}
