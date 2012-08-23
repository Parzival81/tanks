package de.tu_darmstadt.gdi1.tanks.entity;

import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * Represents a wall entity in the game
 * 
 * @version 1.0
 */
public class Wall extends Entity {

    private int maxlife, life;
    
    /**
     * Constructor. Set all the mandatory properties and set the texture
     * 
     * @param id        The walls id
     * @param maxlife   The walls max life
     * @param life      The walls life
     * @param rotation  The walls rotation
     * @param scale     The walls scale
     * @param x         The walls x position
     * @param y         The walls y position
     */
    public Wall(String id, int maxlife, int life, int rotation, int scale, int x, int y) {
        super(id);
        this.maxlife = maxlife;
        this.life = life;
        this.setRotation(rotation);
        this.setScale(scale*0.1f);
        this.setPosition(new Vector2f(x, y));
        this.setPacable(false);
        this.setSize(new Vector2f(50,20));

        /* --- Set the default texture ---*/
        try {
            this.addComponent(new ImageRenderComponent(new Image("assets/mapBg/sandbag.png")));
        } catch (SlickException e) {
            System.out.println("The asset can't be found!");
        }
    }
    
    /**
     * Converts the wall into a single string
     * 
     * @return 
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Wall ").append(this.maxlife).append(" ")
                .append(this.life).append(" ")
                .append((int) this.getRotation()).append(" ")
                .append((int) this.getScale()).append(" ")
                .append((int) this.getPosition().getX()).append(" ")
                .append((int) this.getPosition().getY());
        return sb.toString();
    }
    
    /**
     * Get the walls max life
     * 
     * @return 
     */
    public int getMaxlife() {
        return maxlife;
    }
    
    /**
     * Get the walls life
     * 
     * @return 
     */
    public int getLife() {
        return life;
    }
    
    /**
     * Set the walls life
     * 
     * @param life 
     */
    public void setLife(int life) {
        this.life = life;
    }
    
    /**
     * Get the walls x position
     * 
     * @return 
     */
    public int getX() {
        // TODO: finde solution for flaot to int conversion error
        // return this.getPosition().getX();
        return 1;
    }
    
    /**
     * Get the walls y position
     * 
     * @return 
     */
    public int getY() {
        // TODO: finde solution for flaot to int conversion error
        // return this.getPosition().getY();
        return 1;
    }
}
