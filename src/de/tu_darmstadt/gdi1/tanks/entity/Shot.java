package de.tu_darmstadt.gdi1.tanks.entity;

import de.tu_darmstadt.gdi1.tanks.states.Game;
import java.awt.Container;

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

public class Shot extends Entity {

    float strength, rotation, scale;
    Vector2f position;

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

        // TODO: Override the map set scale
        // this.setScale(this.scale);
        this.setScale(0.1f);

        /* --- Set the shots initial postiton --- */
        this.setPosition(this.position);


        /* --- Move the shot in the rotation of the tank --- */
        /* --- add the texture --- */
        try {
            this.addComponent(new ImageRenderComponent(new Image("assets/fx/TankShot.png")));
        } catch (SlickException e) {
            System.out.println("The asset can't be found!");
        }
        this.setRotation(rotation);
        LoopEvent loop = new LoopEvent();
        loop.addAction(new MoveForwardAction(1f));
        this.addComponent(loop);

        /* ---- Destory the shot when it hits something ---- */
        DestroyEntityAction dea = new DestroyEntityAction();
        CollisionEvent ce = new CollisionEvent();
        ce.addAction(dea);
        this.addComponent(ce);

        /* ---- Destroy hit object ---- */
        CollisionEvent ce1 = new CollisionEvent();
        ce1.addAction(new Action() {
            @Override
            public void update(GameContainer gc, StateBasedGame sb, int delta, Component event) {
                CollisionEvent ce = (CollisionEvent) event;
                System.out.println(ce.getColidedEntity());

                Tank t = (Tank) Game.entityManager.getEntity(delta, ce.getColidedEntity().getId());
                Shot s = (Shot) Game.entityManager.getEntity(delta, ce.getOwnerEntity().getId());
                if (t.getLife() <= 0) {
                    t.setLife((int) t.getLife() - (int) t.getStrength());
                } else {
                    DestroyEntityAction dea = new DestroyEntityAction();
                    ce.addAction(dea);
                    t.addComponent(ce);
                }
            }
        });
        this.addComponent(ce1);

        /* ---- Destroy the shot when it leaves the screen ---- */
        // Should be working correctly
        LeavingScreenEvent lse = new LeavingScreenEvent();
        lse.addAction(dea);
        this.addComponent(lse);

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
