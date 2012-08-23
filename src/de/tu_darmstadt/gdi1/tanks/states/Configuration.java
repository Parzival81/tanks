package de.tu_darmstadt.gdi1.tanks.states;

import de.tu_darmstadt.gdi1.tanks.ui.Tanks;
import eea.engine.action.Action;
import eea.engine.action.basicactions.ChangeStateAction;
import eea.engine.action.basicactions.ChangeStateInitAction;
import eea.engine.component.Component;
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

/**
 * Configuration menu
 * 
 */
public class Configuration extends BasicGameState{
    private int stateID;
    private StateBasedEntityManager entityManager;
    
	   public Configuration(int id) {
	        stateID = id;
	        entityManager = StateBasedEntityManager.getInstance();
	    }
           
	    @Override
	    public void init(GameContainer container, StateBasedGame arg1)
	            throws SlickException {

	        /* ---- Background Entity ---- */
	        Entity background = new Entity("config-menu");
	        background.setPosition(new Vector2f(400, 300));
	        background.addComponent(new ImageRenderComponent(new Image("assets/ui/menu-config.png")));
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
	        
	        /* ---- Screen size Changer ---- */
	        Entity screen_Entity = new Entity("Screen");
	        screen_Entity.setPosition(new Vector2f(170, 160));
	        screen_Entity.setScale(0.15f);
	        screen_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
	        ANDEvent screenEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
	        Action screen_Action = new Action(){
				@Override
				public void update(GameContainer gc, StateBasedGame sb,
						int delta, Component event) {
					if (gc.isFullscreen()){
						try {
							gc.setFullscreen(false);
						} catch (SlickException e) {
							e.printStackTrace();
						}
					}else{
						try {
							gc.setFullscreen(true);
						} catch (SlickException e) {
							e.printStackTrace();
						}
					}	
				}
	        };
	        screen_Entity.addComponent(screenEvents);
	        screenEvents.addAction(screen_Action);
	        entityManager.addEntity(this.stateID, screen_Entity);
	        
	        /* ---- Music Volume Plus ---- */
	        Entity mvp_Entity = new Entity("Screen");
	        mvp_Entity.setPosition(new Vector2f(82, 190));
	        mvp_Entity.setScale(0.1f);
	        mvp_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry2.png")));
	        ANDEvent mvpEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
	        Action mvp_Action = new Action(){
				@Override
				public void update(GameContainer gc, StateBasedGame sb,
						int delta, Component event) {
					gc.setMusicVolume(gc.getMusicVolume() + 1);
				}
	        };
	        mvp_Entity.addComponent(mvpEvents);
	        mvpEvents.addAction(mvp_Action);
	        entityManager.addEntity(this.stateID, mvp_Entity);
	        
	        /* ---- Music Volume Minus ---- */
	        Entity mvm_Entity = new Entity("Screen");
	        mvm_Entity.setPosition(new Vector2f(100, 190));
	        mvm_Entity.setScale(0.1f);
	        mvm_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry2.png")));
	        ANDEvent mvmEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
	        Action mvm_Action = new Action(){
				@Override
				public void update(GameContainer gc, StateBasedGame sb,
						int delta, Component event) {
					gc.setMusicVolume(gc.getMusicVolume() - 1);
				}
	        };
	        mvm_Entity.addComponent(mvmEvents);
	        mvmEvents.addAction(mvm_Action);
	        entityManager.addEntity(this.stateID, mvm_Entity);
	        
	        /* ---- Sound Volume Plus ---- */
	        Entity svp_Entity = new Entity("Screen");
	        svp_Entity.setPosition(new Vector2f(82, 220));
	        svp_Entity.setScale(0.1f);
	        svp_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry2.png")));
	        ANDEvent svpEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
	        Action svp_Action = new Action(){
				@Override
				public void update(GameContainer gc, StateBasedGame sb,
						int delta, Component event) {
					gc.setSoundVolume(gc.getSoundVolume() + 1);
				}
	        };
	        svp_Entity.addComponent(svpEvents);
	        svpEvents.addAction(svp_Action);
	        entityManager.addEntity(this.stateID, svp_Entity);
	        
	        /* ---- Sound Volume Minus ---- */
	        Entity svm_Entity = new Entity("Screen");
	        svm_Entity.setPosition(new Vector2f(100, 220));
	        svm_Entity.setScale(0.1f);
	        svm_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry2.png")));
	        ANDEvent svmEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
	        Action svm_Action = new Action(){
				@Override
				public void update(GameContainer gc, StateBasedGame sb,
						int delta, Component event) {
					gc.setSoundVolume(gc.getSoundVolume() - 1);
				}
	        };
	        svm_Entity.addComponent(svmEvents);
	        svmEvents.addAction(svm_Action);
	        entityManager.addEntity(this.stateID, svm_Entity);
	    }

	    @Override
	    public void render(GameContainer container, StateBasedGame game, Graphics g)
	            throws SlickException {
	        entityManager.renderEntities(container, game, g);
	        int counter = 0;
	        
	        String screen;
	        if (container.isFullscreen()){
	        	screen = "Vollbild";
	        }else{
	        	screen = "Fenster";
	        }        
   
	        g.setColor(Color.black);
	        g.drawString("Menu [ESC]", 105, 540);
	        
	        
	        g.setColor(Color.white);
	        g.drawString("+", 77, 180);
	        g.drawString("-", 95, 180);
	        
	        g.drawString("+", 77, 210);
	        g.drawString("-", 95, 210);
	        
	        g.drawString("Bildschirm: " + screen, 80, 150 + 30 * counter);
	        counter++;
	        g.drawString("Musicvolume: " + container.getMusicVolume(), 120, 150 + 30 * counter);
	        counter++;
	        g.drawString("Soundvolume: " + container.getSoundVolume(), 120, 150 + 30 * counter);
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


