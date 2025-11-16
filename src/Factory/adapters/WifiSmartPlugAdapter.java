package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.EnergyManagement;
import Factory.factories.WifiSmartPlugApi;

/**
 * Адаптер для SmartPlug по WiFi протоколу
 */
public class WifiSmartPlugAdapter implements IDevice, EnergyManagement {
    private WifiSmartPlugApi wifiAPI;

    public WifiSmartPlugAdapter(WifiSmartPlugApi wifiAPI) {
        this.wifiAPI = wifiAPI;
    }

    @Override
    public String getName() {
        return "Smart Plug (WiFi)";
    }

    @Override
    public void limitPower(int watts) {
        wifiAPI.wifiTurnOn();
        System.out.println("WiFi: Power limited to " + watts + "W");
    }

    @Override
    public int getConsumption() {
        return 120;
    }
}
