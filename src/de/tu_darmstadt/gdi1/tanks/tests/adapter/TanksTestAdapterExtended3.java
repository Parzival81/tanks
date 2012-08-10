package de.tu_darmstadt.gdi1.tanks.tests.adapter;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Input;

import de.tu_darmstadt.gdi1.tanks.ui.Tanks;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;

public class TanksTestAdapterExtended3 extends TanksTestAdapterExtended2 {

	/**
	 * Use this constructor to set up everything you need.
	 */
	public TanksTestAdapterExtended3() {
		super();
	}
	
	/* *************************************************** 
	 * ************ Panzer des zweiten Spielers **********
	 * *************************************************** */
	
	/**
	 * @return Name des zweiten Spielerpanzers
	 */
	public String getSecondPlayerTankName() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return "Horst";
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle Lebenspunkte des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankMaxLife() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle Lebenspunkte des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankActualLife() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Maximale Anzahl an Schuessen des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankMaxShot() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle Anzahl an Schuessen des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankActualShot() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Maximal moegliche Anzahl an Minen des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankMaxMine() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle Anzahl an Minen des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankActualMine() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Staerke des vom zweiten menschlichen Panzers gefeuerten Schusses
	 */
	public int getSecondPlayerTankStrength() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Geschwindigkeit des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankSpeed() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle Rotation des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankRotation() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle Skalierung des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankScale() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle x-Position des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankXPosition() {
		
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tank ist die Bezeichnung einen Panzer mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Panzer muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. 
	 * 
	 * @return Aktuelle y-Position des zweiten menschlichen Panzers
	 */
	public int getSecondPlayerTankYPosition() {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/* *************************************************** 
	 * ********************** Input **********************
	 * *************************************************** */
		
	/**
	 * This Method should emulate the pressing of various keys.
	 * This should make the playertank shoot.
	 * 
	 * Diese Methode emuliert das Druecken beliebiger Tasten.
	 * (Dies soll es ermoeglichen, das Schiessen des Spielerpanzers
	 * zu testen)
	 * 
	 * @param updatetime : Zeitdauer bis update-Aufruf
	 * @param input : z.B. Input.KEY_K, Input.KEY_L
	 */
	public void handleKeyDownW() {
		handleKeyDown(1000, Input.KEY_W);
	}
	
	/**
	 * This Method should emulate the pressing of the a key.
	 * This should make the second player tank turn counter clockwise.
	 */
	public void handleKeyDownA() {
		handleKeyDown(1000, Input.KEY_A);
	}
	
	/**
	 * This Method should emulate the pressing of the s key.
	 * This should move the second player tank backward.
	 */
	public void handleKeyDownS() {
		handleKeyDown(1000, Input.KEY_S);
	}
	
	/**
	 * This Method should emulate the pressing of the d key.
	 * This should make the second player tank turn clockwise.
	 */
	public void handleKeyDownD() {
		handleKeyDown(1000, Input.KEY_D);
	}
	
	/**
	 * This Method should emulate the pressing of the g key.
	 * This should make the second player tank fire.
	 */
	public void handleKeyPressG() {
		handleKeyPressed(0, Input.KEY_G);
	}
	
	/**
	 * This Method should emulate the pressing of the h key.
	 * This should make the second player tank fire a scattershot.
	 */
	public void handleKeyPressH() {
		handleKeyPressed(0, Input.KEY_H);
	}
	
	/**
	 * This Method should emulate the pressing of the f key.
	 * This should make the second player tank plant a mine.
	 */
	public void handleKeyPressF() {
		handleKeyPressed(0, Input.KEY_F);
	}
}
