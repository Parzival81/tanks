package TankMain;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


import eea.engine.action.Action;
import eea.engine.action.basicactions.*;
import eea.engine.component.render.*;
import eea.engine.entity.*;
import eea.engine.event.*;
import eea.engine.event.basicevents.*;

public class Game extends BasicGameState{
	
	private int stateID; 						
	private StateBasedEntityManager entityManager;
	
	public Game(int id){
		stateID = id;
		entityManager = StateBasedEntityManager.getInstance();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		//Hintergrund
    	Entity background = new Entity("menu");	
    	background.setPosition(new Vector2f(400,300));
    	background.addComponent(new ImageRenderComponent(new Image("/assets/expl01.png")));    	    	
    	entityManager.addEntity(stateID, background);
    	
    	//Escape Taste
    	Entity esc_Listener = new Entity("ESC_Listener");
    	KeyPressedEvent esc_pressed = new KeyPressedEvent(Input.KEY_ESCAPE);
    	esc_pressed.addAction(new ChangeStateAction(Launch.MENU));
    	esc_Listener.addComponent(esc_pressed);    	
    	entityManager.addEntity(stateID, esc_Listener);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		entityManager.renderEntities(container, game, g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		entityManager.updateEntities(container, game, delta);
		
	}

	@Override
	public int getID() {
		return stateID;
	}
	
}
