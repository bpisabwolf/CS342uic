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

public class SideBar extends JPanel implements ActionListener {
	private JButton buttons[];
	private final String buttonLabels[] = 
	      { "1", "2", "3", "4", "5", "6", "7", "8", "9", "C"};
	   
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel sidebar = new SideBar();
		JButton CandidateButton = new JButton("Show Candidate List");
		JPanel helpbar = new HelpBar();
	       
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(BorderLayout.SOUTH, helpbar);
		frame.getContentPane().add(BorderLayout.EAST, sidebar);
		
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
			buttons[count].addActionListener( this );
			buttons[count].setFont(new Font("Arial", Font.PLAIN, 25));
	       
	  }
	}
	
	 
	 // handle button events 
	 public void actionPerformed( ActionEvent event )
	 { 
	     
	      JButton temp = (JButton) event.getSource();
		  int buttonPos = -1;
		  for ( int count = 0; count < buttons.length; count++ ) 
		  {
		     if ( temp.equals(buttons[count] ) ) {
		    	 buttonPos = count;
		     }
		  }
			         
		  buttons[buttonPos].setEnabled(false);  
		     
	      if (buttonPos < 9) {
	 	      JOptionPane.showMessageDialog( this,
	            "Select Cell(s) to place a " + event.getActionCommand() + " "
	                            + "into.");
	      }
	      else if (buttonPos == 9) {
	    	  JOptionPane.showMessageDialog( this, "Select Cell(s) to Clear.");
	      }
	      
	      buttons[buttonPos].setEnabled(true); 
		     
	 }	  
 }
 
