import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void displayInfo() {
        System.out.println("Author: " + name + " (" + gender + ") | Email: " + email);
    }
}

class Book {
    private String title;
    private double price;
    private int qty;
    private Author author;

    public Book(String title, Author author, double price) {
        this(title, author, price, 0);
    }

    public Book(String title, Author author, double price, int qty) {
        this.title = title;
        this.author = author;
        this.price = (price >= 0.0) ? price : 0.0;
        this.qty = (qty >= 0) ? qty : 0;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        }
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        if (qty >= 0) {
            this.qty = qty;
        }
    }

    public void displayInfo() {
        System.out.printf("Book: %-25s | Price: $%-6.2f | Qty: %-3d | Written by: %s\n", 
                title, price, qty, author.getName());
    }
}

class LibraryManager {
    private String libraryName;
    private List<Book> books;

    public LibraryManager(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    public List<Book> getBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    public void displayAllBooks() {
        System.out.println("============================================================================");
        System.out.println(" LIBRARY: " + libraryName.toUpperCase());
        System.out.println("============================================================================");
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        for (Book book : books) {
            book.displayInfo();
        }
        System.out.println("============================================================================\n");
    }
}

public class MainAuthorBook {
    public static void main(String[] args) {
        Author author1 = new Author("Nguyen Van A", "anv@cleancoder.com", 'M');
        Author author2 = new Author("Tran Thi B", "bt.tran@gmail.com", 'M');

        Book b1 = new Book("Clean Code", author1, 42.50, 15);
        Book b2 = new Book("Clean Architecture", author1, 45.00, 10);
        Book b3 = new Book("Effective Java", author2, 54.99, 20);

        LibraryManager library = new LibraryManager("UIT Central Library");
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.displayAllBooks();

        System.out.println("--> Searching books by author: 'Nguyen Van A'");
        List<Book> uncleBobBooks = library.getBooksByAuthor("Nguyen Van A");
        for (Book book : uncleBobBooks) {
            book.displayInfo();
        }
    }
}