package de.tu_darmstadt.gdi1.tanks.states;

import de.tu_darmstadt.gdi1.tanks.ui.Tanks;
import eea.engine.action.Action;
import eea.engine.action.basicactions.*;
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

    private int stateID; 							
    private StateBasedEntityManager entityManager; 	
    private final int distance = 40;
    private final int start_Position = 240;

    public MainMenu(int id) {
        stateID = id;
        entityManager = StateBasedEntityManager.getInstance();
    }

    /**
     * Wird vor dem (erstmaligen) Starten dieses State's ausgefuehrt
     */
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
    	
        /* ---- Background Entity ---- */
        Entity background = new Entity("menu");
        background.setPosition(new Vector2f(400, 300));
        background.addComponent(new ImageRenderComponent(new Image("/assets/menu.png")));
        entityManager.addEntity(stateID, background);

        /* ---- New Game Button Entity ---- */
        String new_Game = "Neues Spiel starten";
        Entity new_Game_Entity = new Entity(new_Game);
        new_Game_Entity.setPosition(new Vector2f(700, 250));
        new_Game_Entity.setScale(0.15f);
        new_Game_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent mainEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action new_Game_Action = new ChangeStateInitAction(Tanks.GAME);
        new_Game_Entity.addComponent(mainEvents);
        mainEvents.addAction(new_Game_Action);
        entityManager.addEntity(this.stateID, new_Game_Entity);
        
        
        /* ---- Highscore Button Entity ---- */
        String highscore = "Highscore";
        Entity scoreEntity = new Entity(highscore);
        scoreEntity.setPosition(new Vector2f(700, 330));
        scoreEntity.setScale(0.15f);
        scoreEntity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent scoreEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action scoreAction = new ChangeStateInitAction(Tanks.HIGHSCORE);
        scoreEntity.addComponent(scoreEvents);
        scoreEvents.addAction(scoreAction);
        entityManager.addEntity(this.stateID, scoreEntity);
        
                
        /* ---- Control Button Entity ---- */
        Entity control_Entity = new Entity("Steuerung");
        control_Entity.setPosition(new Vector2f(700, 290));
        control_Entity.setScale(0.15f);
        control_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent controlEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action control_Action = new ChangeStateInitAction(Tanks.CONTROL);
        control_Entity.addComponent(controlEvents);
        controlEvents.addAction(control_Action);
        entityManager.addEntity(this.stateID, control_Entity);
        
        /* ---- About Button Entity ---- */
        Entity about_Entity = new Entity("About");
        about_Entity.setPosition(new Vector2f(700, 370));
        about_Entity.setScale(0.15f);
        about_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent aboutEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action about_Action = new ChangeStateInitAction(Tanks.ABOUT);
        about_Entity.addComponent(aboutEvents);
        aboutEvents.addAction(about_Action);
        entityManager.addEntity(this.stateID, about_Entity);
        

        /* ---- Quit Button Entity ---- */
        Entity quit_Entity = new Entity("Beenden");
        quit_Entity.setPosition(new Vector2f(700, 410));
        quit_Entity.setScale(0.15f);
        quit_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent mainEvents_q = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action quit_Action = new QuitAction();
        mainEvents_q.addAction(quit_Action);
        quit_Entity.addComponent(mainEvents_q);
        entityManager.addEntity(this.stateID, quit_Entity);
        
        
        /* ---- N Listener Entity ---- */
        Entity n_Listener = new Entity("N_Listener");
        KeyPressedEvent n_pressed = new KeyPressedEvent(Input.KEY_N);
        Action loadFirstLevel = new ChangeStateInitAction(Tanks.GAME);
        n_pressed.addAction(loadFirstLevel);
        n_Listener.addComponent(n_pressed);
        entityManager.addEntity(stateID, n_Listener);
        
        
        /* ---- Escape Listener Entity ---- */
        Entity esc_Listener = new Entity("ESC_Listener");
        KeyPressedEvent esc_pressed = new KeyPressedEvent (Input.KEY_ESCAPE);
        esc_pressed.addAction(new ChangeStateAction(Tanks.GAME));
        esc_Listener.addComponent(esc_pressed);
        entityManager.addEntity(stateID, esc_Listener);
        
        
        /* ---- S Listener Entity ---- */
        Entity s_Listener = new Entity("S_Listener");
        KeyPressedEvent s_pressed = new KeyPressedEvent(Input.KEY_S);
        Action s = new ChangeStateInitAction(Tanks.CONTROL);
        s_pressed.addAction(s);
        s_Listener.addComponent(s_pressed);
        entityManager.addEntity(stateID, s_Listener);
        
        /* ---- A Listener Entity ---- */
        Entity a_Listener = new Entity("A_Listener");
        KeyPressedEvent a_pressed = new KeyPressedEvent(Input.KEY_A);
        Action a = new ChangeStateInitAction(Tanks.ABOUT);
        a_pressed.addAction(a);
        a_Listener.addComponent(a_pressed);
        entityManager.addEntity(stateID, a_Listener);
        
        /* ---- H Listener Entity ---- */
        Entity h_Listener = new Entity("H_Listener");
        KeyPressedEvent h_pressed = new KeyPressedEvent(Input.KEY_H);
        Action h = new ChangeStateInitAction(Tanks.HIGHSCORE);
        h_pressed.addAction(h);
        h_Listener.addComponent(h_pressed);
        entityManager.addEntity(stateID, h_Listener);
        
        /* ---- Q Listener Entity ---- */
        Entity q_Listener = new Entity("Q_Listener");
        KeyPressedEvent q_pressed = new KeyPressedEvent(Input.KEY_Q);
        Action q = new QuitAction();
        q_pressed.addAction(q);
        q_Listener.addComponent(q_pressed);
        entityManager.addEntity(stateID, q_Listener);
        
        
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
        g.drawString("Neues Spiel [N]", 620, start_Position + counter * distance);
        counter++;
        g.drawString("Steuerung [S]", 620, start_Position + counter * distance);
        counter++;
        g.drawString("Highscore [H]", 620, start_Position + counter * distance);
        counter++;
        g.drawString("About [A]", 620, start_Position + counter * distance);
        counter++;
        g.drawString("Beenden [Q]", 620, start_Position + counter * distance);
        counter++;
    }

    @Override
    public int getID() {
        return stateID;
    }
}
