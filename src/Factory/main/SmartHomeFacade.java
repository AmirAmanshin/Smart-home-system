package Factory.main;

import Factory.devices.*;
import Factory.factories.DeviceFactory;
import Factory.factories.DeviceType;
import Factory.factories.Protocol;

/**
 * Фасада для упрощенной работы с умными устройствами
 * Скрывает сложность создания и управления устройствами
 */
public class SmartHomeFacade {
    
    public SmartHomeFacade() {
    }
    
    /**
     * Создает и возвращает устройство по типу и протоколу
     */
    public IDevice createDevice(DeviceType type, Protocol protocol) {
        System.out.println("[SmartHome] Creating " + type + " device with " + protocol + " protocol...");
        return DeviceFactory.create(type, protocol);
    }
    
    /**
     * Создает и управляет умным светом
     */
    public void setupSmartLight(Protocol protocol, int brightness, String color) {
        System.out.println("\nUpdating Smart Light");
        IDevice light = DeviceFactory.create(DeviceType.SMART_LIGHT, protocol);
        System.out.println("Device: " + light.getName());
        
        if (light instanceof LightControl) {
            LightControl lightControl = (LightControl) light;
            lightControl.setBrightness(brightness);
            lightControl.setColor(color);
            System.out.println("Light configured: Brightness=" + brightness + "%, Color=" + color);
        }
    }
    
    /**
     * Создает и управляет кондиционером
     */
    public void setupAirConditioner(Protocol protocol, int temperature, String mode) {
        System.out.println("\nUpdating Air Conditioner");
        IDevice ac = DeviceFactory.create(DeviceType.AIR_CONDITIONER, protocol);
        System.out.println("Device: " + ac.getName());
        
        if (ac instanceof ClimateControl) {
            ClimateControl climate = (ClimateControl) ac;
            climate.setTemperature(temperature);
            climate.setMode(mode);
            System.out.println("AC configured: Temp=" + temperature + "°C, Mode=" + mode);
        }
    }
    
    /**
     * Создает и управляет RGB лампой
     */
    public void setupRGBLight(Protocol protocol, int brightness, String color) {
        System.out.println("\nUpdating RGB Light");
        IDevice rgbLight = DeviceFactory.create(DeviceType.RGBLIGHT, protocol);
        System.out.println("Device: " + rgbLight.getName());
        
        if (rgbLight instanceof LightControl) {
            LightControl lightControl = (LightControl) rgbLight;
            lightControl.setBrightness(brightness);
            lightControl.setColor(color);
            System.out.println("RGB Light configured: Brightness=" + brightness + "%, Color=" + color);
        }
    }
    
    /**
     * Создает и управляет камерой безопасности
     */
    public void setupCamera(Protocol protocol, boolean enabled) {
        System.out.println("\nUpdating Security Camera");
        IDevice camera = DeviceFactory.create(DeviceType.CAMERA, protocol);
        System.out.println("✓ Device: " + camera.getName());
        
        if (camera instanceof Security) {
            Security security = (Security) camera;
            if (enabled) {
                security.enable();
                System.out.println("Camera enabled");
            } else {
                security.disable();
                System.out.println("Camera disabled");
            }
            System.out.println("Status: " + security.getSecurityStatus());
        }
    }
    
    /**
     * Создает и управляет умной розеткой
     */
    public void setupSmartPlug(Protocol protocol, int powerLimit) {
        System.out.println("\nUpdating Smart Plug");
        IDevice plug = DeviceFactory.create(DeviceType.SMART_PLUG, protocol);
        System.out.println("Device: " + plug.getName());
        
        if (plug instanceof EnergyManagement) {
            EnergyManagement energy = (EnergyManagement) plug;
            energy.limitPower(powerLimit);
            int consumption = energy.getConsumption();
            System.out.println("Smart Plug configured: PowerLimit=" + powerLimit + "W, Current=" + consumption + "W");
        }
    }
    
    /**
     * Создает и управляет датчиком дыма
     */
    public void setupSmokeSensor(Protocol protocol) {
        System.out.println("\nUpdating Smoke Sensor");
        IDevice sensor = DeviceFactory.create(DeviceType.SMOKE_SENSOR, protocol);
        System.out.println("✓ Device: " + sensor.getName());
        
        if (sensor instanceof Sensor) {
            Sensor smokeSensor = (Sensor) sensor;
            double value = smokeSensor.readValue();
            System.out.println("Smoke Sensor reading: " + String.format("%.2f", value) + " ppm");
        }
    }
    
    /**
     * Создает и управляет робот-пылесосом
     */
    public void setupRobotVacuum(Protocol protocol, String schedule) {
        System.out.println("\nUpdating Robot Vacuum");
        IDevice vacuum = DeviceFactory.create(DeviceType.ROBOT_VACUUM, protocol);
        System.out.println("Device: " + vacuum.getName());
        
        if (vacuum instanceof CleaningControl) {
            CleaningControl cleaning = (CleaningControl) vacuum;
            cleaning.setSchedule(schedule);
            System.out.println("Vacuum scheduled at: " + schedule);
        }
    }
    
    /**
     * Создает и управляет робот-шваброй
     */
    public void setupRobotMop(Protocol protocol, String schedule) {
        System.out.println("\nUpdating Robot Mop");
        IDevice mop = DeviceFactory.create(DeviceType.ROBOT_MOP, protocol);
        System.out.println("Device: " + mop.getName());
        
        if (mop instanceof CleaningControl) {
            CleaningControl cleaning = (CleaningControl) mop;
            cleaning.setSchedule(schedule);
            System.out.println("Mop scheduled at: " + schedule);
        }
    }
    
    /**
     * Создает и управляет обогревателем
     */
    public void setupHeater(Protocol protocol, int temperature, String mode) {
        System.out.println("\nUpdating Heater");
        IDevice heater = DeviceFactory.create(DeviceType.HEATER, protocol);
        System.out.println("Device: " + heater.getName());
        
        if (heater instanceof ClimateControl) {
            ClimateControl climate = (ClimateControl) heater;
            climate.setTemperature(temperature);
            climate.setMode(mode);
            System.out.println("Heater configured: Temp=" + temperature + "°C, Mode=" + mode);
        }
    }
    
    /**
     * Вспомогательный метод для вывода информации об устройстве
     */
    public void printDeviceInfo(IDevice device) {
        System.out.println("Device Info:");
        System.out.println("Name: " + device.getName());
        System.out.println("Type: " + device.getClass().getSimpleName());
        
        // Выводим поддерживаемые интерфейсы
        StringBuilder interfaces = new StringBuilder("  Supports: ");
        if (device instanceof LightControl) interfaces.append("[Light] ");
        if (device instanceof ClimateControl) interfaces.append("[Climate] ");
        if (device instanceof Security) interfaces.append("[Security] ");
        if (device instanceof Sensor) interfaces.append("[Sensor] ");
        if (device instanceof CleaningControl) interfaces.append("[Cleaning] ");
        if (device instanceof EnergyManagement) interfaces.append("[Energy] ");
        System.out.println(interfaces.toString());
    }
    
    /**
     * Интерактивное управление устройством
     */
    public void interactiveDeviceControl(DeviceType type, Protocol protocol) {
        IDevice device = this.createDevice(type, protocol);
        System.out.println("\nInteractive controlling: " + device.getName());
        
        if (device instanceof LightControl) {
            handleLightInteraction((LightControl) device);
        } else if (device instanceof ClimateControl) {
            handleClimateInteraction((ClimateControl) device);
        } else if (device instanceof Security) {
            handleSecurityInteraction((Security) device);
        } else if (device instanceof EnergyManagement) {
            handleEnergyInteraction((EnergyManagement) device);
        } else if (device instanceof CleaningControl) {
            handleCleaningInteraction((CleaningControl) device);
        } else if (device instanceof Sensor) {
            handleSensorInteraction((Sensor) device);
        }
    }
    
    private void handleLightInteraction(LightControl light) {
        System.out.println("Preferences: brightness (0-100), color");
        System.out.println("Command: brightness <level> or color <color>");
    }
    
    private void handleClimateInteraction(ClimateControl climate) {
        System.out.println("Prefences: temperature, mode");
        System.out.println("Command: temp <degrees> or mode <mode>");
    }
    
    private void handleSecurityInteraction(Security security) {
        System.out.println("Preferences: status (on/off)");
        System.out.println("Status: " + security.getSecurityStatus());
    }
    
    private void handleEnergyInteraction(EnergyManagement energy) {
        System.out.println("Current consumming: " + energy.getConsumption() + "W");
        System.out.println("Command: limit <power>");
    }
    
    private void handleCleaningInteraction(CleaningControl cleaning) {
        System.out.println("Command: start, stop or schedule <HH:MM>");
    }
    
    private void handleSensorInteraction(Sensor sensor) {
        System.out.println("Current: " + String.format("%.2f", sensor.readValue()));
    }
}