package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.model.exceptions.SemanticException;
import de.tu_darmstadt.gdi1.tanks.model.exceptions.SyntaxException;
import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterExtended1;
import de.tu_darmstadt.gdi1.tanks.ui.Tanks;

public class SaveGameTest {

	TanksTestAdapterExtended1 adapter;
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterExtended1();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public final void testSaveGame() {
		
		// initialize the game in MAINMENUSTATE
		adapter.initializeGame();
		
		// load the testmap for testing 'save a game'
		try {
			adapter.loadMapFromFileWithExceptions(new File("testmaps/extended1/correcte1"));
		} catch (SyntaxException e1) {
			assertTrue("The loaded map does not have syntax errors, your parser seems to be buggy", false);
		} catch (SemanticException e1) {
			assertTrue("The loaded map does not have semantic errors, your parser seems to be buggy", false);
		}
		
		assertTrue("The game has not been started in MAINMENUSTATE, current state id = "+adapter.getStateBasedGame().getCurrentStateID(), 
				Tanks.MAINMENUSTATE == adapter.getStateBasedGame().getCurrentStateID());

		// go into GAMEPLAYSTATE
		adapter.handleKeyPressN();
		assertTrue("The game is not in GAMEPLAYSTATE, current state id = "+adapter.getStateBasedGame().getCurrentStateID(), 
				Tanks.GAMEPLAYSTATE == adapter.getStateBasedGame().getCurrentStateID());
		
		String original = adapter.getStringRepresentationOfMap();
		
		// go into MENU
		adapter.handleKeyPressEscape();
		assertTrue("The state has not been changed. The game is in GAMEPLAYSTATE!"+adapter.getStateBasedGame().getCurrentStateID(), 
				Tanks.GAMEPLAYSTATE != adapter.getStateBasedGame().getCurrentStateID());
		
		// save the game into the file 'saves/autosave.tanks'
		adapter.handleKeyPressS();
		
		try {
			// load file autosave.tanks in folder saves
			// get current String representation
			File f = new File("saves/autosave.tanks");
			adapter.loadMapFromFileWithExceptions(f);
			String current = adapter.getStringRepresentationOfMap();
			
			assertEquals("saved output is not equal, ", current, original);
			
			// delete file
			f.delete();
			
		} catch(NullPointerException e) {
			assertTrue("No file /saves/autosave.tanks created!", false);
		} catch (SyntaxException e) {
			assertTrue("Your saved map was saved with syntax errors or not parsed correctly", false);
		} catch (SemanticException e) {
			assertTrue("Your saved map was saved with semantic errors or not parsed correctly", false);
		}
	}
}
