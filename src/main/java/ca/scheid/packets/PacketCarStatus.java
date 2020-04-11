/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.data.CarStatusData;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 10, 2020
 */
@ToString(includeFieldNames=true)
public class PacketCarStatus {
	/**
	 * This packet details car statuses for all the cars in the race. 
	 * It includes values such as the damage readings on the car.
	 */
	@Getter
	private CarStatusData[] carStatus;
	
	public PacketCarStatus(ByteBuffer byteBuffer) {
		this.carStatus = new CarStatusData[20];
		for(int i=0;i<20;i++) this.carStatus[i] = new CarStatusData(byteBuffer);
	}
}
