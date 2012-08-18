package de.tu_darmstadt.gdi1.tanks.components;

import eea.engine.action.basicactions.MoveForwardAction;
import eea.engine.entity.Entity;
import eea.engine.event.basicevents.CollisionEvent;

/**
 * Basic AI for the game
 *
 * @author Patrick
 */
public class AiBasic {

    public AiBasic(Entity tank) {

        MoveForwardAction mfa = new MoveForwardAction(1f);
    }
}
