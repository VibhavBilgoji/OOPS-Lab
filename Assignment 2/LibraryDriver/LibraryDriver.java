import java.util.Scanner;

class LibraryException extends Exception {
    public LibraryException(String message) { super(message); }
}

interface Displayable {
    void showDetails();
}

class Book implements Displayable {
    String isbn;
    String title;
    boolean isAvailable = true;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public void showDetails() {
        System.out.println("Book: " + title + " [" + isbn + "] - " + (isAvailable ? "Available" : "Issued"));
    }
}

abstract class User implements Displayable {
    String userId;
    String name;
    int maxBooks;
    int currentBooks = 0;

    public User(String userId, String name, int maxBooks) {
        this.userId = userId;
        this.name = name;
        this.maxBooks = maxBooks;
    }

    public void issueBook(Book b) throws LibraryException {
        if (!b.isAvailable) throw new LibraryException("Book is already issued.");
        if (currentBooks >= maxBooks) throw new LibraryException("Maximum borrowing limit reached.");
        b.isAvailable = false;
        currentBooks++;
        System.out.println(name + " successfully issued " + b.title);
    }

    public void returnBook(Book b) throws LibraryException {
        if (b.isAvailable) throw new LibraryException("This book was not issued.");
        b.isAvailable = true;
        currentBooks--;
        System.out.println(name + " successfully returned " + b.title);
    }
}

class Student extends User {
    public Student(String userId, String name) { super(userId, name, 3); }
    @Override
    public void showDetails() { System.out.println("Student: " + name + " | Issued: " + currentBooks + "/" + maxBooks); }
}

class Faculty extends User {
    public Faculty(String userId, String name) { super(userId, name, 10); }
    @Override
    public void showDetails() { System.out.println("Faculty: " + name + " | Issued: " + currentBooks + "/" + maxBooks); }
}

public class LibraryDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] library = { new Book("B1", "Java Fundamentals"), new Book("B2", "Data Structures") };
        Student s1 = new Student("U1", "Alice");
        Faculty f1 = new Faculty("U2", "Dr. Bob");

        while (true) {
            System.out.println("\n1. Issue Book\n2. Return Book\n3. Show Book Status\n4. Exit");
            System.out.print("Select action: ");
            int action = scanner.nextInt();
            if (action == 4) break;

            System.out.print("Select User (1 for Alice (Student), 2 for Dr. Bob (Faculty)): ");
            User activeUser = (scanner.nextInt() == 1) ? s1 : f1;

            if (action == 3) {
                library[0].showDetails();
                library[1].showDetails();
                activeUser.showDetails();
                continue;
            }

            System.out.print("Enter Book ID (B1 or B2): ");
            String bookId = scanner.next();
            Book selectedBook = bookId.equals("B1") ? library[0] : (bookId.equals("B2") ? library[1] : null);

            try {
                if (selectedBook == null) {
                    throw new LibraryException("Invalid Book ID.");
                }
                if (action == 1) activeUser.issueBook(selectedBook);
                else if (action == 2) activeUser.returnBook(selectedBook);
            } catch (LibraryException e) {
                System.out.println("Library Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}