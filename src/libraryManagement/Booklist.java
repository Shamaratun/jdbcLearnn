package libraryManagement;

public class Booklist {
    private  String  title;
    private  String  author;
    private  int  year;
    private  int  pages;
    private  int  price;
    boolean isBorrowed;
    public Booklist(String title, String author, int year, int pages, int price, boolean borrowed) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.isBorrowed = borrowed;
    }

    public Booklist(String title) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("pages: " + pages);
        System.out.println("Available: " + (isBorrowed ? "No" : "Yes"));
        System.out.println("----------------------------");
    }
}
