package Strategy;

import java.util.List;
import BuilderFacade.*;
public class ConditionalExecutionStrategy implements ExecutionStrategy {
    private final java.util.function.Supplier<Boolean> condition;

    public ConditionalExecutionStrategy(java.util.function.Supplier<Boolean> condition) {
        this.condition = condition;
    }

    @Override
    public void execute(List<DeviceAction> actions) {
        if (condition.get()) {
            System.out.println("Condition met, executing actions...");
            for (DeviceAction action : actions) {
                action.execute();
            }
        } else {
            System.out.println("Condition not met, skipping execution.");
        }
    }
}