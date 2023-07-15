/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Blueprint {
	private int numberOfFloors;
	
	private Floor[] floors;
	private int nof; //number of floors
	
	public Blueprint(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
		
		this.floors = new Floor[numberOfFloors];
		this.nof = 0;
	}
	
	public Blueprint(Blueprint other) {
		this(other.numberOfFloors);
		for(int i = 0; i < other.nof; i++) {
			this.floors[i] = new Floor(other.floors[i]);
		}
		this.nof = other.nof;
		
	}
	public void addFloorPlan(Floor floor) {
		this.floors[this.nof] = floor;
		this.nof++;
	}
	
	public Floor[] getFloors() {
		Floor[] floors = new Floor[this.nof];
		for(int i = 0; i < this.nof; i++) {
			floors[i] = new Floor(this.floors[i]);
		}
		return floors;
	}
	
	public String toString() {
		double buildingProgress = (100.0 * this.nof)/this.numberOfFloors;
		return String.format("%.1f percents of building blueprint completed (%d out of %d floors)",
				buildingProgress, this.nof, this.numberOfFloors);
	}
}