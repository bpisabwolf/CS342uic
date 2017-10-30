
public class GameMechanics {
	private static int rowNum = 9;
	private static int colNum = 9;
	private String buttons[][];
	private String buttonNums[] = {"1","2","3","4","5","6","7","8","9"};
	public GameMechanics(){
		buttons = new String[rowNum][colNum];
	}
	
	public void setPlaceHolderButtons(){
		for(int r = 0; r < rowNum; r++){
			for(int c = 0; c < colNum; c++){
				buttons[r][c] = buttonNums[c];
			}
		}
	}
	
	public void printButtons(){
		for(int r = 0; r < rowNum; r++){
			for(int c = 0; c < colNum; c++){
				System.out.print(buttons[r][c] + " ");
			}
			System.out.println("");
		}
	}
	
	private void determineButton
	public void setButtonNum(){
		
	}
}
