package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.LightControl;
import Factory.factories.ZigbeeSmartLightApi;

/**
 * Адаптер для SmartLight по Zigbee протоколу
 */
public class ZigbeeSmartLightAdapter implements IDevice, LightControl {
    private ZigbeeSmartLightApi zigbeeAPI;

    public ZigbeeSmartLightAdapter(ZigbeeSmartLightApi zigbeeAPI) {
        this.zigbeeAPI = zigbeeAPI;
    }

    @Override
    public String getName() {
        return "Smart Light (Zigbee)";
    }

    @Override
    public void setBrightness(int level) {
        if (level > 0) {
            zigbeeAPI.zbStart();
            System.out.println("Zigbee: Brightness set to " + level);
        } else {
            zigbeeAPI.zbStop();
            System.out.println("Zigbee: Device off");
        }
    }

    @Override
    public void setColor(String color) {
        System.out.println("Zigbee: Color set to " + color);
    }
}
