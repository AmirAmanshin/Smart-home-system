package Factory.factories;

public class WifiSmartLightApi {
    public void wifiOn() { System.out.println("WiFi Smart Light: ON"); }
    public void wifiOff() { System.out.println("WiFi Smart Light: OFF"); }
    public void wifiBrightness(int b) { System.out.println("WiFi Smart Light: brightness = " + b); }

    public void wifiTurnOn() {
        System.out.println("WiFi Smart Light: turn on!");
    }

    public void wifiTurnOff() {
        System.out.println("WiFi Smart Light: turn off!");
    }
}
