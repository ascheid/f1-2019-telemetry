/**
 * 
 */
package ca.scheid.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 10, 2020
 */

public class PanelController {
	@Getter @Setter
	private static float THROTTLE;
	
	@Getter @Setter
	private static float BRAKE;
	
	@Getter @Setter
	private static float STEERING_WHEEL;
	
	@Getter @Setter
	private static float SESSION = 0;
	
	@Getter @Setter
	private static short DURATION = 0;
	
}
