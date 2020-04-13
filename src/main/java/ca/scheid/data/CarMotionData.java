/**
 * 
 */
package ca.scheid.data;

import java.nio.ByteBuffer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(includeFieldNames=true)
public class CarMotionData {
		/**
		 * World space X position
		 */
		@Getter @Setter
		private float worldPositionX;
		
		/**
		 * World space Y position
		 */
		@Getter @Setter
		private float worldPositionY;
		
		/**
		 * World space Z position
		 */
		@Getter @Setter
		private float worldPositionZ;
		
		/**
		 * Velocity in world space X
		 */
		@Getter @Setter
		private float worldVelocityX;
		
		/**
		 * Velocity in world space Y
		 */
		@Getter @Setter
		private float worldVelocityY;
		
		/**
		 * Velocity in world space Z
		 */
		@Getter @Setter
		private float worldVelocityZ;
		
		/**
		 *  World space forward X direction (normalised)
		 */
		@Getter @Setter
		private short worldForwardDirX;
		
		/**
		 * World space forward Y direction (normalised)
		 */
		@Getter @Setter
		private short worldForwardDirY;
		
		/**
		 * World space forward Z direction (normalised)
		 */
		@Getter @Setter
		private short worldForwardDirZ;
		
		/**
		 * World space right X direction (normalised)
		 */
		@Getter @Setter
		private short worldRightDirX;
		
		/**
		 * World space right Y direction (normalised)
		 */
		@Getter @Setter
		private short worldRightDirY;
		
		/**
		 * World space right Z direction (normalised)
		 */
		@Getter @Setter
		private short worldRightDirZ;
		
		/**
		 * Lateral G-Force component
		 */
		@Getter @Setter
		private float gForceLateral;
		
		/**
		 * Longitudinal G-Force component
		 */
		@Getter @Setter
		private float gForceLongitudinal;
		
		/**
		 * Vertical G-Force component
		 */
		@Getter @Setter
		private float gForceVertical;
		
		/**
		 * Yaw angle in radians
		 */
		@Getter @Setter
		private float yaw;
		
		/**
		 * Pitch angle in radians
		 */
		@Getter @Setter
		private float pitch;
		
		/**
		 * Roll angle in radians 
		 */
		@Getter @Setter
		private float roll;
		
		public CarMotionData(ByteBuffer byteBuffer){
			this.worldPositionX = byteBuffer.getFloat();
			this.worldPositionY = byteBuffer.getFloat();
			this.worldPositionZ = byteBuffer.getFloat();
			this.worldVelocityX = byteBuffer.getFloat();
			this.worldVelocityY = byteBuffer.getFloat();
			this.worldVelocityZ = byteBuffer.getFloat();
			this.worldForwardDirX = byteBuffer.getShort();
			this.worldForwardDirY = byteBuffer.getShort();
			this.worldForwardDirZ = byteBuffer.getShort();
			this.worldRightDirX = byteBuffer.getShort();
			this.worldRightDirY = byteBuffer.getShort();
			this.worldRightDirZ = byteBuffer.getShort();
			this.gForceLateral = byteBuffer.getFloat();
			this.gForceLongitudinal = byteBuffer.getFloat();
			this.gForceVertical = byteBuffer.getFloat();
			this.yaw = byteBuffer.getFloat();
			this.pitch = byteBuffer.getFloat();
			this.roll = byteBuffer.getFloat();
		}
}
