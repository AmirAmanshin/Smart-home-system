package Factory.factories;

public class ZigbeeAirConditionerApi {
    public void zbOn() { System.out.println("Zigbee Air Conditioner: ON"); }
    public void zbOff() { System.out.println("Zigbee Air Conditioner: OFF"); }
    public void zbSetTemp(int t) { System.out.println("Zigbee Air Conditioner: set temp = " + t); }
}
