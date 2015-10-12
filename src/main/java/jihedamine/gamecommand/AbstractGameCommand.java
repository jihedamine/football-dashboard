package jihedamine.gamecommand;

import jihedamine.Game;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * Implements the pattern matching portion and the isGameStarted method for a GameCommand
 */
public abstract class AbstractGameCommand implements GameCommand {
    protected Pattern pattern;

    @Override
    public String execute(String command, Game game) {
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            return executeMatches(command, game, matcher);
        } else {
            return "";
        }
    }

    /**
     * Has to be implemented by every class extending AbstractGameCommand
     * Defines the command's processing on a game
     * @param str string matching the command's pattern
     * @param game game on which the command is executed
     * @param matcher matcher of the command's pattern
     * @return result of the command's execution
     */
    protected abstract String executeMatches(String str, Game game, Matcher matcher);

    public boolean isGameStarted(Game game) {
        return (game != null && game.isInProgress());
    }
}