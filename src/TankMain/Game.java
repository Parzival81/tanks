package TankMain;

import Elements.*;
import eea.engine.action.Action;
import eea.engine.action.basicactions.*;
import eea.engine.component.Component;
import eea.engine.component.render.*;
import eea.engine.entity.*;
import eea.engine.event.basicevents.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

    private int stateID;
    private StateBasedEntityManager entityManager;
    private Level gamelevel;

    // The current map. Should be set via a GUI
    private String currentMap = "maps/BattleOfTheSeelowHeights.tanks";

    public Game(int id) {
        stateID = id;
        entityManager = StateBasedEntityManager.getInstance();

    }
    
    /* ---- toString method ---- */
    public String toString(){
    	return gamelevel.toString();
    }
    
    
    /* ---- Getter + Setter for currentMap ---- */
	public String getCurrentMap() {
		return currentMap;
	}
	public void setCurrentMap(String currentMap) {
		this.currentMap = currentMap;
	}

	@Override
    public void init(GameContainer arg0, StateBasedGame arg1)
            throws SlickException {
		
        // DataReader reads a data and converts the String into a level object
        DataReader dr = new DataReader(currentMap);
        gamelevel = dr.getLevel();


        /* ---- Background Entity ---- */
        Entity background = new Entity("menu");
        background.setPosition(new Vector2f(400, 300));
        background.addComponent(new ImageRenderComponent(new Image(gamelevel
                .getGameMap().getBackground())));
        entityManager.addEntity(stateID, background);

        /* ---- Escape Listener ---- */
        Entity esc_Listener = new Entity("ESC_Listener");
        KeyPressedEvent esc_pressed = new KeyPressedEvent(Input.KEY_ESCAPE);
        esc_pressed.addAction(new ChangeStateAction(Launch.MENU));
        esc_Listener.addComponent(esc_pressed);
        entityManager.addEntity(stateID, esc_Listener);

        /* ---- Opponents Entity ---- */
        for (Tank opponents: gamelevel.getGameTankO()){
        	Tank opponentTank = new Tank(
                    opponents.getName(),opponents.getMaxLife(),opponents.getLife(),opponents.getMaxShot(),
                    opponents.getShot(),opponents.getMaxMine(),opponents.getMine(),opponents.getStrength(),
                    opponents.getSpeed(),opponents.getRotation(),opponents.getScale(),opponents.getX(),
                    opponents.getY()
        			);
            opponentTank.setTexture("assets/tankBg/tankOppenent.png");
            entityManager.addEntity(stateID, opponentTank.getTank());
        }

        /* ---- Player Tank Entity ---- */
        Tank playerTank = new Tank(
                gamelevel.getGameTankP().getName(),
                gamelevel.getGameTankP().getMaxLife(),
                gamelevel.getGameTankP().getLife(),
                gamelevel.getGameTankP().getMaxShot(),
                gamelevel.getGameTankP().getShot(),
                gamelevel.getGameTankP().getMaxMine(),
                gamelevel.getGameTankP().getMine(),
                gamelevel.getGameTankP().getStrength(),
                gamelevel.getGameTankP().getSpeed(),
                gamelevel.getGameTankP().getRotation(),
                gamelevel.getGameTankP().getScale(),
                gamelevel.getGameTankP().getX(),
                gamelevel.getGameTankP().getY());
        
        		// controls
		        playerTank.steerForward(new KeyDownEvent(Input.KEY_UP));
		        playerTank.steerBack(new KeyDownEvent(Input.KEY_DOWN));
		        playerTank.steerRight(new KeyDownEvent(Input.KEY_RIGHT));
		        playerTank.steerLeft(new KeyDownEvent(Input.KEY_LEFT));

        entityManager.addEntity(stateID, playerTank.getTank());
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
