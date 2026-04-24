interface Diagnosable{
    void runDiagnostics(String[] tests);
    default int diagnosticCost(int numberOfTests){
        final int baseCost = 800;
        final int labFee = 200;
        return numberOfTests * baseCost + labFee;
    }
}

interface Treatable extends Diagnosable{
    void prescribeMedication(String condition);
    default int treatmentDuration(int severity){
        final int days = severity * 3 + 5;
        return days;
    }
    default double medicationCost(int daysOfTreatment, double dailyDrugCost){
        final var medCost = daysOfTreatment * dailyDrugCost;
        final float pharmacyMarkup = 0.12f;
        return (1 + pharmacyMarkup) * medCost;
    }
}

interface SurgicallyTreatable extends Treatable{
    void scheduleSurgery(String type, int urgencyLevel);
    default float surgeryRisk(int age, double bmi, int comorbidities){
        final float riskScore = (age * 0.4f) + (bmi > 30 ? 20 : 0) + (comorbidities * 15);
        return riskScore;
    }
    default double anesthesiaCost(double surgeryHours){
        final int aneCostPerHour = 3500;
        final int flatRate = 2000;
        return aneCostPerHour * surgeryHours + flatRate;
    }
}

interface Billable{
    double generateInvoice();
    default double applyGST(double amount){
        // boolean checks = false;
        // double finalBill;
        // final float medGST = 0.05f;
        // final float nonMedGST = 0.18f;
        // do{
        //     System.out.print("Enter the medical services bill: ");
        //     final var medBill = sc.nextDouble();
        //     if(medBill < 0){
        //         System.out.println("Bill cannot be negative.");
        //         continue;
        //     }
        //     System.out.print("Enter the non-medical services bill: ");
        //     final var nonMedBill = sc.nextDouble();
        //     if(nonMedBill < 0){
        //         System.out.println("Bill cannont be negative.");
        //         continue;
        //     }
        //     if((medBill + nonMedBill) != amount){
        //         System.out.println("The combined bill must be " + amount);
        //         continue;
        //     }
        //     checks = true;
        //     finalBill = medBill * (1 + medGST) + nonMedBill * (1 + nonMedGST);
        // } while (!checks);
        // return finalBill;
        return 0.0
    }
    default double lateFee(int daysOverdue){
        return 0.0;
    }
}

interface InsuranceClaimable extends Billable{
    void submitClaim(String policyNumber);
    default double reimbursementAmount(double totalBill, double coveragePercentage, double deductible){
        return Math.max(0, totalBill * coveragePercentage / 100 - deductible);
    }
}

interface CorporateClaimable extends InsuranceClaimable{
    default double corporateDiscount(double bill, String tier){
        float discount;
        switch (tier) {
            case "Gold":
            discount = 0.20f;
            break;

            case "Silver":
            discount = 0.12f;
            break;

            case "Standard":
            discount = 0.05f;
            break;

            default:
            discount = 0.0f;
            break;
        }
        return bill * (1 - discount);
    }
    boolean validateEmployeePolicy(String empId);
}