package Strategy;
import BuilderFacade.*;
import java.util.List;

public class RetryExecutionStrategy implements ExecutionStrategy {
    private final int maxRetries;

    public RetryExecutionStrategy(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public void execute(List<DeviceAction> actions) {
        System.out.println("Executing with retry strategy (max " + maxRetries + " retries)...");
        for (DeviceAction action : actions) {
            int attempts = 0;
            boolean success = false;

            while (attempts <= maxRetries && !success) {
                try {
                    action.execute();
                    success = true;
                } catch (Exception e) {
                    attempts++;
                    if (attempts > maxRetries) {
                        System.err.println("BuilderFacade.Action failed after " + maxRetries + " retries");
                    }
                }
            }
        }
    }
}