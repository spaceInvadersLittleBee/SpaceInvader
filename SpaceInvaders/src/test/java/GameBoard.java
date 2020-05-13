import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameBoard {
	//singletons
	private static GameBoard gameBoard;
	private static Player player;
	private static View view;
	
	//getters
	public static GameBoard getGameBoard() {
		return gameBoard;
	}
	public static Player getPlayer() {
		return player;
	}
	
	//called once when starting the game
	public static void initializeGame() {
		gameBoard = new GameBoard();
		view = new View();
		player = new Player(450,400,150,150,5,100);
		view.windowSetup();
		Timer timer = new Timer(17,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
        timer.start();
	}
	//end of initializeGame()
	
	
	
	//update is called once per frame
    public static void update(){
        player.moveDir(view.getXAxis(), 0);
        
        view.repaint();
    }//end of update

}
