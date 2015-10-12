package jihedamine.gamecommand;

import jihedamine.Game;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * Interface representing a game command
 */
public interface GameCommand {

    /**
     * Tells if the game is in progress
     * @param game game to evaluate
     * @return true if the game is started, false otherwise
     */
    boolean isGameStarted(Game game);

    /**
     * Executes a command on a game and returns the result
     * @param command command to execute
     * @param game game on which the command is executed
     * @return result of the command's execution
     */
    String execute(String command, Game game);
}
