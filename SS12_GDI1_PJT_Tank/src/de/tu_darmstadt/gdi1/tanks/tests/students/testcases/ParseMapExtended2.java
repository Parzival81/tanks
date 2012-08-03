package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterExtended2;

public class ParseMapExtended2 {

	TanksTestAdapterExtended2  adapter;
	
	String 	map01 = "testmaps/extended2/correct01e2";
	
	String stringRepresentation01 = "Map \"/assets/sandTexture.jpg\" \"correct01e2\" \"null\" 0 0 0\n" +
									"Tank \"PlayerOne\" 1000 1000 10 10 3 3 30 5 0 10 300 200\n" +
									"Tank \"OpponentTank0\" 30 30 1 1 0 0 1 5 270 10 100 200\n" +
									"Scattershot 10 5 231 10 112 372\n";
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterExtended2();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public final void testLoadMapFromFileScattershotExtension() {
		adapter.loadMapFromFile(new File(map01));
		assertTrue("A correct map was detected as incorrect (scattershot extension): " + map01, adapter.isCorrectMap());
	}
	
	@Test
	public final void testScattershotEntitiy() {
		adapter.loadMapFromFile(new File(map01));
		assertTrue("A correct map was detected as incorrect (scattershot extension): " + map01, adapter.isCorrectMap());
		assertEquals("String representation of " + map01 + " is wrong" , stringRepresentation01, adapter.getStringRepresentationOfMap());
		
		assertEquals("Incorrect scattershot count", 1, adapter.getScattershotCount());
		
		assertEquals("Incorrect time value of scattershot at position 0", 10, adapter.getScattershotTime(0));
		assertEquals("Incorrect strength value of scattershot at position 0", 5, adapter.getScattershotStrength(0));
		assertEquals("Incorrect rotation value of scattershot at position 0", 231, adapter.getScattershotRotation(0));
		assertEquals("Incorrect scale value of scattershot at position 0", 10, adapter.getScattershotScale(0));
		assertEquals("Incorrect x position value of scattershot at position 0", 112, adapter.getScattershotXPosition(0));
		assertEquals("Incorrect y position value of scattershot at position 0", 372, adapter.getScattershotYPosition(0));
	}	
}
