import java.util.Scanner;

public class InsuranceCalculator {

    /*ข้อที่ 1.1 CommissionRate*/
    public static String commissionRate(int age, int yearsInsured) {
        if (yearsInsured == 1) {          
            if (age >= 0 && age < 50) {
                return "2%";
            } else if (age >= 50 && age < 60) {
                return "2%";
            }
        } else if (yearsInsured == 2) {
            if (age >= 0 && age < 50) {
                return "1%";
            } else if (age >= 50 && age < 60) {
                return "2%";
            }
        } else if (yearsInsured == 3) {
            if (age >= 0 && age < 50) {
                return "1%";
            } else if (age >= 50 && age < 60) {
                return "1%";
            }
        } 
        return "Does not match any case";
    }

    /*ข้อที่ 1.2 OveridingRate*/
    public static String overridingRate(int age, String annual) {
        if (age >= 0 && age < 50) {
            if (annual.toLowerCase().contains("annual")) {
                return "20%";
            } else if (annual.toLowerCase().contains("nonannual")) {
                return "16%";
            }
            return "Does not match any case";
        } else if (age >= 51 && age < 60) {
            return "13%";
        }
        return "Does not match any case";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
      
        System.out.println("==================================================");
        System.out.println(" Choose which rate you want to calculate?");
        System.out.println("==================================================");
        System.out.println(" 1. First year insurance agent commission rate");
        System.out.println(" 2. Event organization fee per insurance premium");
        System.out.println("--------------------------------------------------");
        
        do {
            System.out.print(" Please choose (1 or 2): ");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println("--------------------------------------------------");
        } while (choice != 1 && choice != 2);
        
        if (choice == 1) {
            System.out.print(" Please enter the number of insured (1 - 3) years: ");
            int yearsInsured = Integer.parseInt(sc.nextLine());  
            System.out.print(" Please enter the age of the insured person: ");
            int ageOfInsured = Integer.parseInt(sc.nextLine());  
            String commissionRate = commissionRate(ageOfInsured, yearsInsured);
            System.out.println("\n*************************************************");
            System.out.println(" First year insurance agent commission rate: " + commissionRate);
            System.out.println("*************************************************");
        } else if (choice == 2) {
            String annual = "";
            System.out.print(" Please enter the age of the insured person: ");
            int ageOfInsured = Integer.parseInt(sc.nextLine());  

            if (ageOfInsured >= 0 && ageOfInsured <= 50) {
                System.out.println("\n==================================================");
                System.out.println(" Choose 'Annual' or 'NonAnnual' for insurance premium");    
                System.out.println("==================================================");    
                System.out.println(" 1. Annual");
                System.out.println(" 2. NonAnnual");
                System.out.println("--------------------------------------------------");   
                
                do {
                    System.out.print(" Please choose (1 or 2): ");
                    choice = Integer.parseInt(sc.nextLine());     
                    if (choice == 1) {
                        annual = "Annual";
                    } else if (choice == 2) {
                        annual = "NonAnnual";
                    } else {
                        System.out.println("\n*************************************************");
                        System.out.println(" Invalid choice. Please enter either 1 or 2.");
                        System.out.println("*************************************************");
                    }
                } while (choice != 1 && choice != 2);
            }
            String overridingRate = overridingRate(ageOfInsured, annual);
            System.out.println("\n*************************************************");
            System.out.println(" Event organization fee per insurance premium: " + overridingRate);
            System.out.println("*************************************************");
        }
        sc.close();
    } 
}
