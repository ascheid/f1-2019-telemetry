/**
 * 
 */
package ca.scheid.controller;

import java.nio.ByteBuffer;

import ca.scheid.packets.PacketCarSetup;
import ca.scheid.packets.PacketCarStatus;
import ca.scheid.packets.PacketCarTelemetry;
import ca.scheid.packets.PacketEvent;
import ca.scheid.packets.PacketHeader;
import ca.scheid.packets.PacketLap;
import ca.scheid.packets.PacketMotion;
import ca.scheid.packets.PacketParticipants;
import ca.scheid.packets.PacketSession;
import lombok.extern.log4j.Log4j2;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 10, 2020
 */

@Log4j2
public class PacketController {
	private PacketHeader packetHeader;
	
	public PacketController(ByteBuffer byteBuffer) {
		this.packetHeader = new PacketHeader(byteBuffer);
		packetFactory(byteBuffer);
	}
	
	private void packetFactory(ByteBuffer byteBuffer) {
		switch(this.packetHeader.getPacketId()) {
		case 0:
			PacketMotion packetMotion = new PacketMotion(byteBuffer);
			log.trace(packetMotion.toString());
			break;
		case 1:
			PacketSession packetSession = new PacketSession(byteBuffer);
			log.trace(packetSession.toString());
			break;
		case 2:
			PacketLap packetLap = new PacketLap(byteBuffer);
			log.trace(packetLap.toString());
			break;
		case 3:
			PacketEvent packetEvent = new PacketEvent(byteBuffer);
			log.trace(packetEvent.toString());
			break;
		case 4:
			PacketParticipants packetParticipants = new PacketParticipants(byteBuffer);
			log.trace(packetParticipants.toString());
			break;
		case 5:
			PacketCarSetup packetCarSetup = new PacketCarSetup(byteBuffer);
			log.trace(packetCarSetup.toString());
			break;
		case 6:
			PacketCarTelemetry packetCarTelemetry = new PacketCarTelemetry(byteBuffer);
			log.trace(packetCarTelemetry.toString());
			break;
		case 7:
			PacketCarStatus packetCarStatus = new PacketCarStatus(byteBuffer);
			log.trace(packetCarStatus.toString());
			break;
		default:
			log.error("Packet ID not valid!");	
		}
	}
}
