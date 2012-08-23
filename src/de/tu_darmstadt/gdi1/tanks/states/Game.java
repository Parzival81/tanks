package de.tu_darmstadt.gdi1.tanks.states;

import de.tu_darmstadt.gdi1.tanks.components.AiBasic;
import de.tu_darmstadt.gdi1.tanks.components.DataReader;
import de.tu_darmstadt.gdi1.tanks.entity.Border;
import de.tu_darmstadt.gdi1.tanks.entity.Mine;
import de.tu_darmstadt.gdi1.tanks.entity.Tank;
import de.tu_darmstadt.gdi1.tanks.entity.Wall;
import de.tu_darmstadt.gdi1.tanks.level.Level;
import de.tu_darmstadt.gdi1.tanks.ui.Tanks;
import eea.engine.action.Action;
import eea.engine.action.basicactions.*;
import eea.engine.component.Component;
import eea.engine.component.render.*;
import eea.engine.entity.*;
import eea.engine.event.ANDEvent;
import eea.engine.event.basicevents.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import javax.swing.JOptionPane;
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
 * The game state. Represents the actual game tanks
 *
 */
public class Game extends BasicGameState {

    private int stateID;
    public static StateBasedEntityManager entityManager;
    public static Level gamelevel;
    // The current map. Should be set via a GUI
    public static String currentMap;

    public Game(int id) {
        stateID = id;
        entityManager = StateBasedEntityManager.getInstance();
        currentMap = "maps/BattleOfTheSeelowHeights.tanks";
    }

    /* ---- toString method ---- */
    public String toString() {
        return gamelevel.toString();
    }

    /* ---- Getter + Setter for currentMap ---- */
    public String getCurrentMap() {
        return currentMap;
    }

    /* ---- Set the next map ---- */
    public static void setCurrentMap(String currentMap2) {
        currentMap = currentMap2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame arg1)
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
        esc_pressed.addAction(new ChangeStateAction(Tanks.MENU));
        esc_Listener.addComponent(esc_pressed);
        entityManager.addEntity(stateID, esc_Listener);

        /* ---- Opponents Entity ---- */
        int i = 0;
        for (Tank opponents : gamelevel.getGameTankO()) {
            try {
                opponents.setTexture("assets/tankBg/tankOppenent" + i + ".png");
            } catch (Exception e) {
                opponents.setTexture("assets/tankBg/tankOppenent0.png");
            }
            entityManager.addEntity(stateID, opponents);
            i++;
        }
        /* ---- Player Tank Entity ---- */
        Tank playerTank = gamelevel.getGameTankP();

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
        for (Border border : gamelevel.getGameBorder()) {
            entityManager.addEntity(stateID, border);
        }

        /* ---- Adding AI ---- */
        for (Tank tank : gamelevel.getGameTankO()) {
            AiBasic ab = new AiBasic(tank, 1);
        }
        
        /* ---- Add mine ---- */
        for (Mine mine : gamelevel.getGameMine()) {
             entityManager.addEntity(stateID, mine);
        }

        /* ---- Quicksave ---- */
        Entity save_Game_Entity = new Entity("Spiel speichern");
        save_Game_Entity.setPosition(new Vector2f(700, 20));
        save_Game_Entity.setScale(0.15f);
        save_Game_Entity.addComponent(new ImageRenderComponent(new Image("assets/entry.png")));
        ANDEvent saveEvents = new ANDEvent(new MouseEnteredEvent(), new MouseClickedEvent());
        Action save_Game_Action = new Action() {
            @Override
            public void update(GameContainer gc, StateBasedGame sb,
                    int delta, Component event) {

                try {
                    File save = new File("save/" + "quicksave.tank");
                    BufferedReader br = new BufferedReader(new StringReader(gamelevel.toString()));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(save));
                    String line = br.readLine();
                    while (line != null) {
                        bw.write(line);
                        bw.newLine();
                        line = br.readLine();
                    }
                    bw.close();
                    if (!gc.isPaused()) {
                        gc.pause();
                    }
                    JOptionPane.showMessageDialog(null, "Spielstand erfolgreich gespeichert!");
                } catch (Exception e) {
                }
            }
        };
        save_Game_Entity.addComponent(saveEvents);
        saveEvents.addAction(save_Game_Action);
        entityManager.addEntity(this.stateID, save_Game_Entity);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

        entityManager.renderEntities(container, game, g);

        g.drawString("Schnellspeichern", 630, 10);

        if (container.isPaused()) {
            g.fillRect(0, 250, 800, 60);
            g.setColor(Color.white);
            g.drawString("PAUSE", 370, 270);
        }

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
        /* ---- catch if the player tank has been destroyed ---- */
        if (entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()) != null) {
            g.drawString("Position: " + entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getPosition().getX()
                    + " / " + entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getPosition().getY(), 450, 570);
        } else {
            g.drawString("Position: Destroyed", 450, 570);
        }

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
        if (gamelevel.getGameTankO().length == 0) {
            JOptionPane.showMessageDialog(null, "Sie haben alle Gegner erfolgreich vernichtet!");
            game.enterState(Tanks.MENU);
        } else if (gamelevel.getGameTankP().getLife() <= 0) {
            JOptionPane.showMessageDialog(null, "Sie wurden vernichtet!");
            game.enterState(Tanks.MENU);
        }

        /* --- Fire tank shot ---*/
        if (container.getInput().isKeyPressed(Input.KEY_F)) {
            /* ---- Get the current positon of the tank form the StateBasedEntityManager ---- */
            gamelevel.getGameTankP().fireShot(
                    entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getPosition(),
                    entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getRotation());
            entityManager.addEntity(stateID, gamelevel.getGameTankP().getTankShot());
        }
        
        /* ---- lay a mine ---- */
        if (container.getInput().isKeyPressed(Input.KEY_M)) {
            /* ---- Get the current positon of the tank form the StateBasedEntityManager ---- */
            gamelevel.getGameTankP().layMine(
                    entityManager.getEntity(stateID, gamelevel.getGameTankP().getName()).getPosition());
            entityManager.addEntity(stateID, gamelevel.getGameTankP().getTankMine());
        }
        
        /* ---- Pause game ---- */
        if (container.getInput().isKeyPressed(Input.KEY_P)) {
            if (container.isPaused()) {
                container.resume();
            } else {
                container.pause();
            }
        }

        entityManager.updateEntities(container, game, delta);

    }

    @Override
    public int getID() {
        return stateID;
    }
}
