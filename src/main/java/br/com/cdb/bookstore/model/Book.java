package br.com.cdb.bookstore.model;

public abstract class Book {

    private int id;
    private String title; // Título
    private String author; // Autor
    private String isbn; // ISBN
    private double price; // Preço

    Book(String title, String author, String isbn, double price) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setPrice(price);
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("O valor deve ser maior ou igual a zero");
        }
        this.price = price;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("O ISBN deve ser informado");
        }
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("O autor deve ser informado");
        }
        this.author = author;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("O título deve ser informado");
        }
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculateTotalPrice(); // Abstração do método para calcular o valor total

    public abstract String toString();

    public abstract String getType();

    public abstract Book getCopy();
}