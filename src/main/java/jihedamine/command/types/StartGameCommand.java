package jihedamine.command.types;

import jihedamine.Game;
import jihedamine.command.AbstractGameCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamaaref on 05/10/15.
 */
public class StartGameCommand extends AbstractGameCommand {

    public StartGameCommand() {
        pattern = Pattern.compile("Start: '([a-zA-Z ]+)?' vs. '([a-zA-Z ]+)?'");
    }

    @Override
    public String executeMatches(String command, Game game, Matcher matcher) {
        if (!isGameStarted(game)) {
            game.start(matcher.group(1), matcher.group(2));
            return "Game started";
        } else {
            return "A game is already started. End it before starting a new one";
        }
    }
}
