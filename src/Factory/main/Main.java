package Factory.main;

import Factory.factories.Protocol;
import java.util.Scanner;

public class Main {
    private static SmartHomeFacade smartHome;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        smartHome = new SmartHomeFacade();
        scanner = new Scanner(System.in);
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            String choice = scanner.nextLine().trim();
            
            if (choice.equals("1")) {
                handleLightControl();
            } else if (choice.equals("2")) {
                handleClimateControl();
            } else if (choice.equals("3")) {
                handleSecurityControl();
            } else if (choice.equals("4")) {
                handleEnergyControl();
            } else if (choice.equals("5")) {
                handleCleaningControl();
            } else if (choice.equals("6")) {
                handleSensorControl();
            } else if (choice.equals("7")) {
                runDemo();
            } else if (choice.equals("0")) {
                running = false;
                System.out.println("\nGoodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println(" Smart Home System - Control Panel");
        System.out.println("1. Light Control");
        System.out.println("2. Climate Control");
        System.out.println("3. Security Control");
        System.out.println("4. Energy Management");
        System.out.println("5. Cleaning Control");
        System.out.println("6. Sensors");
        System.out.println("7. Run Full Demo");
        System.out.println("  0. Exit");
        System.out.print("Select option: ");
    }
    
    private static void handleLightControl() {
        System.out.println("\nLight Control");
        System.out.println("1. Smart Light (WiFi)");
        System.out.println("2. Smart Light (Zigbee)");
        System.out.println("3. RGB Light (WiFi)");
        System.out.println("4. RGB Light (Zigbee)");
        System.out.print("Select device: ");
        
        String choice = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            System.out.print("Enter brightness (0-100): ");
            int brightness = getIntInput();
            System.out.print("Enter color (Red/Green/Blue/Cyan/Yellow/White): ");
            String color = scanner.nextLine().trim();
            smartHome.setupSmartLight(Protocol.WIFI, brightness, color);
        } else if (choice.equals("2")) {
            System.out.print("Enter brightness (0-100): ");
            int brightness = getIntInput();
            System.out.print("Enter color (Red/Green/Blue/Cyan/Yellow/White): ");
            String color = scanner.nextLine().trim();
            smartHome.setupSmartLight(Protocol.ZIGBEE, brightness, color);
        } else if (choice.equals("3")) {
            System.out.print("Enter brightness (0-100): ");
            int brightness = getIntInput();
            System.out.print("Enter color (Red/Green/Blue/Yellow/Cyan/Magenta/White): ");
            String color = scanner.nextLine().trim();
            smartHome.setupRGBLight(Protocol.WIFI, brightness, color);
        } else if (choice.equals("4")) {
            System.out.print("Enter brightness (0-100): ");
            int brightness = getIntInput();
            System.out.print("Enter color (Red/Green/Blue/Yellow/Cyan/Magenta/White): ");
            String color = scanner.nextLine().trim();
            smartHome.setupRGBLight(Protocol.ZIGBEE, brightness, color);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private static void handleClimateControl() {
        System.out.println("\nClimate Control");
        System.out.println("1. Air Conditioner (WiFi)");
        System.out.println("2. Air Conditioner (Zigbee)");
        System.out.println("3. Heater (WiFi)");
        System.out.println("4. Heater (Zigbee)");
        System.out.print("Select device: ");
        
        String choice = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            System.out.print("Enter temperature (16-30C): ");
            int temp = getIntInput();
            System.out.print("Enter mode (Cool/Heat/Dry/Fan/Auto): ");
            String mode = scanner.nextLine().trim();
            smartHome.setupAirConditioner(Protocol.WIFI, temp, mode);
        } else if (choice.equals("2")) {
            System.out.print("Enter temperature (16-30C): ");
            int temp = getIntInput();
            System.out.print("Enter mode (Cool/Heat/Dry/Fan/Auto): ");
            String mode = scanner.nextLine().trim();
            smartHome.setupAirConditioner(Protocol.ZIGBEE, temp, mode);
        } else if (choice.equals("3")) {
            System.out.print("Enter temperature (10-30C): ");
            int temp = getIntInput();
            System.out.print("Enter mode (Heat/Eco/Boost): ");
            String mode = scanner.nextLine().trim();
            smartHome.setupHeater(Protocol.WIFI, temp, mode);
        } else if (choice.equals("4")) {
            System.out.print("Enter temperature (10-30C): ");
            int temp = getIntInput();
            System.out.print("Enter mode (Heat/Eco/Boost): ");
            String mode = scanner.nextLine().trim();
            smartHome.setupHeater(Protocol.ZIGBEE, temp, mode);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private static void handleSecurityControl() {
        System.out.println("\nSecurity Control");
        System.out.println("1. Camera (WiFi)");
        System.out.println("2. Camera (Zigbee)");
        System.out.print("Select device: ");
        
        String choice = scanner.nextLine().trim();
        System.out.print("Enable camera? (y/n): ");
        String enableChoice = scanner.nextLine().trim().toLowerCase();
        boolean enabled = enableChoice.equals("y") || enableChoice.equals("yes");
        
        if (choice.equals("1")) {
            smartHome.setupCamera(Protocol.WIFI, enabled);
        } else if (choice.equals("2")) {
            smartHome.setupCamera(Protocol.ZIGBEE, enabled);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private static void handleEnergyControl() {
        System.out.println("\nEnergy Management");
        System.out.println("1. Smart Plug (WiFi)");
        System.out.print("Select device: ");
        
        String choice = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            System.out.print("Enter power limit (W): ");
            int powerLimit = getIntInput();
            smartHome.setupSmartPlug(Protocol.WIFI, powerLimit);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private static void handleCleaningControl() {
        System.out.println("\nCleaning Control");
        System.out.println("1. Robot Vacuum (WiFi)");
        System.out.println("2. Robot Vacuum (Zigbee)");
        System.out.println("3. Robot Mop (WiFi)");
        System.out.println("4. Robot Mop (Zigbee)");
        System.out.print("Select device: ");
        
        String choice = scanner.nextLine().trim();
        System.out.print("Enter schedule time (HH:MM): ");
        String schedule = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            smartHome.setupRobotVacuum(Protocol.WIFI, schedule);
        } else if (choice.equals("2")) {
            smartHome.setupRobotVacuum(Protocol.ZIGBEE, schedule);
        } else if (choice.equals("3")) {
            smartHome.setupRobotMop(Protocol.WIFI, schedule);
        } else if (choice.equals("4")) {
            smartHome.setupRobotMop(Protocol.ZIGBEE, schedule);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private static void handleSensorControl() {
        System.out.println("\nSensors");
        System.out.println("1. Smoke Sensor (WiFi)");
        System.out.println("2. Smoke Sensor (Zigbee)");
        System.out.print("Select sensor: ");
        
        String choice = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            smartHome.setupSmokeSensor(Protocol.WIFI);
        } else if (choice.equals("2")) {
            smartHome.setupSmokeSensor(Protocol.ZIGBEE);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void runDemo() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║     Running Full Demo...                   ║");
        System.out.println("╚════════════════════════════════════════════╝");

        System.out.println("\nWiFi Protocol Devices:");
        smartHome.setupSmartLight(Protocol.WIFI, 80, "Blue");
        smartHome.setupRGBLight(Protocol.WIFI, 100, "Red");
        smartHome.setupAirConditioner(Protocol.WIFI, 22, "Cool");
        smartHome.setupSmartPlug(Protocol.WIFI, 2000);
        smartHome.setupRobotVacuum(Protocol.WIFI, "10:30");

        System.out.println("\nZigbee Protocol Devices:");
        smartHome.setupSmartLight(Protocol.ZIGBEE, 50, "Green");
        smartHome.setupCamera(Protocol.ZIGBEE, true);
        smartHome.setupHeater(Protocol.ZIGBEE, 20, "Heat");
        smartHome.setupRobotMop(Protocol.ZIGBEE, "15:30");
        smartHome.setupSmokeSensor(Protocol.ZIGBEE);

        System.out.println("\nDemo completed!");
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number!");
            return 0;
        }
    }
}
