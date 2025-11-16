package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.LightControl;
import Factory.implementations.SmartLight;
import Factory.factories.WifiAPI;

/**
 * Адаптер WiFi для SmartLight - интегрирует WiFi протокол с умной лампой
 */
public class WifiLightAdapter implements IDevice, LightControl {
    private SmartLight smartLight;
    private WifiAPI wifiAPI;

    public WifiLightAdapter(SmartLight smartLight, WifiAPI wifiAPI) {
        this.smartLight = smartLight;
        this.wifiAPI = wifiAPI;
    }

    @Override
    public String getName() {
        return smartLight.getName() + " (WiFi)";
    }

    @Override
    public void setBrightness(int level) {
        if (level > 0) {
            wifiAPI.wifiTurnOn();
            smartLight.setBrightness(level);
        } else {
            wifiAPI.wifiTurnOff();
        }
    }

    @Override
    public void setColor(String color) {
        smartLight.setColor(color);
    }
}
