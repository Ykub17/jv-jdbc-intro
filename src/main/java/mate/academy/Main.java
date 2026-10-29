package mate.academy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import mate.academy.lib.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.academy");
        BookDao bookDao = (BookDao) injector.getInstance(BookDao.class);

        Book newBook = new Book();
        newBook.setTitle("Effective Java");
        newBook.setPrice(new BigDecimal("45.00"));

        Book createdBook = bookDao.create(newBook);
        System.out.println("Created: " + createdBook);

        Optional<Book> found = bookDao.findById(createdBook.getId());
        System.out.println("Found: " + found.orElse(null));

        createdBook.setTitle("Effective Java 3rd Edition");
        createdBook.setPrice(new BigDecimal("50.00"));
        Book updated = bookDao.update(createdBook);
        System.out.println("Updated: " + updated);

        List<Book> allBooks = bookDao.findAll();
        System.out.println("All books count: " + allBooks.size());

        boolean isDeleted = bookDao.deleteById(createdBook.getId());
        System.out.println("Deleted: " + isDeleted);
    }
}
