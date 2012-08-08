package TankMain;

import eea.engine.action.Action;
import eea.engine.action.basicactions.*;
import eea.engine.component.Component;
import eea.engine.component.render.*;
import eea.engine.entity.*;
import eea.engine.event.*;
import eea.engine.event.basicevents.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {

    private int stateID; 							// Identifier von diesem BasicGameState
    private StateBasedEntityManager entityManager; 	// zugehoeriger entityManager
    private final int distance = 40;
    private final int start_Position = 240;

    MainMenu(int id) {
        stateID = id;
        entityManager = StateBasedEntityManager.getInstance();
    }

    /**
     * Wird vor dem (erstmaligen) Starten dieses State's ausgefuehrt
     */
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        // Hintergrund
        Entity background = new Entity("menu");
        background.setPosition(new Vector2f(400, 300));
        background.addComponent(new ImageRenderComponent(new Image("/assets/menu.png")));
        entityManager.addEntity(stateID, background);

        // New Game
        String new_Game = "Neues Spiel starten";
        Entity new_Game_Entity = new Entity(new_Game);
        new_Game_Entity.setPosition(new Vector2f(700, 250));
        new_Game_Entity.setScale(0.15f);
        new_Game_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));

        // Erstelle das Ausloese-Event und die zugehoerige Action
        ANDEvent mainEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action new_Game_Action = new ChangeStateInitAction(Launch.GAME);

        new_Game_Entity.addComponent(mainEvents);

        mainEvents.addAction(new_Game_Action);



        // Fuege die Entity zum StateBasedEntityManager hinzu
        entityManager.addEntity(this.stateID, new_Game_Entity);

        // Beenden
        Entity quit_Entity = new Entity("Beenden");
        quit_Entity.setPosition(new Vector2f(700, 290));
        quit_Entity.setScale(0.15f);
        quit_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));

        // Erstelle das Ausloese-Event und die zugehoerige Action
        ANDEvent mainEvents_q = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action quit_Action = new QuitAction();
        mainEvents_q.addAction(quit_Action);
        quit_Entity.addComponent(mainEvents_q);

        // Fuege die Entity zum StateBasedEntityManager hinzu
        entityManager.addEntity(this.stateID, quit_Entity);
        
        
        //N Taste fuer "Neues Spiel"
        Entity n_Listener = new Entity("N_Listener");
        KeyPressedEvent n_pressed = new KeyPressedEvent(Input.KEY_N);
        Action loadFirstLevel = new Action(){

			@Override
			public void update(GameContainer arg0, StateBasedGame arg1,
					int arg2, Component arg3) {
				//TODO level muss auf "maps/map00.tanks" gesetzt werden; Zugang zu Attributen der Klasse Game noch unbekannt
			}
        	
        };
        n_pressed.addAction(loadFirstLevel);
        n_pressed.addAction(new ChangeStateAction(Launch.GAME));
        n_Listener.addComponent(n_pressed);
        entityManager.addEntity(stateID, n_Listener);
        
        //ESC taste fuer "back to game"
        Entity esc_Listener = new Entity("ESC_Listener");
        KeyPressedEvent esc_pressed = new KeyPressedEvent (Input.KEY_ESCAPE);
        esc_pressed.addAction(new ChangeStateAction(Launch.GAME));
        esc_Listener.addComponent(esc_pressed);
        entityManager.addEntity(stateID, esc_Listener);

    }

    /**
     * Wird vor dem Frame ausgefuehrt
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        entityManager.updateEntities(container, game, delta);
    }

    /**
     * Wird mit dem Frame ausgefuehrt
     */
    @Override
    public void render(GameContainer container, StateBasedGame game,
            Graphics g) throws SlickException {
        entityManager.renderEntities(container, game, g);

        int counter = 0;
        g.setColor(Color.black);
        g.drawString("Neues Spiel", 620, start_Position + counter * distance);
        counter++;
        g.drawString("Beenden", 620, start_Position + counter * distance);
        counter++;
    }

    @Override
    public int getID() {
        return stateID;
    }
}
