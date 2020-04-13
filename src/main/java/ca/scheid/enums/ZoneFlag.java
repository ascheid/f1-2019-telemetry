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
public enum ZoneFlag {
	UNKNOWN_OR_INVALID((byte) -1, "Invalid/Unknown"),
	NONE((byte) 0, "None"),
	GREEN((byte) 1, "Green"),
	BLUE((byte) 2,"Blue"),
	YELLOW((byte) 3,"Yellow"),
	RED((byte) 4, "Red");
	
	@Getter
	private final byte code;
	
	@Getter
	private final String zone;
}
