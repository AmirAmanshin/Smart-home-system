package Factory.legacy;


public class LegacyLamp {
    public void activateLamp() {
        System.out.println("Legacy lamp is ON");
    }
    public void shutDown() {
        System.out.println("Legacy lamp is OFF");
    }
    public void modifyLight(int level) {
        System.out.println("Legacy brightness set to " + level + " (via modifyLight)");
    }
}