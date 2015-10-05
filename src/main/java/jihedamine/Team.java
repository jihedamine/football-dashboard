package jihedamine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamaaref on 05/10/15.
 */
public class Team {
    private String name;
    private List<Goal> goals;

    public Team(String name) {
        this.goals = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void addGoal(Goal goal) {
        this.goals.add(goal);
    }
}
