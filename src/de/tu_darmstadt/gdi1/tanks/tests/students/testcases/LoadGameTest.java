package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterExtended1;

public class LoadGameTest {
	
	TanksTestAdapterExtended1 adapter;
	String saveGame = "testmaps/extended1/save.tanks";
	String saveGameRepresentation = "Map \"/assets/sandTexture.jpg\" \"correcte1\" \"null\" 0 9788 6\n" +
									"Tank \"PlayerOne\" 1000 998 10 4 3 3 30 5 155 10 441 211\n" +
									"Tank \"OpponentTank0\" 30 30 1 0 0 0 1 5 12 10 371 473\n" +
									"Border 400 0 800 0\n" +
									"Border 0 300 0 600\n" +
									"Wall 100 100 0 10 100 100\n" +
									"Explosion 40 40 1 408 191\n" +
									"Shot 30 155 5 595 547\n" +
									"Shot 30 155 5 517 377\n" +
									"Shot 30 155 5 478 291\n" +
									"Explosion 40 40 1 408 191\n";
	
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterExtended1();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public final void testLoadGame() {
		
		adapter.loadSaveGameFromFile(new File(saveGame));
		
		assertTrue("A correct map of a loaded savegame was detected as incorrect", adapter.isCorrectMap());
		assertNotNull("The string representation of a map of a loaded savegame was null", adapter.getStringRepresentationOfMap());
		assertEquals("The string representation of the loaded savegame was incorrect", saveGameRepresentation, adapter.getStringRepresentationOfMap());
		
	}
	
	@Test
	public final void testLoadedValues() {
		
		adapter.loadMapFromFile(new File(saveGame));
		
		assertEquals("The value of the background picture loaded from the save game file was wrong", "/assets/sandTexture.jpg", adapter.getMapBackgroundTexture());
		assertEquals("The value of the next map loaded from the save game file was wrong", "null", adapter.getMapNextMap());
		assertEquals("The value of the fired shots loaded from the save game file was wrong", 6, adapter.getShotsFiredOfLoadedMap());
		assertEquals("The value of the passed time loaded from the save game file was wrong", 9788, adapter.getTimePassedOfLoadedMap());
		
		assertEquals(2, adapter.getTankCount());
		assertEquals(3, adapter.getShotCount());
	}
	
}
