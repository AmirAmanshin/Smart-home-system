package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.Sensor;
import Factory.factories.WifiSmokeSensorApi;

/**
 * Адаптер для SmokeSensor по WiFi протоколу
 */
public class WifiSmokeSensorAdapter implements IDevice, Sensor {
    private WifiSmokeSensorApi wifiAPI;

    public WifiSmokeSensorAdapter(WifiSmokeSensorApi wifiAPI) {
        this.wifiAPI = wifiAPI;
    }

    @Override
    public String getName() {
        return "Smoke Sensor (WiFi)";
    }

    @Override
    public double readValue() {
        wifiAPI.wifiTurnOn();
        double value = Math.random() * 10;
        System.out.println("WiFi: Read sensor value: " + value);
        return value;
    }
}
