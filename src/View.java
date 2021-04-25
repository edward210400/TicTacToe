import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 * 
 * The view class is used to display the GUI component of the program, such as the TicTacToe board, the message title, and the 
 * place to enter the name of the player.
 * 
 * @author Edward Suryajaya
 *
 */

public class View {
	
	
	Border black = BorderFactory.createLineBorder(Color.black);
	JPanel panel = new JPanel();
	JMenuBar menubar = new JMenuBar();
	JMenu control = new JMenu("Control");
	JMenu help = new JMenu("Help");
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem instruction = new JMenuItem("Instruction");
	
	JPanel nameinfo = new JPanel();
	JTextField nameinput = new JTextField(17);
	JButton submit = new JButton("Submit");
	
	JLabel text = new JLabel("Enter your name...");
	
	JFrame frame = new JFrame("Tic Tac Toe");
	
	JLabel box1 = new JLabel("", SwingConstants.CENTER);
	JLabel box2 = new JLabel("", SwingConstants.CENTER);
	JLabel box3 = new JLabel("", SwingConstants.CENTER);
	JLabel box4 = new JLabel("", SwingConstants.CENTER);
	JLabel box5 = new JLabel("", SwingConstants.CENTER);
	JLabel box6 = new JLabel("", SwingConstants.CENTER);
	JLabel box7 = new JLabel("", SwingConstants.CENTER);
	JLabel box8 = new JLabel("", SwingConstants.CENTER);
	JLabel box9 = new JLabel("", SwingConstants.CENTER);
	
	String clicked = "";
	
	String readline = "";
    String response = "";
    Socket socket;
    
    /**
     * The view function is used to set the frame for the component.
     */

	public View() {
		setFrame();
	}
	
	/**
	 * The setFrame is used to set the frame for the component.
	 */

	private void setFrame() {
		menubar.add(control);
		menubar.add(help);
		control.add(exit);
		help.add(instruction);
		
		GridLayout layout = new GridLayout(3,3);
		panel.setLayout(layout);
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		panel.add(box4);
		panel.add(box5);
		panel.add(box6);
		panel.add(box7);
		panel.add(box8);
		panel.add(box9);
		box1.setOpaque(true);
		box2.setOpaque(true);
		box3.setOpaque(true);
		box4.setOpaque(true);
		box5.setOpaque(true);
		box6.setOpaque(true);
		box7.setOpaque(true);
		box8.setOpaque(true);
		box9.setOpaque(true);
		box1.setBackground(Color.white);
		box2.setBackground(Color.white);
		box3.setBackground(Color.white);
		box4.setBackground(Color.white);
		box5.setBackground(Color.white);
		box6.setBackground(Color.white);
		box7.setBackground(Color.white);
		box8.setBackground(Color.white);
		box9.setBackground(Color.white);
		box1.setBorder(black);
		box2.setBorder(black);
		box3.setBorder(black);
		box4.setBorder(black);
		box5.setBorder(black);
		box6.setBorder(black);
		box7.setBorder(black);
		box8.setBorder(black);
		box9.setBorder(black);
		box1.setFont(new Font("Tahoma", Font.BOLD, 50));
		box2.setFont(new Font("Tahoma", Font.BOLD, 50));
		box3.setFont(new Font("Tahoma", Font.BOLD, 50));
		box4.setFont(new Font("Tahoma", Font.BOLD, 50));
		box5.setFont(new Font("Tahoma", Font.BOLD, 50));
		box6.setFont(new Font("Tahoma", Font.BOLD, 50));
		box7.setFont(new Font("Tahoma", Font.BOLD, 50));
		box8.setFont(new Font("Tahoma", Font.BOLD, 50));
		box9.setFont(new Font("Tahoma", Font.BOLD, 50));
		
		nameinfo.add(nameinput);
		nameinfo.add(submit);
		
		frame.getContentPane().add(text, BorderLayout.NORTH);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(nameinfo, BorderLayout.SOUTH);
		frame.setJMenuBar(menubar);
		frame.setVisible(true);
		frame.setSize(300, 330);
		
		instruction.addActionListener(new ActionListener() {
			
			/**
			 * This function is used to create an ActionListener for the instruction JMenuItem.
			 */
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Some information about the game:\r\n"+
						"Criteria for a valid move:\r\n" + 
						"- The move is not occupied by any mark.\r\n" + 
						"- The move is made in the player’s turn.\r\n" + 
						"- The move is made within the 3 x 3 board.\r\n" + 
						"The game would continue and switch among the opposite player until it reaches either one of the following conditions:\r\n" + 
						"- Player 1 wins.\r\n" + 
						"- Player 2 wins.\r\n" + 
						"- Draw.");
			}
		});
		
	}

	
	/**
	 * The getSubmitButton is used to get the submit JButton.
	 * @return submit JButton
	 */

	public JButton getSubmitButton() {
		return submit;
	}
	
	/**
	 * The getBox1 is used to get the box1 of the TicTacToe board
	 * @return box1 JLabel
	 */

	public JLabel getBox1() {
		return box1;
	}
	
	/**
	 * The getBox2 is used to get the box2 of the TicTacToe board
	 * @return box2 JLabel
	 */

	public JLabel getBox2() {
		return box2;
	}
	
	/**
	 * The getBox3 is used to get the box3 of the TicTacToe board
	 * @return box3 JLabel
	 */
	
	public JLabel getBox3() {
		return box3;
	}
	
	/**
	 * The getBox4 is used to get the box4 of the TicTacToe board
	 * @return box4 JLabel
	 */
	
	public JLabel getBox4() {
		return box4;
	}
	
	/**
	 * The getBox5 is used to get the box5 of the TicTacToe board
	 * @return box5 JLabel
	 */
	
	public JLabel getBox5() {
		return box5;
	}
	
	/**
	 * The getBox6 is used to get the box6 of the TicTacToe board
	 * @return box6 JLabel
	 */
	
	public JLabel getBox6() {
		return box6;
	}
	
	/**
	 * The getBox7 is used to get the box7 of the TicTacToe board
	 * @return box7 JLabel
	 */
	
	public JLabel getBox7() {
		return box7;
	}
	
	/**
	 * The getBox8 is used to get the box8 of the TicTacToe board
	 * @return box8 JLabel
	 */
	
	public JLabel getBox8() {
		return box8;
	}
	
	/**
	 * The getBox9 is used to get the box9 of the TicTacToe board
	 * @return box9 JLabel
	 */
	
	public JLabel getBox9() {
		return box9;
	}
	
	/**
	 * The getText is used to get the information displayed in the TicTacToe board
	 * @return text, the JLabel displayed in the upper part of the board.
	 */
	
	public JLabel getText() {
		return text;
	}
	
	/**
	 * The getNameInput is used to get the name input by the player.
	 * @return nameInput JTextField.
	 */
	
	public JTextField getNameInput() {
		return nameinput;
	}
	
	/**
	 * The getFrame is used to getThe frame of the component.
	 * @return frame JFrame that contains all of the component.
	 */
	
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * The getWinPanel is used to show the panel when the player wins the game.
	 */
	
	public void getWinPanel() {
		JOptionPane.showMessageDialog(frame, "Congratulations. You win.");
		System.exit(0);
	}
	
	/**
	 * The getLosePanel is used to show the panel when the player loses the game.
	 */
	
	public void getLosePanel() {
		JOptionPane.showMessageDialog(frame, "You lose.");
		System.exit(0);
	}
	
	/**
	 * The getDrawPanel is used to show the panel when the game ends in a draw.
	 */
	
	public void getDrawPanel() {
		JOptionPane.showMessageDialog(frame, "Draw.");
		System.exit(0);
	}
	
	/**
	 * The getExitButton function is used to get the exit JMenuItem.
	 * @return exit JMenuItem.
	 */
	
	public JMenuItem getExitButton() {
		return exit;
	}
	
	/**
	 * The getDonePanel is used to show the panel to the player when one of the players left the game.
	 */
	
	public void getDonePanel() {
		JOptionPane.showMessageDialog(frame, "Game ends. One of the player left.");
		System.exit(0);
	}
	
	
	
}
