package br.com.cdb.bookstore.repository;

import br.com.cdb.bookstore.model.Book;
import br.com.cdb.bookstore.model.ShoppingCart;

public interface ShoppingCartRepository {
    void addBook(Book book);
    void removeBook(int id);
    Book findById(int id);
    ShoppingCart getShoppingCart();
}
