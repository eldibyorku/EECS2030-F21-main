/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

@SuppressWarnings("serial")
public class InsufficientFloorSpaceException extends Exception {
	public InsufficientFloorSpaceException(String s) {
		super(s);
	}
}
