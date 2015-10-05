package jihedamine.command;

import jihedamine.Game;

import java.util.regex.Pattern;

/**
 * Created by jamaaref on 05/10/15.
 */
public interface GameCommand {
    boolean isGameStarted(Game game);

    String execute(String command, Game game);
}
