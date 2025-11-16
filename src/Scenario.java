import java.util.List;
import BuilderFacade.*;
import Strategy.ExecutionStrategy;
import Observer.ScenarioEventManager;

public class Scenario {
    private final String name;
    private final List<DeviceAction> deviceActions;
    private final List<Condition> conditions;
    private final ExecutionStrategy executionStrategy;
    private final ScenarioEventManager eventManager;


    public Scenario(String name,
                    List<DeviceAction> deviceActions,
                    ExecutionStrategy executionStrategy,
                    ScenarioEventManager eventManager,
                    List<Condition> conditions) {
        this.name = name;
        this.deviceActions = deviceActions;
        this.executionStrategy = executionStrategy;
        this.eventManager = eventManager;
        this.conditions = conditions;
    }

    public boolean canExecute(StateContext state) {
        for (Condition c : conditions) {
            if (!c.isMet(state)) {
                return false;
            }
        }
        return true;
    }

    public void execute() {
        try {
            eventManager.notifyScenarioStarted(name);

            executionStrategy.execute(deviceActions);

            for (int i = 0; i < deviceActions.size(); i++) {
                eventManager.notifyActionExecuted(name, "BuilderFacade.Action " + (i + 1));
            }

            eventManager.notifyScenarioCompleted(name);

        } catch (Exception e) {
            eventManager.notifyScenarioFailed(name, e.getMessage());
            throw e;
        }
    }

    public String getName() {
        return name;
    }

    public List<DeviceAction> getDeviceActions() {
        return deviceActions;
    }
}