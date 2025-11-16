package Observer;

public interface ScenarioObserver {
    void onScenarioStarted(String scenarioName);
    void onScenarioCompleted(String scenarioName);
    void onScenarioFailed(String scenarioName, String error);
    void onActionExecuted(String scenarioName, String actionDescription);
}