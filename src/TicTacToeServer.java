import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

/**
 * The TicTacToeServer class is the class used to run the server for the TicTacToe game.
 * 
 * @author Edward Suryajaya
 */

public class TicTacToeServer {
	
	/**
	 * The main function is used to run and stop the server.
	 * 
	 * @throws IOException to throw the IOException.
	 */

	public static void main(String[] args) throws IOException {
		System.out.println("Server is Running...");
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				System.out.println("Server Stopped.");
			}
		}));

		try (var listener = new ServerSocket(6000)) {
			Server myServer = new Server(listener);
			myServer.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}