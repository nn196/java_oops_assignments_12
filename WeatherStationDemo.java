public class WeatherStationDemo {

    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        System.out.println("🛰️ Access Modifier Demonstration:\n");

        // ✅ public method - accessible
        ws.displayStatus();

        // ✅ default field (same class)
        System.out.println("Default Access (location): " + ws.location);

        // ❌ private fields - not accessible
        // System.out.println(ws.temperatureRaw); // ERROR

        // ✅ protected method accessible via subclass
        AdvancedStation adv = new AdvancedStation();
        adv.calculateAndDisplayTemp();
    }
}

// ===================== 🌦️ Weather Station =====================
class WeatherStation {

    // 🔒 PRIVATE: Raw sensor values (only accessible inside this class)
    private double temperatureRaw = 27.345;
    private double humidityRaw = 64.8;

    // 🏷️ DEFAULT (no modifier): Accessible within same file/package
    String location = "Coastal Station A";

    // 🛡️ PROTECTED: Accessible in subclass or same package
    protected double computeAdjustedTemp() {
        // Simulate adjusting based on humidity
        return temperatureRaw - (humidityRaw * 0.01);
    }

    // 🌐 PUBLIC: Accessible anywhere
    public void displayStatus() {
        System.out.println("📡 Weather Station Status:");
        System.out.println("Location       : " + location);
        System.out.println("Adjusted Temp  : " + computeAdjustedTemp() + " °C");
        System.out.println("----------------------------------");
    }
}

// ===================== 📊 Subclass to Access Protected =====================
class AdvancedStation extends WeatherStation {

    public void calculateAndDisplayTemp() {
        double adjusted = computeAdjustedTemp();  // ✅ protected method
        System.out.println("✅ Protected Access from Subclass:");
        System.out.println("Calculated Adjusted Temperature: " + adjusted + " °C");
    }
}
