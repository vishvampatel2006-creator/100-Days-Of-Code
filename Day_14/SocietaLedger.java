import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Resident {
    protected String flatNo;
    protected String name;
    protected double baseMaintenance;
    protected int parkingSlots;

    public Resident(String flatNo, String name, double baseMaintenance, int parkingSlots) {
        this.flatNo = flatNo;
        this.name = name;
        this.baseMaintenance = baseMaintenance;
        this.parkingSlots = parkingSlots;
    }

    public double calculateTotalDues() {
        return baseMaintenance;
    }

    public String getSummary() {
        return flatNo + " | " + name + " | Total Dues: Rs. " + calculateTotalDues();
    }
}

class Owner extends Resident {
    private double sinkingFund;
    private static final double OWNER_PARKING_RATE = 200.0;

    public Owner(String flatNo, String name, double baseMaintenance, int parkingSlots, double sinkingFund) {
        super(flatNo, name, baseMaintenance, parkingSlots);
        this.sinkingFund = sinkingFund;
    }

    @Override
    public double calculateTotalDues() {
        return baseMaintenance + (parkingSlots * OWNER_PARKING_RATE) + sinkingFund;
    }

    @Override
    public String getSummary() {
        return "[Owner]  " + super.getSummary();
    }
}

class Tenant extends Resident {
    private double nonOccupancyCharge;
    private static final double TENANT_PARKING_RATE = 400.0;

    public Tenant(String flatNo, String name, double baseMaintenance, int parkingSlots, double nonOccupancyCharge) {
        super(flatNo, name, baseMaintenance, parkingSlots);
        this.nonOccupancyCharge = nonOccupancyCharge;
    }

    @Override
    public double calculateTotalDues() {
        return baseMaintenance + (parkingSlots * TENANT_PARKING_RATE) + nonOccupancyCharge;
    }

    @Override
    public String getSummary() {
        return "[Tenant] " + super.getSummary();
    }
}

public class SocietaLedger {
    public static void main(String[] args) {
        ArrayList<Resident> residents = new ArrayList<>();
        residents.add(new Owner("A-101", "Rajesh Patel", 1500.0, 1, 300.0));
        residents.add(new Tenant("B-204", "Aarav Shah", 1500.0, 1, 500.0));
        residents.add(new Owner("C-302", "Neha Desai", 1500.0, 2, 300.0));

        System.out.println("=== Societa Monthly Maintenance Ledger ===");
        try (FileWriter writer = new FileWriter("Day_14/ledger_report.txt")) {
            for (Resident r : residents) {
                String line = r.getSummary();
                System.out.println(line);
                writer.write(line + "\n");
            }
            System.out.println("\nLedger saved to Day_14/ledger_report.txt");
        } catch (IOException e) {
            System.out.println("File save error: " + e.getMessage());
        }
    }
}