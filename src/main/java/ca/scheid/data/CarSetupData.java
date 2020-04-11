/**
 * 
 */
package ca.scheid.data;

import java.nio.ByteBuffer;

import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(includeFieldNames=true)
public class CarSetupData {
	/**
	 * Front wing aero
	 */
	@Getter
	private short frontWing;
	
	/**
	 * Rear wing aero
	 */
	@Getter
	private short rearWing;
	
	/**
	 * Differential adjustment on throttle (percentage)
	 */
	@Getter
	private short onThrottle;
	
	/**
	 * Differential adjustment off throttle (percentage)
	 */
	@Getter
	private short offThrottle;
	
	/**
	 * Front camber angle (suspension geometry)
	 */
	@Getter
	private float frontCamber;
	
	/**
	 * Rear camber angle (suspension geometry)
	 */
	@Getter
	private float rearCamber;
	
	/**
	 * Front toe angle (suspension geometry)
	 */
	@Getter
	private float frontToe;
	
	/**
	 * Rear toe angle (suspension geometry)
	 */
	@Getter
	private float rearToe;
	
	/**
	 * Front suspension
	 */
	@Getter
	private short frontSuspension;
	
	/**
	 * Rear suspension
	 */
	@Getter
	private short rearSuspension;
	
	/**
	 * Front anti-roll bar
	 */
	@Getter
	private short frontAntiRollBar;
	
	/**
	 * Rear anti-roll bar
	 */
	@Getter
	private short rearAntiRollBar;
	
	/**
	 * Front ride height
	 */
	@Getter
	private short frontSuspensionHeight;
	
	/**
	 * Rear ride height
	 */
	@Getter
	private short rearSuspensionHeight;
	
	/**
	 * Brake pressure (percentage)
	 */
	@Getter
	private short brakePerssure;
	
	/**
	 * Brake bias (percentage)
	 */
	@Getter
	private short brakeBias;
	
	/**
	 * Front tyre pressure (PSI)
	 */
	@Getter
	private float frontTyrePressure;
	
	/**
	 * Rear tyre pressure (PSI)
	 */
	@Getter
	private float rearTyrePressure;
	
	/**
	 * Ballast
	 */
	@Getter
	private short ballast;
	
	/**
	 * Fuel load
	 */
	@Getter
	private float fuelLoad;

	public CarSetupData(ByteBuffer buffer) {
		this.frontWing = Utils.convert_uint8(buffer.get());
		this.rearWing = Utils.convert_uint8(buffer.get());
		this.onThrottle = Utils.convert_uint8(buffer.get());
		this.offThrottle = Utils.convert_uint8(buffer.get());
		this.frontCamber = buffer.getFloat();
		this.rearCamber = buffer.getFloat();
		this.frontToe = buffer.getFloat();
		this.rearToe = buffer.getFloat();
		this.frontSuspension = Utils.convert_uint8(buffer.get());
		this.rearSuspension = Utils.convert_uint8(buffer.get());
		this.frontAntiRollBar = Utils.convert_uint8(buffer.get());
		this.rearAntiRollBar = Utils.convert_uint8(buffer.get());
		this.frontSuspensionHeight = Utils.convert_uint8(buffer.get());
		this.rearSuspensionHeight = Utils.convert_uint8(buffer.get());
		this.brakePerssure = Utils.convert_uint8(buffer.get());
		this.brakeBias = Utils.convert_uint8(buffer.get());
		this.frontTyrePressure = buffer.getFloat();
		this.rearTyrePressure = buffer.getFloat();
		this.ballast = Utils.convert_uint8(buffer.get());
		this.fuelLoad = buffer.getFloat();
	}
	
}
