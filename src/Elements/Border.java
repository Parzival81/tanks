package Elements;

public class Border {
	private int x0, y0, width, height;

	public Border(int x0, int y0, int width, int height) {
		this.x0 = x0;
		this.y0 = y0;
		this.width = width;
		this.height = height;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Border").append(" ").append(this.x0).append(" ").append(this.y0).append(" ").append(this.width)
		.append(" ").append(this.height);
		
		return sb.toString();
	}

	public int getX0() {
		return x0;
	}

	public int getY0() {
		return y0;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
