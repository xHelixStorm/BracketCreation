package core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
	public static void main (String [] args){
		try {
			PrintStream out = new PrintStream(new FileOutputStream("./brackets.txt"));
			System.setOut(out);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
		int randomDigit1 = 0;
		int randomDigit2 = 0;
		int count = 0;
		boolean newTeam1 = false;
		boolean newTeam2 = false;
		ArrayList<String> teams = Arrays.getTeams();
		ArrayList<String> takenTeams = new ArrayList<String>();
		while(count != (teams.size()/2)){
			count++;
			System.out.println("Bracket "+count+":");
			System.out.println("");
			while(newTeam1 == false || newTeam2 == false){
				if(newTeam1 == false){randomDigit1 = (int) (Math.random()*teams.size());}
				if(newTeam2 == false){randomDigit2 = (int) (Math.random()*teams.size());}
				if(randomDigit1 != randomDigit2){
					if(!takenTeams.contains(teams.get(randomDigit1))){
						takenTeams.add(teams.get(randomDigit1));
						newTeam1 = true;
					}
					if(!takenTeams.contains(teams.get(randomDigit2))){
						takenTeams.add(teams.get(randomDigit2));
						newTeam2 = true;
					}
				}
			}
			System.out.println(teams.get(randomDigit1)+" versus "+teams.get(randomDigit2));
			newTeam1 = false;
			newTeam2 = false;
			System.out.println("-------------------------------");
			System.out.println("");
		}
	}
}
