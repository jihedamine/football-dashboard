package jihedamine;

import jihedamine.gamecommand.GameCommand;
import jihedamine.gamecommand.commands.EndGameCommand;
import jihedamine.gamecommand.commands.GoalGameCommand;
import jihedamine.gamecommand.commands.PrintGameCommand;
import jihedamine.gamecommand.commands.StartGameCommand;

import java.util.*;

/**
 * Created by jamaaref on 05/10/15.
 */
public class Dashboard {
    private Game game;
    private Set<GameCommand> commands;
    ResourceBundle messages;

    public Dashboard() {
        game = new Game();
        commands = new HashSet<>();
        commands.add(new StartGameCommand());
        commands.add(new GoalGameCommand());
        commands.add(new EndGameCommand());
        commands.add(new PrintGameCommand());
    }

    public Dashboard(Locale locale) {
        this();
        messages = ResourceBundle.getBundle("messages", locale);
    }

    public String execute(String inputString) {
        StringBuilder result = new StringBuilder();

        for (GameCommand command : commands) {
            result.append(command.execute(inputString, game));
        }

        if (result.length() == 0) {
            if (game.isInProgress()) {
                result.append("input-error");
            } else {
                result.append("input-error-no-game");
            }
        }

        try {
            return messages.getString(result.toString());
        } catch (MissingResourceException e) {
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        Scanner console = new Scanner(System.in);
        String input;
        do {
            System.out.print("> ");
            input = console.nextLine().trim();
            System.out.println(dashboard.execute(input));
        } while (!input.equals("End"));
    }

}
