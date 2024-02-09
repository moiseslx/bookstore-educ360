package br.com.cdb.bookstore.service;

import br.com.cdb.bookstore.model.Book;
import br.com.cdb.bookstore.repository.ShoppingCartRepository;
import br.com.cdb.bookstore.repository.impl.ShoppingCartRepositoryImpl;

import java.util.List;

public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository = new ShoppingCartRepositoryImpl();
    private int idCounter = 0;
    public void addBook(Book book) {
        Book newBook = book.getCopy();
        newBook.setId(idCounter++);
        shoppingCartRepository.addBook(newBook);
    }

    public void removeBook(int id) {
        shoppingCartRepository.removeBook(id);
    }

    public double checkout() {
        return shoppingCartRepository.getShoppingCart().calculateTotal();
    }

    public List<Book> findAll() {
        return shoppingCartRepository.getShoppingCart().books();
    }

    public Book findById(int id) {
        return shoppingCartRepository.findById(id);
    }
}
