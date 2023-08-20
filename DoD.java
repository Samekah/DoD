public class DoD {
    public static void main(String[] args) {
		GameLogic gl = new GameLogic();
				
		//playerStartPosition(); doesn't work :(
		
		System.out.println("Welcome to dugeons of doom! The following commands are available to you:");
		System.out.println("LOOK, HELLO, PICKUP, QUIT, MOVE N, MOVE E, MOVE S, MOVE W");
		
		while(gl.gameRunning()) {
			System.out.print(gl.hp.getInputFromConsole() + "\n");
		}
		
		try {

			gl.hp.reader.close();
		} 
		catch (Exception e) {}
		
    }
}
