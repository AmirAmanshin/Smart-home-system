package Strategy;
import BuilderFacade.*;
import java.util.List;

public interface ExecutionStrategy {
    void execute(List<DeviceAction> actions);
}