/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

/*
 *Template for update Log is characterized by their version (e.g., 5.7.31) 
 *and fixes from the earlier version (e.g.,addressed writing lag issues).  
 */

public class Log {

	private String version; //e.g., "5.7.31"
	private String[] fixes;
	private int nof; // Number Of Fixe
	private final int MAX_FIXES = 10; // This is a maximum updates range. 

	/* Constructor*/
	public Log(String version) {
		this.version = version;
		this.fixes = new String[MAX_FIXES];
		this.nof = 0;
	}

	/* Mutator*/
	public void addFix(String fix) {
		this.fixes[nof] = fix;
		this.nof++;		
	}

	/* Accessor*/
	public String getVersion() {
		return this.version;
	}

	public int getNumberOfFixes() {
		return this.nof;
	}

	/*
	 *This a algorithm to merge multiple strings in a single string.
	 *The list of fixes (appearing within the pair of square brackets) is comma-separated.
	 */

	public String getFixes() {
		String logFix = "";
		for(int i = 0; i < nof; i++){
			logFix += fixes[i];
			if(i < this.nof - 1) {
				logFix += ", ";
			}
		}
		return String.format("[%s]", logFix);
	}
	
	public String toString() {
		return String.format("Version %s contains %d fixes %s", this.version, this.nof, this.getFixes());
	}
}