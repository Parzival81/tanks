package TankMain;

import Entity.*;
import Level.Level;
import eea.engine.action.basicactions.*;
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
    public String toString() {
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
        int i = 0;
        for (Tank opponents : gamelevel.getGameTankO()) {
            Tank opponentTank = gamelevel.getGameTankO()[i];
            try {
                opponentTank.setTexture("assets/tankBg/tankOppenent" + i + ".png");
            } catch (Exception e) {
                opponentTank.setTexture("assets/tankBg/tankOppenent0.png");
            }
            entityManager.addEntity(stateID, opponentTank);
            i++;
        }
        /* ---- Player Tank Entity ---- */
        Tank playerTank = gamelevel.getGameTankP();

        /* ---- Player Tank Controls --- */
        playerTank.steerForward(new KeyDownEvent(Input.KEY_UP));
        playerTank.steerBack(new KeyDownEvent(Input.KEY_DOWN));
        playerTank.steerRight(new KeyDownEvent(Input.KEY_RIGHT));
        playerTank.steerLeft(new KeyDownEvent(Input.KEY_LEFT));

        /* ---- Wall ---- */
        int j = 0;
        for (Wall wall : gamelevel.getGameWall()) {
            Wall wa = gamelevel.getGameWall()[j];
            entityManager.addEntity(stateID, wa);
            j++;
        }

        entityManager.addEntity(stateID, playerTank);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        entityManager.renderEntities(container, game, g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {

        /* --- Fire tank shot ---*/
        Input fireInput = container.getInput();

        if (fireInput.isKeyDown(Input.KEY_F)) {
            gamelevel.getGameTankP().fireShot();
            entityManager.addEntity(stateID, gamelevel.getGameTankP().getShot());
        }

        entityManager.updateEntities(container, game, delta);
    }

    @Override
    public int getID() {
        return stateID;
    }
}
