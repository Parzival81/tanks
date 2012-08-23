package de.tu_darmstadt.gdi1.tanks.entity;

import eea.engine.entity.Entity;
import org.newdawn.slick.geom.Vector2f;

/**
 * This class represents a boarder object on the map
 * 
 * @version 1.0
 */
public class Border extends Entity {
    
    /**
     * Constructor. Set all mandatory values that are needed to add a wall to
     * the game
     * 
     * @param id        The wall id
     * @param x         The x position
     * @param y         The y position
     * @param width     The boarders width
     * @param height    The boarders height
     */
    public Border(String id, int x, int y, int width, int height) {
        super(id);
        this.setPosition(new Vector2f(x,y));
        this.setSize(new Vector2f(width,height));
        this.setPacable(false);
    }
    /**
     * Method to convert all wall properties to a single string
     * 
     * @return  String
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Border").append(" ").append(this.getX()).append(" ").append(this.getY()).append(" ").append(this.getWidth())
                .append(" ").append(this.getHeight());
        return sb.toString();
    }
    /**
     * Get the walls x position
     * 
     * @return 
     */
    public int getX() {
        return (int) this.getPosition().getX();
    }
    /**
     * Get the walls y position
     * 
     * @return 
     */
    public int getY() {
        return (int) this.getPosition().getY();
    }
    /**
     * Get the walls width
     * 
     * @return 
     */
    public int getWidth(){
    	return (int) this.getSize().getX();
    }
    /**
     * Get the walls hight 
     * 
     * @return 
     */
    public int getHeight() {
        return (int) this.getSize().getY();
    }
}
