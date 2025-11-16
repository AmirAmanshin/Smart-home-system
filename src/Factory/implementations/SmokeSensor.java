package Factory.implementations;

import Factory.devices.IDevice;
import Factory.devices.Sensor;

public class SmokeSensor implements IDevice, Sensor {

    @Override
    public String getName() {
        return "Smoke Sensor";
    }

    @Override
    public double readValue() {
        return Math.random() * 10; // условное значение
    }
}
