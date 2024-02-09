package br.com.cdb.bookstore.controller;

import br.com.cdb.bookstore.model.Book;
import br.com.cdb.bookstore.model.EBook;
import br.com.cdb.bookstore.model.PhysicalBook;
import br.com.cdb.bookstore.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingController {

    private final Scanner scanner;
    private final ShoppingCartService shoppingCartService;
    private final List<Book> books = new ArrayList<>(); // Lista de livros da > BIBLIOTECA <

    public ShoppingController() {
        initializeBookStore();
        this.scanner = new Scanner(System.in);
        this.shoppingCartService = new ShoppingCartService();
    }

    public void listBooksForSale() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addBook() {
        int id = inputInt("Digite o do livro que deseja adicionar: ");
        if (id > books.size()) {
            System.out.println("Não existe esse livro na biblioteca...");
            return;
        }

        shoppingCartService.addBook(books.get(id));
        System.out.println("Livro '" + books.get(id).getTitle() + "' foi adicionado ao carrinho!");
    }

    public void removeBook() {
        int id = inputInt("Digite o do livro que deseja remover do carrinho: ");
        if (shoppingCartService.findById(id) == null) {
            System.out.println("Não existe esse livro no carrinho...");
            return;
        }

        String title = shoppingCartService.findById(id).getTitle();
        shoppingCartService.removeBook(id);
        System.out.println("Livro '" + title + "' foi removido do carrinho!");
    }

    public void checkout() {
        System.out.print("Deseja finalizar sua compra? (s/n): ");
        if (scanner.next().equalsIgnoreCase("s")) {
            System.out.println("\nSuas compras: ");

            for (Book book : shoppingCartService.findAll()) {
                System.out.println(book);
            }

            if (shoppingCartService.checkout() != 0)
                System.out.println("O valor total da sua compra é: " + shoppingCartService.checkout());
            else System.out.println("Você não tem livros no carrinho!");

            scanner.close();
            System.exit(0);
        }
    }

    // Aplicando o instanceof aprendido no CDB, para mostrar os livros da BIBLIOTECA
    public void listPhysicalBooks() {
        for (Book book : books) {
            if (book instanceof PhysicalBook) {
                System.out.println(book);
            }
        }
    }

    public void listEBooks() {
        for (Book book : books) {
            if (book instanceof EBook) {
                System.out.println(book);
            }
        }
    }

    public void listShoppingCart() {

        if (shoppingCartService.findAll().isEmpty()) {
            System.out.println("Carrinho de compras vazio!");
            return;
        }

        System.out.println("\nSeu carrinho de compras: ");
        for (Book book : shoppingCartService.findAll()) {
            System.out.println(book);
        }
    }

    public int inputInt(String message) {
        //Usando o try catch para garantir que o input seja um inteiro e recursividade
        try {
            System.out.print(message);
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Tente novamente...");
            scanner.nextLine();
            return inputInt(message);
        }
    }

    public void menu() {
        System.out.println("---- Livraria CDB -----");
        System.out.println("1. Visualizar Menu de Opções");
        System.out.println("2. Visualizar Livros da BIBLIOTECA");
        System.out.println("3. Visualizar Livros Físicos");
        System.out.println("4. Visualizar Livros E-Book");
        System.out.println("5. Visualizar CARRINHO");
        System.out.println("6. Adicionar Livro ao CARRINHO");
        System.out.println("7. Remover Livro do CARRINHO");
        System.out.println("8. Finalizar Compra");
        System.out.println("0. Sair");
    }

    private void initializeBookStore() {
        List<Book> books = new ArrayList<>();

        // Instâncias de livros gerada por IA
        // Instâncias de livros geradas por IA
        books.add(new EBook("A Revolução dos Bichos", "George Orwell", "978-8595084759", 20.00, 2.0));
        books.add(new EBook("Cem Anos de Solidão", "Gabriel García Márquez", "478-8595084759", 30.00, 1.8));
        books.add(new EBook("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "978-8595084752", 15.00, 1.0));
        books.add(new EBook("A Arte de Fazer Acontecer", "David Allen", "978-8595084242", 25.00, 1.5));
        books.add(new EBook("O Poder do Hábito", "Charles Duhigg", "978-8595024753", 25.00, 1.5));

        books.add(new PhysicalBook("O Alquimista", "Paulo Coelho", "322-8595084759", 15.00, 0.8, 15));
        books.add(new PhysicalBook("A Menina que Roubava Livros", "Markus Zusak", "324-8595084759", 18.00, 1.2, 12));
        books.add(new PhysicalBook("1984", "George Orwell", "325-8595084759", 20.00, 1.0, 10));
        books.add(new PhysicalBook("O Nome do Vento", "Patrick Rothfuss", "326-8595084759", 30.00, 1.5, 8));
        books.add(new PhysicalBook("A Sutil Arte de Ligar o F*da-se", "Mark Manson", "327-8595084759", 22.00, 1.3, 10));


        // Ordenação dos livros
        this.books.addAll(books);
        books.sort((b1, b2) -> b1.getType().compareTo(b2.getType()));

        for (Book book : books) {
            book.setId(books.indexOf(book));
        }
    }
}
