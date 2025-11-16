package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.LightControl;
import Factory.factories.WifiRGBLightApi;

/**
 * Адаптер для RGBLight по WiFi протоколу
 */
public class WifiRGBLightAdapter implements IDevice, LightControl {
    private WifiRGBLightApi wifiAPI;

    public WifiRGBLightAdapter(WifiRGBLightApi wifiAPI) {
        this.wifiAPI = wifiAPI;
    }

    @Override
    public String getName() {
        return "RGB Light (WiFi)";
    }

    @Override
    public void setBrightness(int level) {
        if (level > 0) {
            wifiAPI.wifiTurnOn();
            System.out.println("WiFi: RGB Brightness set to " + level);
        } else {
            wifiAPI.wifiTurnOff();
        }
    }

    @Override
    public void setColor(String color) {
        System.out.println("WiFi: RGB Color set to " + color);
    }
}
