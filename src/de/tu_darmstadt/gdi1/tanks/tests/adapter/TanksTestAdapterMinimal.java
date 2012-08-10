package de.tu_darmstadt.gdi1.tanks.tests.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.tu_darmstadt.gdi1.tanks.model.exceptions.SemanticException;
import de.tu_darmstadt.gdi1.tanks.model.exceptions.SyntaxException;
import de.tu_darmstadt.gdi1.tanks.ui.Tanks;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;
import eea.engine.test.TestAppGameContainer;

/**
 * This is the test adapter for the minimal stage of completion. You <b>must</b> implement the method stubs and match
 * them to your concrete implementation. Please read all the Javadoc of a method before implementing it. <br>
 * <strong>Important:</strong> this class should not contain any real game logic, you should rather only match the
 * method stubs to your game. <br>
 * Example: in {@link #isCorrectMap()} you may return the value <i>Tanks.isCorrectMap()</i>, if you have a variable
 * <i>Tanks</i> and a map has before been loaded via {@link #loadMapFromFile(File)}. What you mustn't do is to
 * implement the actual logic of the method in this class. <br>
 * <br>
 * If you have implemented the minimal stage of completion, you should be able to implement all method stubs. The public
 * and private JUnit tests for the minimal stage of completion will be run on this test adapter. The other test adapters
 * will inherit from this class, because they need the basic methods (like loading a map), too. <br>
 * <br>
 * The methods of all test adapters need to function without any kind of user interaction.</br>
 * 
 * <i>Note:</i> All other test adapters will inherit from this class.
 * 
 * @see TanksTestAdapterExtended1
 * @see TanksTestAdapterExtended2
 * @see TanksTestAdapterExtended3
 */
public class TanksTestAdapterMinimal {

	Tanks tanks; 						// erbt von StateBasedGame
	TestAppGameContainer app;			// spezielle Variante des AppGameContainer,
										// welche keine UI erzeugt (nur für Tests und nur bei Verwendung von eea!)
	boolean syntaxException;			// gibt es Syntax-Fehler
	boolean semanticException;			// gibt es Semantik-Fehler
	
	/**
	 * Verwenden Sie diesen Konstruktor zur Initialisierung von allem,
	 * was sie benoetigen
	 * 
	 * Use this constructor to set up everything you need.
	 */
	public TanksTestAdapterMinimal() {
		super();
		tanks = null;
		syntaxException = true;
		semanticException = true;
	}
	
	/* *************************************************** 
	 * ********* initialize, run, stop the game **********
	 * *************************************************** */
	
	public StateBasedGame getStateBasedGame() {
		return tanks;
	}
	
	/**
	 * Diese Methode initialisiert das Spiel im Debug-Modus, d.h. es wird
	 * ein AppGameContainer gestartet, der keine Fenster erzeugt und aktualisiert.
	 */
	public void initializeGame() {
		
		// Achtung, dieser Code kann nur bei Verwendung von eea genutzt werden, ansonsten
		// muessen Sie ihn leider loeschen
		
		// Setze den library Pfad abhaengig vom Betriebssystem
    	if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/lwjgl-2.8.3/native/windows");
		} 
		else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/lwjgl-2.8.3/native/macosx");
		}
		else {
			System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/lwjgl-2.8.3/native/" +System.getProperty("os.name").toLowerCase());
		}
    	// Initialisiere das Spiel Tanks im Debug-Modus (ohne UI)
		tanks = new Tanks(true);
		
		// Initialisiere die Map und starte das Spiel ohne UI
		try {
			//TODO
			app = new TestAppGameContainer(tanks);
			app.start(0);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Stoppe das im Hintergrund laufende Spiel
	 */
	public void stopGame() {
		if (app != null) {
			app.exit();
			app.destroy();
		}
		StateBasedEntityManager.getInstance().clearAllStates();
		tanks = null;
	}
	
	/**
	 * Run the game for a specified duration.
	 * Laesst das Spiel fuer eine angegebene Zeit laufen
	 * 
	 * @param ms duration of runtime of the game
	 */
	public void runGame(int ms) {
		if (tanks != null && app != null) {
			try {
				app.updateGame(ms);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* *************************************************** 
	 * *********************** Map ***********************
	 * *************************************************** */
	
	/**
	 * Loads a map from a file.
	 * Laed eine Karte von einen File, wirft dabei aber keine Exception
	 * @param file
	 */
	public void loadMapFromFile(File file) {
		//TODO
	}
	
	/**
	 * Lade eine Karte von einem File
	 * @param file
	 * @throws SyntaxException
	 * @throws SemanticException
	 */
	public void loadMapFromFileWithExceptions(File file) throws SyntaxException, SemanticException {
		//TODO
	}
	
	/**
	 * Gebe die aktuelle Karte als String zurueck (toString()-Methode)
	 * @return aktuelle Karte
	 */
	public String getStringRepresentationOfMap() {
		//TODO
		return null;
	}
	
	/**
	 * @return Ist die Karte semantisch und syntaktisch korrekt?
	 */
	public boolean isCorrectMap() {
		return !syntaxException && !semanticException;
	}
	
	/* *************************************************** 
	 * ******************** Tupel Map ********************
	 * *************************************************** */
	
	/**
	 * @return Dateiname der Hintergrunddatei ohne Anfuehrungszeichen mit Dateiendung
	 * des aktuellen Levels
	 */
	public String getMapBackgroundTexture() {
		//TODO
		return null;
	}
	
	/**
	 * @return Dateiname der aktuellen Karte ohne Anfuehrungszeichen und Dateiendung
	 */
	public String getMapName() {
		//TODO
		return null;
	}
	
	/**
	 * @return Dateiname der naechsten Karte ohne Anfuehrungszeichen und Dateiendung
	 */
	public String getMapNextMap() {
		
		//TODO
		
		return null;
	}
	
	/**
	 * @return Zeitlimit dieser Karte, wenn 0, dann ohne Zeitbegrenzung
	 */
	public int getMapMaxDuration() {
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Returns the elapsed time value parsed from the map file.
	 * You don't need to have the timer implemented yet. 
	 * Just return the the stored value you parsed from the map file.
	 * 
	 * Dies gibt die vergangene Zeit in ms zurueck, welche ueber die
	 * Karte eingelesen wurde. Sie muessen den Timer dafuer nicht implementiert haben,
	 * geben Sie dann den gespeicherten Wert aus der Kartendatei zurueck.
	 * 
	 * @return Vergangene Zeit in ms
	 */
	public int getMapElapsedTime() {
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @return Anzahl abgefeuerter Schuesse
	 */
	public int getMapFiredShots() {

		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * ******************* Tupel Tank ********************
	 * *************************************************** */
	
	/**
	 * @param position : Spielernummer
	 * @return Name des Spielers mit der uebergebenen Spielernummer
	 */
	public String getTankName(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return null;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Maximale Lebenspunkte des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankMaxLife(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Aktuelle Lebenspunkte des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankActualLife(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * ******************* Tupel Shot ********************
	 * *************************************************** */
	
	/**
	 * @param position : Spielernummer
	 * @return Maximale Schussanzahl des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankMaxShot(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Aktuelle Schussanzahl des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankActualShot(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * ******************* Tupel Mine ********************
	 * *************************************************** */
	
	/**
	 * @param position : Spielernummer
	 * @return Maximale Minenanzahl des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankMaxMine(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Aktuelle Minenanzahl des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankActualMine(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Staerke des Schusses des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankStrength(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Geschwindigkeit des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankSpeed(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Aktuelle Rotation in Grad des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankRotation(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Aktuelle Skalierung des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankScale(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Aktuelle X-Koordinate des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankXPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @param position : Spielernummer
	 * @return Aktuelle Y-Koordinate des Panzers mit der uebergebenen Spielernummer
	 */
	public int getTankYPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @return Anzahl an Panzern im laufenden Spiel
	 */
	public int getTankCount() {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * ****************** Tupel Border *******************
	 * *************************************************** */

	/**
	 * Border ist die Bezeichnung eine unbesiegbare Wand mit einem Mittelpunkt (x|y) und
	 * einer Hoehe und Breite
	 * @param Bordernummer
	 * @return Aktuelle x-Koordinate der Border mit der uebergebenen Bordernummer
	 */
	public int getBorderXPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Border ist die Bezeichnung eine unbesiegbare Wand mit einem Mittelpunkt (x|y) und
	 * einer Hoehe und Breite
	 * @param Bordernummer
	 * @return Aktuelle y-Koordinate der Border mit der uebergebenen Bordernummer
	 */
	public int getBorderYPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Border ist die Bezeichnung eine unbesiegbare Wand mit einem Mittelpunkt (x|y) und
	 * einer Hoehe und Breite
	 * @param Bordernummer
	 * @return Aktuelle Hoehe der Border mit der uebergebenen Bordernummer
	 */
	public int getBorderXSize(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Border ist die Bezeichnung eine unbesiegbare Wand mit einem Mittelpunkt (x|y) und
	 * einer Hoehe und Breite
	 * @param Bordernummer
	 * @return Aktuelle Breite der Border mit der uebergebenen Bordernummer
	 */
	public int getBorderYSize(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @return Anzahl an Borders im laufenden Spiel
	 */
	public int getBorderCount() {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * ******************* Tupel Wall ********************
	 * *************************************************** */

	/**
	 * Wall ist die Bezeichnung eine zerstoerbare Wand mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Wall-Nummer
	 * @return Maximale Lebenspunkte der Wall mit der uebergebenen Wall-Nummer
	 */
	public int getWallMaxLife(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Wall ist die Bezeichnung eine zerstoerbare Wand mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Wall-Nummer
	 * @return Aktuelle Lebenspunkte der Wall mit der uebergebenen Wall-Nummer
	 */
	public int getWallActualLife(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Wall ist die Bezeichnung eine zerstoerbare Wand mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Wall-Nummer
	 * @return Aktuelle Rotation in Grad der Wall mit der uebergebenen Wall-Nummer
	 */
	public int getWallRotation(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Wall ist die Bezeichnung eine zerstoerbare Wand mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Wall-Nummer
	 * @return Aktuelle Skalierung der Wall mit der uebergebenen Wall-Nummer
	 */
	public int getWallScale(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Wall ist die Bezeichnung eine zerstoerbare Wand mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Wall-Nummer
	 * @return Aktuelle x-Koordinate der Wall mit der uebergebenen Wall-Nummer
	 */
	public int getWallXPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Wall ist die Bezeichnung eine zerstoerbare Wand mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Wall-Nummer
	 * @return Aktuelle y-Koordinate der Wall mit der uebergebenen Wall-Nummer
	 */
	public int getWallYPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @return Anzahl an Walls im aktuellen Spiel
	 */
	public int getWallCount() {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * ******************** Tupel Shot ********************
	 * *************************************************** */
	
	/**
	 * Shot ist die Bezeichnung eine Schuss mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Schuss-Nummer
	 * @return Stärke des Schusses mit der uebergebenen Schuss-Nummer
	 */
	public int getShotStrength(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Shot ist die Bezeichnung eine Schuss mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Schuss-Nummer
	 * @return Aktuelle Rotation in Grad des Schusses mit der uebergebenen Schuss-Nummer
	 */
	public int getShotRotation(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Shot ist die Bezeichnung eine Schuss mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Schuss-Nummer
	 * @return Aktuelle Skalierung des Schusses mit der uebergebenen Schuss-Nummer
	 */
	public int getShotScale(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Shot ist die Bezeichnung eine Schuss mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Schuss-Nummer
	 * @return Aktuelle x-Koordinate des Schusses mit der uebergebenen Schuss-Nummer
	 */
	public int getShotXPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Shot ist die Bezeichnung eine Schuss mit einem Mittelpunkt (x|y) und
	 * einer definierten Skalierung
	 * @param Schuss-Nummer
	 * @return Aktuelle y-Koordinate des Schusses mit der uebergebenen Schuss-Nummer
	 */
	public int getShotYPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @return Anzahl an Schuessen im laufenden Spiel
	 */
	public int getShotCount() {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * **************** Tupel Explosion ******************
	 * *************************************************** */
	
	/**
	 * Explosion ist die Bezeichnung eine Explosion mit einem Mittelpunkt (x|y) und
	 * einer definierten Hoehe und Breite
	 * @param Explosion-Nummer
	 * @return Aktuelle Breite der Explosion mit der uebergebenen Explosion-Nummer
	 */
	public int getExplosionWidth(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Explosion ist die Bezeichnung eine Explosion mit einem Mittelpunkt (x|y) und
	 * einer definierten Hoehe und Breite
	 * @param Explosion-Nummer
	 * @return Aktuelle Hoehe der Explosion mit der uebergebenen Explosion-Nummer
	 */	
	public int getExplosionHeight(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Explosion ist die Bezeichnung eine Explosion mit einem Mittelpunkt (x|y) und
	 * einer definierten Hoehe und Breite und einer Explosionsgeschwindigkeit
	 * @param Explosion-Nummer
	 * @return Geschwindigkeit der Explosion mit der uebergebenen Explosion-Nummer
	 */
	public int getExplosionSpeed(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Explosion ist die Bezeichnung eine Explosion mit einem Mittelpunkt (x|y) und
	 * einer definierten Hoehe und Breite und einer Explosionsgeschwindigkeit
	 * @param Explosion-Nummer
	 * @return Aktuelle x-Koordinate der Explosion mit der uebergebenen Explosion-Nummer
	 */
	public int getExplosionXPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * Explosion ist die Bezeichnung eine Explosion mit einem Mittelpunkt (x|y) und
	 * einer definierten Hoehe und Breite und einer Explosionsgeschwindigkeit
	 * @param Explosion-Nummer
	 * @return Aktuelle y-Koordinate der Explosion mit der uebergebenen Explosion-Nummer
	 */
	public int getExplosionYPosition(int position) {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/**
	 * @return Anzahl an Explosionen im laufenden Spiel
	 */
	public int getExplosionCount() {
		
		List<Entity> entities = new ArrayList<Entity>();
		
		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);
		
		//TODO
		
		return -1;
	}
	
	/* *************************************************** 
	 * ********************** Input **********************
	 * *************************************************** */
	
	/**
	 * This Method should emulate the key down event.
	 * This should make the playertank shoot.
	 * 
	 * Diese Methode emuliert das Druecken beliebiger Tasten.
	 * (Dies soll es ermoeglichen, das Schiessen des Spielerpanzers
	 * zu testen)
	 * 
	 * @param updatetime : Zeitdauer bis update-Aufruf
	 * @param input : z.B. Input.KEY_K, Input.KEY_L
	 */
	public void handleKeyDown(int updatetime, Integer input) {
		
		// Dieser Code kann nur bei Verwendung von eea uebernommen werden
		// ansonsten muessen Sie ihn leider loeschen und ersetzen
		
		if (tanks != null && app != null) {
			app.getTestInput().setKeyDown(input);
			try {
				app.updateGame(updatetime);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This Method should emulate the key pressed event.
	 * This should make the playertank shoot.
	 * 
	 * Diese Methode emuliert das Druecken beliebiger Tasten.
	 * (Dies soll es ermoeglichen, das Schiessen des Spielerpanzers
	 * zu testen)
	 * 
	 * @param updatetime : Zeitdauer bis update-Aufruf
	 * @param input : z.B. Input.KEY_K, Input.KEY_L
	 */
	public void handleKeyPressed(int updatetime, Integer input) {
		
		// Dieser Code kann nur bei Verwendung von eea uebernommen werden
				// ansonsten muessen Sie ihn leider loeschen und ersetzen
		
		if (tanks != null && app != null) {
			app.getTestInput().setKeyPressed(input);
			try {
				app.updateGame(updatetime);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This Method should emulate the pressing of the up arrow key.
	 * (This should make the playertank drive forward.)
	 * 
	 * Diese Methode emuliert das Druecken der 'nach oben'-Taste.
	 * (Dies soll es ermoeglichen, waehrend der Tests Gegenstaende wie
	 * den Panzer zu bewegen)
	 */
	public void handleKeyDownUpArrow() {
		handleKeyDown(1000, Input.KEY_UP);
	}
	
	/**
	 * This Method should emulate the pressing of the down arrow key.
	 * This should make the playertank drive backward.
	 * 
	 * Diese Methode emuliert das Druecken der 'nach unten'-Taste.
	 * (Dies soll es ermoeglichen, waehrend der Tests Gegenstaende wie
	 * den Panzer zu bewegen, in diesem Fall eine Rueckwaertsbewegung)
	 */
	public void handleKeyDownDownArrow() {
		handleKeyDown(1000, Input.KEY_DOWN);
	}
	
	/**
	 * This Method should emulate the pressing of the right arrow key.
	 * This should make the playertank turn clockwise.
	 * 
	 * Diese Methode emuliert das Druecken der 'nach rechts'-Taste.
	 * (Dies soll es ermoeglichen, waehrend der Tests Gegenstaende wie
	 * den Panzer zu bewegen, hier eine Drehung nach rechts)
	 */
	public void handleKeyDownRightArrow() {
		handleKeyDown(1000, Input.KEY_RIGHT);
	}
	
	/**
	 * This Method should emulate the pressing of the left arrow key.
	 * This should make the playertank turn counter clockwise.
	 * 
	 * Diese Methode emuliert das Druecken der 'nach links'-Taste.
	 * (Dies soll es ermoeglichen, waehrend der Tests Gegenstaende wie
	 * den Panzer zu bewegen, hier eine Drehung nach links)
	 */
	public void handleKeyDownLeftArrow() {
		handleKeyDown(1000, Input.KEY_LEFT);
	}
	
	/**
	 * This Method should emulate the pressing of the k key.
	 * This should make the playertank shoot.
	 * 
	 * Diese Methode emuliert das Druecken der 'k'-Taste.
	 * (Dies soll es ermoeglichen, das Schiessen des Spielerpanzers
	 * zu testen)
	 */
	public void handleKeyPressK() {
		handleKeyPressed(0, Input.KEY_K);
	}
	
	/**
	 * This Method should emulate the pressing of the n key.
	 * This should start a new game.
	 * 
	 * Diese Methode emuliert das Druecken der 'k'-Taste.
	 * (Dies soll es ermoeglichen, das Spiel neu zu starten)
	 */
	public void handleKeyPressN() {
		handleKeyPressed(0, Input.KEY_N);
	}
}
