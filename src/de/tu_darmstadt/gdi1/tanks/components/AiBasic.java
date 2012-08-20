package de.tu_darmstadt.gdi1.tanks.components;

import java.util.Random;
import java.util.Timer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import de.tu_darmstadt.gdi1.tanks.entity.Tank;
import eea.engine.action.basicactions.MoveForwardAction;
import eea.engine.entity.Entity;
import eea.engine.event.ANDEvent;
import eea.engine.event.Event;
import eea.engine.event.basicevents.CollisionEvent;
import eea.engine.event.basicevents.KeyDownEvent;
import eea.engine.event.basicevents.LoopEvent;
import eea.engine.event.basicevents.MovementDoesntCollideEvent;

/**
 * Basic AI for the game
 *
 * @author Patrick
 */
public class AiBasic {
	private int difficulty;
	private Entity tank;
	
    public AiBasic(Entity tank, int difficulty) {
    	this.tank = tank;
    	this.difficulty = difficulty;
    	
    	switch (difficulty){
    		case 1: move1();
    		break;
    		case 2: move2();
    		break;
    		case 3: move3();
    		break;
    	}
    	
    }
    
    public void move1(){
    	
    		Random rg = new Random();
    		
    		int number  = rg.nextInt(3);
    		

			((Tank) tank).steerLeft(new ANDEvent
					(new LoopEvent(),new CollisionEvent()));
			
    		((Tank) tank).steerForward(new ANDEvent
    				(new LoopEvent(),new MovementDoesntCollideEvent(2, new MoveForwardAction(0.05f))));
    		
			
//    		 ((Tank) tank).steerRight(new ANDEvent
//    				 (new LoopEvent(),new MovementDoesntCollideEvent(2, new MoveForwardAction(0.05f))));
		    
    		
    		
    		
    	
    }
    public void move2(){
    	
    }
    public void move3(){
    	
    }
    
}
