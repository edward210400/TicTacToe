import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * The class server is the server running on the server side.
 * 
 * @author Edward Suryajaya
 *
 */

public class Server {
	private ServerSocket serverSocket;
	private NumberInfo number;
	private String boxnum = "";
	private int playernum = 0;
	private int nameentered = 0;

	// The set of all the print writers for all the clients, used for broadcast.
	private Set<PrintWriter> writers = new HashSet<>();
	
	/**
	 * The server to create the server and crate new number info.
	 * @param serverSocket is the ServerSocket of the program.
	 */
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		this.number = new NumberInfo();
	}

	/**
	 * The start function is used to start the server.
	 */
	public void start() {
		var pool = Executors.newFixedThreadPool(2);
		int clientCount = 0;
		while (true) {
			try {
				Socket socket_ = serverSocket.accept();
				pool.execute(new Handler(socket_));
				System.out.println("Connected to client " + clientCount++);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	
	/**
	 * 
	 * The class Handler is used to handle the server side activity of the game, such as getting input from the client and sending
	 * output to the client.
	 * 
	 * @author Edward Suryajaya
	 *
	 */
	public class Handler implements Runnable {
		private Socket socket;
		private Scanner input;
		private PrintWriter output;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		/**
		 * The run function is used to run the server.
		 */
		@Override
		public void run() {
			System.out.println("Connected: " + socket);
			try {
				input = new Scanner(socket.getInputStream());
				output = new PrintWriter(socket.getOutputStream(), true);

				// add this client to the broadcast list
				writers.add(output);

				while (input.hasNextLine()) {
					var command = input.nextLine();

					System.out.println("Server Received: " + command);
					
					if (command.startsWith("player")) {
						playernum++;
						String con = "";
						if(playernum%2==1&&playernum>0) {
							con = "010";
						}
						if(playernum%2==0&&playernum>0) {
							con = "020";
						}
						for (PrintWriter writer : writers) {
							writer.println(con);
						}
					}
					if (command.startsWith("name")) {
						String con = "";
						nameentered++;
						con = "050";
						if(nameentered%2==0&&nameentered>0) {
							number.reset();
							for (PrintWriter writer : writers) {
								writer.println(con);
							}
						}
					}
					if (command.startsWith("exit")) {
						String con = "";
						con = "090";
						for (PrintWriter writer : writers) {
							writer.println(con);
						}
					}
					if (command.startsWith("1")||command.startsWith("2")||command.startsWith("3")||command.startsWith("4")||command.startsWith("5")
							||command.startsWith("6")||command.startsWith("7")||command.startsWith("8")||command.startsWith("9")) {
						boxnum = command;
						
						number.up();

						// broadcast updated number to all clients
						for (PrintWriter writer : writers) {
							String num = Integer.toString(number.getNumber());
							writer.println(num+"0"+boxnum);
						}
					}

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				// client disconnected
				if (output != null) {
					writers.remove(output);
				}
			}
		}
	}
}
