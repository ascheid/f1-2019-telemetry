/**
 * 
 */
package ca.scheid.threads;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import lombok.extern.log4j.Log4j2;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com
 * Apr 10, 2020
 * 
 * PacketReceiver thread:
 *   (1) The PacketReceiver thread does a select() to wait on incoming packets in the UDP socket.
 *   (2) When woken up with the notification that a UDP packet is available for reading, it is actually read from the socket.    
 *   (3) The receiver thread calls the recorder_thread.record_packet() method with a TimedPacket containing the reception timestamp and the packet just read.  
 *   (4) The recorder_thread.record_packet() method locks its packet queue, inserts the packet there,
 *     then unlocks the queue. Note that this method is only called from within the receiver thread!  
 *   (5) repeat from (1).
 */

@Log4j2
public class PacketReceiver extends Thread {
	private final int PORT = 20777;
	@Override
	public void run() {
		this.setName("PacketReceiver");
		byte[] buffer = new byte[2048];
		DatagramSocket datagramSocket = null;
		DatagramPacket datagramPacket = null;
		try {
			datagramSocket = new DatagramSocket(PORT);
			datagramPacket = new DatagramPacket(buffer, buffer.length);
			while(true) {
				/* The PacketReceiver thread does a select() to wait on incoming packets in the UDP socket.
				 * When woken up with the notification that a UDP packet is available for reading, it is actually read from the socket. */
				datagramSocket.receive(datagramPacket);
				log.trace("Packet read!");
				PacketProcessor.getPACKET_QUEUE().put(buffer);
				log.trace("Inserted packet in the queue");
				datagramPacket.setLength(buffer.length);
			}
		} catch (Exception e) {
			PacketReceiver.log.error("Error receiving packet!");
			e.printStackTrace();
		} finally {
			datagramSocket.close();
		}
	}
}
