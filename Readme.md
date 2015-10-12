# Football scoring dashboard

By Jihed Amine Maaref (jihedamine@gmail.com)

This a maven project. IntelliJ iml metadata is also provided.

The dashboard is made using a pluggable architecture:
- Command types can be added and removed from the dashboard
- The dashboard can be extended with new commands

The application model entities (Team, Goal, Game) are immutable:
- Attributes are private and only public getters are provided
- The attribute values are set only when creating the instance (except for adding goals to a game)
- The dashboard is responsible for creating, modifying and ending a game

The dashboard supports internationalization and messages are provided for french and english languages.

The application has unit tests covering the basic commands, special cases and internationalization.

The Dashboard class has a main method providing an interactive shell interpreting dashboard commands
and displaying their execution's results