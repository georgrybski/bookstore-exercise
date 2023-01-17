package br.com.georg.bookstore.utilities.printer;

import br.com.georg.bookstore.products.*;
import br.com.georg.bookstore.service.Bookstore;

import java.util.HashMap;
import java.util.Map;

import static br.com.georg.bookstore.utilities.printer.Printer.*;

public class ProductPrinter {

    public static void printAllProducts(Bookstore bookstore) {
        for (Map.Entry<String, HashMap<String, HashMap<String, Product>>> categoryLayer : bookstore.getInventory().entrySet()) {
            printProductsOfACategory(bookstore, categoryLayer.getKey());
        }
    }

    public static void printProduct(Product product, String genreType, String category) {
        printFrameLine();
        printIndentedFormattedLine(genreType + " " + category.substring(0, category.length() - 1)+ " | ID: " + product.getID());
        printIndentedFormattedLine(product.getName() + " | Price: " + product.getPrice() + " USD");

        switch (category) {
            case "Albums" -> {
                Album album = (Album) product;
                printFormattedMultiLineString("Author: " + album.getAuthor() + " | Record label: " + album.getRecordLabel());
            }
            case "Books" -> {
                Book book = (Book) product;
                printFormattedMultiLineString("Author: " + book.getAuthor() + " | Published by: " + book.getPublisher());
            }
            case "Films" -> {
                Film film = (Film) product;
                printFormattedMultiLineString("Directed by: " + film.getDirectors() + " | Produced by: " + film.getProducer());
            }
            case "Games" -> {
                Game game = (Game) product;
                printFormattedMultiLineString("Studio: " + game.getStudio() + " | Distribuitor: " + game.getDistribuitor());
            }
        }
        printIndentedFormattedLine(product.getQuantity() > 0 ? "In Stock - Only " + product.getQuantity() + " Left" : "Out of Stock");
        printFrameLine();
    }

    public static void printProductsOfACategory(Bookstore bookstore, String category) {
        for (Map.Entry<String, HashMap<String, Product>> genreTypeLayer : bookstore.getInventory().get(category).entrySet()) {
            printProductsOfAGenreType(bookstore, category, genreTypeLayer.getKey());
        }
    }

    public static void printProductsOfAGenreType(Bookstore bookstore, String category, String genreType) {
        for (Map.Entry<String, Product> productLayer : bookstore.getInventory().get(category).get(genreType).entrySet()) {
            printProduct(productLayer.getValue(), genreType, category);

        }
    }

}
