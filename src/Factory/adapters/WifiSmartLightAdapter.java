package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.LightControl;
import Factory.factories.WifiSmartLightApi;

/**
 * Адаптер для SmartLight по WiFi протоколу
 */
public class WifiSmartLightAdapter implements IDevice, LightControl {
    private WifiSmartLightApi wifiAPI;

    public WifiSmartLightAdapter(WifiSmartLightApi wifiAPI) {
        this.wifiAPI = wifiAPI;
    }

    @Override
    public String getName() {
        return "Smart Light (WiFi)";
    }

    @Override
    public void setBrightness(int level) {
        if (level > 0) {
            wifiAPI.wifiTurnOn();
            System.out.println("WiFi: Brightness set to " + level);
        } else {
            wifiAPI.wifiTurnOff();
            System.out.println("WiFi: Device off");
        }
    }

    @Override
    public void setColor(String color) {
        System.out.println("WiFi: Color set to " + color);
    }
}
