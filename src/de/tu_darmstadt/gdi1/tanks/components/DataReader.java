package de.tu_darmstadt.gdi1.tanks.components;

import de.tu_darmstadt.gdi1.tanks.entity.Border;
import de.tu_darmstadt.gdi1.tanks.entity.Map;
import de.tu_darmstadt.gdi1.tanks.entity.Tank;
import de.tu_darmstadt.gdi1.tanks.entity.Wall;
import de.tu_darmstadt.gdi1.tanks.level.Level;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Reads all the parameters from the map file and initializes the level object
 * with all its entities (tanks, walls, etc.)
 * 
 * @version 1.0
 */
public class DataReader {

    private String path;

    /**
     * Constructor: parameter determines which file to chose
     *
     * @param path
     */
    public DataReader(String path) {
        this.path = path;
    }

    /**
     * Accessing the file, and returning an instance of the level-class
     * 
     * @return Level
     */
    public Level getLevel() {
        Level toReturn = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line; // representing a line in the file

            // variable declaration | saving every tuple
            LinkedList<Border> borderlist = new LinkedList<Border>();
            LinkedList<Tank> tanklist = new LinkedList<Tank>();
            LinkedList<Wall> walllist = new LinkedList<Wall>();
            Map m = null;
            Tank p = null;
            int j = 0;
            while ((line = br.readLine()) != null) {

                LinkedList<String> ll = new LinkedList<String>(); // linked list saves every parameter
                for (int i = 0; i < line.length(); i++) {
                    StringBuffer sb = new StringBuffer();
                    while (i < line.length() && line.charAt(i) != ' ') {
                        sb.append(line.charAt(i));
                        i++;
                    }
                    ll.add(sb.toString().replaceAll("\"", ""));
                }

                // depend on what kind of tuple it is, there will be an instantiation of the respective class
                if (line.contains("Map")) {
                    m = new Map("Map" + j, ll.get(1), ll.get(2), ll.get(3),
                            Integer.valueOf(ll.get(4)), Integer.valueOf(ll
                            .get(5)), Integer.valueOf(ll.get(6)));
                } else if (line.contains("Border")) {
                    Border bo = new Border("Boarder" + j, Integer.valueOf(ll.get(1)),
                            Integer.valueOf(ll.get(2)), Integer.valueOf(ll
                            .get(3)), Integer.valueOf(ll.get(4)));
                    borderlist.add(bo);
                } else if (line.contains("Tank")) {
                    if (line.contains("PlayerOne")) {
                        p = new Tank("PlayerOne", ll.get(1), Integer.valueOf(ll.get(2)),
                                Integer.valueOf(ll.get(3)), Integer.valueOf(ll.get(4)),
                                Integer.valueOf(ll.get(5)), Integer.valueOf(ll.get(6)),
                                Integer.valueOf(ll.get(7)), Integer.valueOf(ll.get(8)),
                                Integer.valueOf(ll.get(9)), Integer.valueOf(ll.get(10)),
                                Integer.valueOf(ll.get(11)), Integer.valueOf(ll.get(12)),
                                Integer.valueOf(ll.get(13)));
                    } else {
                        Tank ta = new Tank("Oppenent Tank" + j, ll.get(1), Integer.valueOf(ll.get(2)),
                                Integer.valueOf(ll.get(3)), Integer.valueOf(ll.get(4)),
                                Integer.valueOf(ll.get(5)), Integer.valueOf(ll.get(6)),
                                Integer.valueOf(ll.get(7)), Integer.valueOf(ll.get(8)),
                                Integer.valueOf(ll.get(9)),Integer.valueOf(ll.get(10)),
                                Integer.valueOf(ll.get(11)), Integer.valueOf(ll.get(12)),
                                Integer.valueOf(ll.get(13)));
                        tanklist.add(ta);
                    }
                } else if (line.contains("Wall")) {
                    Wall wa = new Wall("Wall" + j, Integer.valueOf(ll.get(1)), Integer.valueOf(ll.get(2)),
                            Integer.valueOf(ll.get(3)), Integer.valueOf(ll.get(4)),
                            Integer.valueOf(ll.get(5)), Integer.valueOf(ll.get(6)));
                    walllist.add(wa);
                } else if (line.contains("Shot")) {
                    // TODO has to be implemented
                } else if (line.contains("Pickup")) {
                    // TODO has to be implemented
                }
                j++;
            }
            // list to array
            Tank[] o = tanklist.toArray(new Tank[tanklist.size()]);
            Wall[] w = walllist.toArray(new Wall[walllist.size()]);
            Border[] b = borderlist.toArray(new Border[borderlist.size()]);


            // instantiation of level
            toReturn = new Level(m, b, p, o, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // returning the instance
        return toReturn;

    }
    
    /**
     * Setting a new path
     * 
     * @param newPath 
     */
    public void setPath(String newPath) {
        this.path = newPath;
    }
}
