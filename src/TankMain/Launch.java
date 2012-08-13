package TankMain;

import eea.engine.entity.StateBasedEntityManager;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Launch extends StateBasedGame {

    // Game states (menu and game)
    public static final int MENU = 0;
    public static final int GAME = 1;
    public static final int CONTROL = 2;

    public Launch() {
        // Set the name of the game
        super("Tanks ~beyond infinity~");
    }

    public static void main(String[] args) throws SlickException {
        // Set the library path dependant on the OS type
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/windows");
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/macosx");
        } else {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/" + System.getProperty("os.name").toLowerCase());
        }

        // Set the game window
        AppGameContainer window = new AppGameContainer(new Launch());
        // Set window size (x, y, fullscreen)
        window.setDisplayMode(800, 600, false);
        window.start();
    }

    @Override
    public void initStatesList(GameContainer arg0) throws SlickException {
        // Add the states (menu and game) to the StateBasedGame
        // The two states are set in there own classes (MainMenu and Game)
        // The first state is run first (so menu has to come first)
        addState(new MainMenu(MENU));
        addState(new Game(GAME));
        addState (new Control(CONTROL));

        // Add the states
        StateBasedEntityManager.getInstance().addState(MENU);
        StateBasedEntityManager.getInstance().addState(GAME);
        StateBasedEntityManager.getInstance().addState(CONTROL);
    }
}
