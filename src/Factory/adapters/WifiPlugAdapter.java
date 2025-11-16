package Factory.adapters;

import Factory.devices.EnergyManagement;
import Factory.devices.IDevice;
import Factory.factories.WifiAPI;
import Factory.implementations.SmartPlug;

/**
 * Адаптер WiFi для SmartPlug - интегрирует WiFi протокол с умной розеткой
 */
public class WifiPlugAdapter implements IDevice, EnergyManagement {
    private SmartPlug smartPlug;
    private WifiAPI wifiAPI;

    public WifiPlugAdapter(SmartPlug smartPlug, WifiAPI wifiAPI) {
        this.smartPlug = smartPlug;
        this.wifiAPI = wifiAPI;
    }

    @Override
    public String getName() {
        return smartPlug.getName() + " (WiFi)";
    }

    @Override
    public void limitPower(int watts) {
        wifiAPI.wifiTurnOn();
        smartPlug.limitPower(watts);
    }

    @Override
    public int getConsumption() {
        return smartPlug.getConsumption();
    }
}
