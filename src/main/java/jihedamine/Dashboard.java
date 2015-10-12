package jihedamine;

import jihedamine.gamecommand.GameCommand;
import jihedamine.gamecommand.commands.EndGameCommand;
import jihedamine.gamecommand.commands.GoalGameCommand;
import jihedamine.gamecommand.commands.PrintGameCommand;
import jihedamine.gamecommand.commands.StartGameCommand;

import java.util.*;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * Represents a dashboard of a football game
 * The dashboard takes commands as input
 * The commands update the game
 * At anytime, the print commands prints the game's status
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
        messages = ResourceBundle.getBundle("messages");
    }

    /**
     * Instantiate a dashboard
     * @param locale locale in which dashboard messages will be displayed
     */
    public Dashboard(Locale locale) {
        this();
        messages = ResourceBundle.getBundle("messages", locale);
    }

    /**
     * Execute a command in the dashboard
     * @param inputString command to execute
     * @return message giving the result of the command's execution
     */
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

    /**
     * Creates an interactive dashboard prompt
     * where the user inputs commands
     * and the dashboard executes the commands
     * and displays their execution's result
     *
     * @param args The method can take an optional parameter for the language to use
     *             otherwise, english will be used as a fallback language
     */
    public static void main(String[] args) {
        Locale locale = Locale.ENGLISH;
        if (args.length > 0) {
            locale = new Locale(args[0]);
        }
        Dashboard dashboard = new Dashboard(locale);
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);
        Scanner console = new Scanner(System.in);
        String input;
        System.out.println(messages.getString("welcome"));
        System.out.println(messages.getString("end-to-exit"));
        do {
            System.out.print("> ");
            input = console.nextLine().trim();
            System.out.println(dashboard.execute(input));
        } while (!input.equals("End"));
    }

}
