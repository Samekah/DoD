import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runs the game with a human player and contains code needed to read inputs.
 *
 */
public class HumanPlayer {
    
    private GameLogic gameLogic;
    private int playerGold;
    private int[] playerPosition;
    BufferedReader reader;

    /**
     * A constructor that sets up the variables needed for the human player 
     * @param gl : Passes the cureent instance of the GameLogic class
     */
    public HumanPlayer(GameLogic gl){
        gameLogic = gl;
        playerGold = 0;
        playerPosition = new int[2];
    }

    public int getPlayerGold(){
        return playerGold;
    }

    public void setPlayerGold(){
        playerGold += 1;
    }

    /**
     * get the players position
     * @return
     */
    public int[] getPlayerPosition(){
        return playerPosition;
    }

    /**
     * Sets the players position
     * @return
     */
    public void setPlayerPosition(int x, int y){
        playerPosition[0] = x;      //x co-ordinate
        playerPosition[1] = y;      //y co-ordinate	
    }

    /*This section of code searches the map array for the player icon (P) and stores the X and Y values
    * of its position
    */
    protected void playerPosition() {
        int mapWidth = gameLogic.map.getMapWidth();
    	int mapLength = gameLogic.map.getMapLength();
    	
    	for(int counter1= 0; counter1 < mapLength; counter1++) { 
    		for(int counter2 = 0; counter2 < mapWidth; counter2++) {
    			
    			if(gameLogic.map.getMap()[counter2][counter1] == 'P') {
    				
                    setPlayerPosition(counter1, counter2);

    			}
    		}
    	}
		
    }


    /**
     * Reads player's input from the console.
     * <p>
     * return : A string containing the input the player entered.
     */
    protected String getInputFromConsole() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
				
			try {
			
				command = reader.readLine().toUpperCase();
				 
			}  
			catch(IOException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}
    	return getNextAction(command);   
		
    }

    /**
     * Processes the command. It should return a reply in form of a String, as the protocol dictates.
     * Otherwise it should return the string "Invalid".
     *
     * @param command : Input entered by the user.
     * @return : Processed output or Invalid if the @param command is wrong.
     */
    protected String getNextAction(String command) {
        String output = "";

        switch(command) {
    	
			case "HELLO":  
                output = gameLogic.hello();
				break;
			case "MOVE N": 
                output = gameLogic.move('N'); 
				break;
			case "MOVE E": 
                output = gameLogic.move('E');
                break;
			case "MOVE S": 
                output = gameLogic.move('S');
                break;
			case "MOVE W": 
                output = gameLogic.move('W');
                break;
			case "PICKUP": 
                output = gameLogic.pickup();
                break;
			case "LOOK": 
                output = gameLogic.look();
                break;
			case "LOAD": 
				
				// Map map = new Map("example_map.txt");
				break;
				
			case "QUIT":                 
                gameLogic.quitGame();
			    break;                
			default: 
                output = "Invalid player input";
				break;
    	}  	
        return output;
    }

}