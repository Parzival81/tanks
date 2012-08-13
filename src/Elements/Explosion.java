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
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Explosion ").append(this.width).append(" ").append(this.height).append(" ").append(this.speed)
		.append(" ").append(this.x).append(" ").append(this.y);
		
		return sb.toString();
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
