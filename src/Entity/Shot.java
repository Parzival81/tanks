package Entity;

import eea.engine.entity.Entity;

public class Shot extends Entity {

    int strength, rotation, scale, x, y;

    public Shot(String id, int strength, int rotation, int scale, int x, int y) {
        
        super(id);
		
        this.strength = strength;
        this.rotation = rotation;
        this.scale = scale;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Shot ").append(this.strength).append(" ").append(this.rotation).append(" ").append(this.scale)
                .append(" ").append(this.x).append(" ").append(this.y);
        return sb.toString();
    }

    public int getStrength() {
        return strength;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
