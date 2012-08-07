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
	 * Accessing the file, and returns an instance of the level-class, which
	 * represents the file
	 * 
	 * @return
	 */
	public Level getLevel() {
		Level toReturn = null;
		try {
			// hier wird file gelesen
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			// line representiert 1 Absatz. Es wird immer bis "\n" gelesen
			String line;

			// Es gibt mehrere Borders, Tanks und Walls, weshalb hier LinkedList
			// verwendet wird um zu speichern
			LinkedList<Border> borderlist = new LinkedList<Border>();
			LinkedList<Tank> tanklist = new LinkedList<Tank>();
			LinkedList<Wall> walllist = new LinkedList<Wall>();

			// File darf nur 1 Map und 1 TankPlayerOne enthalten, weshalb hier keine
			// LinkedList verwendet wurde
			Map m = null;
			Tank p = null;

			
			// ---------- ITERATION UEBER TUPELS -----------
			while ((line = br.readLine()) != null) {
				
				// Alle Attribute eines Tupels werden hier in LinkedList ll gespeichert 
				LinkedList<String> ll = new LinkedList<String>();
				for (int i = 0; i < line.length(); i++) {
					StringBuffer sb = new StringBuffer();
					while (i < line.length() && line.charAt(i) != ' ') {
						sb.append(line.charAt(i));
						i++;
					}
					
					// Das Hinzufuegen erfolgt immer nachdem man " entfernt bzw. gefiltert hat
					ll.add(sb.toString().replaceAll("\"", ""));
				}

				// Ab hier werden die Tupels unterschieden, ob Tank, Wall oder... 
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
					
					// Hier wird ueberprueft ob es ein Player ist oder Opponent
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
					// TODO muss noch implementiert werden / noch nicht in der Aufbaustufe 1 vorgesehen
				} else if (line.contains("Pickup")) {
					// TODO muss noch implementiert werden / noch nicht in der Aufbaustufe 1 vorgesehen
				}

			}
			// Die Listen werden hier in Arrays konvertiert damit...
			Tank[] o = tanklist.toArray(new Tank[tanklist.size()]);
			Wall[] w = walllist.toArray(new Wall[walllist.size()]);
			Border[] b = borderlist.toArray(new Border[borderlist.size()]);
			
			
			// Das Objekt der Klasse Level instanziiert werden kann
			toReturn = new Level(m, b, p, o, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toReturn;

	}

	
	/**
	 * Setting a new path
	 */
	public void setPath(String newPath){
		this.path = newPath;
	}
}
