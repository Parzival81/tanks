package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.model.exceptions.SemanticException;
import de.tu_darmstadt.gdi1.tanks.model.exceptions.SyntaxException;
import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterMinimal;

/**
 * Tests if a given map is correctly parsed.
 */
public class ParseMapTest {
	
	TanksTestAdapterMinimal adapter;
	
	String [] correctMaps = {
			"correct01"
	};
	
	String [] incorrectMaps = {
			"incorrect01"
	};
	
	String[] stringRepresentations = {
			// correct01 string representation
			"Map \"/assets/sandTexture.jpg\" \"correct01\" \"null\" 0 0 0\n" +
			"Tank \"PlayerOne\" 1000 1000 10 10 3 3 30 5 0 10 300 200\n" +
			"Tank \"OpponentTank0\" 30 30 1 1 0 0 1 5 270 10 100 200\n",
	};
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterMinimal();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public final void testLoadMapFromFile() {
		
		for (String map : correctMaps) {
			File mapFile = new File("testmaps/minimal/" + map);
			adapter.loadMapFromFile(mapFile);
			assertTrue("A correct map was detected as incorrect: " + map, adapter.isCorrectMap());
		}
	}
	
	@Test
	public final void testStringRepresentationOfMap() {
		
		for (int i = 0; i < correctMaps.length; i++) {
			
			String map = correctMaps[i];
			File mapFile = new File("testmaps/minimal/" + map);
			adapter.loadMapFromFile(mapFile);
			
			String stringRepresentation = adapter.getStringRepresentationOfMap();
			
			assertTrue("A correct map was detected as incorrect: " + map, adapter.isCorrectMap());
			assertNotNull("String representation of a correctly loaded map should never be null", stringRepresentation);
			assertEquals("String representation of " + map + " is wrong" , stringRepresentations[i], stringRepresentation);
		}
	}
	
	@Test
	public final void testIncorrectMaps() {
		
		for (String map : incorrectMaps) {
			File mapFile = new File("testmaps/minimal/" + map);
			adapter.loadMapFromFile(mapFile);
			assertFalse("An incorrect map was detected as correct: " + map, adapter.isCorrectMap());
			assertNull("String representation of an incorrect map should be null: " + map, adapter.getStringRepresentationOfMap());
		}
	}
	

	@Test
	public final void testMapEntities() {
		
		adapter.loadMapFromFile(new File("testmaps/minimal/entityTest01"));
		assertTrue("A correct map was detected as incorrect", adapter.isCorrectMap());
		
		assertEquals("Incorrect tank count", 5, adapter.getTankCount());
		assertEquals("Incorrect border count", 4, adapter.getBorderCount());
		assertEquals("Incorrect wall count", 5, adapter.getWallCount());
		assertEquals("Incorrect shot count", 7, adapter.getShotCount());
		assertEquals("Incorrect explosion count", 2, adapter.getExplosionCount());
	}
	
	
	
	@Test
	public final void testEntitiyValues() {
		
		adapter.loadMapFromFile(new File("testmaps/minimal/valueTest"));
		assertTrue("A correct map was detected as incorrect", adapter.isCorrectMap());
		
		// Maps infos
		assertEquals("Incorrect value of map background", "/assets/sandTexture.jpg", adapter.getMapBackgroundTexture());
		assertEquals("Incorrect value of map highscore file", "valueTest", adapter.getMapName());
		assertEquals("Incorrect value of next map", "/maps/map00", adapter.getMapNextMap());
		assertEquals("Incorrect value of map maximum duration", 100, adapter.getMapMaxDuration());
		assertEquals("Incorrect value of map elapsed time", 10, adapter.getMapElapsedTime());
		assertEquals("Incorrect value of map fired shots", 5, adapter.getMapFiredShots());
		// Tanks
		assertEquals("Incorrect value of tank amount", 2, adapter.getTankCount());
		// PlayerTank
		assertEquals("Incorrect value of tank name", "PlayerOne", adapter.getTankName(0));
		assertEquals("Incorrect value of tank maximum life", 1000, adapter.getTankMaxLife(0));
		assertEquals("Incorrect value of tank actual life", 875, adapter.getTankActualLife(0));
		assertEquals("Incorrect value of tank maximum shot amount", 10, adapter.getTankMaxShot(0));
		assertEquals("Incorrect value of tank actual shot amount", 5, adapter.getTankActualShot(0));
		assertEquals("Incorrect value of tank maximum mine amount", 3, adapter.getTankMaxMine(0));
		assertEquals("Incorrect value of tank actual mine amount", 2, adapter.getTankActualMine(0));
		assertEquals("Incorrect value of tank strength", 30, adapter.getTankStrength(0));
		assertEquals("Incorrect value of tank speed", 5, adapter.getTankSpeed(0));
		assertEquals("Incorrect value of tank rotation", 0, adapter.getTankRotation(0));
		assertEquals("Incorrect value of tank scale", 10, adapter.getTankScale(0));
		assertEquals("Incorrect value of tank x position", 300, adapter.getTankXPosition(0));
		assertEquals("Incorrect value of tank y position", 200, adapter.getTankYPosition(0));
		// OpponentTank
		assertEquals("Incorrect value of tank name", "OpponentTank0", adapter.getTankName(1));
		assertEquals("Incorrect value of tank maximum life",  30, adapter.getTankMaxLife(1));
		assertEquals("Incorrect value of tank actual life", 11, adapter.getTankActualLife(1));
		assertEquals("Incorrect value of tank maximum shot amount", 1, adapter.getTankMaxShot(1));
		assertEquals("Incorrect value of tank actual shot amount", 1, adapter.getTankActualShot(1));
		assertEquals("Incorrect value of tank maximum mine amount", 0, adapter.getTankMaxMine(1));
		assertEquals("Incorrect value of tank actual mine amount", 0, adapter.getTankActualMine(1));
		assertEquals("Incorrect value of tank strength", 1, adapter.getTankStrength(1));
		assertEquals("Incorrect value of tank speed", 4, adapter.getTankSpeed(1));
		assertEquals("Incorrect value of tank rotation", 270, adapter.getTankRotation(1));
		assertEquals("Incorrect value of tank scale", 10, adapter.getTankScale(1));
		assertEquals("Incorrect value of tank x position", 100, adapter.getTankXPosition(1));
		assertEquals("Incorrect value of tank y position", 200, adapter.getTankYPosition(1));
		// Border
		assertEquals("Incorrect value of wall amount", 1, adapter.getBorderCount());
		assertEquals("Incorrect value of border x position", 400, adapter.getBorderXPosition(0));
		assertEquals("Incorrect value of border y position", 0, adapter.getBorderYPosition(0));
		assertEquals("Incorrect value of border x size", 800, adapter.getBorderXSize(0));
		assertEquals("Incorrect value of border y size", 0, adapter.getBorderYSize(0));
		// Wall
		assertEquals("Incorrect value of wall amount", 1, adapter.getWallCount());
		assertEquals("Incorrect value of wall maximum life", 100, adapter.getWallMaxLife(0));
		assertEquals("Incorrect value of wall actual life", 33, adapter.getWallActualLife(0));
		assertEquals("Incorrect value of wall rotation", 0, adapter.getWallRotation(0));
		assertEquals("Incorrect value of wall scale", 10, adapter.getWallScale(0));
		assertEquals("Incorrect value of wall x position", 100, adapter.getWallXPosition(0));
		assertEquals("Incorrect value of wall y position", 100, adapter.getWallYPosition(0));;
		// Shot
		assertEquals("Incorrect value of shot amount", 1, adapter.getShotCount());
		assertEquals("Incorrect value of shot strength", 5, adapter.getShotStrength(0));
		assertEquals("Incorrect value of shot rotation", 280, adapter.getShotRotation(0));
		assertEquals("Incorrect value of shot scale", 10, adapter.getShotScale(0));
		assertEquals("Incorrect value of shot x position", 50, adapter.getShotXPosition(0));
		assertEquals("Incorrect value of shot y position", 50, adapter.getShotYPosition(0));;
		// Explosion
		assertEquals("Incorrect value of explosion amount", 1, adapter.getExplosionCount());
		assertEquals("Incorrect value of explosion width", 25, adapter.getExplosionWidth(0));
		assertEquals("Incorrect value of explosion height", 40, adapter.getExplosionHeight(0));
		assertEquals("Incorrect value of explosion speed", 1, adapter.getExplosionSpeed(0));
		assertEquals("Incorrect value of explosion x position", 10, adapter.getExplosionXPosition(0));
		assertEquals("Incorrect value of explosion y position", 7, adapter.getExplosionYPosition(0));;
	}
	
	@Test
	public final void testSyntaxException() {
		
		boolean sytaxException;
		
		// No map info
		sytaxException = false;
		try {
			adapter.loadMapFromFileWithExceptions(new File("testmaps/minimal/incorrect01"));
			fail("Loading an syntactically incorrect map should throw a SyntaxException");
		} catch (SemanticException e) {
		} catch (SyntaxException e) {
			sytaxException = true;
		}
		assertTrue("Loading an syntactically incorrect map should throw a SyntaxException", sytaxException);
	}
	
}
