/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class VaccinationSite {

	private String siteName;
	private int maximumSupply;

	private VaccineDistribution[] vaccineDistributions;
	private int nod; // Number of distribution.
	private final int MNOD = 4; //MAX NUMBER OF DISTRIBUTIONS.

	private HealthRecord[] appointments;
	private  int noa; // Number of appointment.
	private final int MNOA = 200; //MAX NUMBER OF APPOINTMENTS.


	public VaccinationSite(String siteName, int maximumSupply) {
		this.siteName = siteName;
		this.maximumSupply = maximumSupply;

		this.vaccineDistributions = new VaccineDistribution[MNOD];
		this.nod = 0;

		this.appointments = new HealthRecord[MNOA];
		this.noa = 0;

	}

	private int vaccineNameMatch(String codename) {
		boolean foundMatch = false;
		int index = -1;
		for(int i = 0; i < this.nod && (!foundMatch); i++) {
			if(this.vaccineDistributions[i].getVaccine().getCodename().equals(codename)) {
				index = i;
				foundMatch = true;
			}
		}
		return index;
	}

	public void addDistribution(Vaccine vaccine, int vaccineSupply) throws UnrecognizedVaccineCodeNameException,TooMuchDistributionException{

		if(!(vaccine.getCodename().equals("mRNA-1273") || vaccine.getCodename().equals("BNT162b2") || vaccine.getCodename().equals("Ad26.COV2.S") || vaccine.getCodename().equals("AZD1222"))){
			throw new UnrecognizedVaccineCodeNameException("UnrecognizedVaccineCodeNameException exception thrown");
		}

		else if(vaccineSupply + this.getNumberOfAvailableDoses() > this.maximumSupply) {
			throw new TooMuchDistributionException("TooMuchDistributionException exception thrown");
		}

		else {
			int index = this.vaccineNameMatch(vaccine.getCodename());
			// If vaccine is not added.
			if(index < 0) {
				this.vaccineDistributions[this.nod] = new VaccineDistribution(vaccine, vaccineSupply);
				this.nod++;
			}
			// If vaccine is added then update the amount.
			else {
				int currentDosesAmount = this.vaccineDistributions[index].getDosesNumber();
				this.vaccineDistributions[index].setDosesNumber(currentDosesAmount + vaccineSupply);
			}
		}
	}

	public int getNumberOfAvailableDoses() {
		int numberOfAvailableDoses = 0;
		for(int i = 0; i < this.nod; i++) {
			numberOfAvailableDoses += this.vaccineDistributions[i].getDosesNumber();
		}
		return numberOfAvailableDoses;
	}

	public int getNumberOfAvailableDoses(String codename) {
		int numberOfAvailableDoses = 0;
		int index = this.vaccineNameMatch(codename);
		if(index >= 0) {
			numberOfAvailableDoses = this.vaccineDistributions[index].getDosesNumber();
		}
		return numberOfAvailableDoses;
	}

	public void bookAppointment(HealthRecord patientRecord) throws InsufficientVaccineDosesException{
		if(this.getNumberOfAvailableDoses() - this.noa == 0 ) {
			String status = String.format("Last vaccination appointment for %s with %s failed", patientRecord.getPatientName(), this.siteName);
			patientRecord.setAppointmentStatus(status);
			throw new InsufficientVaccineDosesException("InsufficientVaccineDosesException exception thrown");
		}

		else {
			this.appointments[this.noa] = patientRecord;
			this.noa++;
			String status = String.format("Last vaccination appointment for %s with %s succeeded", patientRecord.getPatientName(), this.siteName);
			patientRecord.setAppointmentStatus(status);
		}
	}

	/* 
	 *  After administering all patients' first doses,
	 * 	updates should have occurred on both the vaccination site and each of the patients:
	 * 		- Updates on the site: 
	 * 			+ The supply decreases accordingly. 
	 * 			+ The list of appointments is cleared/reset and 
	 * 				new appointments may be accepted should the remaining supply allow.
	 *		- Updates on each patient:
	 *			+ The vaccination's information is added to their record
	 *				(i.e., vaccine, name of site, and date of vaccination).
	 */
	public void administer(String date) {
		for(int i = 0; i < this.noa; i++) {
			HealthRecord patientRecord = this.appointments[i];
			//Distribution site has more than 0 doses available:
			boolean foundMatch = false;
			int index = -1;
			for(int j = 0; j < this.nod && (!foundMatch); j++) {
				if(this.vaccineDistributions[j].getDosesNumber() > 0) {
					index = j;
					foundMatch = true;
				}
			}
			//Updates on the site: 
			VaccineDistribution vaccineDistribution = this.vaccineDistributions[index];
			vaccineDistribution.setDosesNumber(vaccineDistribution.getDosesNumber() - 1);
			//Updates on each patient:
			patientRecord.addRecord(this.vaccineDistributions[index].getVaccine(), this.siteName, date);
		}
		//Updates on the site: 
		this.appointments = new HealthRecord[MNOA];
		this.noa = 0;
	}

	public String toString() {
		String data = "";
		for(int i = 0; i < this.nod; i++) {
			VaccineDistribution vd = this.vaccineDistributions[i];
			data += String.format("%d doses of %s", vd.getDosesNumber(),vd.getVaccine().getManufacturer());
			if(i < this.nod -1) {
				data += ", ";
			}
		}
		return String.format("%s has %d available doses: <%s>", this.siteName, this.getNumberOfAvailableDoses(), data);
	}
}
