package de.tu_darmstadt.gdi1.tanks.entity;

import de.tu_darmstadt.gdi1.tanks.states.Game;
import eea.engine.action.basicactions.*;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.ANDEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * Represents the tanks in the game
 *
 * @version 1.1
 */
public class Tank extends Entity {

    private String name;
    private int maxlife, life, maxshot, shot, maxmine, mine, strength, speed;
    private String texture = "assets/tankBg/tankPlayer.png";											// texture
    private Entity tankShot;
    private Entity tankMine;

    /**
     * Constructor for the tank class. Gets all parameters from the level
     * object.
     *
     * @param id The tanks id
     * @param name The tanks name
     * @param maxlife The tanks full life points
     * @param life The tanks current life points
     * @param maxshot The tanks max shot number
     * @param shot The number of shots the tank still has
     * @param maxmine The maximum number of mines the tank has
     * @param mine The number of mines the tank currently has
     * @param strength The tanks shot power
     * @param speed The tanks speed
     * @param rotation The tanks initial rotation
     * @param scale The tanks scale
     * @param x The tanks initial x position
     * @param y The tanks initial y position
     */
    public Tank(String id, String name, int maxlife, int life, int maxshot,
            int shot, int maxmine, int mine, int strength, int speed,
            int rotation, int scale, int x, int y) {
        super(id);
        /* --- Set the tanks properties --- */
        this.name = name;
        this.maxlife = maxlife;
        this.life = life;
        this.maxshot = maxshot;
        this.shot = shot;
        this.maxmine = maxmine;
        this.mine = mine;
        this.strength = strength;
        this.speed = speed;
        this.setRotation(rotation);
        this.setScale(scale * 0.1f);
        this.setPosition(new Vector2f(x, y));
        /* ---- Set the size of the entity in pixel so the collison is correct ---- */
        this.setSize(new Vector2f(40, 80));
        /* --- Add the default texture --- */
        try {
            this.addComponent(new ImageRenderComponent(new Image(this.texture)));
        } catch (SlickException ex) {
            System.out.println("The tanks image could not be found!");
        }
        this.setPacable(false);
    }

    /**
     * Converts the tank to a single string
     *
     * @return The tank as a string
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Tank ").append(this.name).append(" ").append(this.maxlife).append(" ")
                .append(this.life).append(" ").append(this.maxshot).append(" ")
                .append(this.shot).append(" ").append(this.maxmine).append(" ")
                .append(this.mine).append(" ").append(this.strength)
                .append(" ").append(this.speed).append(" ")
                .append((int) this.getRotation()).append(" ").append((int) this.getScale())
                .append(" ").append((int) this.getPosition().getX()).append(" ")
                .append((int) this.getPosition().getY());
        return sb.toString();
    }

    /**
     * Steers the tank entity forwards
     *
     * @param upPressed
     */
    public void steerForward(ANDEvent upPressed) {
        upPressed.addAction(new MoveForwardAction(0.05f));
        this.addComponent(upPressed);
    }

    /**
     * Steers the tank backwards
     *
     * @param downPressed
     */
    public void steerBack(ANDEvent downPressed) {
        downPressed.addAction(new MoveBackwardAction(0.05f));
        this.addComponent(downPressed);
    }

    /**
     * Steers the tank entity to the right Rotates the entity to right
     *
     * @param rightPressed
     */
    public void steerRight(ANDEvent rightPressed) {
        rightPressed.addAction(new RotateRightAction(0.1f));
        this.addComponent(rightPressed);
    }

    /**
     * Steers the tank entity to the left Rotates the entity to the left
     *
     * @param leftPressed
     */
    public void steerLeft(ANDEvent leftPressed) {
        leftPressed.addAction(new RotateLeftAction(0.1f));
        this.addComponent(leftPressed);
    }

    /**
     * Set the tanks texture (image path)
     *
     * @param texture
     */
    public void setTexture(String texture) {
        this.texture = texture;
        try {
            this.addComponent(new ImageRenderComponent(new Image(this.texture)));
        } catch (SlickException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get the tanks name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the tanks max life points
     *
     * @return
     */
    public int getMaxLife() {
        return maxlife;
    }

    /**
     * Get the tanks life
     *
     * @return
     */
    public int getLife() {
        return life;
    }

    /**
     * Get the tanks max number of shots
     *
     * @return
     */
    public int getMaxShot() {
        return maxshot;
    }

    /**
     * Get the tanks current number of shots
     *
     * @return
     */
    public int getShot() {
        return this.shot;
    }

    /**
     * Get the tanks max number of mines
     *
     * @return
     */
    public int getMaxMine() {
        return maxmine;
    }

    /**
     * Get the tanks current number of mines
     *
     * @return
     */
    public int getMine() {
        return mine;
    }

    /**
     * Get the tanks shot power
     *
     * @return
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Set the tanks name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the tanks max life
     *
     * @param maxlife
     */
    public void setMaxlife(int maxlife) {
        this.maxlife = maxlife;
    }

    /**
     * Set the tanks current life (health points as int)
     *
     * @param life
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Set the tanks max shots
     *
     * @param maxshot
     */
    public void setMaxshot(int maxshot) {
        this.maxshot = maxshot;
    }

    /**
     * Set the tanks current number of shots
     *
     * @param shot
     */
    public void setShot(int shot) {
        this.shot = shot;
    }

    /**
     * Set the tanks number of max mines
     *
     * @param maxmine
     */
    public void setMaxmine(int maxmine) {
        this.maxmine = maxmine;
    }

    /**
     * Set the tanks current number of mines
     *
     * @param mine
     */
    public void setMine(int mine) {
        this.mine = mine;
    }

    /**
     * Set the tanks current strength (as int)
     *
     * @param strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Set the tanks speed
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Get the tanks speed
     *
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Fire a shot entity from the tanks position
     *
     */
    public void fireShot(Vector2f position, float rotation) {
        if (this.shot > 0) {
            this.shot--;
            this.tankShot = new Shot("tankShot", this.getStrength(), rotation,
                    1, position);
        }
    }

    /**
     * Lay a mine at the tanks current position
     *
     * @param position
     */
    public void layMine(Vector2f position, float rotation) {

        int r = -100;

        float x = position.getX();
        float y = position.getY();

        x += (float) r * (java.lang.Math.sin(java.lang.Math.toRadians(rotation)));
        y -= (float) r * (java.lang.Math.cos(java.lang.Math.toRadians(rotation)));

        position = new Vector2f(x, y);

        if (this.mine > 0) {
            this.mine--;
            this.tankMine = new Mine(
                    "PlayerTankMine",
                    100,
                    1,
                    position.getX(),
                    position.getY());
        }
    }

    /**
     * Get the tanks mine as entity (get Mine gets the number of mines left
     *
     * @return
     */
    public Entity getTankMine() {
        return this.tankMine;
    }

    /**
     * Get the tanks INITAL x position
     *
     * @return
     */
    public float getX() {
        return this.getPosition().getX();
    }

    /**
     * Get the tanks INITAL y position
     *
     * @return
     */
    public float getY() {
        return this.getPosition().getY();
    }

    /**
     * Get the tanks shot entity
     *
     * @return
     */
    public Entity getTankShot() {
        return this.tankShot;
    }
}
