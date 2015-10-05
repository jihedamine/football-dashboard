package jihedamine.command.types;

import jihedamine.Game;
import jihedamine.command.AbstractGameCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamaaref on 05/10/15.
 */
public class EndGameCommand extends AbstractGameCommand {

    public EndGameCommand() {
        pattern =  Pattern.compile("End");
    }

    @Override
    public String executeMatches(String command, Game game, Matcher matcher) {
        if (isGameStarted(game)) {
            game.end();
            return "Game ended";
        } else {
            return "No game currently in progress";
        }
    }

}
