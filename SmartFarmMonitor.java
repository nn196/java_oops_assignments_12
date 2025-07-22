import java.util.Arrays;

public class SmartFarmMonitor {

    public static void main(String[] args) {

        // 1. Primitive Data Types
        byte sensorId = 5;                        // byte
        short fieldZone = 102;                   // short
        int totalReadings = 1200;                // int
        long timestamp = System.currentTimeMillis(); // long
        float soilMoisture = 22.5f;              // float (%)
        double temperature = 35.742;             // double (°C)
        char zoneType = 'A';                     // char (crop type)
        boolean isActive = true;                 // boolean

        // 2. Bitwise Flags: status flags for alerting
        int status = 0b0000;                     // binary: 4 flags
        final int DRY = 0b0001;                  // dry soil
        final int HOT = 0b0010;                  // high temperature
        final int SENSOR_ERROR = 0b0100;         // faulty sensor
        final int IRRIGATION_ON = 0b1000;        // irrigation running

        // Logic to raise flags
        if (soilMoisture < 30.0f) status |= DRY;
        if (temperature > 40.0) status |= HOT;
        if (!isActive) status |= SENSOR_ERROR;

        // 3. Non-Primitive Data Types
        String[] sensors = {"Moisture", "Temp", "Humidity", "pH"};
        int[] readings = {23, 41, 68, 6};          // Array
        String zoneName = new String("Zone Alpha");

        // 4. Wrapper Classes
        Integer readingCount = Integer.valueOf(totalReadings);
        Double avgTemp = Double.valueOf(temperature);

        // Output
        System.out.println("=== SMART FARM SENSOR DASHBOARD ===");
        System.out.println("Sensor ID        : " + sensorId);
        System.out.println("Zone             : " + zoneName + " (" + zoneType + ")");
        System.out.println("Field Zone       : " + fieldZone);
        System.out.println("Timestamp        : " + timestamp);
        System.out.println("Readings Count   : " + readingCount);
        System.out.println("Soil Moisture(%) : " + soilMoisture);
        System.out.println("Temperature (°C) : " + avgTemp);
        System.out.println("Sensors Available: " + Arrays.toString(sensors));

        // 5. Logical Decisions
        if ((status & DRY) != 0) {
            System.out.println("⚠️ ALERT: Soil is too dry!");
        }
        if ((status & HOT) != 0) {
            System.out.println("⚠️ ALERT: High temperature detected!");
        }
        if ((status & SENSOR_ERROR) != 0) {
            System.out.println("❌ ERROR: Sensor malfunction!");
        }

        // 6. Turn irrigation ON if needed
        if ((status & DRY) != 0 && (status & HOT) == 0) {
            status |= IRRIGATION_ON;
            System.out.println("💧 Irrigation turned ON.");
        } else {
            System.out.println("💧 Irrigation not needed.");
        }

        // 7. Final Status Report
        System.out.println("Status Binary     : " + String.format("%4s", Integer.toBinaryString(status)).replace(' ', '0'));
        System.out.println("System Active     : " + isActive);
    }
}
