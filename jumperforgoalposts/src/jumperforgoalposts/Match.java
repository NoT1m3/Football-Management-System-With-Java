package jumperforgoalposts;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Match implements Serializable {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private int week;
    private List<String> goalScorers;
    private List<Player> playersInvolved;
    private Referee referee;

    public Match(Team homeTeam, Team awayTeam, int week) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.week = week;
        this.goalScorers = new ArrayList<>();
        this.playersInvolved = new ArrayList<>();
    }

    public void addGoal(String playerName) {
        goalScorers.add(playerName);
    }

    public int getWeek() {
        return week;
    }

    public void setScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public void addPlayerInvolved(Player player) {
        playersInvolved.add(player);
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public List<String> getGoalScorers() {
        return goalScorers;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public Referee getReferee() {
        return referee;
    }

    public List<Player> getPlayersInvolved() {
        return playersInvolved;
    }
}
