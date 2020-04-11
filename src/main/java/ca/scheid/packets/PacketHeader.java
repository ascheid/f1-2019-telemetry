/**
 * 
 */
package ca.scheid.packets;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import ca.scheid.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 8, 2020
 */

@ToString(includeFieldNames=true)
public class PacketHeader {
	/**
	 *  2019
	 */
	@Getter
	@Setter
	private short packetFormat;
	
	
	
	/**
	 * Game major version - "X.00"
	 */
	@Getter
	@Setter
	private short gameMajorVersion;
	
	/**
	 * Game minor version - "1.XX"
	 */
	@Getter
	@Setter
	private short gameMinorVersion;
	
	
	/**
	 * Version of this packet type, all start from 1
	 */
	@Getter
	@Setter
	private short packetVersion;
	
	
	/**
	 * Identifier for the packet type, see below 
	 * PacketID.enum
	 */
	@Getter
	@Setter
	private short packetId;
	
	/**
	 * Unique identifier for the session
	 */
	@Getter
	@Setter
	private BigInteger sessionUid;
	
	/**
	 * Session timestamp
	 */
	@Getter
	@Setter
	private float sessionTime;
	
	/**
	 * Identifier for the frame the data was retrieved on
	 */
	@Getter
	@Setter
	private long frameIdentifier;
	
	/**
	 * Index of player's car in the array
	 */
	@Getter
	@Setter
	private static short playerCarIndex = 0;
	
	public PacketHeader(ByteBuffer buffer) {
		this.packetFormat = Utils.convert_uint16(buffer.getShort());
		this.gameMajorVersion = Utils.convert_uint8(buffer.get());
		this.gameMinorVersion = Utils.convert_uint8(buffer.get());
		this.packetVersion = Utils.convert_uint8(buffer.get());
		this.packetId = Utils.convert_uint8(buffer.get());
		this.sessionUid = Utils.convert_uint64(buffer.getLong());
		this.sessionTime = buffer.getFloat();
		this.frameIdentifier = Utils.convert_uint32(buffer.getInt());;
		PacketHeader.playerCarIndex = Utils.convert_uint8(buffer.get());
	}
}
