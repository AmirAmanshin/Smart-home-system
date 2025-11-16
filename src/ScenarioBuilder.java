import java.util.ArrayList;
import java.util.List;
import BuilderFacade.*;
import Strategy.*;
import Observer.*;

public class ScenarioBuilder {
    private String name;
    private List<DeviceAction> actions = new ArrayList<>();
    private List<Condition> conditions;
    private ExecutionStrategy strategy = new SequentialExecutionStrategy(); // Default
    private ScenarioEventManager eventManager = new ScenarioEventManager();

    public ScenarioBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ScenarioBuilder addAction(DeviceAction action) {
        this.actions.add(action);
        return this;
    }

    public ScenarioBuilder addCondition(Condition condition) {
        conditions.add(condition);
        return this;
    }

    public ScenarioBuilder addActions(List<DeviceAction> actions) {
        this.actions.addAll(actions);
        return this;
    }

    public ScenarioBuilder withSequentialExecution() {
        this.strategy = new SequentialExecutionStrategy();
        return this;
    }

    public ScenarioBuilder withParallelExecution() {
        this.strategy = new ParallelExecutionStrategy();
        return this;
    }

    public ScenarioBuilder withDelayedExecution(long delayMillis) {
        this.strategy = new DelayedExecutionStrategy(delayMillis);
        return this;
    }

    public ScenarioBuilder withConditionalExecution(java.util.function.Supplier<Boolean> condition) {
        this.strategy = new ConditionalExecutionStrategy(condition);
        return this;
    }

    public ScenarioBuilder withRetryExecution(int maxRetries) {
        this.strategy = new RetryExecutionStrategy(maxRetries);
        return this;
    }

    public ScenarioBuilder withExecutionStrategy(ExecutionStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public ScenarioBuilder withLogging() {
        this.eventManager.subscribe(new LoggingObserver());
        return this;
    }

    public ScenarioBuilder withNotifications() {
        this.eventManager.subscribe(new NotificationObserver());
        return this;
    }

    public ScenarioBuilder withStatistics() {
        this.eventManager.subscribe(new StatisticsObserver());
        return this;
    }

    public ScenarioBuilder withObserver(ScenarioObserver observer) {
        this.eventManager.subscribe(observer);
        return this;
    }

    public ScenarioBuilder withEventManager(ScenarioEventManager eventManager) {
        this.eventManager = eventManager;
        return this;
    }

    public Scenario build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Scenario name must be set");
        }
        if (actions.isEmpty()) {
            throw new IllegalStateException("Scenario must have at least one action");
        }

        return new Scenario(name, actions, strategy, eventManager, conditions);
    }

    public ScenarioBuilder reset() {
        this.name = null;
        this.actions = new ArrayList<>();
        this.strategy = new SequentialExecutionStrategy();
        this.eventManager = new ScenarioEventManager();
        return this;
    }
}