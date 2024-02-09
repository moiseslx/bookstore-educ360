package br.com.cdb.bookstore.model;

public class PhysicalBook extends Book {
    private double weight; // Peso
    private double freight; // Frete

    public PhysicalBook(String title, String author, String isbn, double price, double weight, double freight) {
        super(title, author, isbn, price);
        setWeight(weight);
        setFreight(freight);
    }

    public void setFreight(double freight) {
        if (freight < 0) {
            throw new IllegalArgumentException("O frete deve ser maior ou igual a zero");
        }

        this.freight = freight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("O peso deve ser maior ou igual a zero");
        }

        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getFreight() {
        return freight;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() + getFreight();
    }

    @Override
    public String toString() {
        return "\u001B[32m" +
                "ID: " + getId() + " | Título: " + getTitle() + " | Autor: " + getAuthor() +
                " | ISBN: " + getIsbn() + " | Preço: " + getPrice() + " | Peso: " + getWeight() +
                " | Frete: " + getFreight() + " | Tipo: " + getType() +
                "\u001B[0m";
    }


    @Override
    public String getType() {
        return "PhysicalBook";
    }

    @Override
    public Book getCopy() {
        return new PhysicalBook(getTitle(), getAuthor(), getIsbn(), getPrice(), getWeight(), getFreight());
    }
}
