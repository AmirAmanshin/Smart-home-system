package Factory.adapters;

import Factory.devices.IDevice;
import Factory.devices.Sensor;
import Factory.implementations.SmokeSensor;
import Factory.factories.WifiAPI;

/**
 * Адаптер WiFi для SmokeSensor - интегрирует WiFi протокол с датчиком дыма
 */
public class WifiSensorAdapter implements IDevice, Sensor {
    private SmokeSensor smokeSensor;
    private WifiAPI wifiAPI;

    public WifiSensorAdapter(SmokeSensor smokeSensor, WifiAPI wifiAPI) {
        this.smokeSensor = smokeSensor;
        this.wifiAPI = wifiAPI;
    }

    @Override
    public String getName() {
        return smokeSensor.getName() + " (WiFi)";
    }

    @Override
    public double readValue() {
        wifiAPI.wifiTurnOn();
        double value = smokeSensor.readValue();
        System.out.println("WiFi: Read sensor value: " + value);
        return value;
    }
}
