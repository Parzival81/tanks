package Elements;

public class Explosion {
	private int width, height, speed, x, y;
	public Explosion(int width, int height, int speed, int x, int y){
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.x = x;
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getSpeed() {
		return speed;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
