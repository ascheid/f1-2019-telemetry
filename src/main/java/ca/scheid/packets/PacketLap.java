/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.data.LapData;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 9, 2020
 */

@ToString(includeFieldNames=true)
public class PacketLap {
	/**
	 * Lap data for all cars on track
	 */
	@Getter
	private LapData[] lapData;
	
	public PacketLap(ByteBuffer byteBuffer) {
		this.lapData = getLapData(byteBuffer);
	}
	
	private LapData[] getLapData(ByteBuffer byteBuffer) {
		LapData[] aux = new LapData[20];
		for(int i=0; i<20; i++) aux[i] = new LapData(byteBuffer);
		return aux;
	}
	
}
