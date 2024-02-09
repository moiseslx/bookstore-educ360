package br.com.cdb.bookstore;

import br.com.cdb.bookstore.controller.ShoppingController;

public class Main {
     static public void main(String[] args) {
        System.out.println("Seja bem vindo a livraria!");

        ShoppingController controller = new ShoppingController();

        controller.menu();

        while (true) {
            switch (controller.inputInt("Escolha uma opção: ")) {
                case 1 -> controller.menu();
                case 2 -> controller.listBooksForSale();
                case 3 -> controller.listPhysicalBooks();
                case 4 -> controller.listEBooks();
                case 5 -> controller.listShoppingCart();
                case 6 -> controller.addBook();
                case 7 -> controller.removeBook();
                case 8 -> controller.checkout();
                case 0 -> {
                    System.out.println("Finalizando o programa...");
                    System.exit(0);
                }
                default -> System.out.println("Entrada inválida. Tente novamente...");
            }
        }
    }
}