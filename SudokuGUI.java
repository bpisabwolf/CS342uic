/* ------------------------------------------------
* Author: Robert L Barrera
* 		Boris Pisabaj
* 		David Qiao
* Class: CS 342, Fall 2017
* Program: #3-Sudoku Solver
* System: Windows 10, Eclipse
* October 29, 2017
* -------------------------------------------------
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SudokuGUI extends JFrame implements ActionListener {
	private Container largeContainer, smallContainer, gridContainer;
	private GridLayout grid, miniGrid;
	
	private MyJButton gridButtons[][];
	private JPanel mainGrid[];
	private JPanel gridPanel;
	private JPanel bar;
	private JPanel help;
	
	private boolean toggle = true;
	//private String placeHolders[] = {"1", "2", "3", "4", "5", "6","7","8","9"};
	
	
	private JButton buttons[];
	private final String buttonLabels[] = 
	      { "1", "2", "3", "4", "5", "6", "7", "8", "9", "C"};
	String insertString = " ";	// SideBar Variables
	int insertNumber = 0;	// SideBar Variables
	private JButton candidateButton;
	
	
	
	public SudokuGUI(){
		//bar = new SideBar();
		grid = new GridLayout(3, 3, 5, 5);
		miniGrid = new GridLayout(3, 3, 0, 0);
		largeContainer = getContentPane();
		largeContainer.setLayout(new BorderLayout());
		bar = new JPanel(new GridLayout(10, 1));
		help = new JPanel(new GridLayout(1,1));

		
		gridPanel = new JPanel(grid);
		
		largeContainer.add(gridPanel, BorderLayout.CENTER);
		gridButtons = new MyJButton[9][9];
		mainGrid = new MyJPanel[9];
		
		for(int i = 0; i < 9; i++)
		{
			
			mainGrid[i] = new MyJPanel(miniGrid, i+1);
			
			smallContainer = mainGrid[i];
			smallContainer.setLayout(miniGrid);
	
			gridPanel.add(mainGrid[i]);
			for(int j = 0; j < 9; j++){
				gridButtons[i][j] = new MyJButton(/*placeHolders[j]*/ "");
				//gridButtons[i][j].setNumber(i);
				gridButtons[i][j].addActionListener(new GridButtonListener());
				smallContainer.add(gridButtons[i][j]);
			}
			
		}
		
		// Side and Help panel
		
		
		// create and add buttons
		buttons = new JButton[ buttonLabels.length ];
		
		for ( int count = 0; count < 10; count++ ) {
			buttons[count] = new JButton(buttonLabels[count]);
			bar.add( buttons[ count ] );
			buttons[count].addActionListener( this );
			buttons[count].setFont(new Font("Arial", Font.PLAIN, 25));
		}
		
		candidateButton = new JButton("Show Candidate List");
		help.add( candidateButton );
		candidateButton.addActionListener( 
	    		new ActionListener() {
	    			public void actionPerformed( ActionEvent event )
	    			{
				      candidateButton.setEnabled(false);  
	    			}
	    		}
	     );
		candidateButton.setFont(new Font("Arial", Font.PLAIN, 25));

		largeContainer.add(BorderLayout.EAST, bar);
		largeContainer.add(BorderLayout.SOUTH, help);
		
		setSize(500,500);
		setVisible( true );
		
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic( 'F' );

		JMenuItem saveItem = new JMenuItem( "Save puzzle" );
	    saveItem.setMnemonic( 'S' );
	    fileMenu.add( saveItem );
	    saveItem.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
		            {
		               //save file action to be placed here
		            }
	    		}
	    );
		
		
	    JMenuItem loadItem = new JMenuItem( "Load puzzle..." );
	    loadItem.setMnemonic( 'L' );
	    fileMenu.add( loadItem );
	    loadItem.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
		            {
		               //load file action to be placed here
		            }
	    		}
	    );
	    

	    JMenuItem exitItem = new JMenuItem( "Exit" );
	    exitItem.setMnemonic( 'x' );
	    fileMenu.add( exitItem );
	    exitItem.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				System.exit( 0 );
	    			}
	    		}
	    );
	    
	    
	    JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic( 'H' );
		
		JMenuItem how2play = new JMenuItem( "How to play Sudoku" );
	    how2play.setMnemonic( 'S' );
	    helpMenu.add( how2play );
	    how2play.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				JOptionPane.showMessageDialog( SudokuGUI.this,
	    		        "Sudoku consists of a 3 x 3 regioned board, each region, column, and row containing 9 cells each. Numbers are to be placed in each cell. However, each row, column, and 9 cell region must contain only 1 copy of numbers 1-9.",
	    		        "How to play Sudoku", JOptionPane.PLAIN_MESSAGE );
	    			}
	    		}
	    );
	    
	    
	    JMenuItem how2interface = new JMenuItem( "How to use the interface" );
	    how2interface.setMnemonic( 'i' );
	    helpMenu.add( how2interface );
	    how2interface.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				JOptionPane.showMessageDialog( SudokuGUI.this,
	    	    		"Load or save a board to text file using the File menu. To place numbers on the grid, click a number on the right sidebar, then click where you would like to place it.Press the 'C' button to erase a cell's number. To access hints, use the Hints menu at the top.",
	    	    		"How to use", JOptionPane.PLAIN_MESSAGE );
	    			}
	    		}
	    );
	    
	    JMenuItem aboutItem = new JMenuItem( "About..." );
	    aboutItem.setMnemonic( 'A' );
	    helpMenu.add( aboutItem );
	    aboutItem.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				JOptionPane.showMessageDialog( SudokuGUI.this,
	    	    		"Robert Barrera - rbarre4 \nBoris Pisabaj - bpisab3 \nDavid Qiao - dqiao4",
	    	    		"Creators of this program", JOptionPane.PLAIN_MESSAGE );
	    			}
	    		}
	    );
	    
	    
	    JMenu hintMenu = new JMenu("Hints");
		hintMenu.setMnemonic( 'n' );
		
		JMenuItem checkOnFill = new JMenuItem( "Toggle Check on Fill mode" );
	    checkOnFill.setMnemonic( 'C' );
	    hintMenu.add( checkOnFill );
	    checkOnFill.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				//Check on Fill toggle to be placed here
	    			}
	    		}
	    );
	    
	    JMenuItem sAlgorithm = new JMenuItem( "Use Single Algorithm" );
	    sAlgorithm.setMnemonic( 'S' );
	    hintMenu.add( sAlgorithm );
	    sAlgorithm.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				//Single algorithm action to be placed here
	    			}
	    		}
	    );
	    
	    JMenuItem hAlgorithm = new JMenuItem( "Use Hidden Single Algorithm" );
	    hAlgorithm.setMnemonic( 'H' );
	    hintMenu.add( hAlgorithm );
	    hAlgorithm.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				//Hidden Single algorithm action to be placed here
	    			}
	    		}
	    );
	    
	    JMenuItem lAlgorithm = new JMenuItem( "Use Locked Candidate Algorithm" );
	    lAlgorithm.setMnemonic( 'L' );
	    hintMenu.add( lAlgorithm );
	    lAlgorithm.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				//Locked Candidate algorithm action to be placed here
	    			}
	    		}
	    );
	    
	    JMenuItem nAlgorithm = new JMenuItem( "Use Naked Pairs Algorithm" );
	    nAlgorithm.setMnemonic( 'N' );
	    hintMenu.add( nAlgorithm );
	    nAlgorithm.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				//Naked Pairs algorithm action to be placed here
	    			}
	    		}
	    );
	    
	    JMenuItem useAll = new JMenuItem( "Fill in all!" );
	    useAll.setMnemonic( 'a' );
	    hintMenu.add( useAll );
	    useAll.addActionListener(

	    		new ActionListener() {

	    			public void actionPerformed( ActionEvent event )
	    			{
	    				//all 4 algorithm actions placed here
	    			}
	    		}
	    );
	    
	    JMenuBar bar = new JMenuBar();  
	    setJMenuBar( bar );  
	    bar.add( fileMenu );
	    bar.add( helpMenu );
	    bar.add( hintMenu );

	 

	      setSize( 600, 600 );
	      setVisible( true );
		
		
		
	}

	// handle button events 
		 public void actionPerformed( ActionEvent event )
		 { 
		      buttons[insertNumber].setEnabled(true); 
		      
		      JButton temp = (JButton) event.getSource();
			  for ( int count = 0; count < buttons.length; count++ ) 
			  {
			     if ( temp.equals(buttons[count] ) ) {
			    	 insertNumber = count;         
			    	 //buttons[insertNumber].setEnabled(false); 
			     }
			  }
				
			  
			     
		      if (insertNumber < 9) {
		 	     insertString = Integer.toString(insertNumber+1);
		      }
		      else if (insertNumber == 9) {
		    	  insertString = "";
		      }		           
		 }	  
		 
		 // Grid Button Listener
		 class GridButtonListener implements ActionListener {
		        public void actionPerformed(ActionEvent event) {
		        	MyJButton temp = (MyJButton) event.getSource();
					  for ( int i = 0; i < 9; i++ ) {
						  for ( int j = 0; j < 9; j++ ) {
						     if (temp.equals(gridButtons[i][j])) {
						    	 gridButtons[i][j].setText(insertString);
						    	 //gridButtons[i][j].setEnabled(false);
						    	 
						     }
						  }
					  }
					  candidateButton.setEnabled(true); 
		        }
		        
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuGUI application = new SudokuGUI();
	    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	

}

class MyJPanel extends JPanel
{
	int region;
	public MyJPanel(GridLayout g, int r){
		super(g);
		region = r;
	}
	public int getRegion(){
		return this.region;
	}
	public void setRegion(int r){
		region = r;
	}
	
}


class MyJButton extends JButton
{
  private int num;
  private int x;
  private int y;
  public MyJButton ( String text )
  {
    super (text);
    //setText (text);
  }
  
  public MyJButton (String text, int a, int b){
	  super(text);
	  x = a;
	  y = b;
  }
  
  public MyJButton ( String text , int n)
  {
    super (text);
    num = n;
  }
  
  public void setNumber (int n)
  {
    num = n;
  }
  
  public int getNumber ()
  {
    return num;
  }
  public void setCoordintes(int a, int b){
	  this.x = a;
	  this.y = b;
  }
  
  public int getXCoordinate(){
	  return this.x;
  }
  
  public int getYCoordinate(){
	  return this.y;
  }
}
