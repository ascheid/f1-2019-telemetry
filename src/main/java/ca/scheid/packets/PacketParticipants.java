/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.data.ParticipantsData;
import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 9, 2020
 */

@ToString(includeFieldNames=true)
public class PacketParticipants {
	/**
	 * Number of active cars in the data – should match number of cars on HUD
	 */
	@Getter
	private short numActiveCars;
	
	/**
	 * Info for all cars on track
	 */
	@Getter
	private ParticipantsData[] participantsData;
	
	public PacketParticipants(ByteBuffer byteBuffer) {
		this.numActiveCars = Utils.convert_uint8(byteBuffer.get());
		initializeParticipantsData(byteBuffer);
	}
	
	private void initializeParticipantsData(ByteBuffer byteBuffer) {
		this.participantsData = new ParticipantsData[numActiveCars];
		for(int i=0; i<numActiveCars;i++) this.participantsData[i] = new ParticipantsData(byteBuffer);
	}
}
