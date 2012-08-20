package de.tu_darmstadt.gdi1.tanks.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.action.Action;
import eea.engine.action.basicactions.DestroyEntityAction;
import eea.engine.component.Component;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.basicevents.*;

public class Border extends Entity {
    public Border(String id, int x, int y, int width, int height) {
        super(id);
        this.setPosition(new Vector2f(x,y));
        this.setSize(new Vector2f(width,height));
        this.setPacable(false);
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Border").append(" ").append(this.getX()).append(" ").append(this.getY()).append(" ").append(this.getWidth())
                .append(" ").append(this.getHeight());
        return sb.toString();
    }
    public int getX() {
        return (int) this.getPosition().getX();
    }
    public int getY() {
        return (int) this.getPosition().getY();
    }
    public int getWidth(){
    	return (int) this.getSize().getX();
    }
    public int getHeight() {
        return (int) this.getSize().getY();
    }
}
