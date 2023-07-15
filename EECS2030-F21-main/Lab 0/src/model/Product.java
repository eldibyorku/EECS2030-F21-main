/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

/*
 * Template for individual apple product in the refurbished store. 
 */
public class Product {
	/* attributes: should be private so that they are only visible within the current class.
	 * If an attribute is public, then it will be visible to all classes
	 * Instead, create a public accessor for this private attribute. */
	
	private String model; //e.g., iPad Pro 12.9
	private String finish; //e.g., Silver, Space Grey
	private int storage; // in the unit of GB, e.g., 256, 512, 1000 (1TB)
	private boolean hasCellularConnectivity; //e,g., false (only wifi),true (wifi + cellular)
	private double originalPrice; //e.g., 1789.00
	private double discountValue; //e.g., 200.00
	
	/*  constructors */ 
	// if no constructors are declared here, then an implicit default constructor is available. 
	// Advice: If we find the default constructor useful. Then we can define one explicitly.
	// Otherwise as soon as any additional constructors are added, then implicit constructor becomes unavailable.
	public Product() {
		// Do nothing: all attributes will be stored their default values after an object is created.
	}
	
	// An overloaded version of the constructor. 
		public Product(String model, double originalPrice) {
			this.model = model;
			this.originalPrice = originalPrice;
		}
	
	/* accessors */
	public String getModel() {
		return this.model;
	}
	
	public String getFinish() {
		return this.finish;
	}
	
	public int getStorage() {
		return this.storage;
	}
	
	public boolean hasCellularConnectivity() {
		return this.hasCellularConnectivity;
	}
	
	public double getOriginalPrice() {
		return this.originalPrice;
	}
	
	public double getDiscountValue() {
		return this.discountValue;
	}
	
	
	/* mutator */ 
	public void setModel(String model) {
		this.model = model;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
	public double getPrice() {
		//local variable declaration
		double price = 0.0;
		
		// computation 
		price = this.originalPrice - this.discountValue;
		
		//return 
		return price;	
	}
	
	public String toString() {
		//local variable declaration
		String s = "";
		
		// computation 
//		StringBuilder sb = new StringBuilder();
//		sb.append( model + " " + finish + " " + storage + "GB " 
//				+ "(cellular connectivity: " + hasCellularConnectivity + "): $("
//					+ String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")");
//		s = sb.toString();
		
//		s += model + " " + finish + " " + storage + "GB " 
//				+ "(cellular connectivity: " + hasCellularConnectivity + "): $("
//					+ String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")";
//		
		s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)", 
						this.model, this.finish, this.storage, this.hasCellularConnectivity, 
						this.originalPrice, this.discountValue);
		
		//return 
		return s;
	}
}
