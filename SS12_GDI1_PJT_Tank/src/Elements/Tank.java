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
 * Represents the players tank
 *
 * @author patrick
 */
public class Tank {

    private String name;
    private int maxlife, life, maxshot, shot, maxmine, mine, strength, speed,
            rotation, scale, x, y;
    private String texture;     // The tanks texture
    private Entity tank;        // The tank as game entity

    /**
     * First constructor
     *
     * @param texture
     */
    public Tank(String texture) {

        this.texture = texture;
        this.tank = new Entity("playerTank");
        try {
            this.tank.addComponent(new ImageRenderComponent(new Image(this.texture)));
        } catch (SlickException ex) {
            Logger.getLogger(Tank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        tank.setScale(0.3f);
        tank.setPosition(new Vector2f(400, 320));

    }
    
    /**
     * Second constructor
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
    }

    public void steerBack(KeyDownEvent downPressed) {
        downPressed.addAction(new MoveDownAction(0.05f));
        tank.addComponent(downPressed);
    }

    public void steerForward(KeyDownEvent upPressed) {
        upPressed.addAction(new MoveUpAction(0.1f));
        tank.addComponent(upPressed);
    }

    public void steerRight(KeyDownEvent rightPressed) {
        rightPressed.addAction(new RotateRightAction(0.1f));
        tank.addComponent(rightPressed);
    }

    public void steerLeft(KeyDownEvent leftPressed) {
        leftPressed.addAction(new RotateLeftAction(0.1f));
        tank.addComponent(leftPressed);
    }

    /**
     * Return the tank as entity
     *
     * @return
     */
    public Entity getTank() {
        return this.tank;
    }

    public String getName() {
        return name;
    }

    public int getMaxlife() {
        return maxlife;
    }

    public int getLife() {
        return life;
    }

    public int getMaxshot() {
        return maxshot;
    }

    public int getShot() {
        return shot;
    }

    public int getMaxmine() {
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
