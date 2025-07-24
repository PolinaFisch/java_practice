package chatgpt.bigTask01.model;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String isbn;
    private String title;
    private String author;
    private Genre genre;

    public Book(String isbn, String title, String author, Genre genre) {
        //this.isbn = UUID.randomUUID().toString().substring(0, 8);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.getTitle());
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;

        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Book:[%s, %s, %s, %s]", isbn, title, author, genre);
    }
}

