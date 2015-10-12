package jihedamine.gamecommand.commands;

import jihedamine.Game;
import jihedamine.gamecommand.AbstractGameCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * The command ends the game
 *
 * Pattern: "End"
 */
public class EndGameCommand extends AbstractGameCommand {

    public EndGameCommand() {
        pattern =  Pattern.compile("End");
    }

    @Override
    public String executeMatches(String command, Game game, Matcher matcher) {
        if (isGameStarted(game)) {
            game.end();
            return "game-ended";
        } else {
            return "no-game-in-progress";
        }
    }

}
