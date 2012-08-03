package TankMain;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.entity.StateBasedEntityManager;


public class Launch extends StateBasedGame{
	public static final int MENU = 0;
	public static final int GAME = 1;
	
	public Launch() {
		super("TANKS");
	}
	
	public static void main (String[] args) throws SlickException{
    	if (System.getProperty("os.name").toLowerCase().contains("windows")) {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/native/windows");
	} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/native/macosx");
    	} else {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/native/" +System.getProperty("os.name").toLowerCase());
    	}
		
		
		AppGameContainer window = new AppGameContainer(new Launch()); 
		window.setDisplayMode(800, 600, false);
		window.start();
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MainMenu(MENU));
		addState (new Game(GAME));
        StateBasedEntityManager.getInstance().addState(MENU);
        StateBasedEntityManager.getInstance().addState(GAME);
	}
}
