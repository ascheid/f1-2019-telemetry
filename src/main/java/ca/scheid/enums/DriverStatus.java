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
public enum DriverStatus {
	/**
	 * Status of driver - 0 = in garage, 1 = flying lap
	 * 2 = in lap, 3 = out lap, 4 = on track
	 */
	IN_GARAGE((byte) 0, "In Garage"),
	FLYING_LAP((byte) 1, "Flying Lap"),
	IN_LAP((byte) 2, "In Lap"),
	OUT_LAP((byte) 3, "Out Lap"),
	ON_TRACK((byte) 4, "On Track");
	
	@Getter
	private final byte code;
	
	@Getter
	private final String driverStatus;
}
