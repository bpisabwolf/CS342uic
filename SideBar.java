/* ------------------------------------------------
* Author: Robert L Barrera
* Class: CS 342, Fall 2017
* Program: #3-Sudoku Solver
* System: Windows 10, Eclipse
* October 29, 2017
* -------------------------------------------------
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SideBar extends JPanel /*implements ActionListener*/ {
	private JButton buttons[];
	private final String buttonLabels[] = 
	      { "1", "2", "3", "4", "5", "6", "7", "8", "9", "C"};
	   
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel bar = new SideBar();
		JButton labelButton = new JButton("Change Label");
	       
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(BorderLayout.WEST, labelButton);
		frame.getContentPane().add(BorderLayout.EAST, bar);
		
		frame.setSize(680,460);
	    frame.setVisible(true);
    }
	
	public SideBar( ) {
		this.setLayout(new GridLayout(10, 1));
		
		// create and add buttons
		buttons = new JButton[ buttonLabels.length ];
		
		for ( int count = 0; count < 10; count++ ) {
			buttons[count] = new JButton(buttonLabels[count]);
			this.add( buttons[ count ] );
			//buttons[count].addActionListener( this );
			buttons[count].setFont(new Font("Arial", Font.PLAIN, 25));
	     
	     
	  }
	}
 }
