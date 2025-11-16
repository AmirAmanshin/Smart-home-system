package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.CleaningControl;

public class RobotVacuum implements IDevice, CleaningControl {

    @Override
    public String getName() {
        return "Robot Vacuum";
    }

    @Override
    public void startCleaning() {
        System.out.println("Vacuum cleaning started.");
    }

    @Override
    public void stopCleaning() {
        System.out.println("Vacuum cleaning stopped.");
    }

    @Override
    public void setSchedule(String time) {
        System.out.println("Cleaning scheduled at " + time);
    }
}
