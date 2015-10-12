package jihedamine;

/**
 * Created by Jihed Amine Maaref (jihedamine@gmail.com) on 05/10/15.
 *
 * Represents a football team
 *
 */
public class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return name.equals(team.name);
    }
}
