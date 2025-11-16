package Factory.devices;

public interface EnergyManagement {
    void limitPower(int watts);
    int getConsumption();
}