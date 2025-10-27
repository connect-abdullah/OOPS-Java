package Lab_Mid;

import java.util.*;

abstract class SmartDevice {
    private String deviceId;
    private String deviceName;
    private boolean powerStatus;
    private String networkName;

    public SmartDevice(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.powerStatus = false;
    }

    public String getDeviceId() { 
        return deviceId; 
    }
    public String getDeviceName() { 
        return deviceName; 
    }
    public boolean getPowerStatus() { 
        return powerStatus; 
    }

    public void connectToNetwork(String networkName) {
        this.networkName = networkName;
        System.out.println(deviceName + " connected to network: " + networkName);
    }

    public void turnOn() {
        powerStatus = true;
        System.out.println(deviceName + " is turned ON.");
    }

    public void turnOff() {
        powerStatus = false;
        System.out.println(deviceName + " is turned OFF.");
    }

    // Abstract method 
    public abstract void showStatus();
}

class SmartLight extends SmartDevice {
    private int brightnessLevel;

    public SmartLight(String id, String name, int brightnessLevel) {
        super(id, name);
        this.brightnessLevel = brightnessLevel;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Light brightness set to " + brightnessLevel + "%");
    }

    @Override
    public void showStatus() {
        System.out.println(getDeviceName() + " | Light | Status: " + (getPowerStatus() ? "ON" : "OFF"));
    }
}

class SmartFan extends SmartDevice {
    private int speed;

    public SmartFan(String id, String name, int speed) {
        super(id, name);
        this.speed = speed;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Fan running at speed " + speed);
    }

    @Override
    public void showStatus() {
        System.out.println(getDeviceName() + " | Fan | Status: " + (getPowerStatus() ? "ON" : "OFF"));
    }
}

class SmartThermostat extends SmartDevice {
    private double temperature;

    public SmartThermostat(String id, String name, double temperature) {
        super(id, name);
        this.temperature = temperature;
    }

    // Method overloading 
    public void setTemperature(double celsius) {
        this.temperature = celsius;
        System.out.println("Temperature set to " + celsius + "°C");
    }

    public void setTemperature(double value, boolean inFahrenheit) {
        if (inFahrenheit) {
            this.temperature = (value - 32) * 5 / 9;
            System.out.println("Temperature set to " + temperature + "°C (converted from Fahrenheit)");
        } else {
            setTemperature(value);
        }
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Thermostat set at " + temperature + "°C");
    }

    @Override
    public void showStatus() {
        System.out.println(getDeviceName() + " | Thermostat | Status: " + (getPowerStatus() ? "ON" : "OFF"));
    }
}

// Composition
class SmartHomeController {
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void turnAllOn() {
        for (SmartDevice d : devices) d.turnOn();
    }

    public void turnAllOff() {
        for (SmartDevice d : devices) d.turnOff();
    }

    public void showAllStatus() {
        for (SmartDevice d : devices) d.showStatus();
    }
}

public class SmartHomeRunner {
    public static void main(String[] args) {
        SmartLight light = new SmartLight("L1", "Bedroom Light", 80);
        SmartFan fan = new SmartFan("F1", "Ceiling Fan", 3);
        SmartThermostat thermostat = new SmartThermostat("T1", "Room Thermostat", 22.5);

        light.connectToNetwork("Home_WiFi");
        fan.connectToNetwork("Home_WiFi");
        thermostat.connectToNetwork("Home_WiFi");

        SmartHomeController controller = new SmartHomeController();
        controller.addDevice(light);
        controller.addDevice(fan);
        controller.addDevice(thermostat);

        controller.turnAllOn();
        thermostat.setTemperature(75, true); // Overloaded method
        controller.showAllStatus();
        controller.turnAllOff();
    }
}