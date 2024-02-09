package br.com.cdb.bookstore.model;

public class EBook extends Book {

    private double sizeInMB; // Tamanho em MB

    public EBook(String title, String author, String isbn, double price, double sizeInMB) {
        super(title, author, isbn, price);
        setSizeInMB(sizeInMB);
    }

    public void setSizeInMB(double sizeInMB) {
        if (sizeInMB < 0) {
            throw new IllegalArgumentException("O tamanho em MB deve ser maior ou igual a zero");
        }

        this.sizeInMB = sizeInMB;
    }

    public double getSizeInMB() {
        return sizeInMB;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "\u001B[33m" +
                "ID: " + getId() + " | Título: " + getTitle() + " | Autor: " + getAuthor() +
                " | ISBN: " + getIsbn() + " | Preço: " + getPrice() +
                " | Tamanho em MB: " + getSizeInMB() + " | Tipo: " + getType() +
                "\u001B[0m";
    }


    @Override
    public String getType() {
        return "EBook";
    }

    @Override
    public Book getCopy() {
        return new EBook(getTitle(), getAuthor(), getIsbn(), getPrice(), getSizeInMB());
    }
}

