package Factory.factories;

public class ZigbeeRGBLightApi {
    public void zbOn() { System.out.println("Zigbee RGB Light: ON"); }
    public void zbOff() { System.out.println("Zigbee RGB Light: OFF"); }
    public void zbBrightness(int b) { System.out.println("Zigbee RGB Light: brightness = " + b); }
    public void zbColor(int r, int g, int b) {
        System.out.println("Zigbee RGB Light: color = " + r + "," + g + "," + b);
    }
}
