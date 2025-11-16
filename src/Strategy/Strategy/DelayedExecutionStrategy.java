package Strategy;
import BuilderFacade.*;
import java.util.List;

public class DelayedExecutionStrategy implements ExecutionStrategy {
    private final long delayMillis;

    public DelayedExecutionStrategy(long delayMillis) {
        this.delayMillis = delayMillis;
    }

    @Override
    public void execute(List<DeviceAction> actions) {
        System.out.println("Executing actions with " + delayMillis + "ms delay...");
        for (DeviceAction action : actions) {
            action.execute();
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}