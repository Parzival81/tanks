package de.tu_darmstadt.gdi1.tanks.level;

import de.tu_darmstadt.gdi1.tanks.entity.Border;
import de.tu_darmstadt.gdi1.tanks.entity.Map;
import de.tu_darmstadt.gdi1.tanks.entity.Tank;
import de.tu_darmstadt.gdi1.tanks.entity.Wall;
import de.tu_darmstadt.gdi1.tanks.entity.Mine;

/**
 * Represents the game level with all its entities, like tanks, walls, etc.
 * 
 * @version 1.0
 */
public class Level {
	private Map gameMap;
	private Border[] gameBorder;
	private Tank gameTankP; // Spieler
	private Tank[] gameTankO; // Gegner
	private Wall[] gameWall;
        private Mine[] gameMine;
 	
        /**
         * Constructor. Add all elements to the level
         * 
         * @param m     The levels map
         * @param b     The levels boarders (as array)
         * @param p     The levels player tank
         * @param o     The levels opponent tank (as array)
         * @param w     The levels walls (as array)
         */
	public Level(Map m, Border[] b, Tank p, Tank[] o, Wall[] w, Mine[] mine) {
		this.gameBorder = b;
		this.gameMap = m;
		this.gameTankO = o;
		this.gameTankP = p;
		this.gameWall = w;
                this.gameMine = mine;
	}
	
        /**
         * Convert the complete map into a single string
         * 
         * @return 
         */
	public String toString(){
		StringBuffer sb = new StringBuffer ();
		
		sb.append(this.gameMap.toString());
		
		for (Border b : this.gameBorder){
			sb.append("\n").append(b.toString());
		}
		sb.append("\n").append(this.gameTankP.toString());
		
		for (Tank t : this.gameTankO){
			sb.append("\n").append(t.toString());
		}
		for (Wall w : this.gameWall){
			sb.append("\n").append(w.toString());
		}
                for (Mine m : this.gameMine) {
                    sb.append("\n").append(m.toString());
                }
		
		return sb.toString();
	}
        
        /**
         * Set the levels get (as map entity)
         * 
         * @return 
         */
	public Map getGameMap() {
		return this.gameMap;
	}
        
        /**
         * Set the levels game map
         * 
         * @param gameMap 
         */
	public void setGameMap(Map gameMap) {
		this.gameMap = gameMap;
	}
        
        /**
         * Get the levels boarders
         * 
         * @return 
         */
	public Border[] getGameBorder() {
		return gameBorder;
	}
        
        /**
         * Set the levels map
         * 
         * @param gameBorder 
         */
	public void setGameBorder(Border[] gameBorder) {
		this.gameBorder = gameBorder;
	}
        
        /**
         * Get the levels player tank
         * 
         * @return 
         */
	public Tank getGameTankP() {
		return gameTankP;
	}
        
        /**
         * Set the levels player tank
         * 
         * @param gameTankP 
         */
	public void setGameTankP(Tank gameTankP) {
		this.gameTankP = gameTankP;
	}
        
        /**
         * Get the levels opponent tanks
         * 
         * @return 
         */
	public Tank[] getGameTankO() {
		return gameTankO;
	}
        
        /**
         * Set the levels opponent tank
         * 
         * @param gameTankO 
         */
	public void setGameTankO(Tank[] gameTankO) {
		this.gameTankO = gameTankO;
	}
        
        /**
         * Get the levels wall
         * 
         * @return 
         */
	public Wall[] getGameWall() {
		return gameWall;
	}
        
        /**
         * Get the levels mine (as array)
         * 
         */
        public Mine[] getGameMine() {
            return this.gameMine;
        }
        /**
         * Set the levels wall
         * 
         * @param gameWall 
         */
	public void setGameWall(Wall[] gameWall) {
		this.gameWall = gameWall;
	}
        
        /**
         * Set the levels mine 
         * 
         * @param gameMine 
         */
        public void setGameMine(Mine[] gameMine) {
            this.gameMine = gameMine;
        } 

}
