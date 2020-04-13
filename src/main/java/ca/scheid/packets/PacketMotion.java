/**
 * 
 */
package ca.scheid.packets;

import java.nio.ByteBuffer;

import ca.scheid.data.CarMotionData;
import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 9, 2020
 */

@ToString(includeFieldNames = true)
public class PacketMotion {

	/**
	 * Data for all cars on track
	 */
	@Getter
	private CarMotionData[] carMotionData;

	/**
	 * RL, RR, FL, FR
	 */
	@Getter
	private float[] suspensionPosition;

	/**
	 * RL, RR, FL, FR
	 */
	@Getter
	private float[] suspensionVelocity;

	/**
	 * RL, RR, FL, FR
	 */
	@Getter
	private float[] suspensionAcceleration;

	/**
	 * RL, RR, FL, FR
	 */
	@Getter
	private float[] wheelSpeed;

	/**
	 * RL, RR, FL, FR
	 */
	@Getter
	private float[] wheelSlip;
	
	/**
	 * Velocity in local space
	 */
	@Getter
	private float localVelocityX;
	
	/**
	 * Velocity in local space
	 */
	@Getter
	private float localVelocityY;
	
	/**
	 * Velocity in local space
	 */
	@Getter
	private float localVelocityZ;
	
	/**
	 * Angular velocity x-component
	 */
	@Getter
	private float angularVelocityX;
	
	/**
	 * Angular velocity y-component
	 */
	@Getter
	private float angularVelocityY;
	
	/**
	 * Angular velocity z-component
	 */
	@Getter
	private float angularVelocityZ;
	
	/**
	 * Angular acceleration x-component
	 */
	@Getter
	private float angularAccelerationX;
	
	/**
	 * Angular acceleration y-component
	 */
	@Getter
	private float angularAccelerationY;
	
	/**
	 * Angular acceleration z-component
	 */
	@Getter
	private float angularAccelerationZ;
	
	/**
	 * Current front wheels angle in radians
	 */
	@Getter
	private float frontWheelsAngle;
	
	public PacketMotion(ByteBuffer byteBuffer) {
		this.carMotionData = initializeCarMotionData(byteBuffer);
		this.suspensionPosition = Utils.getArrayOfFloats(byteBuffer);
		this.suspensionVelocity = Utils.getArrayOfFloats(byteBuffer);
		this.suspensionAcceleration = Utils.getArrayOfFloats(byteBuffer);
		this.wheelSpeed = Utils.getArrayOfFloats(byteBuffer);
		this.wheelSlip = Utils.getArrayOfFloats(byteBuffer);
		this.localVelocityX = byteBuffer.getFloat();
		this.localVelocityY = byteBuffer.getFloat();
		this.localVelocityZ = byteBuffer.getFloat();
		this.angularVelocityX = byteBuffer.getFloat();
		this.angularVelocityY = byteBuffer.getFloat();
		this.angularVelocityZ = byteBuffer.getFloat();
		this.angularAccelerationX = byteBuffer.getFloat();
		this.angularAccelerationY = byteBuffer.getFloat();
		this.angularAccelerationZ = byteBuffer.getFloat();
		this.frontWheelsAngle = byteBuffer.getFloat();
	}
	
	private CarMotionData[] initializeCarMotionData(ByteBuffer byteBuffer) {
		CarMotionData[] aux = new CarMotionData[20];
		for(int i=0;i<20;i++) aux[i] = new CarMotionData(byteBuffer);
		return aux;
	}
}
