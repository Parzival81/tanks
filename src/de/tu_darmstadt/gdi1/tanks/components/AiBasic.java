package de.tu_darmstadt.gdi1.tanks.components;

import de.tu_darmstadt.gdi1.tanks.entity.Tank;
import de.tu_darmstadt.gdi1.tanks.states.Game;
import eea.engine.action.Action;
import eea.engine.action.basicactions.MoveForwardAction;
import eea.engine.action.basicactions.RotateLeftAction;
import eea.engine.component.Component;
import eea.engine.entity.Entity;
import eea.engine.event.ANDEvent;
import eea.engine.event.basicevents.*;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Basic AI for the enemy tanks
 *
 * @version 1.0
 */
public class AiBasic {
	private int difficulty;
	private Entity tank;
	
    public AiBasic(Entity tank, int difficulty) {
    	this.tank = tank;
    	this.difficulty = difficulty;
    	switch (difficulty){
    		case 1: easy();
    		break;
    		case 2: normal();
    		break;
    		case 3: hard();
    		break;
    	}
    	
    }
    
    public void easy(){
    		((Tank) tank).steerForward(new ANDEvent
    				(new LoopEvent(),new MovementDoesntCollideEvent(2, new MoveForwardAction(0.05f))));

			((Tank) tank).steerLeft(new ANDEvent
					(new LoopEvent(),new MovementDoesntCollideEvent(2, new RotateLeftAction(0.05f))));
			
			
			LoopEvent le = new LoopEvent();
			le.addAction(new Action(){

				@Override
				public void update(GameContainer gc, StateBasedGame sb,
						int delta, Component event) {
					Random rg = new Random();
					int number = rg.nextInt(2000);
					if (Math.round(Game.entityManager.getEntity(1, tank.getId()).getRotation()) == number ){
						((Tank) Game.entityManager.getEntity(1, tank.getId())).fireShot(tank.getPosition(), tank.getRotation());
						Game.entityManager.addEntity(1, ((Tank) tank).getTankShot());
					}
				}
				
			});
			((Tank) tank).addComponent(le);
			

    }
    public void normal(){
    	
    }
    public void hard(){
    	
    }
    
}
