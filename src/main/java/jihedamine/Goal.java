package jihedamine;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * Represents a goal in a football game
 *
 */
public class Goal implements Comparable<Goal> {
    private int minute;
    private Team team;
    private String scorerName;

    /**
     * Creates a goal instance
     * @param minute minute when the goal was scored
     * @param team team that scored the goal
     * @param scorerName name of the player who scored the goal
     */
    public Goal(int minute, Team team, String scorerName) {
        // 140mn = 2 * 45mn (two half-time periods) + 2 * 15mn (two extra time periods)
        // + 20mn eventual maximum additional time for the 4 periods
        if (minute < 0 || minute > 140) {
            throw new IllegalArgumentException("non-valid-goal-time");
        }
        this.minute = minute;
        this.team = team;
        this.scorerName = scorerName;
    }

    /**
     * Get the minute when the goal was scored
     * @return minute when the goal was scored
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Get the team that scored the goal
     * @return team that scored the goal
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Get the scorer's name
     * @return scorer's name
     */
    public String getScorerName() {
        return scorerName;
    }

    @Override
    public int compareTo(Goal other) {
        return this.minute - other.minute;
    }
}
