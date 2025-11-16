package Factory.main;

import Factory.factories.Protocol;
import java.util.Scanner;

/**
 * Interactive demonstration of Smart Home System
 * Allows user to select scenarios and devices
 */
public class SmartHomeDemo {
    private static SmartHomeFacade smartHome;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        smartHome = new SmartHomeFacade();
        scanner = new Scanner(System.in);
        
        displayWelcome();
        
        boolean running = true;
        while (running) {
            displayScenarioMenu();
            String choice = scanner.nextLine().trim();
            
            if (choice.equals("1")) {
                morningScenario();
            } else if (choice.equals("2")) {
                eveningScenario();
            } else if (choice.equals("3")) {
                nightScenario();
            } else if (choice.equals("4")) {
                awayScenario();
            } else if (choice.equals("5")) {
                partyScenario();
            } else if (choice.equals("6")) {
                customScenario();
            } else if (choice.equals("7")) {
                allDevicesDemo();
            } else if (choice.equals("0")) {
                running = false;
                System.out.println("\nThank you for using Smart Home System!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
    
    private static void displayWelcome() {
        System.out.println("Smart Home System - Demo");
    }
    
    private static void displayScenarioMenu() {
        System.out.println("Available Scenarios");
        System.out.println("1. Morning");
        System.out.println("2. Evening");
        System.out.println("3. Night");
        System.out.println("4. Away");
        System.out.println("5. Party");
        System.out.println("6. Custom Scenario");
        System.out.println("7. All Devices Demo");
        System.out.println("0. Exit");
        System.out.print("Select scenario: ");
    }
    
    private static void morningScenario() {
        System.out.println("\nMORNING SCENARIO");
        System.out.println("Enabling all morning devices...\n");
        
        smartHome.setupSmartLight(Protocol.WIFI, 100, "White");
        smartHome.setupAirConditioner(Protocol.WIFI, 21, "Cool");
        smartHome.setupRGBLight(Protocol.ZIGBEE, 80, "Yellow");
        smartHome.setupCamera(Protocol.ZIGBEE, true);
        smartHome.setupRobotVacuum(Protocol.WIFI, "08:00");
        smartHome.setupSmokeSensor(Protocol.WIFI);
        
        System.out.println("\nMorning scenario activated!");
    }
    
    private static void eveningScenario() {
        System.out.println("\nEVENING SCENARIO");
        System.out.println("Enabling all evening devices...\n");
        
        smartHome.setupSmartLight(Protocol.WIFI, 60, "Cyan");
        smartHome.setupRGBLight(Protocol.ZIGBEE, 50, "Orange");
        smartHome.setupAirConditioner(Protocol.WIFI, 23, "Cool");
        smartHome.setupHeater(Protocol.ZIGBEE, 21, "Heat");
        smartHome.setupCamera(Protocol.ZIGBEE, false);
        smartHome.setupSmartPlug(Protocol.WIFI, 1500);
        
        System.out.println("\nEvening scenario activated!");
    }
    
    private static void nightScenario() {
        System.out.println("\nNIGHT SCENARIO");
        System.out.println("Hybernation...\n");
        
        smartHome.setupSmartLight(Protocol.WIFI, 10, "Red");
        smartHome.setupRGBLight(Protocol.ZIGBEE, 5, "Blue");
        smartHome.setupAirConditioner(Protocol.WIFI, 19, "Cool");
        smartHome.setupHeater(Protocol.ZIGBEE, 19, "Eco");
        smartHome.setupCamera(Protocol.ZIGBEE, true);
        smartHome.setupSmokeSensor(Protocol.WIFI);
        
        System.out.println("\nNight scenario activated!");
    }
    
    private static void awayScenario() {
        System.out.println("\nAWAY SCENARIO");
        System.out.println("Activating away mode...\n");
        
        smartHome.setupSmartLight(Protocol.WIFI, 0, "White");
        smartHome.setupAirConditioner(Protocol.WIFI, 26, "Cool");
        smartHome.setupCamera(Protocol.ZIGBEE, true);
        smartHome.setupSmokeSensor(Protocol.WIFI);
        smartHome.setupSmokeSensor(Protocol.ZIGBEE);
        smartHome.setupSmartPlug(Protocol.WIFI, 500);
        
        System.out.println("\nAway mode activated!");
        System.out.println("Cameras enabled, sensors active");
    }
    
    private static void partyScenario() {
        System.out.println("\nPARTY SCENARIO");
        System.out.println("Patry mode\n");
        
        smartHome.setupSmartLight(Protocol.WIFI, 100, "White");
        smartHome.setupRGBLight(Protocol.WIFI, 100, "Red");
        smartHome.setupRGBLight(Protocol.ZIGBEE, 100, "Magenta");
        smartHome.setupAirConditioner(Protocol.WIFI, 20, "Cool");
        smartHome.setupAirConditioner(Protocol.ZIGBEE, 20, "Cool");
        smartHome.setupSmartPlug(Protocol.WIFI, 3000);
        
        System.out.println("\nParty is ready!");
    }
    
    private static void customScenario() {
        System.out.println("\nCUSTOM SCENARIO");
        
        System.out.println("\nSelect devices to control:");
        System.out.println("1. All lights");
        System.out.println("2. Climate control");
        System.out.println("3. Security");
        System.out.println("4. Robotics");
        System.out.print("Select: ");
        
        String choice = scanner.nextLine().trim();
        
        if (choice.equals("1")) {
            customLights();
        } else if (choice.equals("2")) {
            customClimate();
        } else if (choice.equals("3")) {
            customSecurity();
        } else if (choice.equals("4")) {
            customRobots();
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    private static void customLights() {
        System.out.println("\nLight Control");
        System.out.print("Brightness (0-100): ");
        int brightness = getIntInput();
        System.out.print("Color (Red/Green/Blue/Yellow/Cyan/White): ");
        String color = scanner.nextLine().trim();
        
        System.out.println("\nSetting parameters...");
        smartHome.setupSmartLight(Protocol.WIFI, brightness, color);
        smartHome.setupSmartLight(Protocol.ZIGBEE, brightness, color);
        smartHome.setupRGBLight(Protocol.WIFI, brightness, color);
        smartHome.setupRGBLight(Protocol.ZIGBEE, brightness, color);
        System.out.println("All lights updated!");
    }
    
    private static void customClimate() {
        System.out.println("\nClimate Control");
        System.out.print("Temperature (10-30C): ");
        int temp = getIntInput();
        System.out.print("Mode (Cool/Heat): ");
        String mode = scanner.nextLine().trim();
        
        System.out.println("\nSetting parameters...");
        smartHome.setupAirConditioner(Protocol.WIFI, temp, mode);
        smartHome.setupAirConditioner(Protocol.ZIGBEE, temp, mode);
        smartHome.setupHeater(Protocol.WIFI, temp, mode);
        smartHome.setupHeater(Protocol.ZIGBEE, temp, mode);
        System.out.println("All climate devices updated!");
    }
    
    private static void customSecurity() {
        System.out.println("\nSecurity Control");
        System.out.print("Enable cameras? (y/n): ");
        String enableChoice = scanner.nextLine().trim().toLowerCase();
        boolean enabled = enableChoice.equals("y") || enableChoice.equals("yes");
        
        System.out.println("\nSetting parameters...");
        smartHome.setupCamera(Protocol.WIFI, enabled);
        smartHome.setupCamera(Protocol.ZIGBEE, enabled);
        smartHome.setupSmokeSensor(Protocol.WIFI);
        smartHome.setupSmokeSensor(Protocol.ZIGBEE);
        System.out.println("All sensors and cameras updated!");
    }
    
    private static void customRobots() {
        System.out.println("\nRobotics Control");
        System.out.print("Schedule time (HH:MM): ");
        String schedule = scanner.nextLine().trim();
        
        System.out.println("\nSetting schedule...");
        smartHome.setupRobotVacuum(Protocol.WIFI, schedule);
        smartHome.setupRobotVacuum(Protocol.ZIGBEE, schedule);
        smartHome.setupRobotMop(Protocol.WIFI, schedule);
        smartHome.setupRobotMop(Protocol.ZIGBEE, schedule);
        System.out.println("All robots updated!");
    }
    
    private static void allDevicesDemo() {
        System.out.println("FULL DEMONSTRATION OF ALL DEVICES");
        
        System.out.println("\nWiFi Protocol Devices:");
        smartHome.setupSmartLight(Protocol.WIFI, 80, "Blue");
        smartHome.setupRGBLight(Protocol.WIFI, 100, "Red");
        smartHome.setupSmartPlug(Protocol.WIFI, 2000);
        smartHome.setupAirConditioner(Protocol.WIFI, 22, "Cool");
        smartHome.setupHeater(Protocol.WIFI, 20, "Heat");
        smartHome.setupRobotVacuum(Protocol.WIFI, "10:30");
        smartHome.setupRobotMop(Protocol.WIFI, "14:00");
        smartHome.setupSmokeSensor(Protocol.WIFI);
        
        System.out.println("\nZigbee Protocol Devices:");
        smartHome.setupSmartLight(Protocol.ZIGBEE, 50, "Green");
        smartHome.setupRGBLight(Protocol.ZIGBEE, 75, "Yellow");
        smartHome.setupAirConditioner(Protocol.ZIGBEE, 24, "Heat");
        smartHome.setupCamera(Protocol.ZIGBEE, true);
        smartHome.setupRobotVacuum(Protocol.ZIGBEE, "09:00");
        smartHome.setupRobotMop(Protocol.ZIGBEE, "15:30");
        smartHome.setupSmokeSensor(Protocol.ZIGBEE);
        

        System.out.println("All devices configured successfully!");
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
