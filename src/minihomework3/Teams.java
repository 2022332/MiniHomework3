/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minihomework3;

import java.util.List;
import minihomework3.Enums.TeamNames;

/**
 *
 * @author Ari
 */
public class Teams {
    private TeamNames name;
    private List<Person> members;

    public Teams(TeamNames name, List<Person> members) {
        this.name = name;
        this.members = members;
    }
    
    public TeamNames getName() {
        return name;
    }

    public List<Person> getMembers() {
        return members;
    }
}
