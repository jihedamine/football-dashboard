package jihedamine;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by jamaaref on 06/10/15.
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
}
