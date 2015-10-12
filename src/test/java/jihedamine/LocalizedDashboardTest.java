package jihedamine;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 06/10/15.
 *
 * Tests localized dashboard messages
 *
 */
public class LocalizedDashboardTest {

    Dashboard dashboard;

    @Before
    public void init() {
        dashboard = new Dashboard(Locale.FRENCH);
    }

    @Test
    public void testCreateGame() {
        String result = dashboard.execute("Start: 'England' vs. 'West Germany'");
        assertEquals("Partie d\u00E9marr\u00E9e", result);
    }

    @Test
    public void testAddGoal() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("13 'West Germany' Haller");
        assertEquals("But ajout\u00E9", result);
    }

    @Test
    public void testEndGame() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("End");
        assertEquals("Partie termin\u00E9e", result);
        result = dashboard.execute("11 'West Germany' Haller");
        assertEquals("Aucune partie actuellement en cours", result);
    }

    @Test
    public void testDashboardNonValidCommandNoGameInProgress() {
        String result = dashboard.execute("Non valid command");
        assertEquals("erreur saisie - veuillez d\u00E9marrer une partie en tapant 'Start: '<Nom de l'\u0EE9quipe " +
                "\u00E0 domicile>' vs. '<Nom de l'\u0EE9quipe \u00E0 l'ext\u00E9rieur>'", result);
    }

    @Test
    public void testDashboardNonValidCommandGameInProgress() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("Non valid command");
        assertEquals("erreur saisie - veuillez saisir 'print' pour voir les d\u00E9tails de la partie", result);
    }

    @Test
    public void testGoalBackInTime() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        dashboard.execute("18 'England' Hurst");
        String result = dashboard.execute("11 'West Germany' Haller");
        assertEquals("Le but ne peut s'\u00EAtre produit dans le pass\u00E9", result);
    }

    @Test
    public void testNonValidTeamName() {
        dashboard.execute("Start: 'England' vs. 'West Germany'");
        String result = dashboard.execute("18 'Netherlands' Cruyff");
        assertEquals("Le nom de l'\u00E9quipe ne correspond pas \u00E0 une \u00E9quipe jouant la partie", result);
    }
}
