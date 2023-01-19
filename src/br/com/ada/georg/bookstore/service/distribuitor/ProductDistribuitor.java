package br.com.ada.georg.bookstore.service.distribuitor;

import br.com.ada.georg.bookstore.products.Product;
import br.com.ada.georg.bookstore.products.album.Album;
import br.com.ada.georg.bookstore.products.game.Game;
import br.com.ada.georg.bookstore.products.book.Book;
import br.com.ada.georg.bookstore.products.film.Film;
import br.com.ada.georg.bookstore.products.toy.Toy;
import br.com.ada.georg.bookstore.service.Bookstore;

import java.math.BigDecimal;

public class ProductDistribuitor {

    ProductData[] productData = new ProductData[] {
            new AlbumData(), new BookData(), new FilmData(), new GameData() , new ToyData()
    };

    public void deliverProductShippment(Bookstore bookstore) {
        for (ProductData data : productData) {
            for (Object[] productEntry : data.getData()) {
                String productCategory = (String) productEntry[0];
                String productGenre = (String) productEntry[3];
                Product newProduct = null;
                switch (productCategory) {
                    case "Albums" -> {
                        newProduct = new Album(
                                (String) productEntry[1], (BigDecimal) productEntry[2],
                                (String) productEntry[3], (String) productEntry[4],
                                (String) productEntry[5], (int) productEntry[6]
                        );
                    }
                    case "Books" -> {
                        newProduct = new Book(
                                        (String) productEntry[1], (BigDecimal) productEntry[2],
                                        (String) productEntry[3], (String) productEntry[4],
                                        (String) productEntry[5], (int) productEntry[6]
                        );
                    }
                    case "Films" -> {
                        newProduct =
                                new Film(
                                        (String) productEntry[1], (BigDecimal) productEntry[2],
                                        (String) productEntry[3], (String) productEntry[4],
                                        (String) productEntry[5], (String) productEntry[6],
                                        (int) productEntry[7]
                                );
                    }
                    case "Games" -> {
                        newProduct = new Game(
                                (String) productEntry[1], (BigDecimal) productEntry[2],
                                (String) productEntry[3], (String) productEntry[4],
                                (String) productEntry[5], (int) productEntry[6]
                        );
                    }
                    case "Toys" -> {
                        newProduct = new Toy(
                                (String) productEntry[1], (BigDecimal) productEntry[2],
                                (String) productEntry[3], (int) productEntry[4]
                        );
                    }
                }
                bookstore.addProduct(productCategory, productGenre, newProduct);
            }
        }
    }
}
