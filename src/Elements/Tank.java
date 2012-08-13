package Elements;

import eea.engine.action.basicactions.*;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.basicevents.KeyDownEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * Represents the players tank in the game
 *
 * @author Patrick Dorrington
 */
public class Tank {

    private String name;
    private int maxlife, life, maxshot, shot, maxmine, mine, strength, speed,
            rotation, scale, x, y;
    private String texture = "assets/tankBg/tankPlayer.png";    // The tanks texture
    private Entity tank;            // The tank as game Entity
    private Vector2f tankVector;    // The tank as entity
    private float speedForwards;    // The tanks speed forwards
    private float speedBackwards;   // The tanks speed backwards
    private float speedRight;       // The tanks speed to the right
    private float speedLeft;        // The tanks speed to the left

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
    public Tank(String name, int maxlife, int life, int maxshot, int shot,
            int maxmine, int mine, int strength, int speed, int rotation,
            int scale, int x, int y) {

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
        try {
            // Create the tank entity
            this.tank.addComponent(new ImageRenderComponent(new Image(this.texture)));
        } catch (SlickException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }
        tank.setScale(0.3f);
        tank.setPosition(tankVector);
        tank.setRotation(0f);
    }
    
    public String toString(){
    	StringBuffer sb = new StringBuffer();
    	sb.append(this.name).append(" ").append(this.maxlife).append(" ").append(this.life).append(" ").append(this.maxshot)
    	.append(" ").append(this.shot).append(" ").append(this.maxmine).append(" ").append(this.mine).append(" ").append(this.strength).append(" ").append(this.speed)
    	.append(" ").append(this.rotation).append(" ").append(this.scale).append(" ").append(this.x).append(" ").append(this.y);
    	return sb.toString();
    }

    /**
     * Steers the tank entity forwards
     *
     * @param upPressed
     */
    public void steerForward(KeyDownEvent upPressed) {
        // No switch, because switch can can't be used with float
        
        // Up and right (0-90)
        if (tank.getRotation() < 90f) {
            
            // Calculate the tanks speed to the left and the right
            
            // First, we dived by 100 (because we need speed from 0-10)
            this.speedRight = tank.getRotation()/100f;
            
            // Then multiply it by (100/90) (because 90 is our absolute value)
            this.speedRight = this.speedRight*(100f/90);
            
            // The speed to the left is always the complement to the up value
            // E.g. 0.3 -> 0.7; 0.4 -> 0.6
            this.speedForwards = 1-this.speedRight;
            

            System.out.println(this.speedRight);
            System.out.println(this.speedForwards);

            upPressed.addAction(new MoveUpAction(speedForwards));
            upPressed.addAction(new MoveRightAction(speedRight));
        }
        // Right (90)
        else if (tank.getRotation() == 90f) {
            upPressed.addAction(new MoveRightAction(0.1f));
        }
        // Down and right (91-179)
        else if (tank.getRotation() < 180f) {

            this.speedForwards = (tank.getRotation()/100f)/100;
            this.speedRight = (tank.getRotation()/100f)/100;

            upPressed.addAction(new MoveUpAction(0.1f));
            upPressed.addAction(new MoveRightAction(0.1f));
        }
        // Down (180)
        else if (tank.getRotation() == 180f) {
            upPressed.addAction(new MoveDownAction(0.1f));
        }
        // Down and left (181 - 269)
        else if (tank.getRotation() < 270f) {

            this.speedForwards = (tank.getRotation()/100f)/100;
            this.speedRight = (tank.getRotation()/100f)/100;

            upPressed.addAction(new MoveUpAction(0.1f));
            upPressed.addAction(new MoveRightAction(0.1f));
        }
        // Left (270)
        else if (tank.getRotation() == 270f) {
            upPressed.addAction(new MoveLeftAction(0.1f));
        }
        //Up and left (271 - 359)
        else if (tank.getRotation() < 360) {

            this.speedForwards = (tank.getRotation()/100f)/100;
            this.speedRight = (tank.getRotation()/100f)/100;

            upPressed.addAction(new MoveUpAction(0.1f));
            upPressed.addAction(new MoveRightAction(0.1f));
        }
        // (360)
        else if (tank.getRotation() == 360f) {
            upPressed.addAction(new MoveUpAction(0.1f));
        }
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
     * Rotates the entity to right
     *
     * @param rightPressed
     */
    public void steerRight(KeyDownEvent rightPressed) {
        rightPressed.addAction(new RotateRightAction(0.1f));
        tank.addComponent(rightPressed);
    }

    /**
     * Steers the tank entity to the left
     * Rotates the entity to the left
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
