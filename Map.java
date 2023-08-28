import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Reads and contains in memory the map of the game.
 *
 */
public class Map {

	/* Representation of the map */
	private char[][] map;
	
	/* Map name */
	private String mapName;
	
	/* Gold required for the human player to win */
	private int goldRequired;
	private int goldCount = 0;
	private int exitCount = 0;
	
	/**
	 * Default constructor, creates the default map "Very small Labyrinth of doom".
	 */
	public Map() {
		mapName = "Very small Labyrinth of Doom";
		goldRequired = 2;
		map = new char[][]{
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','G','.','.','.','.','.','.','.','.','.','E','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','E','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','G','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
		};
	}
	
	/**
	 * Constructor that accepts a map to read in from a file
	 * TODO: check actual file type aswell as name.
	 *
	 * @param : The filename of the map file.
	 */
	public Map(String fileName) {
		if(!fileName.isEmpty()){
			if(fileName.endsWith(".txt")){
				readMap(fileName);
			}
			else{
				System.out.printf("\ninputed file name of \"%s\", is not the correct file type. \nPlease ensure the file inputters is a text file.", fileName);
				System.exit(1);
			}
		}
		else{
			System.out.printf("\ninputed file name of \"%s\", is empty. \nPlease ensure the name of a text file is inputted.", fileName);
			System.exit(1);
		}
	}

    /**
     * @return : Gold required to exit the current map.
     */
    protected int getGoldRequired() {
        return goldRequired;
    }

    /**
     * @return : The map as stored in memory.
     */
    protected char[][] getMap() {
        return map;
    }


    /**
     * @return : The name of the current map.
     */
    protected String getMapName() {
        return mapName;
    }

	 /**
     * @return : The length of the current map.
     */
	protected int getMapLength() {
    	return map[0].length;
    }
    
	 /**
     * @return : The width of the current map.
     */
    protected int getMapWidth() { 
    	return map.length;
    }

    /**
     * TODO: [X]Reads the map from file.
	 * Check if map is valid [X] format of file is correct - name, gold, map, 
	 * 							[X] name 	[X] gold		[X] map
	 * 						 [X] an array length of <= 2, 
	 * 						 [X] has atleast 1 gold and exit, 
	 * 						 [] Exit can find its way to all the gold + player
     * @param : Name of the map's file.
     */
    protected void readMap(String fileName) {
		int mapLength = 0;
		int mapWidth = 0;

		ArrayList<String> tempMapData = new ArrayList<String>();
		String[] goldLine;

		try {
			BufferedReader bf = new BufferedReader(new FileReader(fileName));
			String line = bf.readLine();

			while (line != null) {
				tempMapData.add(line);
				// System.out.println(line);
				// read next line
				line = bf.readLine();
			}

			bf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//map length - start from 2 to size -1
		//map width - start from 0 to length -1
		mapLength = tempMapData.size();
 		mapWidth = tempMapData.get(2).length();

		map = new char[mapLength-2][mapWidth];

		/*
		 * A set of for loops that:
		 * a) Loop through the size of the map array
		 * b) Loop through each line of the temp map
		 * c) Loop through each char in string
		*/

		for(int y = 2; y < mapLength; y++){
			for(int x = 0; x < mapWidth; x++){
				switch (tempMapData.get(y).charAt(x)) {
					case 'G':
						goldCount++;
						break;
				
					case 'E':
						exitCount++;
						break;
				}				
				map[y-2][x] = tempMapData.get(y).charAt(x);				
			}
		}

		mapName = tempMapData.get(0).replace("name ", "");

		goldLine = tempMapData.get(1).split("[\\p{Punct}\\s]+");
	 	goldRequired = ValidateGold(goldLine);

		validateMap(mapLength, tempMapData.get(1), fileName);		
		
		

		System.out.printf("\ntotal gold count : %d, total exit count id: %d",goldCount, exitCount);
		System.out.printf("\nmap name: %s, map gold required to exit: %d, map:",mapName, goldRequired);
		System.out.printf("\n %s \n\n",Arrays.deepToString(map).replace("],", "],\n"));
    }

	protected int ValidateGold(String[] line){
		int t=0;
		
		for (String item : line) {
			try{
				t = Integer.parseInt(item);
				if( t > goldCount){
					return -2;
				};	
				return t;			
			}
			catch (NumberFormatException e) {}
		}
		return -1;
	}

	protected void validateMap(int ml, String tmd, String fn){
		if(ml-2 <= 2){
			System.err.println("The map '" + mapName + "' is too small!");
			System.exit(1);
		}

		if(goldRequired == -1){
			System.err.println("Gold value '" + tmd + "' in line 2 of file '" + fn + "' is formatted incorrectly");
			System.exit(1);
		}
		else if(goldRequired == -2){
			System.err.println("Gold value '" + tmd + "' in line 2 of file '" + fn + "' is more than the gold available on the map");
			System.exit(1);
		}
		//TODO: for multiplayer, check that required gold = (x - 1) * amount of players - make a check for single player or multiplayer map
		
		if(exitCount == 0){
			System.err.println("Map: " + mapName + " does not have an exit!");
			System.exit(1);
		}
	}
	
	//TODO: do check to see if exit can get to all the gold.
	protected boolean pathPossible(){
		return true;
	}
}