package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.LightControl;
import Factory.factories.ZigbeeAPI;
import Factory.implementations.RGBLight;

/**
 * Адаптер Zigbee для RGBLight - интегрирует Zigbee протокол с RGB лампой
 */
public class ZigbeeRGBLightAdapter implements IDevice, LightControl {
    private RGBLight rgbLight;
    private ZigbeeAPI zigbeeAPI;

    public ZigbeeRGBLightAdapter(RGBLight rgbLight, ZigbeeAPI zigbeeAPI) {
        this.rgbLight = rgbLight;
        this.zigbeeAPI = zigbeeAPI;
    }

    @Override
    public String getName() {
        return rgbLight.getName() + " (Zigbee)";
    }

    @Override
    public void setBrightness(int level) {
        zigbeeAPI.zbStart();
        rgbLight.setBrightness(level);
    }

    @Override
    public void setColor(String color) {
        rgbLight.setColor(color);
    }
}
