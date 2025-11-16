package Observer;

import java.util.ArrayList;
import java.util.List;

public class ScenarioEventManager {
    private final List<ScenarioObserver> observers = new ArrayList<>();

    public void subscribe(ScenarioObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(ScenarioObserver observer) {
        observers.remove(observer);
    }

    public void notifyScenarioStarted(String scenarioName) {
        for (ScenarioObserver observer : observers) {
            observer.onScenarioStarted(scenarioName);
        }
    }

    public void notifyScenarioCompleted(String scenarioName) {
        for (ScenarioObserver observer : observers) {
            observer.onScenarioCompleted(scenarioName);
        }
    }

    public void notifyScenarioFailed(String scenarioName, String error) {
        for (ScenarioObserver observer : observers) {
            observer.onScenarioFailed(scenarioName, error);
        }
    }

    public void notifyActionExecuted(String scenarioName, String actionDescription) {
        for (ScenarioObserver observer : observers) {
            observer.onActionExecuted(scenarioName, actionDescription);
        }
    }
}