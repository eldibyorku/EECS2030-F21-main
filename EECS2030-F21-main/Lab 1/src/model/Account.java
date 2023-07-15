/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

/*
 * Template for  registered Account is characterized by its account owner name,
 * the store it is linked to, the list of
 * downloaded apps, and its status
 */

public class Account {

	private String userName;
	private AppStore appStore;

	private String[] downloadedApps;
	private int noda; //Number Of Downloaded Apps
	private final int MAX_APPS_DOWNLOAD = 50; // This is a maximum Download Range.

	private App[] app;

	private String status;

	/* Constructor*/
	public Account(String userName, AppStore appStore) {
		this.userName = userName;
		this.appStore = appStore;
		this.downloadedApps = new String[MAX_APPS_DOWNLOAD];
		this.app = new App[MAX_APPS_DOWNLOAD];
		this.noda = 0; 
		this.status = String.format("An account linked to the %s store is created for %s.", this.appStore.getBranch(), this.userName);
	}

	public void switchStore(AppStore newStore) { 
		this.appStore = newStore;
		this.status = String.format("Account for %s is now linked to the %s store.", this.userName,this.appStore.getBranch());
	}

	public boolean appExists (String appName) {
		boolean nameExists = false;
		for (int i = 0; i < noda && (!nameExists); i++) {
			if (this.downloadedApps[i].equals(appName)) {
				nameExists = true;
			}
		}
		return nameExists;
	}

	public void uninstall(String appName) {
		boolean nameExists = this.appExists(appName);
		if (nameExists) {
			int index = -1;
			boolean appMatch = false;
			for (int i = 0; i < noda  && (!appMatch); i++) {
				if(this.getNamesOfDownloadedApps()[i].equals(appName)) {
					index = i;
					appMatch = true;
				}
			}
			if (appMatch) {
				for(int i = index; i < noda; i++)	{
					this.downloadedApps[i] = this.downloadedApps[i+1];
				}
				this.noda--;
			}
			this.status = String.format("%s is successfully uninstalled for %s.", appName, this.userName);
		}
		else {
			this.status = String.format("Error: %s has not been downloaded for %s.", appName, this.userName);
		}
	}

	public void submitRating(String appName, int rating) {
		boolean nameExists = this.appExists(appName);
		if (nameExists) {
			this.appStore.getApp(appName).submitRating(rating);		
			this.status = String.format("Rating score %d of %s is successfully submitted for %s.", rating, this.userName, appName);
		}
		else {
			this.status = String.format("Error: %s is not a downloaded app for %s.", appName, this.userName);
		}
	} 

	/* Download apps for registered accounts and check their statues. */
	public void download(String appName) {
		boolean nameExists = this.appExists(appName);
		if (nameExists == true) {
			this.status = String.format("Error: %s has already been downloaded for %s.", appName,this.userName);
		}
		else {
			this.downloadedApps[noda] = appName;
			noda++;
			this.status = String.format("%s is successfully downloaded for %s.", appName, this.userName);
		}
	}

	public String[] getNamesOfDownloadedApps() {
		String[] names = new String[this.noda];
		for(int i = 0; i < this.noda; i++) {
			names[i] = this.downloadedApps[i];
		} 
		return names;
	}

	public App[] getObjectsOfDownloadedApps() {
		this.app= new App[noda];
		for(int i = 0; i < this.noda; i++) {
			app[i] = this.appStore.getApp(this.downloadedApps[i]);
		}
		return this.app;
	}

	public String toString() {
		return String.format("%s",this.status);
	}
}