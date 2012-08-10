package de.tu_darmstadt.gdi1.tanks.tests.adapter;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Input;

import de.tu_darmstadt.gdi1.tanks.ui.Tanks;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;

public class TanksTestAdapterExtended2 extends TanksTestAdapterExtended1 {

	/**
	 * Use this constructor to set up everything you need.
	 */
	public TanksTestAdapterExtended2() {
		super();
	}
	
	/* *************************************************** 
	 * **************** Tupel Scattershot ****************
	 * *************************************************** */

	/**
	 * Scattershot ist die Bezeichnung einen Streuschuss mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Streuschuesse muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Der erste Streuschuss ist an der Position 0. 
	 * 
	 * @param position : Streuschuss-Nummer
	 * @return Zeit des Streuschusses mit der uebergebenen Streuschuss-Nummer,
	 * nachdem sich der Schuss in mehrere aufteilt
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getScattershotTime(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Scattershot ist die Bezeichnung einen Streuschuss mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Streuschuesse muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Der erste Streuschuss ist an der Position 0. 
	 * 
	 * @param position : Streuschuss-Nummer
	 * @return Staerke des Streuschusses mit der uebergebenen Streuschuss-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getScattershotStrength(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Scattershot ist die Bezeichnung einen Streuschuss mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Streuschuesse muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Der erste Streuschuss ist an der Position 0. 
	 * 
	 * @param position : Streuschuss-Nummer
	 * @return Rotation in Grad des Streuschusses mit der uebergebenen Streuschuss-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getScattershotRotation(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Scattershot ist die Bezeichnung einen Streuschuss mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Streuschuesse muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Der erste Streuschuss ist an der Position 0. 
	 * 
	 * @param position : Streuschuss-Nummer
	 * @return Skalierung des Streuschusses mit der uebergebenen Streuschuss-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getScattershotScale(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Scattershot ist die Bezeichnung einen Streuschuss mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Streuschuesse muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Der erste Streuschuss ist an der Position 0. 
	 * 
	 * @param position : Streuschuss-Nummer
	 * @return Aktuelle x-Koordinate des Streuschusses mit der uebergebenen Streuschuss-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getScattershotXPosition(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Scattershot ist die Bezeichnung einen Streuschuss mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Streuschuesse muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Der erste Streuschuss ist an der Position 0. 
	 * 
	 * @param position : Streuschuss-Nummer
	 * @return Aktuelle y-Koordinate des Streuschusses mit der uebergebenen Streuschuss-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getScattershotYPosition(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}

	/**
	 * @return Anzahl der aktuell sich im Spiel befindenden Streuschuesse
	 */
	public int getScattershotCount() {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/* *************************************************** 
	 * ******************* Tupel Tower *******************
	 * *************************************************** */
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Aktuelle x-Koordinate des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerMaximumLife(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Aktuelle Lebenspunkte des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerActualLife(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Maximale Anzahl an Schuessen des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerMaximumShotAmmo(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Aktuelle Anzahl an Schuessen des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerActualShotAmmo(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Staerke eines Schuesses des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerStrength(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Geschwindigkeit, mit der Schueese des Abwehrgeschuetzes 
	 * mit der uebergebenen Geschuetz-Nummer abgefeuert werden,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerSpeed(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Aktuelle Rotation in Grad des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerRotation(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Aktuelle Skalierung des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerScale(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}

	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Aktuelle x-Position des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerXPosition(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}

	/**
	 * Tower ist die Bezeichnung ein Abwehrgeschuetz mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Abwehrgeschuetze muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Abwehrgeschuetz hat die Geschuetz-Nummer 0. 
	 * 
	 * @param position : Geschuetz-Nummer
	 * @return Aktuelle y-Position des Abwehrgeschuetzes mit der uebergebenen Geschuetz-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getTowerYPosition(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}

	/**
	 * @return Anzahl sich im Spiel befindender Abwehrgeschuetze
	 */
	public int getTowerCount() {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/* *************************************************** 
	 * ****************** Tupel Pickup *******************
	 * *************************************************** */
	
	/**
	 * Pickup ist die Bezeichnung ein Gesundheits- oder Munitionspack mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Pickups muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Pickup hat die Pickup-Nummer 0. 
	 * 
	 * @param position : Pickup-Nummer
	 * @return Typ des Pickups mit der uebergebenen Pickup-Nummer,
	 * es gibt Gesundheits- und Munitions-Packs;
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public String getPickupType(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return null;
	}
	
	/**
	 * Pickup ist die Bezeichnung ein Lebens- oder Munitionspack mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Pickups muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Pickup hat die Pickup-Nummer 0. 
	 * 
	 * @param position : Pickup-Nummer
	 * @return Staerke des Pickups mit der uebergebenen Pickup-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getPickupStrength(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Pickup ist die Bezeichnung ein Lebens- oder Munitionspack mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Pickups muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Pickup hat die Pickup-Nummer 0. 
	 * 
	 * @param position : Pickup-Nummer
	 * @return Aktuelle Rotation in Grad des Pickups mit der uebergebenen Pickup-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getPickupRotation(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Pickup ist die Bezeichnung ein Lebens- oder Munitionspack mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Pickups muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Pickup hat die Pickup-Nummer 0. 
	 * 
	 * @param position : Pickup-Nummer
	 * @return Aktuelle Skalierung des Pickups mit der uebergebenen Pickup-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getPickupScale(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Pickup ist die Bezeichnung ein Lebens- oder Munitionspack mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Pickups muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Pickup hat die Pickup-Nummer 0. 
	 * 
	 * @param position : Pickup-Nummer
	 * @return Aktuelle x-Position des Pickups mit der uebergebenen Pickup-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getPickupXPosition(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Pickup ist die Bezeichnung ein Lebens- oder Munitionspack mit einem Mittelpunkt (x|y) und
	 * einer Skalierung. Pickups muessen in der gleichen Reihenfolge gespeichert werden,
	 * wie in der eingelesen Karte gespeichert. Das erste Pickup hat die Pickup-Nummer 0. 
	 * 
	 * @param position : Pickup-Nummer
	 * @return Aktuelle y-Position des Pickups mit der uebergebenen Pickup-Nummer,
	 * wenn die Nummer ungegueltig ist, dann wird -1 zurueckgegeben.
	 */
	public int getPickupYPosition(int position) {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}

	/**
	 * @return Anzahl der sich aktuell im Spiel befindenden Pickups
	 */
	public int getPickupCount() {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * @return Gibt das Zeitlimit dieser Karte zurueck,
	 * angegeben in dem Tupel Map in der Kartendatei.
	 */
	
	/**
	 * Returns the time limit of the map.
	 * This value is specified in the map file.
	 * @return
	 */
	public int getTimeLimit() {
		if (tanks == null) return -1;
		return -1; //TODO
	}
	
	/**
	 * Returns the maximum amount of shots the player starts with.
	 * This value is specified in the map file.
	 * @return
	 */
	public int getLimitedAmmoAmount() {
		
		// Code kann nur bei Verwendung von eea verwendet werden, sonst muss er geloescht werden!
		// Auch bei Verwendung von eea muss diese Methode erweitert werden.

		List<Entity> entities = new ArrayList<Entity>();

		entities = StateBasedEntityManager.getInstance().getEntitiesByState(Tanks.GAMEPLAYSTATE);

		//TODO

		return -1;
	}
	
	/**
	 * Return the actual amount of shot the player currently has.
	 * This value should change when the player shoots.
	 * This value is specified in the map file. 
	 * @return
	 */
	public int getAmmoLeft() {
		
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
	 * This Method should emulate the pressing of the l key.
	 * This should fire a scattershot.
	 */
	public void handleKeyPressL() {
		handleKeyPressed(0, Input.KEY_L);
	}
	
}
