package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.LightControl;
import Factory.factories.WifiAPI;

/**
 * Адаптер для преобразования WiFi протокола в стандартный интерфейс LightControl
 */
public class WifiProtocolAdapter implements IDevice, LightControl {
    private WifiAPI wifiAPI;
    private String deviceName;

    public WifiProtocolAdapter(WifiAPI wifiAPI, String deviceName) {
        this.wifiAPI = wifiAPI;
        this.deviceName = deviceName;
    }

    @Override
    public String getName() {
        return deviceName + " (WiFi)";
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
