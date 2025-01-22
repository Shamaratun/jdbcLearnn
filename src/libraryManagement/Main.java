package libraryManagement;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LibrarySystem book = new LibrarySystem();
        book.LibrarySystem();

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. List of books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    LibrarySystem.bookList();
                    break;
                case 2:
                    LibrarySystem.borrowBook(scanner);
                    break;
                case 3:
                    LibrarySystem.returnBook(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Library Management system!!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
