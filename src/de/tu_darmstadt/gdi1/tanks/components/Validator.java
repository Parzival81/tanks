package de.tu_darmstadt.gdi1.tanks.components;

import de.tu_darmstadt.gdi1.tanks.entity.Tank;
import de.tu_darmstadt.gdi1.tanks.entity.Wall;
import de.tu_darmstadt.gdi1.tanks.entity.Border;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


import de.tu_darmstadt.gdi1.tanks.model.exceptions.SemanticException;
import de.tu_darmstadt.gdi1.tanks.model.exceptions.SyntaxException;


public class Validator {
	private String path;

	public Validator (String path){
		this.path = path;
	}
	
	public void validate() throws SemanticException, SyntaxException{
		boolean validateParameterSize = true; // true: the size is correct
		boolean validateExistenceOpponent = false; // true: there exist at least one player
		boolean validateExistencePlayer = false; // true: there exist at least one opponent
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line; // representing a line in the file

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
				
				// checking if the parameter numbers are correct
				if (line.contains("Map")) {
					if (ll.size() != 7){
						validateParameterSize = false;
					}
				} else if (line.contains("Border")) {
					if (ll.size() != 5){
						validateParameterSize = false;
					}
				} else if (line.contains("Tank")) {
					if (line.contains("PlayerOne")) {
						if (ll.size() != 13){
							validateParameterSize = false;
							validateExistencePlayer = true;
						} 
					}else {
						if (ll.size() != 13){
							validateParameterSize = false;
							validateExistenceOpponent = true;
						}
					}
					
				} else if (line.contains("Wall")) {
					if (ll.size() != 7){
						validateParameterSize = false;
					}
				} else if (line.contains("Shot")) {
					// TODO something has to be done here
				} else if (line.contains("Pickup")) {
					// TODO something has to be done here
				}
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (!validateParameterSize){
			throw new SyntaxException("Syntax exception -> parameter number incorrect.");
		}
		if (!validateExistenceOpponent || !validateExistencePlayer){
			throw new SemanticException("Semantic error -> tank player / tank opponent not available.");
		}
	}
	
	
	public void validatePosition(Tank tank) throws SemanticException{
		DataReader dr = new DataReader (path);

		for (Border b : dr.getLevel().getGameBorder()){
			if (tank.getX() == b.getX() && tank.getY() == b.getY()){
				throw new SemanticException ("Tank at the same position as border(s).");
			}
		}

		for (Wall w: dr.getLevel().getGameWall()){
			if (tank.getX() == w.getX() && tank.getY() == w.getY()){
				throw new SemanticException ("Play at the same position as wall(s).");
			}
		}
		
		for (Tank t: dr.getLevel().getGameTankO()){
			if (t.getName().equals(tank.getName())){
				// same tank, test can be skipped, do nothing here
			}else{
				if (tank.getX() == t.getX() && tank.getY() == t.getY()){
					throw new SemanticException ("Tank at the same position as tank(s)");
				}
			}
		}
		
		if (tank.getName().equals(dr.getLevel().getGameTankP())){
			// same tank, test can be skipped, do nothing here
		}else{
			if (tank.getX() == dr.getLevel().getGameTankP().getX() && tank.getY() == dr.getLevel().getGameTankP().getY()){
				throw new SemanticException("Tank at the same position as the player tank");
			}
		}
		
	}
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
	




