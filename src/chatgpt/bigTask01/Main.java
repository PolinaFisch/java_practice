package chatgpt.bigTask01;

import chatgpt.bigTask01.model.Book;
import chatgpt.bigTask01.model.Genre;
import chatgpt.bigTask01.model.Library;
import chatgpt.bigTask01.model.Member;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // 1) Добавляем книги
        lib.addBook(new Book("978-1", "Clean Code", "Robert Martin", Genre.TECH));
        lib.addBook(new Book("978-2", "Harry Potter", "J. K. Rowling", Genre.FANTASY));
        lib.addBook(new Book("978-3", "Effective Java", "Joshua Bloch", Genre.TECH));

        // 2) Регистрируем читателей
        lib.registerMember(new Member("M001", "Ivan", "Ivanov"));
        lib.registerMember(new Member("M002", "Anna", "Petrova"));

        // 3) Выдаём и возвращаем
        lib.loanBook("978-1", "M001");
        lib.loanBook("978-2", "M002");
        System.out.println("Loaned: " + lib.listLoanedBooks());

        lib.returnBook("978-1", "M001");
        System.out.println("Available: " + lib.listAvailableBooks());

        // 4) Поиск по автору и жанру
        System.out.println("By author Bloch: " + lib.findBooksByAuthor("Joshua Bloch"));
        System.out.println("Fantasy books: " + lib.findBooksByGenre(Genre.FANTASY));

        // 5) Stream‑метод: просроченные
        // (предположим, dueDate выставлен на вчера)
        System.out.println("Overdue: " +
                lib.listOverdueBooks(LocalDate.now().plusDays(16)));

        // 6) Убедимся в сортировке
        lib.sortCatalog();
        System.out.println("Catalog sorted: " + lib.listAvailableBooks());

        lib.returnBook("978-2", "M002");
        System.out.println("Fantasy books: " + lib.findBooksByGenre(Genre.FANTASY));

        lib.sortCatalog();
        System.out.println("Catalog sorted: " + lib.listAvailableBooks());
    }


}









