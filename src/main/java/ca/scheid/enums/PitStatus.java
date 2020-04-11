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
public enum PitStatus {
	
	NONE((byte) 0, "None"),
	PITTING((byte) 1, "Pitting"),
	IN_PIT_AREA((byte) 2, "In Pit Area");
	
	@Getter
	private final byte code;
	
	@Getter
	private final String status;
	
}
