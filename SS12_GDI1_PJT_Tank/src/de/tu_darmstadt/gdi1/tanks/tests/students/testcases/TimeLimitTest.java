package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterExtended2;

public class TimeLimitTest {

	TanksTestAdapterExtended2  adapter;
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterExtended2();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public void testTimeLimit() {
		
		// initialize the game in MAINMENUSTATE
		adapter.initializeGame();
		adapter.loadMapFromFile(new File("testmaps/extended2/limitedTime"));
		assertTrue("A correct level was detected as incorrect", adapter.isCorrectMap());
		assertTrue("The game has not been started in MAINMENUSTATE, current state id = "+adapter.getStateBasedGame().getCurrentStateID(), 
				0 == adapter.getStateBasedGame().getCurrentStateID());
		
		// go into GAMEPLAYSTATE
		adapter.handleKeyPressN();
		assertTrue("The game is not in GAMEPLAYSTATE, current state id = "+adapter.getStateBasedGame().getCurrentStateID(), 
				2 == adapter.getStateBasedGame().getCurrentStateID());
		
		adapter.runGame(1);
		assertTrue("The game is not in MAINMENUSTATE, current state id = "+adapter.getStateBasedGame().getCurrentStateID(), 
				0 == adapter.getStateBasedGame().getCurrentStateID());
		
	}
	
}
