package net.ms.model;

/**
 * Representa el modelo del objeto Libro.
 */
public class Book {
    //clave identificador del libro (simplemente para prácticas, será útil mas adelante para base de datos)
    private int bookId;
    //titulo que lleva el libro
    private String bookTitle;
    //código identificador universal del libro
    private String bookISBN;
    //representa disponiblidad del libro
    private boolean bookAvailable;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookISBN, boolean bookAvailable) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookISBN = bookISBN;
        this.bookAvailable = bookAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public boolean isBookAvailable() {
        return bookAvailable;
    }

    public void setBookAvailable(boolean bookAvailable) {
        this.bookAvailable = bookAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + bookId +
                ", Title='" + bookTitle + '\'' +
                ", ISBN='" + bookISBN + '\'' +
                ", Available=" + bookAvailable +
                '}';
    }
}
