package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.Security;
import Factory.factories.ZigbeeAPI;

/**
 * Адаптер для преобразования Zigbee протокола в стандартный интерфейс Security
 */
public class ZigbeeProtocolAdapter implements IDevice, Security {
    private ZigbeeAPI zigbeeAPI;
    private String deviceName;
    private boolean isEnabled = false;

    public ZigbeeProtocolAdapter(ZigbeeAPI zigbeeAPI, String deviceName) {
        this.zigbeeAPI = zigbeeAPI;
        this.deviceName = deviceName;
    }

    @Override
    public String getName() {
        return deviceName + " (Zigbee)";
    }

    @Override
    public void enable() {
        if (!isEnabled) {
            zigbeeAPI.zbStart();
            isEnabled = true;
        }
    }

    @Override
    public void disable() {
        if (isEnabled) {
            zigbeeAPI.zbStop();
            isEnabled = false;
        }
    }

    @Override
    public String getSecurityStatus() {
        return "Zigbee device " + (isEnabled ? "enabled" : "disabled");
    }
}
