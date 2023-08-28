// import java.util.Arrays;

public class DoD {
    public static void main(String[] args) {
		GameLogic gl = new GameLogic();
		
		System.out.println("Welcome to dugeons of doom! The following commands are available to you:");
		System.out.println("LOOK, HELLO, PICKUP, MOVE N, MOVE E, MOVE S, MOVE W, LOAD, and QUIT");
		System.out.printf("\nCurrently the default map \"%s\" is loaded.\n", gl.map.getMapName());

		
		while(gl.gameRunning()) {
			System.out.print(gl.hp.getInputFromConsole() + "\n\n");
		}
		
		try {

			gl.hp.reader.close();
		} 
		catch (Exception e) {}
		
    }
}
