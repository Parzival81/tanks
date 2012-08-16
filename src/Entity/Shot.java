package Entity;

import eea.engine.action.basicactions.MoveForwardAction;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.basicevents.KeyDownEvent;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Shot extends Entity {

    float strength, rotation, scale;
    KeyDownEvent fire;
    Vector2f position;

    public Shot(
            String id,
            float strength,
            float rotation,
            float scale,
            Vector2f position,
            KeyDownEvent fire) {

        super(id);

        this.strength = strength;
        this.rotation = rotation;
        this.scale = scale;
        this.position = position;
        this.fire = fire;

        // TODO: Override the map set scale
        // this.setScale(this.scale);
        this.setScale(0.1f);
        
        this.setPosition(this.position);

        /* --- Move the shot in the rotation of the tank --- */
        try {
            this.addComponent(new ImageRenderComponent(new Image("assets/ui/shoot.png")));
        } catch (SlickException e) {
            System.out.println("The asset can't be found!");
        }
        this.fire.addAction(new MoveForwardAction(0.1f));

    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Shot ").append(this.strength).append(" ").append(this.rotation).append(" ").append(this.scale)
                .append(" ").append(this.position.getX()).append(" ").append(this.position.getY());
        return sb.toString();
    }

    public float getStrength() {
        return strength;
    }
}
