package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.LightControl;

public class SmartLight implements IDevice, LightControl {

    @Override
    public String getName() {
        return "Smart Light";
    }

    @Override
    public void setBrightness(int level) {
        System.out.println("Brightness set to " + level);
    }

    @Override
    public void setColor(String color) {
        System.out.println("Color set to " + color);
    }
}
