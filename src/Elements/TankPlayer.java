package Elements;

import eea.engine.action.basicactions.MoveDownAction;
import eea.engine.action.basicactions.MoveUpAction;
import eea.engine.action.basicactions.RotateLeftAction;
import eea.engine.action.basicactions.RotateRightAction;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.basicevents.KeyDownEvent;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * Represents the players tank in the game
 *
 * @author Patrick Dorrington
 */
public class TankPlayer {

    private String name;
    private int maxlife, life, maxshot, shot, maxmine, mine, strength, speed,
            rotation, scale, x, y;
    private String texture = "assets/tankBg/tankPlayer.png";    // The tanks texture
    private Entity tank;            // The tank as game Entity
    private Vector2f tankVector;    // The tank as entity

    /**
     * Constructor for the tank class. Gets all parameters from the level
     * object.
     *
     * @param name
     * @param maxlife
     * @param life
     * @param maxshot
     * @param shot
     * @param maxmine
     * @param mine
     * @param strength
     * @param speed
     * @param rotation
     * @param scale
     * @param x
     * @param y
     */
    public TankPlayer(String name, int maxlife, int life, int maxshot, int shot,
            int maxmine, int mine, int strength, int speed, int rotation,
            int scale, int x, int y) throws SlickException {

        // Set the tanks properties
        this.name = name;
        this.maxlife = maxlife;
        this.life = life;
        this.maxshot = maxshot;
        this.shot = shot;
        this.maxmine = maxmine;
        this.mine = mine;
        this.strength = strength;
        this.speed = speed;
        this.rotation = rotation;
        this.scale = scale;
        this.x = x;
        this.y = y;

        this.tank = new Entity("playerTank");
        this.tankVector = new Vector2f(400, 320);

        // Create the tank entity
        this.tank.addComponent(new ImageRenderComponent(new Image(this.texture)));
        tank.setScale(0.3f);
        tank.setPosition(tankVector);
    }

    /**
     * Steers the tank entity forwards
     *
     * @param upPressed
     */
    public void steerForward(KeyDownEvent upPressed) {
        upPressed.addAction(new MoveUpAction(0.1f));
        tank.addComponent(upPressed);
    }

    /**
     * Steers the tank backwards
     *
     * @param downPressed
     */
    public void steerBack(KeyDownEvent downPressed) {
        downPressed.addAction(new MoveDownAction(0.05f));
        tank.addComponent(downPressed);
    }

    /**
     * Steers the tank entity to the right
     *
     * @param rightPressed
     */
    public void steerRight(KeyDownEvent rightPressed) {
        rightPressed.addAction(new RotateRightAction(0.1f));
        tank.addComponent(rightPressed);
    }

    /**
     * Steers the tank entity to the left
     *
     * @param leftPressed
     */
    public void steerLeft(KeyDownEvent leftPressed) {
        leftPressed.addAction(new RotateLeftAction(0.1f));
        tank.addComponent(leftPressed);
    }

    /**
     * Return the tank entity
     *
     * @return
     */
    public Entity getTank() {
        return this.tank;
    }

    public String getName() {
        return name;
    }

    public int getMaxLife() {
        return maxlife;
    }

    public int getLife() {
        return life;
    }

    public int getMaxShot() {
        return maxshot;
    }

    public int getShot() {
        return shot;
    }

    public int getMaxMine() {
        return maxmine;
    }

    public int getMine() {
        return mine;
    }

    public int getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxlife(int maxlife) {
        this.maxlife = maxlife;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setMaxshot(int maxshot) {
        this.maxshot = maxshot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public void setMaxmine(int maxmine) {
        this.maxmine = maxmine;
    }

    public void setMine(int mine) {
        this.mine = mine;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRotation() {
        return rotation;
    }

    public int getScale() {
        return scale;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
