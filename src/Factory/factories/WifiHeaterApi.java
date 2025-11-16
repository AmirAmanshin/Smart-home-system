package Factory.factories;

public class WifiHeaterApi {
    public void wifiOn() { System.out.println("WiFi Heater: ON"); }
    public void wifiOff() { System.out.println("WiFi Heater: OFF"); }
    public void wifiSetTemp(int t) { System.out.println("WiFi Heater: set temp = " + t); }
}
