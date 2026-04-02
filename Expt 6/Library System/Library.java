import java.util.Scanner;

class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter EBook file size (e.g., 2.5MB): ");
        String fileSize = scanner.nextLine();
        System.out.print("Enter EBook format (e.g., PDF, EPUB): ");
        String format = scanner.nextLine();
        System.out.println("\nInitiating object creation...\n");
        EBook myEbook = new EBook(title, author, isbn, fileSize, format);
        System.out.println("\n--- Book Details ---");
        System.out.println(myEbook);
        scanner.close();
    }
}

class Book {
    String title, author, isbn;
    public Book(String t, String a, String i) {
        System.out.println("-> Book (Base Class) Constructor executed.");
        title = t;
        author = a;
        isbn = i;
    }
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn;
    }
}

class EBook extends Book {
    String fileSize, format;
    public EBook(String t, String a, String i, String fileSize, String format) {
        super(t, a, i);
        System.out.println("-> EBook (Subclass) Constructor executed.");
        this.fileSize = fileSize;
        this.format = format;
    }
    @Override
    public String toString() {
        return super.toString() + "\nFile Size: " + fileSize + "\nFormat: " + format;
    }
}