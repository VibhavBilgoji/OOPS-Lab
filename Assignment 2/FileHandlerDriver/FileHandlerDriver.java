import java.util.Scanner;

interface Readable {
    String read() throws RuntimeException;
}

interface Writable {
    void write(String data) throws RuntimeException;
}

class FileHandler implements Readable, Writable {
    private String[] storage = new String[5];
    private int currentIndex = 0;

    public void write(String data) throws RuntimeException {
        if (data == null || data.trim().isEmpty()) {
            throw new RuntimeException("Write Error: Content cannot be empty.");
        }
        if (currentIndex >= storage.length) {
            throw new RuntimeException("Write Error: File storage is full.");
        }
        storage[currentIndex++] = data;
        System.out.println("Data written successfully.");
    }

    public String read() throws RuntimeException {
        if (currentIndex == 0) {
            throw new RuntimeException("Read Error: File is empty.");
        }
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < currentIndex; i++) {
            content.append(storage[i]).append("\n");
        }
        return content.toString();
    }
}

public class FileHandlerDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler handler = new FileHandler();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Write\n2. Read\n3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter string to write: ");
                        String input = scanner.nextLine();
                        handler.write(input);
                        break;
                    case "2":
                        System.out.println("File Content:\n" + handler.read());
                        break;
                    case "3":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}