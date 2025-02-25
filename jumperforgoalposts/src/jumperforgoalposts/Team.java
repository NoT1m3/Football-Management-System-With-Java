package jumperforgoalposts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {
    private String name;
    private String homeGround;
    private int capacity;
    private List<Player> players;
    private int points;
    private String formation;
    private Manager manager;
    private List<Referee> referees;

    public Team(String name, String homeGround, int capacity) {
        this.name = name;
        this.homeGround = homeGround;
        this.capacity = capacity;
        this.players = new ArrayList<>();
        this.referees = new ArrayList<>();
        this.points = 0;
        this.formation = "4-4-2"; // Default formation
    }

    public String getName() {
        return name;
    }

    public String getHomeGround() {
        return homeGround;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        players.removeIf(player -> player.getName().equals(playerName));
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Referee> getReferees() {
        return referees;
    }

    public void addReferee(Referee referee) {
        referees.add(referee);
    }

    public void removeReferee(String refereeName) {
        referees.removeIf(referee -> referee.getName().equals(refereeName));
    }
}
