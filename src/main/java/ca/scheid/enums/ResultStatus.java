/**
 * 
 */
package ca.scheid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@AllArgsConstructor
public enum ResultStatus {
	
	/** Result status - 0 = invalid, 1 = inactive, 2 = active
	  * 3 = finished, 4 = disqualified, 5 = not classified
	  * 6 = retired
	 */
	INVALID((byte) 0, "Invalid"),
	INACTIVE((byte) 1, "Inactive"),
	ACTIVE((byte) 2, "Active"),
	FINISHED((byte) 3, "Finished"),
	DISQUALIFIED((byte) 4, "Disqualified"),
	NOT_CLASSIFIED((byte) 5, "Not Classified");
	
	
	@Getter
	private final short code;
	
	@Getter
	private final String resultStatus;
}
