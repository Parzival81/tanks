package TankMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Elements.*;


import eea.engine.action.Action;
import eea.engine.action.basicactions.*;
import eea.engine.component.render.*;
import eea.engine.entity.*;
import eea.engine.event.*;
import eea.engine.event.basicevents.*;

public class Game extends BasicGameState{
	
	private int stateID; 						
	private StateBasedEntityManager entityManager;
	private Level gamelevel;
	private String path = "/assets/sandTexture.jpg";
	
	public Game(int id){
		stateID = id;
		entityManager = StateBasedEntityManager.getInstance();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// EINLESEN VON DATEI
		// Hier wird eine Karte eingelesen und alle Attribute die fuer die Darstellung der
		// Karte gebraucht werden, werden hier gesetzt.
		try {
    		BufferedReader br = new BufferedReader(new FileReader("maps/map00"));
    		String line;
    		while ((line = br.readLine()) != null) {
    			if (line.contains("Map")){
    				LinkedList <String> ll = new LinkedList<String>();
    				for (int i=0; i < line.length();i++){
    						StringBuffer sb = new StringBuffer();
    						while (i < line.length() && line.charAt(i) != ' '){
    							sb.append(line.charAt(i));
    							i++;
    						}
    						ll.add(sb.toString());    					
    				}
    				System.out.println(ll.toString());
    				Map m = new Map (ll.get(1), ll.get(2), ll.get(3), 
    						Integer.valueOf(ll.get(4)), Integer.valueOf(ll.get(5)), Integer.valueOf(ll.get(6)));
    				
    				
    			}else if (line.contains("Border")){
    				System.out.println(line);
    			}else if (line.contains("Tank")){
    				System.out.println(line);
    			}else if (line.contains("Wall")){
    				System.out.println(line);
    			}else if (line.contains("Shot")){
    				System.out.println(line);
    			}else if (line.contains("Pickup")){
    				System.out.println(line);
    			}else if (line.contains("Border")){
    				System.out.println(line);
    			}
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		
		
		// DARSTELLUNG (DISPLAY)
		// Hier werden alle Attribute auf dem Bildschirm dargestellt
		
		
		
		//Hintergrund
    	Entity background = new Entity("menu");	
    	background.setPosition(new Vector2f(400,300));
    	background.addComponent(new ImageRenderComponent(new Image(path)));    	    	
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
