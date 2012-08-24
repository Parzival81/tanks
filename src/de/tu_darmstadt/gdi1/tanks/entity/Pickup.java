package de.tu_darmstadt.gdi1.tanks.entity;

import de.tu_darmstadt.gdi1.tanks.states.Game;
import eea.engine.action.Action;
import eea.engine.action.basicactions.DestroyEntityAction;
import eea.engine.component.Component;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.basicevents.CollisionEvent;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Represents a pickup in the game
 *
 * @version 1.0
 */
public class Pickup extends Entity {

    int strenght;       // The pickups strenght
    String type;        // The pickups type

    /**
     * Constructor. Set all needed properties
     *
     * @param id
     * @param type
     * @param strenght
     * @param rotation
     * @param scale
     * @param x
     * @param y
     */
    public Pickup(String id, String type, int strenght, int rotation, int scale, float x, float y) {
        super(id);
        this.type = type;
        this.strenght = strenght;
        this.setRotation(rotation);
        this.setScale(scale);
        this.setPosition(new Vector2f(x, y));
        this.setPacable(true);

        /* ---- Set the texture ---- */
        try {
            if (this.type.contains("Ammopack")) {
                this.addComponent(new ImageRenderComponent(new Image("assets/ui/munipack.png")));
            } else {
                this.addComponent(new ImageRenderComponent(new Image("assets/ui/healthpack.png")));
            }
        } catch (SlickException e) {
            // TODO: Remove all sout with this
            e.printStackTrace();
        }

        /* ---- Pickup hit action ---- */
        CollisionEvent ce = new CollisionEvent();
        ce.addAction(new Action() {
            @Override
            public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {

                CollisionEvent ce = (CollisionEvent) event;

                if (ce.getColidedEntity() instanceof Tank && ce.getOwnerEntity() instanceof Pickup) {

                    Tank t = (Tank) ce.getColidedEntity();
                    Pickup p = (Pickup) ce.getOwnerEntity();

                    if (t.getId().contains("Player")) {
                        if (p.getType().contains("Ammopack") && t.getMaxShot() > t.getShot()) {
                            if (t.getShot() + p.getStrength() > t.getMaxShot()) {
                                t.setShot(t.getMaxShot());
                            } else {
                                t.setShot(t.getShot() + p.getStrength());
                            }
                        } else if (t.getMaxLife() > t.getLife()) {
                            if (t.getLife() + p.getStrength() > t.getMaxLife()) {
                                t.setLife(t.getMaxLife());
                            } else {
                                t.setLife(t.getLife() + p.getStrength());
                            }
                        }
                        Pickup[] newPickupArray = new Pickup[Game.gamelevel.getGamePickup().length - 1];
                        int counter = 0;
                        for (int i = 0; Game.gamelevel.getGamePickup().length > i; i++) {
                            if (!p.getId().equals(Game.gamelevel.getGamePickup()[i].getId())) {
                                newPickupArray[counter] = Game.gamelevel.getGamePickup()[i];
                                counter++;
                            }
                        }
                        Game.gamelevel.setGamePickup(newPickupArray);
                    }
                }
            }
        });
        ce.addAction(new DestroyEntityAction());
        this.addComponent(ce);
    }

    /**
     * Converts the pickup to a single string representation
     *
     * @return
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getId()).append(this.type).append(this.strenght).append(this.getRotation()).append(this.getScale()).append(this.getPosition().getX()).append(this.getPosition().getY());
        return sb.toString();
    }

    /**
     * Get ammo packs/health packs strength (how much is added)
     *
     * @return
     */
    public int getStrength() {
        return this.strenght;
    }

    /**
     * The pickups type
     *
     * @return
     */
    public String getType() {
        return this.type;
    }
}
