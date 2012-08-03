package Elements;

public class Shot {
	int strength, rotation, scale, x, y;

	public Shot(int strength, int rotation, int scale, int x, int y) {
		this.strength = strength;
		this.rotation = rotation;
		this.scale = scale;
		this.x = x;
		this.y = y;
	}

	public int getStrength() {
		return strength;
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
