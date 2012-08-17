package Entity;

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

    private int width, height;

    public Border(String id, int x0, int y0, int width, int height) {
        super(id);
        this.setPosition(new Vector2f(x0,y0));
        this.width = width;
        this.height = height;
        this.setScale(1f);
        this.setPacable(false);
        this.setSize(new Vector2f(width,height));
        
        try {
            this.addComponent(new ImageRenderComponent(new Image("assets/ui/munipack.png")));

        } catch (SlickException e) {
            System.out.println("The asset can't be found!");
        }

        this.setSize(new Vector2f (height, width));
        this.setPacable(false);
        
    }

    
    public String toString() {
    	//TODO
    	return "";
//        StringBuffer sb = new StringBuffer();
//        sb.append("Border").append(" ").append(this.).append(" ").append(this.y0).append(" ").append(this.width)
//                .append(" ").append(this.height);
//
//        return sb.toString();
    }

    public int getX0() {
        return (int) this.getPosition().getX();
    }

    public int getY0() {
        return (int) this.getPosition().getY();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
