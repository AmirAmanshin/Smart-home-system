package Observer;

public class NotificationObserver implements ScenarioObserver {
    @Override
    public void onScenarioStarted(String scenarioName) {
        System.out.println("[NOTIFICATION] Starting scenario: " + scenarioName);
    }

    @Override
    public void onScenarioCompleted(String scenarioName) {
        System.out.println("[NOTIFICATION] ✓ Scenario '" + scenarioName + "' completed successfully!");
    }

    @Override
    public void onScenarioFailed(String scenarioName, String error) {
        System.out.println("[NOTIFICATION] ✗ Scenario '" + scenarioName + "' failed!");
    }

    @Override
    public void onActionExecuted(String scenarioName, String actionDescription) {
    }
}