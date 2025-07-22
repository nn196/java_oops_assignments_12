import java.util.Scanner;

public class SmartHomeEnergyOptimizer {

    static final int MAX_DEVICES = 5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] devices = {"Fan", "Light", "AC", "TV", "Heater"};
        int[] powerRatings = {70, 40, 150, 100, 200}; // watts
        boolean[] isOn = new boolean[MAX_DEVICES];

        System.out.println("👋 Welcome to Smart Home Energy Optimizer");

        // DO-WHILE: Accepting usage time
        int hour;
        do {
            System.out.print("Enter current hour (0–23): ");
            hour = sc.nextInt();
        } while (hour < 0 || hour > 23);

        // SWITCH: Time-based automation
        switch (hour) {
            case 6: case 7: case 8:
                System.out.println("🌅 Morning Mode: Turning on Fan and Light");
                isOn[0] = true; // Fan
                isOn[1] = true; // Light
                break;
            case 22: case 23: case 0:
                System.out.println("🌙 Night Mode: Only Fan remains on");
                isOn[0] = true;
                break;
            default:
                System.out.println("🕒 Day Mode: Manual Control");
                break;
        }

        // FOR loop: Manual toggle
        for (int i = 0; i < MAX_DEVICES; i++) {
            System.out.print("Turn ON " + devices[i] + "? (yes/no): ");
            String input = sc.next().toLowerCase();

            if (input.equals("skip")) {
                continue; // skip this device
            }

            if (input.equals("exit")) {
                System.out.println("Exiting setup...");
                break; // jump out of loop
            }

            isOn[i] = input.equals("yes");
        }

        // WHILE: Power calculation
        int index = 0;
        int totalPower = 0;
        while (index < MAX_DEVICES) {
            if (isOn[index]) {
                totalPower += powerRatings[index];
            }
            index++;
        }

        System.out.println("\n📊 Total Power Consumed: " + totalPower + " watts");

        // IF-ELSE: Power optimization warning
        if (totalPower > 400) {
            System.out.println("⚠️ High power usage! Consider turning off some devices.");
        } else {
            System.out.println("✅ Power usage is optimal.");
        }

        // Bitwise Example
        System.out.println("\n🔍 Bitwise Check:");
        int statusBits = 0;
        for (int i = 0; i < MAX_DEVICES; i++) {
            if (isOn[i]) {
                statusBits |= (1 << i); // set ith bit
            }
        }
        System.out.println("Device Status Bitmask: " + Integer.toBinaryString(statusBits));

        // RETURN to exit
        System.out.println("👋 System shutting down...");
        return;
    }
}
