package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.CleaningControl;

public class RobotMop implements IDevice, CleaningControl {

    @Override
    public String getName() {
        return "Robot Mop";
    }

    @Override
    public void startCleaning() {
        System.out.println("Mopping started.");
    }

    @Override
    public void stopCleaning() {
        System.out.println("Mopping stopped.");
    }

    @Override
    public void setSchedule(String time) {
        System.out.println("Mopping scheduled at " + time);
    }
}
