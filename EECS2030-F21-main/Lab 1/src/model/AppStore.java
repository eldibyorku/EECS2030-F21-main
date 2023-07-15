/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

/*
 * Template for AppStore is characterized by their branch name (e.g., Canada, UK)
 * and a list of available apps.
 */
public class AppStore {

	private String branch;

	private App[] apps;
	private int noa; //Number Of Apps

	/* Constructor*/
	public AppStore(String branch, int numberOfApps) {
		this.branch = branch;
		this.apps = new App[numberOfApps];
		this.noa = 0;
	}

	/* Accessor*/
	public int getNumberOfApps() {
		return this.noa;
	}

	public String getBranch() {
		return this.branch;
	}

	public void addApp(App app) {
		this.apps[noa] = app;
		noa++;
	}

	/*  Retrieve the app object of the given name.*/
	public App getApp(String appName) {
		App result = null;
		boolean foundMatch = false;
		for(int i = 0; i < this.noa && (!foundMatch); i++) {
			App app  =  this.apps[i];
			if(app.getName().equals(appName)) {
				result = app;
				foundMatch = true;
			}
		}
		return result;
	}

	/* Retrieve the information of all available apps in the app store that are stable, i.e., contain more than 2 updates.
	 * Initially, there are no apps in the app store and thus no apps are stable.*/ 
	public String[] getStableApps(int numUpdates) {
		String indices[] = new String[this.noa]; 
		int count = 0;
		// collect all products satisfying the search criteria.
		for(int i = 0; i < this.noa; i++) {
			App app = this.apps[i];
			if(app.getReleaseUpdate() >= numUpdates) {
				indices[count] = String.format("%s (%d versions; Current Version: %s)",app.getName(), 
						app.getReleaseUpdate(), app.getWhatIsNew());
				count++;
			}
		}

		String stableApps[] = new String[count]; 
		for(int i = 0; i < count; i++) {
			stableApps[i] = indices[i];
		}
		return stableApps;
	}
}