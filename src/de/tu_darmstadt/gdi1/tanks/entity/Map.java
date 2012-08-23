package de.tu_darmstadt.gdi1.tanks.entity;

import eea.engine.entity.Entity;

/**
 * Represents a map in the game
 * 
 * @version 1.0
 */
public class Map extends Entity {

    private String background, actualmap, nextmap;
    private int maxduration, elapsedTime, shots;

    /**
     * Constructor. Set all the maps mandatory properties
     * 
     * @param id            The maps id
     * @param background    The maps background image
     * @param actualmap     TODO: What is this? 
     * @param nextmap       The next map to play
     * @param maxduration   The play time for the map
     * @param elapsedTime   The time the player has played
     * @param shots         The shots the player has fired
     */
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
    
    /**
     * Converts a map into a single string
     * 
     * @return The map with all its properties as a String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Map").append(" ").append("\"").append(this.background).append("\"").append(" ")
                .append("\"").append(this.actualmap).append("\"").append(" ").append("\"").append(this.nextmap)
                .append("\"").append(" ").append(this.maxduration).append(" ").append(this.elapsedTime).append(" ")
                .append(this.shots);

        return sb.toString();
    }

    /**
     * Get the maps background image path
     * 
     * @return 
     */
    public String getBackground() {
        return background;
    }
    
    /**
     * TODO: What?
     * 
     * @return 
     */
    public String getActualmap() {
        return actualmap;
    }
    
    /**
     * Get the next maps name
     * 
     * @return 
     */
    public String getNextmap() {
        return nextmap;
    }
    
    /**
     * Get the maximum duration of the map
     * 
     * @return 
     */
    public int getMaxduration() {
        return maxduration;
    }
    
    /**
     * Get the time the map has been played
     * 
     * @return 
     */
    public int getElapsedTime() {
        return elapsedTime;
    }
    
    /**
     * Get the number of shots the player has fired
     * 
     * @return 
     */
    public int getShots() {
        return shots;
    }
}
