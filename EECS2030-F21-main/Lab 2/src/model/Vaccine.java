/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Vaccine {
	private String codename;
	private String type;
	private String manufacturer;

	public Vaccine(String codename ,String type, String manufacturer) {
		this.codename = codename;
		this.type = type;
		this.manufacturer = manufacturer;
	}

	public String getCodename() {
		return this.codename;
	}

	public String getType() {
		return this.type;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public String toString() {
		String result = "";
		if(this.codename.equals("mRNA-1273") || this.codename.equals("BNT162b2") || this.codename.equals("Ad26.COV2.S") || this.codename.equals("AZD1222")){
			result =  String.format("Recognized vaccine: %s (%s; %s)", this.codename,this.type,this.manufacturer);
		}

		else {
			result = String.format("Unrecognized vaccine: %s (%s; %s)",this.codename , this.type,this.manufacturer);
		}
		return result;
	}
}
