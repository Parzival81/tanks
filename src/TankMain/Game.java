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
    // Die Paths werden hier eingebunden
    // The current map. Should be set via a GUI
    private String currentMap = "maps/BattleOfTheSeelowHeights.tanks";

    public Game(int id) {
        stateID = id;
        entityManager = StateBasedEntityManager.getInstance();

    }
    
    public String toString(){
    	return gamelevel.toString();
    }

    @Override
    public void init(GameContainer arg0, StateBasedGame arg1)
            throws SlickException {
        // EINLESEN VON DATEI
        // Hier wird eine Karte eingelesen und alle Attribute die fuer die
        // Darstellung der
        // Karte gebraucht werden, werden hier gesetzt.
        DataReader dr = new DataReader(currentMap);
        gamelevel = dr.getLevel();
        
        // DARSTELLUNG (DISPLAY)
        // Hier werden alle Attribute auf dem Bildschirm dargestellt

        // Hintergrund
        Entity background = new Entity("menu");
        background.setPosition(new Vector2f(400, 300));
        background.addComponent(new ImageRenderComponent(new Image(gamelevel
                .getGameMap().getBackground())));
        entityManager.addEntity(stateID, background);

        // Escape Taste
        Entity esc_Listener = new Entity("ESC_Listener");
        KeyPressedEvent esc_pressed = new KeyPressedEvent(Input.KEY_ESCAPE);
        esc_pressed.addAction(new ChangeStateAction(Launch.MENU));
        esc_Listener.addComponent(esc_pressed);
        entityManager.addEntity(stateID, esc_Listener);

        for (Tank opponents: gamelevel.getGameTankO()){
        	Tank opponentTank = new Tank(
                    opponents.getName(),
                    opponents.getMaxLife(),
                    opponents.getLife(),
                    opponents.getMaxShot(),
                    opponents.getShot(),
                    opponents.getMaxMine(),
                    opponents.getMine(),
                    opponents.getStrength(),
                    opponents.getSpeed(),
                    opponents.getRotation(),
                    opponents.getScale(),
                    opponents.getX(),
                    opponents.getY()
        			
        			);

            entityManager.addEntity(stateID, opponentTank.getTank());
        }
        
        // Create a new tank object
        // TODO pass all data to the constructor
        Tank PlayerTank = new Tank(
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
        
        

        // TankPlayer controlls
        // Pass the event listners to the tank obejct
        PlayerTank.steerForward(new KeyDownEvent(Input.KEY_UP));
        PlayerTank.steerBack(new KeyDownEvent(Input.KEY_DOWN));
        PlayerTank.steerRight(new KeyDownEvent(Input.KEY_RIGHT));
        PlayerTank.steerLeft(new KeyDownEvent(Input.KEY_LEFT));

        entityManager.addEntity(stateID, PlayerTank.getTank());
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

        // alle Entities werden gerendert
        entityManager.renderEntities(container, game, g);

        // g.drawImage(new Image(playerTank), gamelevel.getGameTankP().getX(),
        // gamelevel.getGameTankP().getY());

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {

        // alle Entities werden geupdated
        entityManager.updateEntities(container, game, delta);
    }

    @Override
    public int getID() {
        return stateID;
    }
}
