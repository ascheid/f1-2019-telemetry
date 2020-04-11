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
public enum Race {
	MELBOURNE((byte) 0 , "Melbourne"),
    PAUL_RICARD((byte) 1 , "Paul Ricard"),
    SHANGHAI((byte)  2 , "Shanghai"),
    SAHKIR((byte)  3 , "Sakhir (Bahrain)"),
    CATALANUYA((byte)  4 , "Catalunya"),
     MONACO((byte) 5 , "Monaco"),
     MONTREAL((byte) 6 , "Montreal"),
     SILVERSTONE((byte) 7 , "Silverstone"),
     HOCKENHEIM((byte) 8 , "Hockenheim"),
     HUNGARORING((byte) 9 , "Hungaroring"),
    SPA((byte) 10 , "Spa"),
    MONZA((byte) 11 , "Monza"),
    SINGAPORE((byte) 12 , "Singapore"),
    SUZUKA((byte) 13 , "Suzuka"),
    ABU_DHABI((byte) 14 , "Abu Dhabi"),
    TEXAS((byte) 15 , "Texas"),
    BRAZIL((byte) 16 , "Brazil"),
    AUSTRIA((byte) 17 , "Austria"),
    SOCHI((byte) 18 , "Sochi"),
    MEXICO((byte) 19 , "Mexico"),
    BAKU((byte) 20 , "Baku (Azerbaijan)"),
    SAKHIR_SHORT((byte) 21 , "Sakhir Short"),
    SILVERSTONE_SHORT((byte) 22 , "Silverstone Short"),
    TEXAS_SHORT((byte) 23 , "Texas Short"),
    SUZUKA_SHORT((byte) 24 , "Suzuka Short");
	
	@Getter
	private final byte code;
	
	@Getter
	private final String raceName;
}
