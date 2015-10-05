package jihedamine.command.types;

import jihedamine.Game;
import jihedamine.Goal;
import jihedamine.Team;
import jihedamine.command.AbstractGameCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamaaref on 05/10/15.
 */
public class GoalGameCommand extends AbstractGameCommand {

    public GoalGameCommand() {
        pattern = Pattern.compile("([0-9]{1,2}?) '([a-zA-Z ]+?)' ([a-zA-Z ]+)?");
    }

    @Override
    public String executeMatches(String command, Game game, Matcher matcher) {
        if (isGameStarted(game)) {
            int minute = Integer.valueOf(matcher.group(1));
            Team scoringTeam = game.getTeamByName(matcher.group(2));
            String scorerName = matcher.group(3);
            scoringTeam.addGoal(new Goal(minute, scorerName));
            return "Goal added";
        } else {
            return "No game currently in progress";
        }
    }

}
