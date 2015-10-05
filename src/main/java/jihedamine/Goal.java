package jihedamine;

/**
 * Created by jamaaref on 05/10/15.
 */
public class Goal {
    private int minute;
    private String scorerName;

    public Goal(int minute, String scorerName) {
        this.minute = minute;
        this.scorerName = scorerName;
    }

    public int getMinute() {
        return minute;
    }

    public String getScorerName() {
        return scorerName;
    }
}
