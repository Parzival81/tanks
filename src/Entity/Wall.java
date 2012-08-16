package Entity;

import eea.engine.entity.Entity;

public class Wall extends Entity {

    private int maxlife, life, rotation, scale, x, y;

    public Wall(String id, int maxlife, int life, int rotation, int scale, int x, int y) {
        super(id);
        this.maxlife = maxlife;
        this.life = life;
        this.rotation = rotation;
        this.scale = scale;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Wall ").append(this.maxlife).append(" ").append(this.life).append(" ").append(this.rotation)
                .append(" ").append(this.scale).append(" ").append(this.x).append(" ").append(this.y);

        return sb.toString();
    }

    public int getMaxlife() {
        return maxlife;
    }

    public int getLife() {
        return life;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
