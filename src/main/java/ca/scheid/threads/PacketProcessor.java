/**
 * 
 */
package ca.scheid.threads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

import ca.scheid.controller.PacketController;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 10, 2020
 */

@Log4j2
public class PacketProcessor extends Thread {
	/**
	 * Queue that receives the packets
	 */
	@Getter
	private static BlockingQueue<byte[]> PACKET_QUEUE = new SynchronousQueue<byte[]>();

	@Override
	public void run() {
		this.setName("PacketProcessor");
		try {
			while (true) {
				byte[] buffer = PACKET_QUEUE.take();
				log.trace("Element took from queue");
				ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
				byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
				new PacketController(byteBuffer);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
