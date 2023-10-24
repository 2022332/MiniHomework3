/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minihomework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import minihomework3.Enums.GamerAttribute;
import minihomework3.Enums.TeamNames;

/**
 *
 * @author Ari
 * GitHub link: https://github.com/2022332/MiniHomework3.git
 */
public class MiniHomework3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //PART 1 TO READ, PROCESS AND STORE THE FILE
        Set<Person> allGamers = new HashSet<>(); //this set is to stored all the gamers from the excel file
        List<Teams> teams = new ArrayList<>(); //this list is to store all the teams that were created
        List<String[]> dataLines = new ArrayList<>(); //this list is to store the lines of data from the excel file
        
       try (BufferedReader myKB = new BufferedReader(new FileReader("MOCK_DATA.csv"))){ //this is to open and read the excel file
           //this part is to read each line of the file and check if the line has the expected information (id,first name, last name, email)
           String line;
           while ((line = myKB.readLine()) != null){
               String[] data = line.split(",");
               if (data.length == 4){
                   dataLines.add(data);
               }
           }
       } catch (IOException e){
           e.printStackTrace(); //this is in case there is any issue with file like file not found, etc
           return;
       }
       //this process and stores all the data from the file into the allGamers set
       for (String[] data : dataLines){
           int id = Integer.parseInt(data[GamerAttribute.ID.ordinal()]);
           String firstName = data[GamerAttribute.FIRST_NAME.ordinal()];
           String lastName = data[GamerAttribute.LAST_NAME.ordinal()];
           String email = data[GamerAttribute.EMAIL.ordinal()];
           allGamers.add(new Person(id, firstName, lastName, email));
       }
       //PART 2 TO GENERATE THE TEAMS RANDOMLY
       Random random = new Random(); //this is to make the gamers random for each team
       List<Person> remainingGamers = new ArrayList<>(allGamers);
       //this is the loop to create the teams
       for (TeamNames teamName : TeamNames.values()){
           List<Person> teamMembers = new ArrayList<>();
           //this part is to assign the gamers to the team and remove the ones 
           //that were already assigned so they are not repeated
           while (teamMembers.size() < 5 && !remainingGamers.isEmpty()){
               int randomIndex = random.nextInt(remainingGamers.size());
               teamMembers.add(remainingGamers.get(randomIndex));
           }
           teams.add(new Teams(teamName, teamMembers));
       }
       //PART 3 DISPLAY OF THE TEAMS
       for (Teams team : teams){
           System.out.println("Team Name: " + team.getName());
           System.out.println("Team Members: " + team.getMembers());
           System.out.println();
       }
    }
}
