/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Floor {
	private int maxCapacity; //in square feet

	private Unit[] units;
	private int nou; //Number of Units.
	private final int MNOU = 20; //Maximum Number of Units.

	public Floor(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.units = new Unit[MNOU];
		this.nou = 0;
	}

	public Floor(Floor other) {
		this(other.maxCapacity);
		for(int i = 0; i < other.nou; i++) {
			this.units[i] = other.units[i];
		}
		this.nou = other.nou;
	}

	public void addUnit(String function , int width, int length) throws InsufficientFloorSpaceException{
		if(this.getRemainingSpace() - (width * length) < 0) {
			throw new InsufficientFloorSpaceException("InsufficientFloorSpaceException exception thrown");
		}
		else {
			this.units[this.nou] = new Unit(function, width, length);
			this.nou++;
		}
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public int getUtilizedSpace() {
		int utilizedSpace = 0;
		for(int i = 0; i < this.nou; i++) {
			Unit unitData = this.units[i];
			utilizedSpace += unitData.getAreaInSquareFeet();
		}
		return utilizedSpace;
	}

	public int getRemainingSpace() {
		int remainingSpace = 0;
		remainingSpace = this.maxCapacity - this.getUtilizedSpace();
		return remainingSpace;

	}

	public String getUnitData() {
		String data = "";
		for(int i = 0; i < this.nou; i++) {
			Unit unitData = this.units[i];
			data += String.format("%s: %d sq ft (%d' by %d')"
					,unitData.getFunction(), unitData.getAreaInSquareFeet(), unitData.getWidth(), unitData.getLength()); 
			if(i < this.nou - 1) {
				data += ", ";  
			}
		}
		return data;
	}

	public int numberOfEqualUnits(Unit unit) {
		int result = 0;
		for (int i = 0; i < this.nou; i++) {
			if(this.units[i].equals(unit)) {
				result++;
			}
		}
		return result;
	}

	/*
	 * Two floors are considered equal if: 
	 * 	1. their maximum capacities are the same; and
	 * 	2. their spaces are utilized in the same way 
	 * 		(meaning that for each added unit in one floor, we can find its equivalent in the other floor)
	 *  For 2, the orders in which units are added to the two floors do not matter.   
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Floor other = (Floor) obj;
		boolean equal = (this.maxCapacity == other.maxCapacity) && (this.nou == other.nou);
		if(equal) {
			for (int i = 0; i < this.nou && equal; i++) {
				Unit unit = this.units[i];
				equal = this.numberOfEqualUnits(unit) == other.numberOfEqualUnits(unit);
			}
		}
		return equal;
	}

	public String toString() {
		String result = "";
		result = String.format("Floor's utilized space is %d sq ft (%d sq ft remaining): [%s]"
				,this.getUtilizedSpace(), this.getRemainingSpace(), this.getUnitData());
		return result;
	}
}