package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.LightControl;

public class RGBLight implements IDevice, LightControl {

    @Override
    public String getName() {
        return "RGB Light";
    }

    @Override
    public void setBrightness(int level) {
        System.out.println("RGB brightness set to " + level);
    }

    @Override
    public void setColor(String color) {
        System.out.println("RGB color set to " + color);
    }
}
