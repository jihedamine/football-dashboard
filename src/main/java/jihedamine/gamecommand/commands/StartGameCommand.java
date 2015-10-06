package jihedamine.gamecommand.commands;

import jihedamine.Game;
import jihedamine.gamecommand.AbstractGameCommand;

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
            return "game-started";
        } else {
            return "end-before-new-game";
        }
    }
}
