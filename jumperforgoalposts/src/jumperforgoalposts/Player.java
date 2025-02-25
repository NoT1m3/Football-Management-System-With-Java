package jumperforgoalposts;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String position;
    private int goals;
    private int assists;
    private boolean isInjured;
    private String formationPosition;

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
        this.goals = 0;
        this.assists = 0;
        this.isInjured = false;
        this.formationPosition = "";
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getGoals() {
        return goals;
    }

    public void addGoal() {
        goals++;
    }

    public int getAssists() {
        return assists;
    }

    public void addAssist() {
        assists++;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public String getFormationPosition() {
        return formationPosition;
    }

    public void setFormationPosition(String formationPosition) {
        this.formationPosition = formationPosition;
    }

    @Override
    public String toString() {
        return "Player Name: " + name + ", Position: " + position;
    }
}
