package Strategy;
import BuilderFacade.*;
import java.util.List;

public class ParallelExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(List<DeviceAction> actions) {
        System.out.println("Executing actions in parallel...");
        actions.parallelStream().forEach(DeviceAction::execute);
    }
}