/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * Represents a mine that can be laid down by a tank
 *
 * @version 1.0
 */
public class Mine extends Entity {

    int Strenght;   // The mines strenght

    /**
     * Constructor. Set all the mines properties
     *
     * @param id
     * @param strenght
     * @param scale
     * @param x
     * @param y
     */
    public Mine(String id, int strenght, int scale, int x, int y) {
        super(id);
        this.Strenght = strenght;
        this.setScale(scale);
        this.setPosition(new Vector2f(x, y));
        this.setPacable(true);

        /* ---- Set the texture ---- */
        try {
            // TODO: Get new mine asset!
            this.addComponent(new ImageRenderComponent(new Image("assets/mine.png")));
        } catch (SlickException e) {
            e.printStackTrace();
        }

        /* ---- Destroy hit object ---- */
        CollisionEvent ce = new CollisionEvent();
        ce.addAction(new Action() {
            @Override
            public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {
                
                CollisionEvent ce = (CollisionEvent) event;

                if (ce.getColidedEntity() instanceof Tank) {
                    
                    Tank t = (Tank) ce.getColidedEntity();
                    Mine m = (Mine) ce.getOwnerEntity();
                    
                    if (t.getLife() > 0) {
                        t.setLife((int) t.getLife() - (int) m.getStrength());
                    } else {
                        DestroyEntityAction dea = new DestroyEntityAction();
                        ce.addAction(dea);
                        t.addComponent(ce);

                        /* Removing the Tank from gamelevel */
                        if (t.getId().contains("Oppenent")) {
                            Tank[] newTankArray = new Tank[Game.gamelevel.getGameTankO().length - 1];
                            int counter = 0;
                            for (int i = 0; Game.gamelevel.getGameTankO().length > i; i++) {
                                if (!t.getId().equals(Game.gamelevel.getGameTankO()[i].getId())) {
                                    newTankArray[counter] = Game.gamelevel.getGameTankO()[i];
                                    counter++;
                                }
                            }
                            Game.gamelevel.setGameTankO(newTankArray);

                        }

                    }
                }
            }
        });
        ce.addAction(new DestroyEntityAction());
        this.addComponent(ce);
    }

    /**
     * Converts the mine to a single string representation
     *
     * @return
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getId()).append(this.Strenght).append(this.getScale()).append(this.getPosition().getX()).append(this.getPosition().getY());
        return sb.toString();
    }
    
    /**
     * Get the damage the mine dose
     * 
     * @return 
     */
    public int getStrength() {
        return this.Strenght;
    }
}
