package jihedamine.gamecommand.commands;

import jihedamine.Game;
import jihedamine.Goal;
import jihedamine.gamecommand.AbstractGameCommand;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamaaref on 05/10/15.
 */
public class PrintGameCommand extends AbstractGameCommand {

    public PrintGameCommand() {
        pattern =  Pattern.compile("print");
    }

    @Override
    public String executeMatches(String command, Game game, Matcher matcher) {
        if (isGameStarted(game)) {
            String result;
                StringBuffer text = new StringBuffer();
                text.append(game.getHomeTeam().getName());
                text.append(" ");
                printGoals(game.getGoals(game.getHomeTeam()), text);
                text.append(" vs. ");
                text.append(game.getAwayTeam().getName());
                text.append(" ");
                printGoals(game.getGoals(game.getAwayTeam()), text);
                result = text.toString();
            return result;
        } else {
            return "no-game-in-progress";
        }
    }


    private static void printGoals(List<Goal> goals, StringBuffer text) {
        text.append(goals.size());
        if (goals.size() > 0) {
            text.append(" (");
            for (Goal goal : goals) {
                text.append(goal.getScorerName());
                text.append(" ");
                text.append(goal.getMinute());
                text.append("' ");
            }
            // delete last space
            text.deleteCharAt(text.length() - 1);
            text.append(")");
        }
    }


}
