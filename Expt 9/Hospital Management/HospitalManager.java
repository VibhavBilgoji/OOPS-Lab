import java.util.Scanner;

interface Billable {
    double generateInvoice();

    default double applyGST(double amount) { return amount * 0.05; }

    default double lateFee(double amount, int daysOverdue) {
        double months = daysOverdue / 30.0;
        return amount * Math.pow(1.015, months) - amount;
    }
}

interface Diagnosable extends Billable {
    void runDiagnostics(String[] tests);

    default double diagnosticCost(int numberOfTests) {
        final int baseCost = 800;
        final int labFee = 200;
        return (numberOfTests * baseCost) + labFee;
    }
}

interface Treatable extends Diagnosable {
    void prescribeMedication(String condition);

    default int treatmentDuration(int severity) { return severity * 3 + 5; }

    default double medicationCost(int daysOfTreatment, double dailyDrugCost) {
        double medCost = daysOfTreatment * dailyDrugCost;
        final float pharmacyMarkup = 0.12f;
        return medCost * (1 + pharmacyMarkup);
    }
}

interface SurgicallyTreatable extends Treatable {
    void scheduleSurgery(String type, int urgencyLevel);

    default float surgeryRisk(int age, double bmi, int comorbidities) {
        return (age * 0.4f) + (bmi > 30 ? 20 : 0) + (comorbidities * 15);
    }

    default double anesthesiaCost(double surgeryHours) {
        final int aneCostPerHour = 3500;
        final int flatRate = 2000;
        return (aneCostPerHour * surgeryHours) + flatRate;
    }
}

interface InsuranceClaimable extends Billable {
    void submitClaim(String policyNumber);

    default double reimbursementAmount(double totalBill, double coveragePercentage, double deductible) {
        return Math.max(0, (totalBill * (coveragePercentage / 100.0)) - deductible);
    }
}

interface CorporateClaimable extends InsuranceClaimable {
    default double corporateDiscount(double bill, String tier) {
        float discount;
        switch (tier.toLowerCase()) {
            case "gold": discount = 0.20f; break;
            case "silver": discount = 0.12f; break;
            case "standard": discount = 0.05f; break;
            default: discount = 0.0f; break;
        }
        return bill * (1 - discount);
    }

    boolean validateEmployeePolicy(String empId);
}

class Person {
    private String name;
    private int age;
    private String gender;
    private String contactInfo;

    Person(String name, int age, String gender, String contactInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public double bmi(double weight, double height) {
        return weight / Math.pow(height, 2);
    }
}

class Patient extends Person implements Billable {
    private String patientId;
    private String admissionDate;
    private String roomType;

    Patient(String name, int age, String gender, String contactInfo, String p, String a, String r) {
        super(name, age, gender, contactInfo);
        patientId = p;
        admissionDate = a;
        roomType = r;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public double roomCharges(int days) {
        int charge;
        switch(roomType.toLowerCase()) {
            case "icu": charge = 12000; break;
            case "private": charge = 5500; break;
            case "general": charge = 1800; break;
            default: charge = 0;
        }
        return charge * days;
    }

    @Override public double generateInvoice() { return 0.0; }
}

class SurgicalPatient extends Patient implements SurgicallyTreatable, CorporateClaimable {
    private int numOfTests;
    private int severity;
    private double dailyDrugCost;
    private double surgeryHours;
    private int comorbidities;
    private String corporateTier;
    private double insuranceCoveragePercent;
    private double insuranceDeductible;
    private int roomDays;
    private double calculatedBmi;

    SurgicalPatient(String n, int a, String g, String c, String p, String ad, String r) {
        super(n, a, g, c, p, ad, r);
    }

    public int getNumOfTests() { return numOfTests; }
    public void setNumOfTests(int numOfTests) { this.numOfTests = numOfTests; }

    public int getSeverity() { return severity; }
    public void setSeverity(int severity) { this.severity = severity; }

    public double getDailyDrugCost() { return dailyDrugCost; }
    public void setDailyDrugCost(double dailyDrugCost) { this.dailyDrugCost = dailyDrugCost; }

    public double getSurgeryHours() { return surgeryHours; }
    public void setSurgeryHours(double surgeryHours) { this.surgeryHours = surgeryHours; }

    public int getComorbidities() { return comorbidities; }
    public void setComorbidities(int comorbidities) { this.comorbidities = comorbidities; }

    public String getCorporateTier() { return corporateTier; }
    public void setCorporateTier(String corporateTier) { this.corporateTier = corporateTier; }

    public double getInsuranceCoveragePercent() { return insuranceCoveragePercent; }
    public void setInsuranceCoveragePercent(double insuranceCoveragePercent) { this.insuranceCoveragePercent = insuranceCoveragePercent; }

    public double getInsuranceDeductible() { return insuranceDeductible; }
    public void setInsuranceDeductible(double insuranceDeductible) { this.insuranceDeductible = insuranceDeductible; }

    public int getRoomDays() { return roomDays; }
    public void setRoomDays(int roomDays) { this.roomDays = roomDays; }

    public double getCalculatedBmi() { return calculatedBmi; }
    public void setCalculatedBmi(double calculatedBmi) { this.calculatedBmi = calculatedBmi; }

    public void setBillingDetails(int tests, int sev, double drugCost, double hours, int comorb, String tier, double coverage, double deductible, int days, double bmiValue) {
        setNumOfTests(tests);
        setSeverity(sev);
        setDailyDrugCost(drugCost);
        setSurgeryHours(hours);
        setComorbidities(comorb);
        setCorporateTier(tier);
        setInsuranceCoveragePercent(coverage);
        setInsuranceDeductible(deductible);
        setRoomDays(days);
        setCalculatedBmi(bmiValue);
    }

    public double getORBookingCost() {
        final int baseCost = 25000;
        final int perHour = 8000;
        return baseCost + (perHour * surgeryHours);
    }

    @Override public double applyGST(double amount) { return getORBookingCost() * 0.05; }

    @Override
    public double generateInvoice() {
        double diag = diagnosticCost(numOfTests);
        double med = medicationCost(treatmentDuration(severity), dailyDrugCost);
        double surgery = getORBookingCost();
        double anesthesia = anesthesiaCost(surgeryHours);
        double room = roomCharges(roomDays);

        double baseTotal = diag + med + surgery + anesthesia + room;
        double withGst = baseTotal + applyGST(baseTotal);
        double afterDiscount = corporateDiscount(withGst, corporateTier);
        double reimbursement = reimbursementAmount(afterDiscount, insuranceCoveragePercent, insuranceDeductible);

        return afterDiscount - reimbursement;
    }

    public void printFullReport() {
            System.out.println("\n--- MEDICAL & BILLING REPORT ---");
            System.out.println("Patient: " + getName() + " | Age: " + getAge() + " | BMI: " + calculatedBmi);
            System.out.println("Risk Score: " + surgeryRisk(getAge(), calculatedBmi, comorbidities));

            System.out.println("\n--- ITEMIZED BILL ---");

            double diagCost = diagnosticCost(numOfTests);
            double medCost = medicationCost(treatmentDuration(severity), dailyDrugCost);
            double surgCost = getORBookingCost();
            double anesCost = anesthesiaCost(surgeryHours);
            double roomCost = roomCharges(roomDays);

            System.out.printf("Diagnostics: Rs. %.2f\n", diagCost);
            System.out.printf("Medication: Rs. %.2f\n", medCost);
            System.out.printf("OR Booking (Surgery): Rs. %.2f\n", surgCost);
            System.out.printf("Anesthesia: Rs. %.2f\n", anesCost);
            System.out.printf("Room Charges: Rs. %.2f\n", roomCost);

            double subTotal = diagCost + medCost + surgCost + anesCost + roomCost;
            System.out.printf("\nSubtotal: Rs. %.2f\n", subTotal);

            double gst = applyGST(subTotal);
            System.out.printf("Applied GST (5%% on Surgery only): Rs. %.2f\n", gst);

            double totalWithGst = subTotal + gst;
            System.out.printf("Total with GST: Rs. %.2f\n", totalWithGst);

            double discountedTotal = corporateDiscount(totalWithGst, corporateTier);
            double discountAmount = totalWithGst - discountedTotal;
            System.out.printf("Corporate Discount (%s): -Rs. %.2f\n", corporateTier, discountAmount);

            double reimbursement = reimbursementAmount(discountedTotal, insuranceCoveragePercent, insuranceDeductible);
            System.out.printf("Insurance Reimbursement: -Rs. %.2f\n", reimbursement);

            System.out.println("--------------------------------");
            System.out.printf("FINAL OUT-OF-POCKET: Rs. %.2f\n", generateInvoice());
        }

    @Override
    public void runDiagnostics(String[] tests) {
        System.out.println("Running standard diagnostics suite.");
    }

    @Override
    public void prescribeMedication(String condition) {
        System.out.println("Prescribing standard medication for condition: " + condition);
    }

    @Override
    public void scheduleSurgery(String type, int urgencyLevel) {
        System.out.println("Scheduling surgery of type: " + type + " with urgency level: " + urgencyLevel);
    }

    @Override
    public void submitClaim(String policyNumber) {
        System.out.println("Submitting insurance claim for policy number: " + policyNumber);
    }

    @Override public boolean validateEmployeePolicy(String empId) { return true; }
}

public class HospitalManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Patient Registration ---");
        System.out.print("Name: ");
        String n = sc.nextLine();

        System.out.print("Age: ");
        int a = sc.nextInt();
        sc.nextLine();

        System.out.print("Gender: ");
        String g = sc.nextLine();

        System.out.print("Contact: ");
        String c = sc.nextLine();

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Room (ICU/Private/General): ");
        String r = sc.nextLine();

        SurgicalPatient patient = new SurgicalPatient(n, a, g, c, id, date, r);

        System.out.println("\n--- Medical Details ---");
        System.out.print("Weight (kg): ");
        double w = sc.nextDouble();

        System.out.print("Height (m): ");
        double h = sc.nextDouble();

        System.out.print("Surgery Hours: ");
        double hrs = sc.nextDouble();

        System.out.print("Severity (1-10): ");
        int sev = sc.nextInt();

        System.out.print("Comorbidities: ");
        int com = sc.nextInt();
        sc.nextLine();

        System.out.print("Corporate Tier (Gold/Silver/Standard): ");
        String tier = sc.nextLine();

        System.out.print("Insurance Coverage %: ");
        double cov = sc.nextDouble();

        System.out.print("Deductible: ");
        double ded = sc.nextDouble();

        System.out.print("Num Tests: ");
        int t = sc.nextInt();

        System.out.print("Daily Drug Cost: ");
        double ddc = sc.nextDouble();

        System.out.print("Room Days: ");
        int rd = sc.nextInt();

        patient.setBillingDetails(t, sev, ddc, hrs, com, tier, cov, ded, rd, patient.bmi(w, h));
        patient.printFullReport();

        sc.close();
    }
}