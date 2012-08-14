package TankMain;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import eea.engine.action.Action;
import eea.engine.action.basicactions.ChangeStateInitAction;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;
import eea.engine.event.ANDEvent;
import eea.engine.event.basicevents.MouseClickedEvent;
import eea.engine.event.basicevents.MouseEnteredEvent;

public class Control  extends BasicGameState{
    private int stateID; 							// Identifier von diesem BasicGameState
    private StateBasedEntityManager entityManager; 	// zugehoeriger entityManager
    
    
	public Control(int id){
        stateID = id;
        entityManager = StateBasedEntityManager.getInstance();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
        /* ---- Background Entity ---- */
        Entity background = new Entity("menu");
        background.setPosition(new Vector2f(400, 300));
        background.addComponent(new ImageRenderComponent(new Image("/assets/menu-control.png")));
        entityManager.addEntity(stateID, background);
        
        /* ---- Back Button Entity ---- */
        Entity backEntity = new Entity("Back");
        backEntity.setPosition(new Vector2f(145, 550));
        backEntity.setScale(0.15f);
        backEntity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent backEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action backAction = new ChangeStateInitAction(Launch.MENU);
        backEntity.addComponent(backEvents);
        backEvents.addAction(backAction);
        entityManager.addEntity(this.stateID, backEntity);

        
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		entityManager.renderEntities(arg0, arg1, g);
        g.setColor(Color.black);
        g.drawString("Menu", 125, 540);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		entityManager.updateEntities(arg0, arg1, arg2);
		
	}

	@Override
	public int getID() {
		return stateID;
	}
}
