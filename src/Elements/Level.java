package Elements;

public class Level {
	private Map gameMap;
	private Border[] gameBorder;
	private TankPlayer gameTankP; // Spieler
	private TankPlayer[] gameTankO; // Gegner
	private Wall[] gameWall;
	
	public Level(Map m, Border[] b, TankPlayer p, TankPlayer[] o, Wall[] w) {
		this.gameBorder = b;
		this.gameMap = m;
		this.gameTankO = o;
		this.gameTankP = p;
		this.gameWall = w;
		
	}

	public Map getGameMap() {
		return gameMap;
	}

	public void setGameMap(Map gameMap) {
		this.gameMap = gameMap;
	}

	public Border[] getGameBorder() {
		return gameBorder;
	}

	public void setGameBorder(Border[] gameBorder) {
		this.gameBorder = gameBorder;
	}

	public TankPlayer getGameTankP() {
		return gameTankP;
	}

	public void setGameTankP(TankPlayer gameTankP) {
		this.gameTankP = gameTankP;
	}

	public TankPlayer[] getGameTankO() {
		return gameTankO;
	}

	public void setGameTankO(TankPlayer[] gameTankO) {
		this.gameTankO = gameTankO;
	}

	public Wall[] getGameWall() {
		return gameWall;
	}

	public void setGameWall(Wall[] gameWall) {
		this.gameWall = gameWall;
	}

}
