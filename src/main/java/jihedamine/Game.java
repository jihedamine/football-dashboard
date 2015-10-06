package jihedamine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jamaaref on 05/10/15.
 */
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private boolean isInProgress;
    private List<Goal> goals;

    public void start(String homeTeamName, String awayTeamName) {
        homeTeam = new Team(homeTeamName);
        awayTeam = new Team(awayTeamName);
        isInProgress = true;
        goals = new ArrayList<>();
    }

    public void end() {
        homeTeam = null;
        awayTeam = null;
        isInProgress = false;
        goals = null;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public boolean isInProgress() {
        return isInProgress;
    }

    public Team getTeamByName(String teamName) {
        if (teamName.equals(homeTeam.getName())) {
            return homeTeam;
        } else if (teamName.equals(awayTeam.getName())) {
            return awayTeam;
        } else throw new IllegalArgumentException("team-name-not-found");
    }

    public void addGoal(Goal goal) {
        if (isBackInTimeGoal(goal)) {
            throw new IllegalArgumentException("goal-back-in-time");
        }
        this.goals.add(goal);
    }

    private boolean isBackInTimeGoal(Goal goal) {
        if (goals.size() == 0) return false;
        // Goals are sorted in chronological order
        return goals.get(goals.size()-1).compareTo(goal) > 0;
    }

    public List<Goal> getGoals(Team team) {
        return goals.stream().filter(g -> g.getTeam().equals(team)).collect(Collectors.toList());
    }
}
