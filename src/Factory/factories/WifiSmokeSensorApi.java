package Factory.factories;

public class WifiSmokeSensorApi {
    public boolean wifiSmokeDetected() {
        System.out.println("WiFi Smoke Sensor: smoke detected!");
        return true;
    }

    public void wifiTurnOn() {
        System.out.println("WiFi Smoke Sensor: turn on!");
    }
}
