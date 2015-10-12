package jihedamine.gamecommand.commands;

import jihedamine.Game;
import jihedamine.gamecommand.AbstractGameCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 *  The command start a new game between the two teams which names are passed as parameters
 *
 *  Pattern: "Start: '<Name of Home Team>' vs. '<Name of Away Team>'"
 *  Example: "Start: 'England' vs. 'West Germany'"
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
