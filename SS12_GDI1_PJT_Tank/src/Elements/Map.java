package Elements;

public class Map {
	private String background, actualmap, nextmap;
	private int maxduration, elapsedTime, shots;

	public Map(String background, String actualmap, String nextmap,
			int maxduration, int elapsedTime, int shots) {
		this.background = background;
		this.actualmap = actualmap;
		this.nextmap = nextmap;
		this.maxduration = maxduration;
		this.elapsedTime = elapsedTime;
		this.shots = shots;
	}

	public String getBackground() {
		return background;
	}

	public String getActualmap() {
		return actualmap;
	}

	public String getNextmap() {
		return nextmap;
	}

	public int getMaxduration() {
		return maxduration;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public int getShots() {
		return shots;
	}

}
