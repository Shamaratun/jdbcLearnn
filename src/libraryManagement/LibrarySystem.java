package libraryManagement;

import java.util.Arrays;
import java.util.Scanner;

public class LibrarySystem {
    static Booklist[] books = {
            new Booklist("THE VINCI CODE", "DAN BROWN", 1999, 550, 500, true),
            new Booklist("SATKAHON", "SAMARASH MOJUMDAR", 1990, 550, 420, true),
            new Booklist("UTTORADHIKAR", "SAMARASH MOJUMDAR", 1998, 350, 400, true),
            new Booklist("KALLBELA", "SAMARASH MOJUMDAR", 2005, 500, 380, true)
    };


    static void listofBooks() {
        System.out.println(Arrays.toString(books));

    }

    public static void bookList(){
        for (Booklist book: books){
            book.display();
        }
        System.out.println("Press any key+Enter to return to the menu.");
        new Scanner(System.in).nextLine();
    }

    public static void borrowBook(Scanner scanner) {
        while (true) {
            System.out.print("Enter the title of the book to borrow (or type '0' to return to the menu): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("0")) {
                break;
            }

            boolean found = false;
            for (Booklist book : books ) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    found = true;
                    if (book.isBorrowed()) {
                        book.setBorrowed(false);
                        System.out.println("You have successfully borrowed '" + book.getTitle() + "'.");
                    } else {
                        System.out.println("Sorry, '" + book.getTitle() + "' is currently not available.");
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Book not found in the library.");
            }
        }
    }

    public static void returnBook(Scanner scanner) {
        while (true) {
            System.out.print("Enter the  of the book  to return (or type '0' to return to the menu): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("0")) {
                break;
            }

            boolean found = false;
            for (Booklist book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    found = true;
                    if (!book.isBorrowed()) {
                        book.setBorrowed(true);
                        System.out.println("Thank you for returning '" + book.getTitle() + "'.");
                    } else {
                        System.out.println("'" + book.getTitle() + "' was not borrowed.");
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Book not found in the library.");
            }
        }

    }


    public void LibrarySystem() {
    }
}