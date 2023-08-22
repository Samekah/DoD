import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * Runs the game with a human player and contains code needed to read inputs.
 *
 */
public class HumanPlayer {
    
    private GameLogic gameLogic;
    private char[][] loadedMap;
    private int playerGold;
    private int[] playerPosition;
    BufferedReader reader;

    /**
     * A constructor that sets up the variables needed for the human player 
     * @param gl : Passes the cureent instance of the GameLogic class
     */
    public HumanPlayer(GameLogic gl){
        gameLogic = gl;
        loadedMap = gl.map.getMap();
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
    public int[] getPlayerCoord(){
        return playerPosition;
    }

    /**
    * Sets the players position
    * @return
    */
    public void setPlayerCoord(int x, int y){
        playerPosition[0] = x;      //x co-ordinate
        playerPosition[1] = y;      //y co-ordinate	
    }

    /**
    * Adds Player icon to a random position on the map and makes sure it is not surrounded by walls
	*/
    protected void randomPlayerPosition(){
        
        Random r = new Random();
        int randomY = r.nextInt(gameLogic.map.getMapWidth()-2) + 1;
        int randomX = r.nextInt(gameLogic.map.getMapLength()-2) + 1;
        char icon = loadedMap[randomY][randomX];

        if(icon == '#' || icon == 'G' || icon =='E'){
            randomPlayerPosition();
        }
        else{
            if(loadedMap[randomY-1][randomX] == '#' && loadedMap[randomY+1][randomX] == '#' 
            && loadedMap[randomY][randomX-1] == '#' && loadedMap[randomY][randomX+1] == '#'){
                randomPlayerPosition();
            }
            else{
                loadedMap[randomY][randomX] = 'P';
                setPlayerCoord(randomX, randomY);
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