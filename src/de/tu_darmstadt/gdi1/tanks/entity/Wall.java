package de.tu_darmstadt.gdi1.tanks.entity;

import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Wall extends Entity {

    private int maxlife, life;

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

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Wall ").append(this.maxlife).append(" ")
                .append(this.life).append(" ")
                .append(this.getRotation()).append(" ")
                .append(this.getScale()).append(" ")
                .append(this.getPosition().getX()).append(" ")
                .append(this.getPosition().getY());
        return sb.toString();
    }

    public int getMaxlife() {
        return maxlife;
    }

    public int getLife() {
        return life;
    }

    public int getX() {
        // TODO: finde solution for flaot to int conversion error
        // return this.getPosition().getX();
        return 1;
    }

    public int getY() {
        // TODO: finde solution for flaot to int conversion error
        // return this.getPosition().getY();
        return 1;
    }
}
