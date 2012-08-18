package de.tu_darmstadt.gdi1.tanks.states;

import de.tu_darmstadt.gdi1.tanks.ui.Tanks;
import eea.engine.action.Action;
import eea.engine.action.basicactions.ChangeStateAction;
import eea.engine.action.basicactions.ChangeStateInitAction;
import eea.engine.component.render.ImageRenderComponent;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;
import eea.engine.event.ANDEvent;
import eea.engine.event.basicevents.KeyPressedEvent;
import eea.engine.event.basicevents.MouseClickedEvent;
import eea.engine.event.basicevents.MouseEnteredEvent;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Highscore  extends BasicGameState{
    private int stateID;
    private StateBasedEntityManager entityManager;
    
    public Highscore(int id) {
        stateID = id;
        entityManager = StateBasedEntityManager.getInstance();

    }
    


    @Override
    public void init(GameContainer arg0, StateBasedGame arg1)
            throws SlickException {

        /* ---- Background Entity ---- */
        Entity background = new Entity("menu");
        background.setPosition(new Vector2f(400, 300));
        background.addComponent(new ImageRenderComponent(new Image("assets/ui/highscore_menu.png")));
        entityManager.addEntity(stateID, background);

        /* ---- Back Button Entity ---- */
        Entity backEntity = new Entity("Back");
        backEntity.setPosition(new Vector2f(145, 550));
        backEntity.setScale(0.15f);
        backEntity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent backEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action backAction = new ChangeStateInitAction(Tanks.MENU);
        backEntity.addComponent(backEvents);
        backEvents.addAction(backAction);
        entityManager.addEntity(this.stateID, backEntity);
        
        /* ---- Escape Listener ---- */
        Entity esc_Listener = new Entity("ESC_Listener");
        KeyPressedEvent esc_pressed = new KeyPressedEvent(Input.KEY_ESCAPE);
        esc_pressed.addAction(new ChangeStateAction(Tanks.MENU));
        esc_Listener.addComponent(esc_pressed);
        entityManager.addEntity(stateID, esc_Listener);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        entityManager.renderEntities(container, game, g);
        g.setColor(Color.black);
        g.drawString("Menu [ESC]", 105, 540);
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
