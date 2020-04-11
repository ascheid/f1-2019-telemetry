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
public enum Sector {
	SECTOR_ONE((byte) 0,"Sector 1"),
	SECTOR_TWO((byte) 1, "Sector 2"),
	SECTOR_THREE((byte) 2, "Sector 3");
	
	@Getter
	private final byte code;
	
	@Getter
	private final String sector;
}
