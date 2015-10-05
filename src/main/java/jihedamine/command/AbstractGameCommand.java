package jihedamine.command;

import jihedamine.Game;
import jihedamine.command.GameCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamaaref on 05/10/15.
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

    protected abstract String executeMatches(String str, Game game, Matcher matcher);

    public boolean isGameStarted(Game game) {
        return (game != null && game.isInProgress());
    }
}