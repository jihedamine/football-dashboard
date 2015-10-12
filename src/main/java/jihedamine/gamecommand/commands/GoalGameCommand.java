package jihedamine.gamecommand.commands;

import jihedamine.Game;
import jihedamine.Goal;
import jihedamine.Team;
import jihedamine.gamecommand.AbstractGameCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * The command adds a goal to the game
 *
 * Pattern: "<minute> '<Team>' <name of scorer>"
 * Example: "11 'West Germany' Haller"
 */
public class GoalGameCommand extends AbstractGameCommand {

    public GoalGameCommand() {
        pattern = Pattern.compile("^([0-9]{1,3}?) '([a-zA-Z ]+?)' ([a-zA-Z ]+)?");
    }

    @Override
    public String executeMatches(String command, Game game, Matcher matcher) {
        if (isGameStarted(game)) {
            try {
                int minute = Integer.valueOf(matcher.group(1));
                Team scoringTeam = game.getTeamByName(matcher.group(2));
                String scorerName = matcher.group(3);
                game.addGoal(new Goal(minute, scoringTeam, scorerName));
                return "goal-added";
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        } else {
            return "no-game-in-progress";
        }
    }

}
