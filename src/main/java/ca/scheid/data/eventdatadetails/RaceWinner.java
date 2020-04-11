/**
 * 
 */
package ca.scheid.data.eventdatadetails;

import java.nio.ByteBuffer;

import ca.scheid.data.EventDataDetails;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(callSuper=true, includeFieldNames=true)
public class RaceWinner extends EventDataDetails{
	public RaceWinner(ByteBuffer buffer) {
		super(buffer);
	}
}
