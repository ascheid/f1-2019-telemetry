/**
 * 
 */
package ca.scheid.data;

import java.nio.ByteBuffer;

import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(includeFieldNames=true)
public class EventDataDetails {
	/**
	 * Vehicle index of car achieving fastest lap
	 */
	@Getter @Setter
	private short vehicleIdx;
	
	public EventDataDetails(ByteBuffer byteBuffer) {
		this.vehicleIdx = Utils.convert_uint8(byteBuffer.get()); 
	}
}
