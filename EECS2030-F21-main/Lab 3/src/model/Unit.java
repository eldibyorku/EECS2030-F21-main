/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Unit {
	private String function;
	private int width;
	private int length;
	private String mode; // feet or meters
	private final String FEET_MODE = "feet";
	private final String METERS_MODE = "meters";
	private final double FEET_METER = 0.3048;

	public Unit(String function , int width, int length) {
		this.function = function;
		this.width = width;
		this.length = length;
		this.mode = FEET_MODE;
	}

	public String getFunction() {
		return this.function;
	}

	public int getWidth() {
		return this.width;
	}

	public int getLength() {
		return this.length;
	}

	public int getAreaInSquareFeet() {
		return this.width * this.length;
	}
	
	public double getAreaInSquareMeter() {
		return (this.width * FEET_METER) * (this.length * FEET_METER) ;
	}

	public void toogleMeasurement() {
		if(this.mode.equals(FEET_MODE)) {
			this.mode = METERS_MODE;
		}
		else {
			this.mode = FEET_MODE;
		}
	}
	
	/*
	 * Two units are considered equal if their intended functions are the same (case-sensitive)
	 * 	and the areas (in square feet) are the same (even if the dimensions may be different). 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		return  this.function.equals(other.function) && this.getAreaInSquareFeet() == other.getAreaInSquareFeet();
	}
	
	public String toString() {
		String result = "";
		if (this.mode.equals(FEET_MODE)) {
			result = String.format("A unit of %d square feet (%d' wide and %d' long) functioning as %s", 
					this.getAreaInSquareFeet(), this.width, this.length, this.function);
		}
		else {
			result = String.format("A unit of %.2f square meters (%.2f m wide and %.2f m long) functioning as %s", 
					this.getAreaInSquareMeter(), this.width * FEET_METER, this.length * FEET_METER, this.function);		
		}

		return result;
	}
}