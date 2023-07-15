/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class HealthRecord {

	private String patientName;

	private Vaccine[] vaccine;
	private String[] site;
	private String[] date;
	private int rd; // number of received doses by patient. 
	private final int mnod ; // Maximum number of doses

	private String appointmentStatus;


	public HealthRecord(String patientName, int mnod) {
		this.patientName = patientName;
		this.mnod = mnod;
		this.vaccine = new Vaccine[this.mnod];
		this.site = new String[this.mnod];
		this.date = new String[this.mnod];
		this.rd = 0;
		this.appointmentStatus = null;
	}

	public void addRecord(Vaccine vaccine, String site, String date) {
		this.vaccine[this.rd] = vaccine;
		this.site[this.rd] = site;
		this.date[this.rd] = date;
		this.rd++;
	}
	
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public String getPatientName() {
		return patientName;
	}
	
	public String getVaccinationReceipt() {
		String vaccinationReceipt = "";
		if (this.rd ==0) {
			vaccinationReceipt = String.format("%s has not yet received any doses.", this.patientName);
		}
		else {
			String report = "";
			for(int i = 0; i < this.rd; i++ ) {
				report += String.format("%s in %s on %s", this.vaccine[i].toString(), this.site[i], this.date[i]);
				if(i < this.rd -1) {
					report += "; ";
				}
			}
			vaccinationReceipt = String.format("Number of doses %s has received: %d [%s]", this.patientName, this.rd, report);
		}
		return vaccinationReceipt;
	}

	public String getAppointmentStatus() {
		String appointmentStatus = null;
		if (this.appointmentStatus == null) {
			appointmentStatus = String.format("No vaccination appointment for %s yet", this.patientName);
		}
		else {
			appointmentStatus = this.appointmentStatus;
		}
		return appointmentStatus;
	}
}
