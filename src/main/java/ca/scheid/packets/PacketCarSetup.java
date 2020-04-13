/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.data.CarSetupData;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 10, 2020
 */

@ToString(includeFieldNames=true)
public class PacketCarSetup {
	/**
	 * This packet details the car setups for each vehicle in the session. Note that in multiplayer games, other player cars will appear as blank, 
	 * you will only be able to see your car setup and AI cars.
	 */
	@Getter
	private CarSetupData[] carSetupData;
	
	public PacketCarSetup(ByteBuffer byteBuffer) {
		initializeCarSetupData(byteBuffer);
	}
	
	private void initializeCarSetupData(ByteBuffer byteBuffer) {
		this.carSetupData = new CarSetupData[20];
		for(int i=0;i<20;i++) this.carSetupData[i] = new CarSetupData(byteBuffer);
	}
}
