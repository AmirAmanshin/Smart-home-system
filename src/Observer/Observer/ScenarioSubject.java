package Observer;

public interface ScenarioSubject {
    void attach(ScenarioObserver observer);
    void detach(ScenarioObserver observer);
    void notifyObservers();
}