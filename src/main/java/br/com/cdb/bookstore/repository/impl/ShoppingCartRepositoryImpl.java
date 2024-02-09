package br.com.cdb.bookstore.repository.impl;

import br.com.cdb.bookstore.model.Book;
import br.com.cdb.bookstore.model.ShoppingCart;
import br.com.cdb.bookstore.repository.ShoppingCartRepository;

import java.util.ArrayList;

public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

    // Cria um carrinho
    private final ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());

    // Adiciona um livro ao carrinho
    @Override
    public void addBook(Book book) {
        shoppingCart.books().add(book);
    }

    // Remove um livro do carrinho
    @Override
    public void removeBook(int id) {
        for (int i = 0; i < shoppingCart.books().size(); i++) {
            if (shoppingCart.books().get(i).getId() == id) {
                shoppingCart.books().remove(i);
                break;
            }
        }
    }

    @Override
    public Book findById(int id) {
        for (Book book : shoppingCart.books()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Retorna o carrinho
    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
