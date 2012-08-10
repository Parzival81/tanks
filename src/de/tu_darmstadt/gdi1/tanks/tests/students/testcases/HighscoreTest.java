package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterExtended1;

public class HighscoreTest {
	
	TanksTestAdapterExtended1 adapter;
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterExtended1();
		adapter.resetHighscore();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public final void testCreateHighscoreEntry() {
		
		assertEquals("Highscore count should be zero after reset", 0, adapter.getHighscoreCount());
		
		adapter.addHighscore("PlayerOne", 23, 123456);
		
		assertEquals("Highscore count should be one after adding an entry", 1, adapter.getHighscoreCount());
		assertEquals("The playername of the highscore entry is incorrect", "PlayerOne", adapter.getNameAtHighscorePosition(0));
		assertEquals("The amount of shots fired of the highscore entry is incorrect", 23, adapter.getShotsFiredAtHighscorePosition(0));
		assertEquals("The time passed of the highscore entry is incorrect", 123456, adapter.getTimePassedAtHighscorePosition(0));	
	}
	
	@Test
	public final void testSortHighscoresByShotsFired() {
		assertEquals("Highscore count should be zero after reset", 0, adapter.getHighscoreCount());
	
		adapter.addHighscore("PlayerSix", 213, 123145);
		adapter.addHighscore("PlayerOne", 1, 123145);
		adapter.addHighscore("PlayerThree", 79, 123145);
		adapter.addHighscore("PlayerFive", 137, 123145);
		adapter.addHighscore("PlayerTwo", 25, 123145);
		adapter.addHighscore("PlayerFour", 100, 123145);
		
		assertEquals("Highscore count should be 6", 6, adapter.getHighscoreCount());
		
		assertEquals("PlayerOne", adapter.getNameAtHighscorePosition(0));
		assertEquals(1, adapter.getShotsFiredAtHighscorePosition(0));
		assertEquals("PlayerTwo", adapter.getNameAtHighscorePosition(1));
		assertEquals(25, adapter.getShotsFiredAtHighscorePosition(1));
		assertEquals("PlayerThree", adapter.getNameAtHighscorePosition(2));
		assertEquals(79, adapter.getShotsFiredAtHighscorePosition(2));
		assertEquals("PlayerFour", adapter.getNameAtHighscorePosition(3));
		assertEquals(100, adapter.getShotsFiredAtHighscorePosition(3));
		assertEquals("PlayerFive", adapter.getNameAtHighscorePosition(4));
		assertEquals(137, adapter.getShotsFiredAtHighscorePosition(4));
		assertEquals("PlayerSix", adapter.getNameAtHighscorePosition(5));
		assertEquals(213, adapter.getShotsFiredAtHighscorePosition(5));
		
		for (int i = 0; i < 6; i++) {
			assertEquals("The amount of time passed is incorrect", 123145, adapter.getTimePassedAtHighscorePosition(i));
		}
	}

	@Test
	public final void testNullAccess() {
		assertEquals("Highscore count should be zero after reset", 0, adapter.getHighscoreCount());
		
		adapter.addHighscore("PlayerOne", 2, 3);
		
		assertNull("Accessing a non existent position should resturn null", adapter.getNameAtHighscorePosition(-1));
		assertNull("Accessing a non existent position should resturn null", adapter.getNameAtHighscorePosition(1));
		
		assertEquals("Accessing a non existent position should resturn null", -1, adapter.getShotsFiredAtHighscorePosition(-1));
		assertEquals("Accessing a non existent position should resturn null", -1, adapter.getShotsFiredAtHighscorePosition(1));
		
		assertEquals("Accessing a non existent position should resturn null", -1, adapter.getTimePassedAtHighscorePosition(-1));
		assertEquals("Accessing a non existent position should resturn null", -1, adapter.getShotsFiredAtHighscorePosition(1));
		
	}
	
	
}
