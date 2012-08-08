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

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxlife(int maxlife) {
		this.maxlife = maxlife;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setMaxshot(int maxshot) {
		this.maxshot = maxshot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public void setMaxmine(int maxmine) {
		this.maxmine = maxmine;
	}

	public void setMine(int mine) {
		this.mine = mine;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
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
