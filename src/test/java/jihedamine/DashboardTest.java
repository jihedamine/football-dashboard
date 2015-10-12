package jihedamine;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 06/10/15.
 *
 * Tests various dashboard command sequences including issuing non valid commands
 *
 */
public class DashboardTest {

    Dashboard dashboard;

    @Before
    public void init() {
        dashboard = new Dashboard();
    }

    @Test
    public void testCreateGame() {
        String result = dashboard.execute("Start: 'England' vs. 'West Germany'");
        assertEquals("Game started", result);
    }

    @Test
    public void testAddGoal() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("13 'West Germany' Haller");
        assertEquals("Goal added", result);
    }

    @Test
    public void printAfterGoal() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        dashboard.execute("13 'West Germany' Haller");
        String result = dashboard.execute("print");
        assertEquals("England 0 vs. West Germany 1 (Haller 13')", result);
    }

    @Test
    public void printAfterOneToOne() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        dashboard.execute("12 'West Germany' Haller");
        dashboard.execute("18 'England' Hurst");
        String result = dashboard.execute("print");
        assertEquals("England 1 (Hurst 18') vs. West Germany 1 (Haller 12')", result);
    }

    @Test
    public void printAfterTwoToOne() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        dashboard.execute("12 'West Germany' Haller");
        dashboard.execute("18 'England' Hurst");
        dashboard.execute("78 'England' Peters");
        String result = dashboard.execute("print");
        assertEquals("England 2 (Hurst 18' Peters 78') vs. West Germany 1 (Haller 12')", result);
    }

    @Test
    public void testEndGame() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("End");
        assertEquals("Game ended", result);
        result = dashboard.execute("11 'West Germany' Haller");
        assertEquals("No game currently in progress", result);
    }

    @Test
    public void testDashboardValidCommandNoGameInProgress() {
        String result = dashboard.execute("11 'West Germany' Haller");
        assertEquals("No game currently in progress", result);
    }

    @Test
    public void testDashboardNonValidCommandNoGameInProgress() {
        String result = dashboard.execute("Non valid command");
        assertEquals("input error - please start a game through typing " +
                "'Start: '<Name of Home Team>' vs. '<Name of Away Team>'", result);
    }

    @Test
    public void testDashboardNonValidCommandGameInProgress() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("Non valid command");
        assertEquals("input error - please type 'print' for game details", result);
    }

    @Test
    public void testGoalBackInTime() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        dashboard.execute("18 'England' Hurst");
        String result = dashboard.execute("11 'West Germany' Haller");
        assertEquals("The goal can't happen back in time", result);
    }

    @Test
    public void testNegativeGoalTime() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("-18 'England' Hurst");
        // Input begins with a minus and doesn't match the goal command pattern
        // so the command isn't considered a valid one
        assertEquals("input error - please type 'print' for game details", result);
    }

    @Test
    public void testMoreThanThreeDigitGoalTime() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("1855 'England' Hurst");
        // Input has more than three digit goal time and doesn't match the goal command pattern
        // so the command isn't considered a valid one
        assertEquals("input error - please type 'print' for game details", result);
    }

    @Test
    public void testNonValidGoalTime() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("185 'England' Hurst");
        // Input has 3 digits goal time and matches the goal command pattern
        // so the command is considered valid, but the minutes value is greater than 140mn
        // 140mn = 2 * 45mn (two half-time periods) + 2 * 15mn (two extra time periods)
        // + 20mn eventual maximum additional time for the 4 periods
        assertEquals("Goal time value isn't valid", result);
    }


    @Test
    public void testNonValidTeamName() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("18 'Netherlands' Cruyff");
        assertEquals("Team name doesn't match a team playing the game", result);
    }
}
