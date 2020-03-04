
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String team; 
    private String nationality;
    private int goals;
    private int assists;
    
    public Player(String name, String team, String nationality, int goals, int assists) {
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.goals = goals;
        this.assists = assists;
    }
        
    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public int getPoints() {
        return goals + assists;
    }
   
    @Override
    public String toString() {      
        return String.format("%-20s",name) + " " + nationality + " " + team + " " + String.format("%2d",goals) + " + " 
                + String.format("%2d",assists) + " = " + getPoints();
    }

    public int compareTo(Player t) {
        return t.getPoints()-this.getPoints();
    }
}

