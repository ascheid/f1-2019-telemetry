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
 * Apr 9, 2020
 */

@ToString(includeFieldNames=true)
public class CarTelemetryData {
		/**
		 * Speed of car in kilometres per hour
		 */
		@Getter
		private short speed;
		
		/**
		 * Amount of throttle applied (0.0 to 1.0)
		 */
		@Getter
		private float throttle;
		
		/**
		 * Steering (-1.0 (full lock left) to 1.0 (full lock right))
		 */
		@Getter
		private float steer;
		
		/**
		 * Amount of brake applied (0.0 to 1.0)
		 */
		@Getter
		private float brake;
		
		/**
		 * Amount of clutch applied (0 to 100)
		 */
		@Getter
		private short clutch;
		
		/**
		 * Gear selected (1-8, N=0, R=-1)
		 */
		@Getter
		private short gear;
		
		/**
		 * Engine RPM
		 */
		@Getter
		private short engineRPM;
		
		/**
		 *  0 = off, 1 = on
		 */
		@Getter
		private short drs;
		
		/**
		 * Rev lights indicator (percentage)
		 */
		@Getter
		private short revLightsPercentage;
		
		/**
		 * Brakes temperature (celsius)
		 */
		@Getter
		private short[] brakesTemperature;
		
		/**
		 * Tyres surface temperature (celsius)
		 */
		@Getter
		private short[] tyresSurfaceTemperature;
		
		/**
		 * Tyres inner temperature (celsius)
		 */
		@Getter
		private short[] tyresInnerTemperature;
		
		/**
		 * Engine temperature (celsius)
		 */
		@Getter
		private short engineTemperature;
		
		/**
		 * Tyres pressure (PSI)
		 */
		@Getter
		private float[] tyresPressure;
		
		/**
		 * Driving surface, see appendices
		 */
		@Getter
		private short[] surfaceType;

		public CarTelemetryData(ByteBuffer byteBuffer) {
			this.brakesTemperature = new short[4];
			this.tyresPressure = new float[4];
			this.surfaceType = new short[4];
			this.tyresSurfaceTemperature = new short[4];
			this.tyresInnerTemperature = new short[4];
			this.speed = Utils.convert_uint16(byteBuffer.getShort());
			this.throttle = byteBuffer.getFloat();
			this.steer = byteBuffer.getFloat();
			this.brake = byteBuffer.getFloat();
			this.clutch = Utils.convert_uint8(byteBuffer.get());
			this.gear = byteBuffer.get();
			this.engineRPM = Utils.convert_uint16(byteBuffer.getShort());
			this.drs = Utils.convert_uint8(byteBuffer.get());
			this.revLightsPercentage = Utils.convert_uint8(byteBuffer.get());
			this.brakesTemperature = Utils.getArrayOfuint16(byteBuffer);
			this.tyresSurfaceTemperature = Utils.getArrayOfuint16(byteBuffer);
			this.tyresInnerTemperature = Utils.getArrayOfuint16(byteBuffer);
			this.engineTemperature = Utils.convert_uint16(byteBuffer.getShort());
			this.tyresPressure = Utils.getArrayOfFloats(byteBuffer);
			this.surfaceType = Utils.getArrayOfuint8(byteBuffer);
		}
}
