
import java.io.*;  
import java.net.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * The controller class is used to control the activity on the client side (GUI component).
 * 
 * @author Edward Suryajaya
 *
 */

public class Controller {

	private View view;
	private ActionListener submitButtonListener;
	private ActionListener exitButtonListener;
	private MouseListener box1Listener;
	private MouseListener box2Listener;
	private MouseListener box3Listener;
	private MouseListener box4Listener;
	private MouseListener box5Listener;
	private MouseListener box6Listener;
	private MouseListener box7Listener;
	private MouseListener box8Listener;
	private MouseListener box9Listener;
	private WindowListener windowListener;

	private Socket socket;
	private Scanner in;
	private PrintWriter out;
	private String xo;
	private int boxnum;
	private int determine = 0;
	private int playernum = 0;
	private String message = "";
	private String name = "";
	private String namecheck = "";
	private int player = 0;
	private int exitcheck;
	char[] arr;
	int turn;
	
	/**
	 * The function Controller is used to control the GUI component.
	 * @param view is the GUI component of the program.
	 */

	public Controller(View view) {
		this.view = view;
	}
	
	/**
	 * The function start is used to start the client side controller.
	 */

	public void start() {
		try {
			this.socket = new Socket("127.0.0.1", 6000);
			this.in = new Scanner(socket.getInputStream());
			this.out = new PrintWriter(socket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(player == 0) {
			out.println("player");
		}
		
		windowListener = new WindowAdapter() {
			/**
			 * This function is used to create a WindowListener when the player exit the game.
			 */
			@Override
			public void windowClosing(WindowEvent e)
            {
				e.getWindow().dispose();
                out.println("exit");
                System.exit(0);
            }
		};
		view.getFrame().addWindowListener(windowListener);
		
		exitButtonListener = new ActionListener() {
			/**
			 * This function is used to create an ActionListener for the exit JMenuItem.
			 */
			public void actionPerformed(ActionEvent actionEvent) {
				out.println("exit");
				System.exit(0);
			}
		};
		view.getExitButton().addActionListener(exitButtonListener);

		submitButtonListener = new ActionListener() {
			/**
			 * This function is used to create an ActionListener for the Submit JButton.
			 */
			public void actionPerformed(ActionEvent actionEvent) {
				name = view.getNameInput().getText();
				view.getText().setText("WELCOME "+name);
				view.getFrame().setTitle("Tic Tac Toe-Player: "+name);
				view.getNameInput().setEditable(false);
				view.getSubmitButton().setEnabled(false);
				out.println("name");
			}
		};
		view.getSubmitButton().addActionListener(submitButtonListener);

		
		box1Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box1 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox1().getText()==""&&namecheck=="checked") {
					//System.out.println(view.player());
					System.out.println("1");
					out.println("1");
				}
			}
		};
		view.getBox1().addMouseListener(box1Listener);
		
		box2Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box2 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox2().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("2");
				}
			}
		};
		view.getBox2().addMouseListener(box2Listener);
		
		box3Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box3 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox3().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("3");
				}
			}
		};
		view.getBox3().addMouseListener(box3Listener);
		
		box4Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box4 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox4().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("4");
				}
			}
		};
		view.getBox4().addMouseListener(box4Listener);
		
		box5Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box5 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox5().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("5");
				}
			}
		};
		view.getBox5().addMouseListener(box5Listener);
		
		box6Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box6 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox6().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("6");
				}
			}
		};
		view.getBox6().addMouseListener(box6Listener);
		
		box7Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box7 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox7().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("7");
				}
			}
		};
		view.getBox7().addMouseListener(box7Listener);
		
		box8Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box8 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox8().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("8");
				}
			}
		};
		view.getBox8().addMouseListener(box8Listener);
		
		box9Listener = new MouseAdapter() {
			/**
			 * This function is used to create a MouseListener when the player clicks on the box9 JLabel of the TicTacToe board.
			 */
			public void mouseClicked(MouseEvent actionEvent) {
				if(name!=""&&((player==1&&turn%2==0)||(player==2&&turn%2==1&&turn>0))&&view.getBox9().getText()==""&&namecheck=="checked") {
					System.out.println("1");
					out.println("9");
				}
			}
		};
		view.getBox9().addMouseListener(box9Listener);

		Thread handler = new ClinetHandler(socket);
		handler.start();
	}
	
	/**
	 * 
	 * The ClientHandler is used to assign the socket.
	 * 
	 * @author Edward Suryajaya
	 *
	 */

	class ClinetHandler extends Thread {
		private Socket socket;

		/**
		 * The ClientHandler function is used to assign the socket.
		 * @param socket the socket that is assigned.
		 */
		public ClinetHandler(Socket socket) {
			this.socket = socket;
		}
		
		/**
		 * The run function is used to run the client side.
		 */

		@Override
		public void run() {
			try {
				readFromServer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * The readFromServer function is used to read the data that is sent from the server to the client.
		 * @throws Exception
		 */
		public void readFromServer() throws Exception {
			try {
				while (in.hasNextLine()) {
					String command = in.nextLine();
					if(player!=0) {
						arr = command.trim().toCharArray();
						boxnum = Character.getNumericValue(arr[2]);
						turn = Character.getNumericValue(arr[0]);
						exitcheck = Character.getNumericValue(arr[1]);
					}
					if(player==0) {
						if(Integer.parseInt(command)==10) {
							player = 1;
						}
						if(Integer.parseInt(command)==20 && player==0) {
							player = 2;
						}
					}
					if(namecheck=="") {
						if(Integer.parseInt(command)==50) {
							namecheck = "checked";
						}
					}
					if(exitcheck == 9) {
						view.getDonePanel();
					}
					if(turn % 2 == 0) {
						xo = "O";
					}
					if(turn % 2 != 0) {
						xo = "X";
					}
					if(boxnum==1) {
						view.getBox1().setText(xo);
						if(xo =="X") {
							view.getBox1().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox1().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox1().getText()=="X"&&view.getBox2().getText()=="X"&&view.getBox3().getText()=="X")||
								(view.getBox1().getText()=="X"&&view.getBox4().getText()=="X"&&view.getBox7().getText()=="X")||
								(view.getBox1().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox9().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox1().getText()=="X"&&view.getBox2().getText()=="X"&&view.getBox3().getText()=="X")||
								(view.getBox1().getText()=="X"&&view.getBox4().getText()=="X"&&view.getBox7().getText()=="X")||
								(view.getBox1().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox9().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox1().getText()=="O"&&view.getBox2().getText()=="O"&&view.getBox3().getText()=="O")||
								(view.getBox1().getText()=="O"&&view.getBox4().getText()=="O"&&view.getBox7().getText()=="O")||
								(view.getBox1().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox9().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox1().getText()=="O"&&view.getBox2().getText()=="O"&&view.getBox3().getText()=="O")||
								(view.getBox1().getText()=="O"&&view.getBox4().getText()=="O"&&view.getBox7().getText()=="O")||
								(view.getBox1().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox9().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					
					if(boxnum==2) {
						view.getBox2().setText(xo);
						if(xo =="X") {
							view.getBox2().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox2().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox1().getText()=="X"&&view.getBox2().getText()=="X"&&view.getBox3().getText()=="X")||
								(view.getBox2().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox8().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox1().getText()=="X"&&view.getBox2().getText()=="X"&&view.getBox3().getText()=="X")||
								(view.getBox2().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox8().getText()=="X"))){
							view.getLosePanel();
						}
						if(player==1&&((view.getBox1().getText()=="O"&&view.getBox2().getText()=="O"&&view.getBox3().getText()=="O")||
								(view.getBox2().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox8().getText()=="O"))){
							view.getLosePanel();
						}
						if(player==2&&((view.getBox1().getText()=="O"&&view.getBox2().getText()=="O"&&view.getBox3().getText()=="O")||
								(view.getBox2().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox8().getText()=="O"))){
							view.getWinPanel();
						}
					}
					if(boxnum==3) {
						view.getBox3().setText(xo);
						if(xo =="X") {
							view.getBox3().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox3().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox1().getText()=="X"&&view.getBox2().getText()=="X"&&view.getBox3().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox6().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox7().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox1().getText()=="X"&&view.getBox2().getText()=="X"&&view.getBox3().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox6().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox7().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox1().getText()=="O"&&view.getBox2().getText()=="O"&&view.getBox3().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox6().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox7().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox1().getText()=="O"&&view.getBox2().getText()=="O"&&view.getBox3().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox6().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox7().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					if(boxnum==4) {
						view.getBox4().setText(xo);
						if(xo =="X") {
							view.getBox4().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox4().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox1().getText()=="X"&&view.getBox4().getText()=="X"&&view.getBox7().getText()=="X")||
								(view.getBox4().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox6().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox1().getText()=="X"&&view.getBox4().getText()=="X"&&view.getBox7().getText()=="X")||
								(view.getBox4().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox6().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox1().getText()=="O"&&view.getBox4().getText()=="O"&&view.getBox7().getText()=="O")||
								(view.getBox4().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox6().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox1().getText()=="O"&&view.getBox4().getText()=="O"&&view.getBox7().getText()=="O")||
								(view.getBox4().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox6().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					if(boxnum==5) {
						view.getBox5().setText(xo);
						if(xo =="X") {
							view.getBox5().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox5().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox1().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox2().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox8().getText()=="X")||
								(view.getBox4().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox6().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox7().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox1().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox2().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox8().getText()=="X")||
								(view.getBox4().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox6().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox7().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox1().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox2().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox8().getText()=="O")||
								(view.getBox4().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox6().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox7().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox1().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox2().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox8().getText()=="O")||
								(view.getBox4().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox6().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox7().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					if(boxnum==6) {
						view.getBox6().setText(xo);
						if(xo =="X") {
							view.getBox6().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox6().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox3().getText()=="X"&&view.getBox6().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox4().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox6().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox3().getText()=="X"&&view.getBox6().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox4().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox6().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox3().getText()=="O"&&view.getBox6().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox4().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox6().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox3().getText()=="O"&&view.getBox6().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox4().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox6().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					if(boxnum==7) {
						view.getBox7().setText(xo);
						if(xo =="X") {
							view.getBox7().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox7().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox1().getText()=="X"&&view.getBox4().getText()=="X"&&view.getBox7().getText()=="X")||
								(view.getBox7().getText()=="X"&&view.getBox8().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox7().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox1().getText()=="X"&&view.getBox4().getText()=="X"&&view.getBox7().getText()=="X")||
								(view.getBox7().getText()=="X"&&view.getBox8().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox7().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox1().getText()=="O"&&view.getBox4().getText()=="O"&&view.getBox7().getText()=="O")||
								(view.getBox7().getText()=="O"&&view.getBox8().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox7().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox1().getText()=="O"&&view.getBox4().getText()=="O"&&view.getBox7().getText()=="O")||
								(view.getBox7().getText()=="O"&&view.getBox8().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox7().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					if(boxnum==8) {
						view.getBox8().setText(xo);
						if(xo =="X") {
							view.getBox8().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox8().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox2().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox8().getText()=="X")||
								(view.getBox7().getText()=="X"&&view.getBox8().getText()=="X"&&view.getBox9().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox2().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox8().getText()=="X")||
								(view.getBox7().getText()=="X"&&view.getBox8().getText()=="X"&&view.getBox9().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox2().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox8().getText()=="O")||
								(view.getBox7().getText()=="O"&&view.getBox8().getText()=="O"&&view.getBox9().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox2().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox8().getText()=="O")||
								(view.getBox7().getText()=="O"&&view.getBox8().getText()=="O"&&view.getBox9().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					if(boxnum==9) {
						view.getBox9().setText(xo);
						if(xo =="X") {
							view.getBox9().setForeground(Color.green);
						}
						if(xo =="O") {
							view.getBox9().setForeground(Color.red);
						}
						if(player==1&&xo=="X") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==2&&xo=="X") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==1&&xo=="O") {
							view.getText().setText("Your opponent has moved, now is your turn");
						}
						if(player==2&&xo=="O") {
							view.getText().setText("Valid move, wait for your opponent");
						}
						if(player==1&&((view.getBox1().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox7().getText()=="X"&&view.getBox8().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox6().getText()=="X"&&view.getBox9().getText()=="X"))) {
							view.getWinPanel();
						}
						if(player==2&&((view.getBox1().getText()=="X"&&view.getBox5().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox7().getText()=="X"&&view.getBox8().getText()=="X"&&view.getBox9().getText()=="X")||
								(view.getBox3().getText()=="X"&&view.getBox6().getText()=="X"&&view.getBox9().getText()=="X"))) {
							view.getLosePanel();
						}
						if(player==1&&((view.getBox1().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox7().getText()=="O"&&view.getBox8().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox6().getText()=="O"&&view.getBox9().getText()=="O"))) {
							view.getLosePanel();
						}
						if(player==2&&((view.getBox1().getText()=="O"&&view.getBox5().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox7().getText()=="O"&&view.getBox8().getText()=="O"&&view.getBox9().getText()=="O")||
								(view.getBox3().getText()=="O"&&view.getBox6().getText()=="O"&&view.getBox9().getText()=="O"))) {
							view.getWinPanel();
						}
					}
					if(turn==9) {
						view.getDrawPanel();
					}
					out.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				socket.close();
			}
		}
	}

}
