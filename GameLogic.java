import java.util.Arrays;

/**
 * Contains the main logic part of the game, as it processes.
 *
 */
public class GameLogic {
	
	protected Map map;
    protected HumanPlayer hp;

    private char specialIcon;
    private char temp;
    private boolean isRunning = true;
    private int playerX = 0 ;
	private int playerY = 0;
    private int[] nextIcon = new int[2]; 
   	
	/**
	 * Default constructor
	 */
	public GameLogic() {
        map = new Map();
        hp = new HumanPlayer(this);
        hp.playerPosition();
	}

    /**
     * @return if the game is running.
     */
    protected boolean gameRunning() {
        return isRunning;
    }

    /**
     * @return : Returns back gold player requires to exit the Dungeon.
     */
    protected String hello() {
        return "Total Gold needed to win: " + map.getGoldRequired();
    }

    /**
     * Checks if movement is legal and updates player's location on the map.
     *
     * @param direction : The direction of the movement.
     * @return : Protocol if success or not.
     */
    protected String move(char direction) {
        int playerPos = 0;
        playerX = hp.getPlayerPosition()[0];
        playerY = hp.getPlayerPosition()[1];
        
        /*This section of code sets the variable player position to be the x or y co-ordinate 
    	 * that the player wants to move to
    	 */
    	switch(direction) {
    	
			case 'N':
                playerPos = playerY - 1;
                break;
			case 'E':
				playerPos = playerX + 1;
				break;
			case 'S':
				playerPos = playerY + 1;
				break;
			case 'W':
				playerPos = playerX - 1;
				break;
				
    	}

        if(direction == 'N' || direction == 'S') {	
			//if the position you want to move to is # (a wall, dont allow it)
			if(map.getMap()[playerPos][playerX]  == '#' ) {
			   return "FAIL";
			}

			//get the icon in the next position and store it in specialIcon
			nextIcon[0]= playerPos;
			nextIcon[1]= playerX;
			specialIcon = map.getMap()[nextIcon[0]][nextIcon[1]];

			//if temp is a special icon place it in the last position that it was in after player walks over
			if(temp == 'G'){
				map.getMap()[playerY][playerX] = 'G';
			}
			else if(temp == 'E'){
				map.getMap()[playerY][playerX] = 'E';
			}
			else{
				map.getMap()[playerY][playerX] = '.';
			}
			temp = ' ';

			//set temp if special icon is present			
			if(specialIcon == 'G'){
				temp = 'G';
			}
			else if(specialIcon == 'E'){
				if(hp.getPlayerGold() == map.getGoldRequired()) {
						System.out.println("Congratulations, you have escaped with all the gold!");
						quitGame();
				}
				else{
					temp = 'E';
				}
			}			
		
			//move player to new position
            map.getMap()[playerPos][playerX] = 'P';
            hp.setPlayerPosition(playerX, playerPos); 
		}
        else if(direction == 'E' || direction == 'W') {	
			//if the position you want to move to is # (a wall, dont allow it)
			if(map.getMap()[playerY][playerPos]  == '#' ) {
			   return "FAIL";
			}

			//get the icon in the next position and store it in specialIcon
			nextIcon[0]= playerY;
			nextIcon[1]= playerPos;
			specialIcon = map.getMap()[nextIcon[0]][nextIcon[1]];

			//if temp is a special icon place it in the last position that it was in after player walks over
			if(temp == 'G'){
				map.getMap()[playerY][playerX] = 'G';
			}
			else if(temp == 'E'){
				map.getMap()[playerY][playerX] = 'E';
			}
			else{
				map.getMap()[playerY][playerX] = '.';
			}
			temp = ' ';

			//set temp if special icon is present			
			if(specialIcon == 'G'){
				temp = 'G';
			}
			else if(specialIcon == 'E'){
				if(hp.getPlayerGold() == map.getGoldRequired()) {
						System.out.println("Congratulations, you have escaped with all the gold!");
						quitGame();
				}
				else{
					temp = 'E';
				}
			}			
		
			//move player to new position
            map.getMap()[playerY][playerPos] = 'P';
            hp.setPlayerPosition(playerPos, playerY); 
		}
        return "SUCCESS";
    }

    /**
     * Converts the map from a 2D char array to a single string.
     *
     * @return : A String representation of the game map.
     */
    protected String look() {
        int mapWidth = map.getMapWidth();
    	int mapLength = map.getMapLength();
    	
        playerX = hp.getPlayerPosition()[0];
        playerY = hp.getPlayerPosition()[1];

        /**
         * This section of code uses the players x and y co-ordinates, takes awy 2 from the x and y aswell
    	 * as add 2 and uses this range to print a 5x5 grid for the user to see. the first loop cycles through which array
         * and the second loop cycle through items in the chosen array - y, then x
    	 */
    		for(int viewx = playerY - 2; viewx <= playerY + 2; viewx++) { // Y
    					    					    				
    			for(int viewy = playerX -2; viewy <= playerX + 2; viewy++) {//X
    				if(viewy < 0 || viewy > mapLength - 1 || viewx < 0 || viewx > mapWidth - 1) {
    							    							
        				System.out.print("#");
    				}
        			else {
    				System.out.print(map.getMap()[viewx][viewy]);
        			}
    			}
                System.out.println("");
    		}
    		
        return "";
    }

    /**
     * Processes the player's pickup command, updating the map and the player's gold amount.
     * it does this by checking if the temp variable contains the special icon G. If it does the user is able to pick up the gold.
     * If temp is empty then return Failed.
     * 
     * @return If the player successfully picked-up gold or not.
     */
    protected String pickup() {
        if(temp == 'G'){
			temp = ' ';
            hp.setPlayerGold(); 
    		System.out.println("SUCCESS. Gold owned: " );
		}
		else{
			System.out.println("FAILED. Gold owned: " );
		}
		return String.valueOf(hp.getPlayerGold());
    }

    /**
     * Quits the game, shutting down the application by setting the isRunning variable to false.
     */
    protected void quitGame() {
        isRunning = false;
    }
	
}