package jihedamine;

/**
 * Created by jamaaref on 05/10/15.
 */
public class Goal implements Comparable<Goal> {
    private int minute;
    private Team team;
    private String scorerName;

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

    public int getMinute() {
        return minute;
    }

    public Team getTeam() {
        return team;
    }

    public String getScorerName() {
        return scorerName;
    }

    @Override
    public int compareTo(Goal other) {
        return this.minute - other.minute;
    }
}
