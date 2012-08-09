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
	private String playerTankImage = "assets/tankPlayer.png";
    // The current map. Should be set via a GUI
    private String currentMap = "maps/BattleOfTheSeelowHeights.tanks";

	public Game(int id) {
		stateID = id;
		entityManager = StateBasedEntityManager.getInstance();

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

		// Tankdarstellung
		Entity tank = new Entity("playerTank");
		tank.addComponent(new ImageRenderComponent(new Image(playerTankImage)));
		tank.setScale(0.3f);
		tank.setPosition(new Vector2f(400, 320));

		// Steuerung
		KeyDownEvent down_pressed = new KeyDownEvent(Input.KEY_DOWN);
		down_pressed.addAction(new Action() {
			@Override
			public void update(GameContainer arg0, StateBasedGame arg1,
					int arg2, Component arg3) {
				gamelevel.getGameTankP().setY(
						gamelevel.getGameTankP().getY() - 1);
				System.out.println("Tank Y-coordinate: "
						+ gamelevel.getGameTankP().getY()
						+ " Tank X-coordinate: "
						+ gamelevel.getGameTankP().getX());
			}
		});

		down_pressed.addAction(new MoveDownAction(0.05f));

		KeyDownEvent up_pressed = new KeyDownEvent(Input.KEY_UP);
		up_pressed.addAction(new Action() {
			@Override
			public void update(GameContainer arg0, StateBasedGame arg1,
					int arg2, Component arg3) {
				gamelevel.getGameTankP().setY(
						gamelevel.getGameTankP().getY() + 1);
				System.out.println("Tank Y-coordinate: "
						+ gamelevel.getGameTankP().getY()
						+ " Tank X-coordinate: "
						+ gamelevel.getGameTankP().getX());
			}
		});
		up_pressed.addAction(new MoveUpAction(0.1f));

		KeyDownEvent right_pressed = new KeyDownEvent(Input.KEY_RIGHT);
		right_pressed.addAction(new Action() {
			@Override
			public void update(GameContainer arg0, StateBasedGame arg1,
					int arg2, Component arg3) {
				gamelevel.getGameTankP().setX(
						gamelevel.getGameTankP().getX() + 1);
				System.out.println("Tank Y-coordinate: "
						+ gamelevel.getGameTankP().getY()
						+ " Tank X-coordinate: "
						+ gamelevel.getGameTankP().getX());
			}
		});
		right_pressed.addAction(new RotateRightAction(0.1f));

		KeyDownEvent left_pressed = new KeyDownEvent(Input.KEY_LEFT);
		left_pressed.addAction(new Action() {
			@Override
			public void update(GameContainer arg0, StateBasedGame arg1,
					int arg2, Component arg3) {
				gamelevel.getGameTankP().setX(
						gamelevel.getGameTankP().getX() - 1);
				System.out.println("Tank Y-coordinate: "
						+ gamelevel.getGameTankP().getY()
						+ " Tank X-coordinate: "
						+ gamelevel.getGameTankP().getX());
			}
		});
		left_pressed.addAction(new RotateLeftAction(0.1f));

		tank.addComponent(down_pressed);
		tank.addComponent(up_pressed);
		tank.addComponent(right_pressed);
		tank.addComponent(left_pressed);

		entityManager.addEntity(stateID, tank);

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
