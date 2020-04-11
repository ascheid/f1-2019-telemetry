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
public enum Weather {
	CLEAR((short) 0, "Clear"),
	LIGHT_CLOUD((short) 1, "Light Clouds"),
	OVERCAST((short) 2, "Overcast"),
	LIGHT_RAIN((short) 3, "Light Rain"),
	HEAVY_RAIN((short) 4, "Heavy Rain"),
	STORM((short) 5, "Storm");
	
	@Getter
	private final short code;
	
	@Getter
	private final String weather;
}
