package jihedamine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * Represents a football game
 *
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

    /**
     * Returns the game's team instance
     * named as the name passed in paramater
     * @param teamName name of the team
     * @return a team instance
     */
    public Team getTeamByName(String teamName) {
        if (teamName.equals(homeTeam.getName())) {
            return homeTeam;
        } else if (teamName.equals(awayTeam.getName())) {
            return awayTeam;
        } else throw new IllegalArgumentException("team-name-not-found");
    }

    /**
     * Adds a goal to this game
     * @param goal goal to add to the game
     */
    public void addGoal(Goal goal) {
        if (isBackInTimeGoal(goal)) {
            throw new IllegalArgumentException("goal-back-in-time");
        }
        this.goals.add(goal);
    }

    /**
     * Asserts if a goal happened before previously added goals to the game
     * @param goal the goal to evaluate
     * @return true if the goal happened before previously added goals
     */
    private boolean isBackInTimeGoal(Goal goal) {
        if (goals.size() == 0) return false;
        // Goals are sorted in chronological order
        return goals.get(goals.size()-1).compareTo(goal) > 0;
    }

    /**
     * Returns the list of goals scored by the team passed as a parameter
     * @param team the team that scored the goals
     * @return list of goals scored by the team in the game
     */
    public List<Goal> getGoals(Team team) {
        return goals.stream().filter(g -> g.getTeam().equals(team)).collect(Collectors.toList());
    }
}
