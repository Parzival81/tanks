package de.tu_darmstadt.gdi1.tanks.tests.students.testcases;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tu_darmstadt.gdi1.tanks.tests.adapter.TanksTestAdapterExtended2;

public class LimitedAmmoTest {

	TanksTestAdapterExtended2  adapter;
	
	String map = "testmaps/extended2/limitedAmmo";
	
	@Before
	public void setUp() {
		adapter = new TanksTestAdapterExtended2();
	}
	
	@After
	public void finish() {
		adapter.stopGame();
	}
	
	@Test
	public void testLimitedAmmo() {
		adapter.initializeGame();
		adapter.loadMapFromFile(new File(map));
		assertTrue("A correct map was detected as incorrect: " + map, adapter.isCorrectMap());
		adapter.handleKeyPressN();
		assertEquals("The maximum ammo amount the player has should be 3", 3, adapter.getLimitedAmmoAmount());
		assertEquals("The player should have 2 shots lefts", 2, adapter.getAmmoLeft());
		assertEquals("No shot entities should be present", 0, adapter.getShotCount());
	}
	
}
