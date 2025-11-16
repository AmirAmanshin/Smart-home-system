package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.Security;
import Factory.factories.ZigbeeAPI;
import Factory.implementations.Camera;

/**
 * Адаптер Zigbee для Camera - интегрирует Zigbee протокол с камерой безопасности
 */
public class ZigbeeCameraAdapter implements IDevice, Security {
    private Camera camera;
    private ZigbeeAPI zigbeeAPI;

    public ZigbeeCameraAdapter(Camera camera, ZigbeeAPI zigbeeAPI) {
        this.camera = camera;
        this.zigbeeAPI = zigbeeAPI;
    }

    @Override
    public String getName() {
        return camera.getName() + " (Zigbee)";
    }

    @Override
    public void enable() {
        zigbeeAPI.zbStart();
        camera.enable();
    }

    @Override
    public void disable() {
        zigbeeAPI.zbStop();
        camera.disable();
    }

    @Override
    public String getSecurityStatus() {
        return camera.getSecurityStatus() + " (Zigbee)";
    }
}
