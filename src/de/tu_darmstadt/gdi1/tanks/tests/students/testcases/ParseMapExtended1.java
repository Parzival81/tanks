package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterExtended1;

public class ParseMapExtended1 {

	TanksTestAdapterExtended1  adapter;
	
	String map = "testmaps/extended1/correcte1";
	String map2 = "testmaps/minimal/correct01";
	
	String stringRepresentation = "Map \"/assets/sandTexture.jpg\" \"correcte1\" \"null\" 0 0 0\n" +
							   	  "Tank \"PlayerOne\" 1000 1000 10 10 3 3 30 5 0 10 300 200\n" +
							   	  "Tank \"OpponentTank0\" 30 30 1 1 0 0 1 5 270 10 400 500\n" +
							   	  "Border 400 0 800 0\n" +
							   	  "Border 0 300 0 600\n" +
							   	  "Wall 100 100 0 10 100 100\n" +
							   	  "Shot 5 280 10 50 50\n" +
							   	  "Explosion 25 25 1 10 10\n" +
							   	  "Mine 60 20 303 168\n" +
							   	  "Mine 40 30 112 30\n";
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterExtended1();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public final void testLoadMapFromFile() {
		adapter.loadMapFromFile(new File(map));
		assertTrue("A correct map was detected as incorrect (mine extension): " + map, adapter.isCorrectMap());
	}
	
	@Test
	public final void testMineEntitiy() {
		adapter.loadMapFromFile(new File(map));
		assertTrue("A correct map was detected as incorrect (mine extension): " + map, adapter.isCorrectMap());
		assertEquals("String representation of " + map + " is wrong" , stringRepresentation, adapter.getStringRepresentationOfMap());
		// Count
		assertEquals("Incorrect mine count", 2, adapter.getMineCount());
		// Mine 1
		assertEquals("Incorrect strength value of mine at position 0", 60, adapter.getMineStrength(0));
		assertEquals("Incorrect scale value of mine at position 0", 20, adapter.getMineScale(0));
		assertEquals("Incorrect x position value of mine at position 0", 303, adapter.getMineXPosition(0));
		assertEquals("Incorrect y position value of mine at position 0", 168, adapter.getMineYPosition(0));
		// Mine 2
		assertEquals("Incorrect strength value of mine at position 1", 40, adapter.getMineStrength(1));
		assertEquals("Incorrect scale value of mine at position 1", 30, adapter.getMineScale(1));
		assertEquals("Incorrect x position value of mine at position 1", 112, adapter.getMineXPosition(1));
		assertEquals("Incorrect y position value of mine at position 1", 30, adapter.getMineYPosition(1));
	}

}
