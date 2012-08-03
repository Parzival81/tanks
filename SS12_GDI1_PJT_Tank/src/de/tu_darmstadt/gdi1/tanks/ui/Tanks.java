package de.tu_darmstadt.gdi1.tanks.ui;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Tanks extends StateBasedGame {
 
	// Jeder State wird durch einen Integer-Wert gekennzeichnet
    public static final int MAINMENUSTATE		= 0;
    public static final int GAMEPLAYSTATE		= 2;
    //TODO Weitere Konstanten, die einen State identifizieren, einfuegen
    
    // Fuer die automatisierten Tests muessen Sie sicher stellen, dass ihr
    // Spiel auch ohne UI starten kann. Ist debug auf true gesetzt, so soll
    // das geschehen. Nutzen Sie diese Variable zur Abfrage in den anderen
    // Klassen, wenn Sie moechten.
    public static boolean debug = false;
    public static void setDebug(boolean debuging){ debug = debuging; }
 
    /**
     * Konstruktor des Spiel Tanks.
     * @param debug : falls true, dann soll Tanks ohne UI gestartet werden
     */
    public Tanks(boolean debug)
    {
        super("Tanks");
        setDebug(debug);
    }    
 
    public static void main(String[] args) throws SlickException
    {
    	// Setze den library Pfad abhaengig vom Betriebssystem
    	// hier bitte keine Aenderungen vornehmen, da es sonst zu Fehlern in Ihrem Spiel kommt
    	if(System.getProperty("os.name").toLowerCase().contains("windows")) {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/lwjgl-2.8.3/native/windows");
    	} 
    	else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/lwjgl-2.8.3/native/macosx");
    	}
    	else {
    		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/lwjgl-2.8.3/native/" +System.getProperty("os.name").toLowerCase());
    	}
    	
    	// Setze dieses StateBasedGame in einen App Container (= Spielfenster)
        AppGameContainer app = new AppGameContainer(new Tanks(false));
 
        // Lege die Einstellungen des Fensters fest und starte das Fenster
        app.setShowFPS(false); // ohne Anzeige der FPS-Rate
        
        // Fuehren Sie hier (falls noetig), weitere Initialisierungen ein
        //TODO Initialisierungen
        
        // Starte das Spiel Tanks
        app.start();
    }
 
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
 
        // Fuege dem StateBasedGame die State's hinzu
    	// TODO State's hinzu fuegen, z.B. this.addState(new MainMenuState(MAINMENUSTATE));
        
        // Fuege dem StateBasedEntityManager die State's hinzu
    	// TODO State's hinzu fuegen, z.B. StateBasedEntityManager.getInstance().addState(MAINMENUSTATE);
    }
}