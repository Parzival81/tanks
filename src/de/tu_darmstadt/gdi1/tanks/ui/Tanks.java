package de.tu_darmstadt.gdi1.tanks.ui;

import de.tu_darmstadt.gdi1.tanks.states.About;
import de.tu_darmstadt.gdi1.tanks.states.Configuration;
import de.tu_darmstadt.gdi1.tanks.states.Control;
import de.tu_darmstadt.gdi1.tanks.states.Game;
import de.tu_darmstadt.gdi1.tanks.states.Highscore;
import de.tu_darmstadt.gdi1.tanks.states.MainMenu;
import eea.engine.entity.StateBasedEntityManager;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Main tanks class
 *
 * @author patrick
 */
public class Tanks extends StateBasedGame {

    /* --- Game states --- */
    public static final int MENU = 0;
    public static final int GAME = 1;
    public static final int CONTROL = 2;
    public static final int HIGHSCORE = 3;
    public static final int ABOUT = 4;
    public static final int CONFIG = 5;
    public static boolean debug = false;

    public static void setDebug(boolean debuging) {
        debug = debuging;
    }
    
    public Tanks(boolean debug) {
        /* ---- Set the name of the game ---- */
        super("Tanks ~beyond infinity~");
        setDebug(debug);
    }

    public static void main(String[] args) throws SlickException {
        /* ---- Set the library path dependant on the OS type ---- */
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/windows");
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/macosx");
        } else {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/native/" + System.getProperty("os.name").toLowerCase());
        }

        /* ---- Set StateBasedGame in an App Container ---- */
        AppGameContainer app = new AppGameContainer(new Tanks(false));

        /* ---- Do not show FPS ---- */
        app.setShowFPS(false);

        /* ---- Set the game window ---- */
        AppGameContainer window = new AppGameContainer(new Tanks(false));
        /* ---- Set window size (x, y, fullscreen) --- */
        window.setDisplayMode(800, 600, false);
        window.start();
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

        /* ---- Initialize the states ---- */
        addState(new MainMenu(MENU));
        addState(new Game(GAME));
        addState(new Control(CONTROL));
        addState(new Highscore(HIGHSCORE));
        addState(new About(ABOUT));
        addState(new Configuration(CONFIG));

        /* --- Add the states ---- */
        StateBasedEntityManager.getInstance().addState(MENU);
        StateBasedEntityManager.getInstance().addState(GAME);
        StateBasedEntityManager.getInstance().addState(CONTROL);
        StateBasedEntityManager.getInstance().addState(HIGHSCORE);
        StateBasedEntityManager.getInstance().addState(ABOUT);
        StateBasedEntityManager.getInstance().addState(CONFIG);
    }
}