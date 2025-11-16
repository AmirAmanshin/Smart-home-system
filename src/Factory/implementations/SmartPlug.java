package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.EnergyManagement;

public class SmartPlug implements IDevice, EnergyManagement {

    private int consumption = 120;

    @Override
    public String getName() {
        return "Smart Plug";
    }

    @Override
    public void limitPower(int watts) {
        System.out.println("Power limited to " + watts + "W");
    }

    @Override
    public int getConsumption() {
        return consumption;
    }
}
