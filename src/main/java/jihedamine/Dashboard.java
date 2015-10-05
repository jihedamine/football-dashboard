package jihedamine;

import jihedamine.command.GameCommandExecutor;

/**
 * Created by jamaaref on 05/10/15.
 */
public class Dashboard {

    private Game game;
    private GameCommandExecutor commandExecutor;

    public Dashboard() {
        game = new Game();
        commandExecutor = new GameCommandExecutor(game);
    }

    public String execute(String command) {
        return commandExecutor.execute(command);
    }

    private static void printTeam(Team team, StringBuffer text) {
        text.append(team.getName());
        text.append(" ");
        text.append(team.getGoals().size());
        if (team.getGoals().size() > 0) {
            text.append(" (");
            for (Goal goal : team.getGoals()) {
                text.append(goal.getScorerName());
                text.append(" ");
                text.append(goal.getMinute());
                text.append("' ");
            }
            // delete last space
            text.deleteCharAt(text.length() - 1);
            text.append(")");
        }
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        System.out.println(dashboard.execute("Start: 'England' vs. 'West Germany'"));
        System.out.println(dashboard.print());
        System.out.println(dashboard.execute("11 'West Germany' Haller"));
        System.out.println(dashboard.print());
        System.out.println(dashboard.execute("25 'West Germany' Klinsmann"));
        System.out.println(dashboard.print());
        System.out.println(dashboard.execute("33 'England' Shearer"));
        System.out.println(dashboard.print());
        System.out.println(dashboard.execute("End"));
    }

    public String print() {
        String result;
        if (game.isInProgress()) {
            StringBuffer text = new StringBuffer();
            printTeam(game.getHomeTeam(), text);
            text.append(" vs. ");
            printTeam(game.getAwayTeam(), text);
            result = text.toString();
        } else {
            result = "No game currently in progress";
        }
        return result;
    }
}
