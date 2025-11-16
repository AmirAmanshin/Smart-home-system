package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.ClimateControl;

public class Heater implements IDevice, ClimateControl {

    @Override
    public String getName() {
        return "Heater";
    }

    @Override
    public void setTemperature(int temp) {
        System.out.println("Heater temp set to " + temp + "°C");
    }

    @Override
    public void setMode(String mode) {
        System.out.println("Heater mode: " + mode);
    }
}
