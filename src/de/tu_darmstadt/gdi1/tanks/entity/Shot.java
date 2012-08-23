package de.tu_darmstadt.gdi1.tanks.entity;

import de.tu_darmstadt.gdi1.tanks.states.Game;
import eea.engine.action.Action;
import eea.engine.action.basicactions.DestroyEntityAction;
import eea.engine.action.basicactions.MoveForwardAction;
import eea.engine.component.Component;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.event.basicevents.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Represents a tank shot in the game
 *
 * @version 1.5
 */
public class Shot extends Entity {

    float strength, rotation, scale;
    Vector2f position;

    /**
     * Constructor. Set all the mandatory properties, create a new shot entity,
     * place it in front of the tank and check for collision with other objects.
     * Shot is destroyed when it leaves the screen
     *
     * @param id The shots id
     * @param strength The shots strength (how much it will subtract form the
     * hit objects health
     * @param rotation The shots rotation
     * @param scale The shots scale
     * @param position The shots initial position
     */
    public Shot(
            String id,
            float strength,
            float rotation,
            float scale,
            Vector2f position) {

        super(id);

        this.strength = strength;
        this.rotation = rotation;
        this.scale = scale;

        /* 
         * calculate the postiton of the shot (infront of the tank entity)
         * via Polar coordinate system (http://en.wikipedia.org/wiki/Polar_coordinate_system)
         */

        /* ----  distance from the tank ---- */
        int r = 60;

        float x = position.getX();
        float y = position.getY();

        x += (float) r * (java.lang.Math.sin(java.lang.Math.toRadians(rotation)));
        y -= (float) r * (java.lang.Math.cos(java.lang.Math.toRadians(rotation)));

        this.position = new Vector2f(x, y);
        this.setPacable(false);
        /* 
         * Shot scale is set manualy in the tank class, as all othe shot 
         * properties are set in the map file in the tank entity
         */
        this.setScale(this.scale * 0.1f);
        /* --- Set the shots initial postiton --- */
        this.setPosition(this.position);


        /* --- Move the shot in the rotation of the tank --- */
        /* --- add the texture --- */
        try {
            this.addComponent(new ImageRenderComponent(new Image("assets/fx/TankShot.png")));
        } catch (SlickException e) {
            System.out.println("The asset can't be found!");
        }
        /* ---- Shoot moving forward ---- */
        this.setRotation(rotation);
        LoopEvent loop = new LoopEvent();
        loop.addAction(new MoveForwardAction(1f));
        this.addComponent(loop);

        /* ---- Destroy hit object ---- */
        CollisionEvent ce1 = new CollisionEvent();
        ce1.addAction(new Action() {
            @Override
            public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {
                CollisionEvent ce = (CollisionEvent) event;
                /* ---- collision  with tank ---- */
                if (ce.getColidedEntity() instanceof Tank) {
                    Tank t = (Tank) ce.getColidedEntity();
                    Shot s = (Shot) ce.getOwnerEntity();
                    if (t.getLife() > 0) {
                        t.setLife((int) t.getLife() - (int) s.getStrength());
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
                    /* ---- Wall collision ---- */
                } else if (ce.getColidedEntity() instanceof Wall) {
                    Wall w = (Wall) ce.getColidedEntity();
                    Shot s = (Shot) ce.getOwnerEntity();
                    if (w.getLife() > 0) {
                        w.setLife((int) w.getLife() - (int) s.getStrength());
                    } else {
                        DestroyEntityAction dea = new DestroyEntityAction();
                        ce.addAction(dea);
                        w.addComponent(ce);


                        Wall[] newWallArray = new Wall[Game.gamelevel.getGameWall().length - 1];
                        int counter = 0;
                        for (int i = 0; Game.gamelevel.getGameWall().length > i; i++) {
                            if (!w.getId().equals(Game.gamelevel.getGameWall()[i].getId())) {
                                newWallArray[counter] = Game.gamelevel.getGameWall()[i];
                                counter++;
                            }
                        }
                        Game.gamelevel.setGameWall(newWallArray);
                    }
                /* ---- collision with a mine ---- */
                } else if (ce.getColidedEntity() instanceof Mine) {
                    Mine m = (Mine) ce.getColidedEntity();
                    Shot s = (Shot) ce.getOwnerEntity();
                    if (m.getLife() > 0) {
                        m.setLife((int) m.getLife() - (int) s.getStrength());
                    } else {
                        DestroyEntityAction dea = new DestroyEntityAction();
                        ce.addAction(dea);
                        m.addComponent(ce);


                        Mine[] newMineArray = new Mine[Game.gamelevel.getGameMine().length - 1];
                        int counter = 0;
                        for (int i = 0; Game.gamelevel.getGameMine().length > i; i++) {
                            if (!m.getId().equals(Game.gamelevel.getGameMine()[i].getId())) {
                                newMineArray[counter] = Game.gamelevel.getGameMine()[i];
                                counter++;
                            }
                        }
                        Game.gamelevel.setGameMine(newMineArray);
                    }
                }
            }
        });
        ce1.addAction(new DestroyEntityAction());
        this.addComponent(ce1);

        /* ---- Destroy the shot when it leaves the screen ---- */
        LeavingScreenEvent lse = new LeavingScreenEvent();
        DestroyEntityAction dea = new DestroyEntityAction();
        lse.addAction(dea);
        this.addComponent(lse);
    }

    /**
     * Convert a shot into a single String
     *
     * @return
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Shot ").append(this.strength).append(" ").append(this.rotation).append(" ").append(this.scale)
                .append(" ").append(this.position.getX()).append(" ").append(this.position.getY());
        return sb.toString();
    }

    /**
     * Get the shots strength
     *
     * @return
     */
    public float getStrength() {
        return strength;
    }
}
