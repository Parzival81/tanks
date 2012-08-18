package States;

import Components.DataReader;
import Entity.*;
import Level.Level;
import TankMain.Launch;
import eea.engine.action.basicactions.*;
import eea.engine.component.render.*;
import eea.engine.entity.*;
import eea.engine.event.ANDEvent;
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
        // playerTank.addComponent(new CollisionEvent().addAction(new DestroyEntityAction()));

        /* ---- Player Tank Controls --- */
        playerTank.steerForward(new ANDEvent(new KeyDownEvent(Input.KEY_UP), new MovementDoesntCollideEvent(2, new MoveForwardAction(0.05f))));
        playerTank.steerBack(new ANDEvent(new KeyDownEvent(Input.KEY_DOWN), new MovementDoesntCollideEvent(2, new MoveBackwardAction(0.05f))));
        playerTank.steerRight(new ANDEvent(new KeyDownEvent(Input.KEY_RIGHT), new MovementDoesntCollideEvent(2, new RotateRightAction(0.1f))));
        playerTank.steerLeft(new ANDEvent(new KeyDownEvent(Input.KEY_LEFT), new MovementDoesntCollideEvent(2, new RotateLeftAction(0.1f))));
        entityManager.addEntity(stateID, playerTank);

        /* ---- Wall ---- */
        for (Wall wall : gamelevel.getGameWall()) {
            entityManager.addEntity(stateID, wall);
        }

        /* ---- Border ---- */
//        for (Border border : gamelevel.getGameBorder()){
//        	entityManager.addEntity(stateID, border);
//        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        entityManager.renderEntities(container, game, g);


        /* ----- PlayerTank Information On-Screen -----*/
        g.drawImage(new Image("assets/entry.png"), 0, 500);
        g.setColor(Color.black);
        g.drawString("Lebenspunkte: " + gamelevel.getGameTankP().getLife() + " / " + gamelevel.getGameTankP().getMaxLife(), 10, 510);
        g.drawString("Schuesse: " + gamelevel.getGameTankP().getShot() + " / " + gamelevel.getGameTankP().getMaxShot(), 10, 530);
        g.drawString("Mine: " + gamelevel.getGameTankP().getMine() + " / " + gamelevel.getGameTankP().getMaxMine(), 10, 550);
        g.drawString("Power: " + gamelevel.getGameTankP().getStrength(), 10, 570);


        g.drawString("Map: " + gamelevel.getGameMap().getActualmap(), 450, 510);
        g.drawString("Anzahl der Gegner: " + gamelevel.getGameTankO().length, 450, 530);
        g.drawString("Verbleibende Zeit: " + gamelevel.getGameMap().getElapsedTime() + " / " + gamelevel.getGameMap().getMaxduration(), 450, 550);
        g.drawString("Position: " + entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getPosition().getX()
                + " / " + entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getPosition().getY(), 450, 570);



    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {

        /* --- Fire tank shot ---*/
        Input fireInput = container.getInput();

        if (fireInput.isKeyPressed(Input.KEY_F)) {
            /* ---- Get the current positon of the tank form the StateBasedEntityManager ---- */
            gamelevel.getGameTankP().fireShot(
                    entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getPosition(),
                    entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getRotation());
            entityManager.addEntity(stateID, gamelevel.getGameTankP().getTankShot());
        }

        /* ---- Destory the shot when it hits something ---- */
//        DestroyEntityAction dea = new DestroyEntityAction();
//        CollisionEvent ce = new CollisionEvent();
//        ce.addAction(dea);
//        entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).addComponent(ce);

        entityManager.updateEntities(container, game, delta);




    }

    @Override
    public int getID() {
        return stateID;
    }
}
