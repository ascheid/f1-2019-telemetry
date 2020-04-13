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
public class CarStatusData {
		/**
		 * 0 (off) - 2 (high)
		 */
		@Getter
		private short tractionControl;
		
		/**
		 * 0 (off) - 1 (on)
		 */
		@Getter
		private short antiLockBrakes;
		
		/**
		 * Fuel mix - 0 = lean, 1 = standard, 2 = rich, 3 = max 
		 */
		@Getter
		private short fuelMix;
		
		/**
		 * Front brake bias (percentage)
		 */
		@Getter
		private short frontBrakeBias;
		
		/**
		 * Pit limiter status - 0 = off, 1 = on
		 */
		@Getter
		private short pitLimiterStatus;
		
		/**
		 * Current fuel mass
		 */
		@Getter
		private float fuelInTank;
		
		/**
		 * Fuel capacity
		 */
		@Getter
		private float fuelCapacity;
		
		/**
		 * Fuel remaining in terms of laps (value on MFD)
		 */
		@Getter
		private float fuelRemainingLaps;
		
		/**
		 * Cars max RPM, point of rev limiter
		 */
		@Getter
		private short maxRPM;
		
		/**
		 * Cars idle RPM
		 */
		@Getter
		private short idleRPM;
		
		/**
		 * Maximum number of gears
		 */
		@Getter
		private short maxGears;
		
		/**
		 * 0 = not allowed, 1 = allowed, -1 = unknown
		 */
		@Getter
		private short drsAllowed;
		
		/**
		 * Tyre wear percentage
		 */
		@Getter
		private short[] tyresWear;
		
		
		/**
		 * F1 Modern - 16 = C5, 17 = C4, 18 = C3, 19 = C2, 20 = C1
		 * 7 = inter, 8 = wet
		 * F1 Classic - 9 = dry, 10 = wet
		 * F2 – 11 = super soft, 12 = soft, 13 = medium, 14 = hard 15 = wet
		 */
		@Getter
		private short actualTyreCompound;
		
		
		/**
		 * F1 visual (can be different from actual compound)
		 * 16 = soft, 17 = medium, 18 = hard, 7 = inter, 8 = wet
		 * F1 Classic – same as above
		 * F2 – same as above
		 */
		@Getter
		private short tyreVisualCompound;
		
		/**
		 * Tyre damage (percentage)
		 */
		@Getter
		private short[] tyresDamage;
		
		/**
		 * Front left wing damage (percentage)
		 */
		@Getter
		private short frontLeftWingDamage;
		
		/**
		 * Front right wing damage (percentage)
		 */
		@Getter
		private short frontRightWingDamage;
		
		/**
		 * Rear wing damage (percentage)
		 */
		@Getter
		private short rearWingDamage;
		
		/**
		 * Engine damage (percentage)
		 */
		@Getter
		private short engineDamage;
		
		/**
		 * Gear box damage (percentage)
		 */
		@Getter
		private short gearBoxDamage;
		
		
		/**
		 * -1 = invalid/unknown, 0 = none, 1 = green
		 * 2 = blue, 3 = yellow, 4 = red
		 */
		@Getter
		private short vehicleFiaFlags;
		
		/**
		 * ERS energy store in Joules
		 */
		@Getter
		private float ersStoreEnergy;
		
		
		/**
		 * ERS deployment mode, 0 = none, 1 = low, 2 = medium
		 * 3 = high, 4 = overtake, 5 = hotlap
		 */
		@Getter
		private short ersDeployMode;
		
		/**
		 * ERS energy harvested this lap by MGU-K
		 */
		@Getter
		private float ersHarvestedThisLapMGUK;
		
		/**
		 * ERS energy harvested this lap by MGU-H
		 */
		@Getter
		private float ersHarvestedThisLapMGUH;
		
		/**
		 * ERS energy deployed this lap
		 */
		@Getter
		private float ersDeployedThisLap;

		public CarStatusData(ByteBuffer byteBuffer) {
			this.tyresWear = new short[4];
			this.tyresDamage = new short[4];
			this.tractionControl = Utils.convert_uint8(byteBuffer.get());
			this.antiLockBrakes = Utils.convert_uint8(byteBuffer.get());
			this.fuelMix = Utils.convert_uint8(byteBuffer.get());
			this.frontBrakeBias = Utils.convert_uint8(byteBuffer.get());
			this.pitLimiterStatus = Utils.convert_uint8(byteBuffer.get());
			this.fuelInTank = byteBuffer.getFloat();
			this.fuelCapacity = byteBuffer.getFloat();
			this.fuelRemainingLaps = byteBuffer.getFloat();
			this.maxRPM = Utils.convert_uint16(byteBuffer.getShort());
			this.idleRPM = Utils.convert_uint16(byteBuffer.getShort());
			this.maxGears = Utils.convert_uint8(byteBuffer.get());
			this.drsAllowed = Utils.convert_uint8(byteBuffer.get());
			this.tyresWear = Utils.getArrayOfuint8(byteBuffer);
			this.actualTyreCompound = Utils.convert_uint8(byteBuffer.get());
			this.tyreVisualCompound = Utils.convert_uint8(byteBuffer.get());
			this.tyresDamage = Utils.getArrayOfuint8(byteBuffer);
			this.frontLeftWingDamage = Utils.convert_uint8(byteBuffer.get());
			this.frontRightWingDamage = Utils.convert_uint8(byteBuffer.get());
			this.rearWingDamage = Utils.convert_uint8(byteBuffer.get());
			this.engineDamage = Utils.convert_uint8(byteBuffer.get());
			this.gearBoxDamage = Utils.convert_uint8(byteBuffer.get());
			this.vehicleFiaFlags = byteBuffer.get();
			this.ersStoreEnergy = byteBuffer.getFloat();
			this.ersDeployMode = Utils.convert_uint8(byteBuffer.get());
			this.ersHarvestedThisLapMGUK = byteBuffer.getFloat();
			this.ersHarvestedThisLapMGUH = byteBuffer.getFloat();
			this.ersDeployedThisLap = byteBuffer.getFloat();
		}
}
