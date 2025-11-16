package Observer;

public class LoggingObserver implements ScenarioObserver {
    @Override
    public void onScenarioStarted(String scenarioName) {
        System.out.println("[LOG] Scenario started: " + scenarioName);
    }

    @Override
    public void onScenarioCompleted(String scenarioName) {
        System.out.println("[LOG] Scenario completed: " + scenarioName);
    }

    @Override
    public void onScenarioFailed(String scenarioName, String error) {
        System.err.println("[LOG] Scenario failed: " + scenarioName + " - Error: " + error);
    }

    @Override
    public void onActionExecuted(String scenarioName, String actionDescription) {
        System.out.println("[LOG] BuilderFacade.Action executed in " + scenarioName + ": " + actionDescription);
    }
}