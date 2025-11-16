package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.Security;

public class Camera implements IDevice, Security {

    @Override
    public String getName() {
        return "Security Camera";
    }

    @Override
    public void enable() {
        System.out.println("Camera enabled.");
    }

    @Override
    public void disable() {
        System.out.println("Camera disabled.");
    }

    @Override
    public String getSecurityStatus() {
        return "Camera active and recording.";
    }
}
