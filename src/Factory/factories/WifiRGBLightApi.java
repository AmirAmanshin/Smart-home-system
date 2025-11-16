package Factory.factories;

public class WifiRGBLightApi {
    public void wifiOn() { System.out.println("WiFi RGB Light: ON"); }
    public void wifiOff() { System.out.println("WiFi RGB Light: OFF"); }
    public void wifiBrightness(int b) { System.out.println("WiFi RGB Light: brightness = " + b); }
    public void wifiColor(int r, int g, int b) {
        System.out.println("WiFi RGB Light: color = " + r + "," + g + "," + b);
    }

    public void wifiTurnOn() {
        System.out.println("WiFi RGB Light: turn on");
    }

    public void wifiTurnOff() {
        System.out.println("WiFi RGB Light: turn off");
    }
}
