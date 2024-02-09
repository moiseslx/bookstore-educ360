package br.com.cdb.bookstore.model;

import java.util.List;

/**
 * @param books Livros do carrinho
 */
public record ShoppingCart(List<Book> books) {

    // Calcular o valor total dos livros
    public double calculateTotal() {
        if (books != null) {
            double total = 0;
            for (Book book : books) {
                total += book.calculateTotalPrice();
            }

            return total;
        }

        throw new IllegalArgumentException("O elemento books está nulo");
    }
}
