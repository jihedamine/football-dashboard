package jihedamine;

/**
 * Created by jamaaref on 05/10/15.
 */
public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private boolean isInProgress;

    public void start(String homeTeamName, String awayTeamName) {
        homeTeam = new Team(homeTeamName);
        awayTeam = new Team(awayTeamName);
        isInProgress = true;
    }

    public void end() {
        homeTeam = null;
        awayTeam = null;
        isInProgress = false;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public boolean isInProgress() {
        return isInProgress;
    }

    public Team getTeamByName(String teamName) {
        if (teamName.equals(homeTeam.getName())) {
            return homeTeam;
        } else if (teamName.equals(awayTeam.getName())) {
            return awayTeam;
        } else throw new IllegalArgumentException();
    }

}
