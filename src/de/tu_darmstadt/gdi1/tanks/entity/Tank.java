package de.tu_darmstadt.gdi1.tanks.entity;

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
 * @author Patrick Dorrington
 */
public class Tank extends Entity {

	private String name;
	private int maxlife, life, maxshot, shot, maxmine, mine, strength, speed;
	private String texture = "assets/tankBg/tankPlayer.png"; // The tanks
																// texture
	private Entity tankShot; // The tanks shot

	/**
	 * Constructor for the tank class. Gets all parameters from the level
	 * object.
	 * 
	 * @param id
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
	public Tank(String id,String name, int maxlife, int life, int maxshot,
			int shot, int maxmine, int mine, int strength, int speed,
			int rotation, int scale, int x, int y) {
		super(id);
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
		this.setRotation(rotation);
		this.setScale(scale * 0.1f);
		this.setPosition(new Vector2f(x, y));
		this.setSize(new Vector2f(40, 80));
		/* --- Add the default texture --- */
		try {
			this.addComponent(new ImageRenderComponent(new Image(this.texture)));
		} catch (SlickException ex) {
			Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.setPacable(false);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Tank ").append(this.name).append(" ").append(this.maxlife).append(" ")
				.append(this.life).append(" ").append(this.maxshot).append(" ")
				.append(this.shot).append(" ").append(this.maxmine).append(" ")
				.append(this.mine).append(" ").append(this.strength)
				.append(" ").append(this.speed).append(" ")
				.append((int)this.getRotation()).append(" ").append((int)this.getScale())
				.append(" ").append((int)this.getPosition().getX()).append(" ")
				.append((int)this.getPosition().getY());
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

	public void setTexture(String texture) {
		this.texture = texture;
		try {
			this.addComponent(new ImageRenderComponent(new Image(this.texture)));
		} catch (SlickException ex) {
			Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
		}
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
		return this.shot;
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

	public int getSpeed() {
		return speed;
	}

	/**
	 * Fire a shot from the tanks position
	 * 
	 */
	public void fireShot(Vector2f position, float rotation) {
		if (this.shot > 0) {
			this.shot--;
			this.tankShot = new Shot("tankShot", this.getStrength(), rotation,
					this.getScale(), position);
		}
	}

	public float getX() {
		return this.getPosition().getX();
	}

	public float getY() {
		return this.getPosition().getY();
	}

	public Entity getTankShot() {
		return this.tankShot;
	}
}
