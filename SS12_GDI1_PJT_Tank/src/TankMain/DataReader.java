package TankMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import Elements.Border;
import Elements.Level;
import Elements.Map;
import Elements.Tank;
import Elements.Wall;



public class DataReader {

private String path;
	/**
	 * Constructor: parameter determines which file to chose
	 * @param path
	 */
	public DataReader(String path){
		this.path = path;
	}
	
	public Level getLevel(){
		Level toReturn = null;
		try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            LinkedList<Border> borderlist = new LinkedList<Border>();
            LinkedList<Tank> tanklist = new LinkedList<Tank>();
            LinkedList<Wall> walllist = new LinkedList<Wall>();
            //Attribute die gesetzt werden muessen
            Map m = null;

            while ((line = br.readLine()) != null) {
                if (line.contains("Map")) {
                    LinkedList<String> ll = new LinkedList<String>();
                    for (int i = 0; i < line.length(); i++) {
                        StringBuffer sb = new StringBuffer();
                        while (i < line.length() && line.charAt(i) != ' ') {
                            sb.append(line.charAt(i));
                            i++;
                        }
                        ll.add(sb.toString().replaceAll("\"", ""));
                    }
                    System.out.println(ll.toString());
                    m = new Map(ll.get(1), ll.get(2), ll.get(3),
                            Integer.valueOf(ll.get(4)), Integer.valueOf(ll.get(5)), Integer.valueOf(ll.get(6)));


                } else if (line.contains("Border")) {
                    LinkedList<String> ll = new LinkedList<String>();
                    for (int i = 0; i < line.length(); i++) {
                        StringBuffer sb = new StringBuffer();
                        while (i < line.length() && line.charAt(i) != ' ') {
                            sb.append(line.charAt(i));
                            i++;
                        }
                        ll.add(sb.toString());
                    }

                    Border bo = new Border(Integer.valueOf(ll.get(1)), Integer.valueOf(ll.get(2)),
                            Integer.valueOf(ll.get(3)), Integer.valueOf(ll.get(4)));
                    borderlist.add(bo);


                } else if (line.contains("Tank")) {
                    LinkedList<String> ll = new LinkedList<String>();
                    for (int i = 0; i < line.length(); i++) {
                        StringBuffer sb = new StringBuffer();
                        while (i < line.length() && line.charAt(i) != ' ') {
                            sb.append(line.charAt(i));
                            i++;
                        }
                        ll.add(sb.toString().replaceAll("\"", ""));
                    }
                    Tank ta = new Tank(ll.get(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13));

                    tanklist.add(ta);
                } else if (line.contains("Wall")) {
                    LinkedList<String> ll = new LinkedList<String>();
                    for (int i = 0; i < line.length(); i++) {
                        StringBuffer sb = new StringBuffer();
                        while (i < line.length() && line.charAt(i) != ' ') {
                            sb.append(line.charAt(i));
                            i++;
                        }
                        ll.add(sb.toString());
                    }
                    Wall wa = new Wall(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3),
                            Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6));

                    walllist.add(wa);
                } else if (line.contains("Shot")) {
                    //TODO muss noch implementiert werden
                } else if (line.contains("Pickup")) {
                    //TODO muss noch implementiert werden
                }
                Tank p = null;
                // TODO: Error in implementation, has to be fixed
                for (Tank tan : tanklist) {
                    if (tan.getName().equals("PlayerOne")) {
                        p = new Tank(tan.getName(), tan.getMaxlife(), tan.getLife(), tan.getMaxshot(), tan.getShot(), tan.getMaxmine(), tan.getMine(), tan.getStrength(), tan.getSpeed(), tan.getRotation(), tan.getScale(), tan.getX(), tan.getY());
                        tanklist.remove(tan);
                    }
                }
                Tank[] o = tanklist.toArray(new Tank[tanklist.size()]);
                Wall[] w = walllist.toArray(new Wall[walllist.size()]);
                Border[] b = borderlist.toArray(new Border[borderlist.size()]);
                toReturn = new Level(m, b, p, o, w);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return toReturn;
		
	}
	
	


}
