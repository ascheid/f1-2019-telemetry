/**
 * 
 */
package ca.scheid.threads;

/**
 * @author Alvaro Scheid
 * @email ascheid@gmail.com Apr 10, 2020
 */

public class ScreenRefresher extends Thread {
	@Override
	public void run() {
		this.setName("ScreenRefresher");
		while(true) {
			try {
				Thread.sleep((long) 16.67);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}