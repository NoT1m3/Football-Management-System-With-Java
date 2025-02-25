package jumperforgoalposts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class League implements Serializable {
    private List<Team> teams;
    private List<Match> matches;
    private List<Manager> coaches;
    private List<Referee> referees;

    public League() {
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.coaches = new ArrayList<>();
        this.referees = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public void addCoach(Manager coach) {
        coaches.add(coach);
    }

    public void addReferee(Referee referee) {
        referees.add(referee);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<Manager> getCoaches() {
        return coaches;
    }

    public List<Referee> getReferees() {
        return referees;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Player getTopScorer() {
        Player topScorer = null;
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if (topScorer == null || player.getGoals() > topScorer.getGoals()) {
                    topScorer = player;
                }
            }
        }
        return topScorer;
    }

    public int getLeaguePoints() {
        int totalPoints = 0;
        for (Team team : teams) {
            totalPoints += team.getPoints();
        }
        return totalPoints;
    }
}
