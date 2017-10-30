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

public class HelpBar extends JPanel implements ActionListener{
	private JButton candidateButton;
	
	public HelpBar () {
		candidateButton = new JButton("Show Candidate List");
		this.add( candidateButton );
		candidateButton.addActionListener( this );
		candidateButton.setFont(new Font("Arial", Font.PLAIN, 25));
	}
	
	// handle button events 
	public void actionPerformed( ActionEvent event ) { 
		candidateButton.setEnabled(false);  
		JOptionPane.showMessageDialog( this, "Select Cell to show Candidate List.");
		// Select Cell here //
		candidateButton.setEnabled(true);  

		
        JButton temp = (JButton) event.getSource();
	   
	}	 
}
