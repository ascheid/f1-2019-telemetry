/**
 * 
 */
package ca.scheid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 8, 2020
 */

@AllArgsConstructor
public enum Teams {
	MERCEDES((byte) 0, "Mercedes"), FERRARI((byte) 1, "Ferrari"), RED_BULL((byte) 2, "Red Bull Racing"),
	WILLIAMS((byte) 3, "Williams"), RACING_POINT((byte) 4, "Racing Point"), RENAULT((byte) 5, "Renault"),
	TORO_ROSSO((byte) 6, "Toro Rosso"), HAAS((byte) 7, "Haas"), MCLAREN((byte) 8, "McLaren"),
	ALFA_ROMEO((byte) 9, "Alfa Romeo"), MCLAREN_1988((byte) 10, "McLaren 1988"),
	MCLAREN_1991((byte) 11, "McLaren 1991"), WILLIAMS_1992((byte) 12, "Williams 1992"),
	FERRARI_1995((byte) 13, "Ferrari 1995"), WILLIAM_1996((byte) 14, "Williams 1996"),
	MCLAREN_1998((byte) 15, "McLaren 1998"), FERRARI_2002((byte) 16, "Ferrari 2002"),
	FERRARI_2004((byte) 17, "Ferrari 2004"), RENAULT_2006((byte) 18, "Renault 2006"),
	FERRARI_2007((byte) 19, "Ferrari 2007"), RED_BULL_2010((byte) 21, "Red Bull 2010"),
	FERRARI_1976((byte) 22, "Ferrari 1976"), ART_GRAND_PRIX((byte) 23, "ART Grand Prix"),
	CAMPOS_VEXATEX((byte) 24, "Campos Vexatec Racing"), CARLIN((byte) 25, "Carlin"),
	CHAROUZ((byte) 26, "Charouz Racing System"), DAMS((byte) 27, "DAMS"), RUSSIAN_TIME((byte) 28, "Russian Time"),
	MP_MOTORSPORT((byte) 29, "MP Motorsport"), PERTAMINA((byte) 30, "Pertamina"),
	MCLAREN_1990((byte) 31, "McLaren 1990"), TRIDENT((byte) 32, "Trident"), BWT_ARDEN((byte) 33, "BWT Arden"),
	MCLAREN_1976((byte) 34, "McLaren 1976"), LOTUS_1972((byte) 35, "Lotus 1972"),
	FERRARI_1979((byte) 36, "Ferrari 1979"), MCLAREN_1982((byte) 37, "McLaren 1982"),
	WILLIAMS_2003((byte) 38, "Williams 2003"), BRAWN_2009((byte) 39, "Brawn 2009"), LOTUS_1978((byte) 40, "Lotus 1978"),
	FERRARI_1990((byte) 63, "Ferrari 1990"), MCLAREN_2010((byte) 64, "McLaren 2010"),
	FERRARI_2010((byte) 65, "Ferrari 2010");
	
	@Getter
	private final byte code;
	
	@Getter
	private final String teamName;
}
