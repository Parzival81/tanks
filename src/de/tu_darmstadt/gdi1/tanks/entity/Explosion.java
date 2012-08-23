package de.tu_darmstadt.gdi1.tanks.entity;

import eea.engine.entity.Entity;

/**
 * Represents an explosion object in the game
 * 
 * @version 1.0
 */
public class Explosion extends Entity {
    
	private int width, height, speed, x, y;
        
        /**
         * Constructor. Set all the mandatory properties for the object 
         * 
         * @param id        The explosion id
         * @param width     The explosion width
         * @param height    The explosion hight
         * @param speed     The explosions speed (how fast dose it go away)
         * @param x         The explosion x position
         * @param y         The explosion y position
         */
	public Explosion(String id, int width, int height, int speed, int x, int y){
            super(id);
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.x = x;
		this.y = y;
	}
        
        /**
         * Converts the explosion into a single String
         * 
         * @return 
         */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Explosion ").append(this.width).append(" ").append(this.height).append(" ").append(this.speed)
		.append(" ").append(this.x).append(" ").append(this.y);
		
		return sb.toString();
	}
	
        /**
         * Get the explosions width
         * 
         * @return 
         */
	public int getWidth() {
		return width;
	}
        /**
         * Get the explosions height
         * 
         * @return 
         */
	public int getHeight() {
		return height;
	}
        /**
         * Get the explosions speed
         * 
         * @return 
         */
	public int getSpeed() {
		return speed;
	}
        /**
         *  Get the explosions x position
         * 
         * @return 
         */
	public int getX() {
		return x;
	}
        /**
         * Get the explosion y position
         * 
         * @return 
         */
	public int getY() {
		return y;
	}
}
