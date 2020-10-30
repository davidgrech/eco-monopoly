/**
 * 
 */
package saveourworld;


/**
 * @author michaelcarey-small and David Grech
 *
 */
public abstract class Board {

	private int boardIndex;
	private String areaName;
	private String regionName;

	/**
	 * Default constructor
	 */
	public Board() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Constructor with fields
	 * 
	 * @param boardIndex
	 * @param areaName
	 * @param regionName
	 */

	public Board(int boardIndex, String areaName, String regionName) {
		this.setBoardIndex(boardIndex);
		this.setAreaName(areaName);
		this.setRegionName(regionName);

	}

	/**
	 * 
	 * @return board index
	 */
	public int getBoardIndex() {
		return boardIndex;
	}

	/**
	 * set board index
	 * 
	 * @param boardIndex must be set between 0 and 11
	 */
	public void setBoardIndex(int boardIndex) throws IllegalArgumentException{
		if(boardIndex>=0&&boardIndex<=11) {
		this.boardIndex = boardIndex;
		} else {
			throw new IllegalArgumentException("Board Index must be between 0 and 11");
		}
	}

	/**
	 * 
	 * @return area name
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * set area name
	 * 
	 * @param areaName must be set between 1 and 20 characters long
	 */
	public void setAreaName(String areaName) {
		if(areaName.length()>=1&&areaName.length()<=20) {
		this.areaName = areaName;
		} else {
			throw new IllegalArgumentException("Area name must be set between 1 and 20 characters long");
		}
	}

	/**
	 * 
	 * @return field name
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * set field name
	 * 
	 * @param regionName must be set between 1 and 20 characters long
	 */
	public void setRegionName(String regionName) {
		if(regionName.length()>=1&&regionName.length()<=20) {
		this.regionName = regionName;
		} else {
			throw new IllegalArgumentException("Region name must be set between 1 and 20 chracters long");
		}
	}

	/**
	 * this method returns Board fields to String
	 */
	@Override
	public String toString() {
		return "[squareIndex=" + boardIndex + ", areaName=" + areaName + ", regionName=" + regionName + "]";
	}


	public abstract void displayAll();

}
