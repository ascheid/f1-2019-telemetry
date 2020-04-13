/**
 * 
 */
package ca.scheid.data;

import java.nio.ByteBuffer;

import ca.scheid.enums.ZoneFlag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(includeFieldNames=true)
public class MarshalZone {
	/**
	 * Fraction (0..1) of way through the lap the marshal zone starts
	 */
	@Getter @Setter
	private float zoneStart; 
	
	/**
	 * ZoneFlag.enum
	 */
	@Getter @Setter
	private String zoneFlag;
	
	public MarshalZone(ByteBuffer buffer) {
		this.zoneStart = buffer.getFloat();
		this.zoneFlag = getTheZoneFlag(buffer.get());
	}
	
	public String getTheZoneFlag(byte code) {
		for(ZoneFlag zf : ZoneFlag.values())
			if(zf.getCode() == code)
				return zf.getZone();
		return "MarshalZone:getTheZoneFlag=Invalid code!";
	}
}
