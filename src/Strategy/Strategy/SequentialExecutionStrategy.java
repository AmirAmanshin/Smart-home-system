package Strategy;
import BuilderFacade.*;
import java.util.List;

public class SequentialExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(List<DeviceAction> actions) {
        System.out.println("Executing actions sequentially.");
        for (DeviceAction action : actions) {
            action.execute();
        }
    }
}