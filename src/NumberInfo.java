
/**
 * 
 * The NumberInfo class is the class that store the numbers that is shared to all of the clients.
 * 
 * @author Edward Suryajaya
 *
 */
public class NumberInfo {
	private final Object lock = new Object();
	private int n;

	/**
	 * This function creates a number starting from 0;
	 */
	public NumberInfo() {
		this.n = 0;
	}
	
	/**
	 * The up function is used to increase the number of turn everytime a player finishes their turn.
	 */

	public void up() {
		synchronized (lock) {
			n++;
		}
	}
	
	/**
	 * The reset function is used to reset the number of turns after the game ends.
	 */
	
	public void reset() {
		synchronized (lock) {
			n=0;
		}		
	}
	
	/**
	 * The getNumber function us used to get the current number of turns.
	 * @return n, which is the current number of turns.
	 */

	public int getNumber() {
		synchronized (lock) {
			return n;
		}
	}
	
	
}