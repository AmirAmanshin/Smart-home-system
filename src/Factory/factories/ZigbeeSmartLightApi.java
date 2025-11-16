package Factory.factories;

public class ZigbeeSmartLightApi {
    public void zbOn() { System.out.println("Zigbee Smart Light: ON"); }
    public void zbOff() { System.out.println("Zigbee Smart Light: OFF"); }
    public void zbBrightness(int b) { System.out.println("Zigbee Smart Light: brightness = " + b); }

    public void zbStart() {
        System.out.println("Zigbee Smart Light: START");
    }

    public void zbStop() {
        System.out.println("Zigbee Smart Light: STOP");
    }
}
