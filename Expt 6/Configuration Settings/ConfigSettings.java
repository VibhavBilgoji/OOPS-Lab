import java.util.Scanner;

class ConfigSettings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Configuration ID:");
        String id = sc.nextLine();

        System.out.println("Enter System Name:");
        String name = sc.nextLine();

        SystemConfig config = new SystemConfig(id, name);
        config.displayConfiguration();

        sc.close();
    }
}

final class SystemConfig{
    String configurationId, systemName;
    public SystemConfig(String id, String name) {
        configurationId = id;
        systemName = name;
    }
    public void displayConfiguration(){
        System.out.println("--- System Configuration ---");
       	System.out.println("Configuration ID: " + configurationId);
       	System.out.println("System Name: " + systemName);
    }
}

/*
// If you uncomment this, the compiler will throw an error:
// "cannot inherit from final SystemConfig"

class ConfigExtension extends SystemConfig {
    public ConfigExtension(String id, String name) {
        super(id, name);
    }
}
*/