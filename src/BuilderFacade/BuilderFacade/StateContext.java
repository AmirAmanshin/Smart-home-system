package BuilderFacade;

public class StateContext {
    private final int temperature;
    private final int powerConsumption;

    public StateContext(int temperature, int powerConsumption) {
        this.temperature = temperature;
        this.powerConsumption = powerConsumption;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }
}