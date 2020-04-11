/**
 * 
 */
package ca.scheid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 9, 2020
 */

@AllArgsConstructor
public enum PacketID {
	MOTION((short) 0),
	SESSION((short) 1),
	LAP_DATA((short) 2),
	EVENT((short) 3),
	PARTICIPANTS((short) 4),
	CAR_SETUPS((short) 5),
	CAR_TELEMETRY((short) 6),
	CAR_STATUS((short) 7);
	
	@Getter
	private final short code;
}
