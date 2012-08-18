package de.tu_darmstadt.gdi1.tanks.entity;

import eea.engine.entity.Entity;

public class Map extends Entity {

    private String background, actualmap, nextmap;
    private int maxduration, elapsedTime, shots;

    public Map(String id, String background, String actualmap, String nextmap,
            int maxduration, int elapsedTime, int shots) {
        super(id);
        this.background = background;
        this.actualmap = actualmap;
        this.nextmap = nextmap;
        this.maxduration = maxduration;
        this.elapsedTime = elapsedTime;
        this.shots = shots;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Map").append(" ").append("\"").append(this.background).append("\"").append(" ")
                .append("\"").append(this.actualmap).append("\"").append(" ").append("\"").append(this.nextmap)
                .append("\"").append(" ").append(this.maxduration).append(" ").append(this.elapsedTime).append(" ")
                .append(this.shots);

        return sb.toString();
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
