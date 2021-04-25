import javax.swing.SwingUtilities;

/**
 * 
 * The TicTacToeClient class is the class used to run the client side of the TicTacToe game.
 * 
 * @author Edward Suryajaya
 *
 */

public class TicTacToeClient {
	
	/**
	 * The main function is used to run the client.
	 */
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			/**
			 * The run function is used to run the controller for the client side.
			 */
			@Override
			public void run() {
				View view = new View();
				Controller controller = new Controller(view);
				controller.start();
			}
		});
	}
	
}
