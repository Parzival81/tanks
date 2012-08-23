/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.gdi1.tanks.entity;

import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * Represents a mine that can be laid down by a tank
 *
 * @version 1.0
 */
public class Mine extends Entity {

    int Strenght;   // The mines strenght
    int life = 100; // The mines life

    /**
     * Constructor. Set all the mines properties
     *
     * @param id
     * @param strenght
     * @param scale
     * @param x
     * @param y
     */
    public Mine(String id, int strenght, int scale, int x, int y) {
        super(id);
        this.Strenght = strenght;
        this.setScale(scale);
        this.setPosition(new Vector2f(x, y));
        this.setPacable(false);
        
        /* ---- Set the texture ---- */
        try {
            this.addComponent(new ImageRenderComponent(new Image("assets/mine.png")));
        } catch (SlickException e) {
            e.printStackTrace();
        }
        
        /* ---- Set destruction ---- */
    }

    /**
     * Converts the mine to a single string representation
     *
     * @return
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getId()).append(this.Strenght).append(this.getScale()).append(this.getPosition().getX()).append(this.getPosition().getY());
        return sb.toString();
    }
    /**
     * Set the mines life
     * 
     */
    public void setLife(int life) {
        this.life = life;
    }
    /**
     * Get the mines life
     * 
     * @return 
     */
    public int getLife() {
        return this.life;
    }
}
