/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.data.EventDataDetails;
import ca.scheid.data.eventdatadetails.FastestLap;
import ca.scheid.data.eventdatadetails.RaceWinner;
import ca.scheid.data.eventdatadetails.Retirement;
import ca.scheid.data.eventdatadetails.TeamMateInPits;
import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 9, 2020
 */

@ToString(includeFieldNames=true)
public class PacketEvent {
	/**
	 * Event string code
	 */
	@Getter
	private String eventStringCode;
	
	/**
	 * Event details - should be interpreted differently
	 */
	@Getter
	private EventDataDetails eventDetails;
	
	public PacketEvent(ByteBuffer byteBuffer) {
		initializeEventString(byteBuffer);
		initializeEventDetails(byteBuffer);
	}

	private void initializeEventDetails(ByteBuffer byteBuffer) {
		switch(this.eventStringCode) {
		case "SSTA":
			break;
		case "SEND":
			break;
		case "FTLP":
			this.eventDetails = new FastestLap(byteBuffer);
			break;
		case "RTMT":
			this.eventDetails = new Retirement(byteBuffer);
		case "DRSE":
			break;
		case "DRSD":
			break;
		case "TMPT":
			this.eventDetails = new TeamMateInPits(byteBuffer);
			break;
		case "CHQF":
			break;
		case "RCWN":
			this.eventDetails = new RaceWinner(byteBuffer);
		}
	}

	private void initializeEventString(ByteBuffer byteBuffer) {
		char[] charArray = new char[4];
		for(int i=0;i<4;i++) charArray[i] = (char) Utils.convert_uint8(byteBuffer.get());
		this.eventStringCode = String.valueOf(charArray);
	}
}
