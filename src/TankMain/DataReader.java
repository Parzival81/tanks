package TankMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import Elements.*;

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
	 * @return
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
					System.out.println(ll.toString());
					m = new Map(ll.get(1), ll.get(2), ll.get(3),
							Integer.valueOf(ll.get(4)), Integer.valueOf(ll
									.get(5)), Integer.valueOf(ll.get(6)));
				} else if (line.contains("Border")) {
					Border bo = new Border(Integer.valueOf(ll.get(1)),
							Integer.valueOf(ll.get(2)), Integer.valueOf(ll
									.get(3)), Integer.valueOf(ll.get(4)));
					borderlist.add(bo);
				} else if (line.contains("Tank")) {
					if (line.contains("PlayerOne")) {
						p = new Tank(ll.get(1), Integer.valueOf(2),
								Integer.valueOf(3), Integer.valueOf(4),
								Integer.valueOf(5), Integer.valueOf(6),
								Integer.valueOf(7), Integer.valueOf(8),
								Integer.valueOf(9), Integer.valueOf(10),
								Integer.valueOf(11), Integer.valueOf(12),
								Integer.valueOf(13));
					} else {
						Tank ta = new Tank(ll.get(1), Integer.valueOf(2),
								Integer.valueOf(3), Integer.valueOf(4),
								Integer.valueOf(5), Integer.valueOf(6),
								Integer.valueOf(7), Integer.valueOf(8),
								Integer.valueOf(9), Integer.valueOf(10),
								Integer.valueOf(11), Integer.valueOf(12),
								Integer.valueOf(13));
						tanklist.add(ta);
					}
				} else if (line.contains("Wall")) {
					Wall wa = new Wall(Integer.valueOf(1), Integer.valueOf(2),
							Integer.valueOf(3), Integer.valueOf(4),
							Integer.valueOf(5), Integer.valueOf(6));
					walllist.add(wa);
				} else if (line.contains("Shot")) {
					// TODO something has to be done here
				} else if (line.contains("Pickup")) {
					// TODO something has to be done here
				}

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
	 */
	public void setPath(String newPath){
		this.path = newPath;
	}
}
