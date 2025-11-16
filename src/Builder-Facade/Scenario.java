// Импортируем List.
import java.util.List;

public class Scenario {
    private final String name;
    private final List<Action> actions;
    private final List<Condition> conditions;

    public Scenario(String name, List<Action> actions, List<Condition> conditions) {
        this.name = name;
        this.actions = actions;
        this.conditions = conditions;
    }
    
}
