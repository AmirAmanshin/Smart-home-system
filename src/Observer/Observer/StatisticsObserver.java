package Observer;

public class StatisticsObserver implements ScenarioObserver {
    private int scenariosStarted = 0;
    private int scenariosCompleted = 0;
    private int scenariosFailed = 0;
    private int actionsExecuted = 0;

    @Override
    public void onScenarioStarted(String scenarioName) {
        scenariosStarted++;
    }

    @Override
    public void onScenarioCompleted(String scenarioName) {
        scenariosCompleted++;
    }

    @Override
    public void onScenarioFailed(String scenarioName, String error) {
        scenariosFailed++;
    }

    @Override
    public void onActionExecuted(String scenarioName, String actionDescription) {
        actionsExecuted++;
    }

    public void printStatistics() {
        System.out.println("\n=== Statistics ===");
        System.out.println("Scenarios started: " + scenariosStarted);
        System.out.println("Scenarios completed: " + scenariosCompleted);
        System.out.println("Scenarios failed: " + scenariosFailed);
        System.out.println("Actions executed: " + actionsExecuted);
        System.out.println("==================\n");
    }
}