/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

/*
 *Template for App is characterized by their name (e.g., GoodNotes 5),
 *a list of update logs (for its various versions),
 *and a list of user rating scores 
 */

public class App {
	private String appName;

	private Log[] updates;
	private int nou; //Number Of Updates
	private final int MAX_UPDATES = 20; // This is a maximum log range.

	private int[] ratings;
	private int nor; // numberOfRating.

	/* Constructor*/
	public App(String appName, int maxNumberOfRating) {
		this.appName = appName;

		this.updates = new Log[MAX_UPDATES];
		this.nou = 0;

		this.ratings = new int[maxNumberOfRating];
		this.nor = 0;
	}

	/* Accessor*/
	public String getName() {
		return this.appName;
	}

	public int getNumberOfRating() {
		return this.nor;
	}

	public void releaseUpdate(String version) {
		Log newVersion = new Log(version);
		this.updates[this.nou] = newVersion;
		this.nou++;
	}

	public int getReleaseUpdate() {
		return this.nou;
	}

	public String getWhatIsNew(){ 
		String recentUpdate = "";
		if (this.nou == 0 ) {
			recentUpdate = "n/a";
		}
		else {
			recentUpdate = this.updates[this.nou - 1].toString(); 
		}
		return recentUpdate;
	}

	/*
	 * Retrieve the array of Logs arrange in the chronological order in which they were inserted.
	 */

	public Log[] getUpdateHistory() {
		Log[] updateHistory = new Log[this.nou];
		for (int i = 0; i < this.nou; i++) {
			updateHistory[i] = this.updates[i];
		}
		return updateHistory;
	}

	/*
	 * Return the log of the objects associated with the version.
	 */
	public Log getVersionInfo(String version) {
		Log result = null;
		boolean foundMatch = false;
		for (int i = 0; i < this.nou && (!foundMatch); i++){
			Log log = this.updates[i];
			if(log.getVersion().equals(version)) {
				result = log;
				foundMatch = true;
			}
		}
		return result; 
	}

	/*
	 * Rating score is between 1 and 5
	 * Size of Rating Array will be based on the constructor value.
	 */
	public void submitRating(int rating) {
		this.ratings[nor] = rating;
		this.nor++;
	}

	public String avgRating() {
		String avgRating = "";
		int ratingTotal=0;
		double average;
		if (this.nor == 0) {
			avgRating = "n/a";
		}
		else {
			for (int i=0; i<this.nor; i++){
				ratingTotal += ratings[i];
			}
			average = ((double)ratingTotal)/this.nor;
			avgRating = String.format("%.1f",average);
		}
		return avgRating;
	}

	public String getSubmissionRating(){
		int s1=0;
		int s2=0;
		int s3=0;
		int s4=0;
		int s5=0;
		int value;
		for(int i = 0; i < this.nor; i++){
			value = ratings[i];
			if(value == 1){
				s1++;
			}
			if(value == 2){
				s2++;
			}
			if(value == 3){
				s3++;
			}
			if(value == 4){
				s4++;
			}
			if(value == 5){
				s5++;
			}
		}
		return String.format("(Score 5: %d, Score 4: %d, Score 3: %d, Score 2: %d, Score 1: %d)", s5, s4, s3, s2, s1);
	}

	public String getRatingReport() {
		String report = "";
		if(this.nor == 0) {
			report = "No ratings submitted so far!";
		}
		else {
			report = String.format("Average of %d ratings: %s %s", this.nor, avgRating(), getSubmissionRating());
		}
		return report;
	}

	/*
	 * The string representation of an app object includes:
	 * 	- its name
	 * 	- log information of current/latest version/release (n/a when none have been released)
	 * 	- an average of rating scores received so far (n/a when none have been submitted)
	 */
	public String toString() {
		return String.format("%s (Current Version: %s; Average Rating: %s)",this.appName, this.getWhatIsNew(), this.avgRating());		
	}
}