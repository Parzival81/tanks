package Elements;

public class Tank {
	private String name;
	private int maxlife, life, maxshot, shot, maxmine, mine, strength, speed,
			rotation, scale, x, y;

	public Tank(String name, int maxlife, int life, int maxshot, int shot,
			int maxmine, int mine, int strength, int speed, int rotation,
			int scale, int x, int y) {
		this.name = name;
		this.maxlife = maxlife;
		this.life = life;
		this.maxshot = maxshot;
		this.shot = shot;
		this.maxmine = maxmine;
		this.mine = mine;
		this.strength = strength;
		this.speed = speed;
		this.rotation = rotation;
		this.scale = scale;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public int getMaxlife() {
		return maxlife;
	}

	public int getLife() {
		return life;
	}

	public int getMaxshot() {
		return maxshot;
	}

	public int getShot() {
		return shot;
	}

	public int getMaxmine() {
		return maxmine;
	}

	public int getMine() {
		return mine;
	}

	public int getStrength() {
		return strength;
	}

	public int getSpeed() {
		return speed;
	}

	public int getRotation() {
		return rotation;
	}

	public int getScale() {
		return scale;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
