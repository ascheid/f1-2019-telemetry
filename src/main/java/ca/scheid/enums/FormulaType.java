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
public enum FormulaType {
	F1_M((short) 0, "F1 Modern"),
	F1_C((short) 1, "F1 Classic"),
	F2((short) 2, "F2"),
	F1_G((short) 3, "F1 Generic");
	
	@Getter
	private final short code;
	
	@Getter
	private final String formulaType;
}
