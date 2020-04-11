/**
 * 
 */
package ca.scheid.data.eventdatadetails;

import java.nio.ByteBuffer;

import ca.scheid.data.EventDataDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(callSuper=true,includeFieldNames=true)
public class FastestLap extends EventDataDetails{
	
	/**
	 * Lap time in seconds
	 */
	@Getter
	@Setter
	private float lapTime;
	
	public FastestLap(ByteBuffer buffer) {
		super(buffer);
		this.lapTime = buffer.getFloat();
	}
}
