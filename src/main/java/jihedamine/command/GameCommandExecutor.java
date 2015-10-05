package jihedamine.command;

import jihedamine.Game;
import jihedamine.command.types.EndGameCommand;
import jihedamine.command.types.GoalGameCommand;
import jihedamine.command.types.StartGameCommand;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jamaaref on 05/10/15.
 */
public class GameCommandExecutor {
    private Game game;
    private Set<GameCommand> commands;

    public GameCommandExecutor(Game game) {
        commands = new HashSet<>();
        commands.add(new StartGameCommand());
        commands.add(new GoalGameCommand());
        commands.add(new EndGameCommand());
        this.game = game;
    }

    public String execute(String inputString) {
        StringBuilder result = new StringBuilder();

        boolean validCommand = false;

        for (GameCommand command : commands) {
            result.append(command.execute(inputString, game));
            validCommand = true;
        }

        if (!validCommand) {
            if (game != null && game.isInProgress()) {
                result.append("input error - please type 'print' for game details");
            } else {
                result.append("input error - please start a game through typing 'Start: '<Name of Home Team>' vs. '<Name of Away Team>'");
            }
        }

        return result.toString();
    }

}
