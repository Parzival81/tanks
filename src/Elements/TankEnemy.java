package Elements;

import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * TODO: Correct to the correct data types
 * @author patrick
 */
public class TankEnemy {

    private String name;
    private int maxlife, life, maxshot, shot, maxmine, mine, strength, speed,
            rotation, scale, x, y;
    private String texture = "assets/tankBg/tankOppenent.png";      // The tanks texture
    private Entity tank;                                            // The tank as game entity

    public TankEnemy(String name, int maxlife, int life, int maxshot, int shot,
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

        this.tank = new Entity("playerTank");
        try {
            this.tank.addComponent(new ImageRenderComponent(new Image(this.texture)));
        } catch (SlickException ex) {
            Logger.getLogger(TankPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        tank.setScale(0.3f);
        tank.setPosition(new Vector2f(400, 320));
    }
}
