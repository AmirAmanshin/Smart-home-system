package Factory.factories;

import Factory.adapters.*;
import Factory.devices.*;
import Factory.implementations.*;


public class DeviceFactory {

    public static IDevice create(DeviceType type, Protocol protocol) {

        switch (type) {

            case AIR_CONDITIONER:
                return createAirConditioner(protocol);

            case CAMERA:
                return createCamera(protocol);

            case HEATER:
                return createHeater(protocol);

            case RGBLIGHT:
                return createRGBLight(protocol);

            case ROBOT_MOP:
                return createRobotMop(protocol);

            case ROBOT_VACUUM:
                return createRobotVacuum(protocol);

            case SMART_LIGHT:
                return createSmartLight(protocol);

            case SMART_PLUG: // опечатка в enum, исправлять не буду
                return createSmartPlug(protocol);

            case SMOKE_SENSOR:
                return createSmokeSensor(protocol);
        }

        throw new IllegalArgumentException("Unknown device type: " + type);
    }



    private static IDevice createAirConditioner(Protocol protocol) {
        switch (protocol) {
            case WIFI:
                return new WifiProtocolAdapter(new WifiAPI(), "Air Conditioner");
            case ZIGBEE:
                return new ZigbeeProtocolAdapter(new ZigbeeAPI(), "Air Conditioner");
        }
        throw new UnsupportedOperationException("AirConditioner does not support protocol: " + protocol);
    }

    private static IDevice createCamera(Protocol protocol) {
        switch (protocol) {
            case WIFI:
                return new WifiProtocolAdapter(new WifiAPI(), "Camera");
            case ZIGBEE:
                return new ZigbeeCameraAdapter(new Camera(), new ZigbeeAPI());
        }
        throw new UnsupportedOperationException("Camera does not support protocol: " + protocol);
    }

    private static IDevice createHeater(Protocol protocol) {
        if (protocol == Protocol.WIFI) {
            return new WifiProtocolAdapter(new WifiAPI(), "Heater");
        }
        throw new UnsupportedOperationException("Heater supports only WiFi.");
    }

    private static IDevice createRGBLight(Protocol protocol) {
        switch (protocol) {
            case WIFI:
                return new WifiRGBLightAdapter(new WifiRGBLightApi());
            case ZIGBEE:
                return new ZigbeeRGBLightAdapter(new RGBLight(), new ZigbeeAPI());
        }
        throw new UnsupportedOperationException("RGBLight does not support protocol: " + protocol);
    }

    private static IDevice createRobotMop(Protocol protocol) {
        switch (protocol) {
            case WIFI:
                return new WifiProtocolAdapter(new WifiAPI(), "Robot Mop");
            case ZIGBEE:
                return new ZigbeeProtocolAdapter(new ZigbeeAPI(), "Robot Mop");
        }
        throw new UnsupportedOperationException("RobotMop does not support protocol: " + protocol);
    }

    private static IDevice createRobotVacuum(Protocol protocol) {
        switch (protocol) {
            case WIFI:
                return new WifiProtocolAdapter(new WifiAPI(), "Robot Vacuum");
            case ZIGBEE:
                return new ZigbeeProtocolAdapter(new ZigbeeAPI(), "Robot Vacuum");
        }
        throw new UnsupportedOperationException("RobotVacuum does not support protocol: " + protocol);
    }

    private static IDevice createSmartLight(Protocol protocol) {
        switch (protocol) {
            case WIFI:
                return new WifiSmartLightAdapter(new WifiSmartLightApi());
            case ZIGBEE:
                return new ZigbeeSmartLightAdapter(new ZigbeeSmartLightApi());
        }
        throw new UnsupportedOperationException("SmartLight does not support protocol: " + protocol);
    }

    private static IDevice createSmartPlug(Protocol protocol) {
        if (protocol == Protocol.WIFI) {
            return new WifiSmartPlugAdapter(new WifiSmartPlugApi());
        }
        throw new UnsupportedOperationException("SmartPlug supports only WiFi.");
    }

    private static IDevice createSmokeSensor(Protocol protocol) {
        switch (protocol) {
            case ZIGBEE:
                return new ZigbeeProtocolAdapter(new ZigbeeAPI(), "Smoke Sensor");
            case WIFI:
                return new WifiSensorAdapter(new SmokeSensor(), new WifiAPI());
        }
        throw new UnsupportedOperationException("SmokeSensor does not support protocol: " + protocol);
    }
}