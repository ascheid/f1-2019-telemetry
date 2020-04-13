/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.controller.PanelController;
import ca.scheid.data.CarTelemetryData;
import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 10, 2020
 */

@ToString(includeFieldNames=true)
public class PacketCarTelemetry {
	/**
	 * This packet details telemetry for all the cars in the race. 
	 * It details various values that would be recorded on the car such as speed, throttle application, DRS etc.
	 */
	@Getter
	private CarTelemetryData[] carTelemetry;
	
	@Getter
	private long buttonStatus;
	
	public PacketCarTelemetry(ByteBuffer byteBuffer) {
		initializeCarTelemetryData(byteBuffer);
		this.buttonStatus = Utils.convert_uint32(byteBuffer.getInt());
		updateCarTelemetryGui();
	}

	private void initializeCarTelemetryData(ByteBuffer byteBuffer) {
		this.carTelemetry = new CarTelemetryData[20];
		for(int i=0;i<20;i++) this.carTelemetry[i] = new CarTelemetryData(byteBuffer); 
	}
	
	private void updateCarTelemetryGui() {
		PanelController.setTHROTTLE(this.carTelemetry[PacketHeader.getPlayerCarIndex()].getThrottle());
		PanelController.setBRAKE(this.carTelemetry[PacketHeader.getPlayerCarIndex()].getBrake());
		PanelController.setSTEERING_WHEEL(this.carTelemetry[PacketHeader.getPlayerCarIndex()].getSteer());
		PanelController.setREV_LIGHTS(this.carTelemetry[PacketHeader.getPlayerCarIndex()].getRevLightsPercentage());
	}
}
