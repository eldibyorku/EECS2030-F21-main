/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class VaccineDistribution {
	private Vaccine vaccine;
	private int dosesNumber;
	

	public VaccineDistribution(Vaccine vaccine, int dosesNumber) {
		this.vaccine = vaccine;
		this.dosesNumber = dosesNumber;
	}

	public Vaccine getVaccine() {
		return this.vaccine;
	}

	public int getDosesNumber() {
		return dosesNumber;
	}

	public void setDosesNumber(int dosesNumber) {
		this.dosesNumber = dosesNumber;
	}

	public String toString() {
		return String.format("%d doses of %s by %s",this.dosesNumber, this.vaccine.getCodename(), this.vaccine.getManufacturer());
	}
}