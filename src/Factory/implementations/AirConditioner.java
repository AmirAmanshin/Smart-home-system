package Factory.implementations;

import Factory.devices.*;

public class AirConditioner implements IDevice, ClimateControl{

    @Override
    public String getName() {
        return "Air Conditioner";
    }

    @Override
    public void setTemperature(int temp) {
        System.out.println("AC temperature set to " + temp + "°C");
    }

    @Override
    public void setMode(String mode) {
        System.out.println("AC mode set to: " + mode);
    }
}