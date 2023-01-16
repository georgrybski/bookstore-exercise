package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.products.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private static final String[] PRODUCT_CATEGORY_MENU_OPTIONS =
            createCategoryGenreAndTypeMenuOptions(Product.getCategories());

    private static final String[] LOGGED_OUT_MENU_OPTIONS = {
            "1 - Create an account", " 2 - Log in", "3 - Exit"
    };

    private static final String[] LOGGED_BUYER_MENU_OPTIONS = {
            "1 - Browse all products", "2 -  Add a product to shopping cart", "3 - Go to shopping cart",
            "4 - See my purchase history", "5 - Log out", "6 - Exit"
    };


    private static final String[] ADMIN_MENU_OPTIONS = {
            "1 - See products list", "2 - Add new product", "3 - Modify an existing product",
            "4 - Remove a product", "5 - See sales history", "6 - Log out", "7 - Exit"
    };

    public static HashMap<String, String[]> GENRE_TYPE_ARRAYS = new HashMap<>(Map.of(
            "Albums", Album.getGenreArray(), "Books", Book.getGenreArray(),
            "Films", Film.getGenreArray(), "Games", Game.getGenresArray(),
            "Toys", Toy.getTypesArray()
    ));

    private static String[] getGenreTypeArray(String category) {
        int[] i = {1};
        return Arrays.stream(GENRE_TYPE_ARRAYS.get(category))
                .map(option -> i[0]++ + " - " + option).toArray(String[]::new);
    }

    public static void seeProductList(Bookstore bookstore) {
        switch (Menu.getIntFrom(new String[]{"1 - All products", "2 -  Products of a certain category"})) {
            case 1 -> {
                Printer.printAllProducts(bookstore);
                Printer.printFormattedMesage("^ List of all products ^");
            }
            case 2 -> seeProductListByCategory(bookstore);
        }
    }

    public static void seeProductListByCategory(Bookstore bookstore) {
        int categoryNumber = getProductCategory() - 1;
        String categoryString = Product.getCategoriesArray()[categoryNumber];

        int input = Menu.getIntFrom(
                new String[]{
                        "1 - See all " + categoryString,
                        "2 - See " + categoryString + " of a specific "
                                + (categoryString.equals("Toys") ? "type" : "genre")
                }
        );

        switch (input) {
            case 1 -> {
                Printer.printProductsOfACategory(bookstore, categoryString);
                Printer.printFormattedMesage("^ List of " + categoryString + " ^");
            }
            case 2 -> seeProductByGenreType(bookstore, categoryString, categoryNumber);
        }
    }

    public static void goToCart(Bookstore bookstore, Account loggedAccount) {
        boolean checkingCart = true;
        while (checkingCart) {
        switch (Menu.getIntFrom(new String[]{"1 - Checkout", "2 - Remove or add items", "3 - Continue Shopping"})) {
//              TODO print cart
                case (1) -> {
                    bookstore.completeSale(loggedAccount.getShoppingCart());
                    Printer.printFormattedMesage("Payment successful");
                    checkingCart = false;
                }
//              TODO print cart
                case (2) -> {}
                case (3) -> checkingCart = false;
            }
        }
    }

    public static void seeProductByGenreType(Bookstore bookstore, String category, int categoryNumber) {
        int genreTypeNumber = Menu.getIntFrom(getGenreTypeArray(category));
        String genreTypeString = GENRE_TYPE_ARRAYS.get(Product.getCategoriesArray()[categoryNumber])[genreTypeNumber - 1];
        Printer.printProductsOfAGenreType(bookstore, category, genreTypeString);
        Printer.printFormattedMesage("^ List of " + genreTypeString + " " + category + " ^");
    }

    public static void addProduct(Bookstore bookstore) {

        int categoryNumber = getProductCategory() - 1;
        String categoryString = Product.getCategoriesArray()[categoryNumber];
        int genreTypeNumber = Menu.getIntFrom(getGenreTypeArray(categoryString));
        String genreTypeString = GENRE_TYPE_ARRAYS.get(Product.getCategoriesArray()[categoryNumber])[genreTypeNumber - 1];
        String productName = Input.getProductName(categoryString);
        BigDecimal productPrice = Input.getProductPrice(categoryString);

        Product newProduct = switch (categoryString) {
            case "Albums" -> new Album(
                    categoryString, productName, productPrice, genreTypeString,
                    Input.getProductAuthor(categoryString),
                    Input.getRecordLabel(), Input.getProductQuantity()
            );
            case "Books" -> new Book(
                    categoryString, productName, productPrice, genreTypeString,
                    Input.getProductAuthor(categoryString),
                    Input.getPublisher(), Input.getProductQuantity()
            );
            case "Films" -> new Film(
                    categoryString, productName, productPrice, genreTypeString,
                    Input.getStudio(categoryString),
                    Input.getDirector(),
                    Input.getProducer(),
                    Input.getProductQuantity()
            );
            case "Games" -> new Game(
                    categoryString, productName, productPrice, genreTypeString,
                    Input.getDistribuitor(),
                    Input.getStudio(categoryString),
                    Input.getProductQuantity()
            );
            case "Toys" -> new Toy(
                    categoryString, productName, productPrice, genreTypeString,
                    Input.getProductQuantity()
            );
            default -> null;
        };

        bookstore.addProduct(categoryString, genreTypeString, newProduct);
    }


    public static String[] createCategoryGenreAndTypeMenuOptions(HashMap<Integer, String> genres) {
        return genres.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toArray(String[]::new);
    }

    public static int getProductCategory() {
        return getIntFrom(PRODUCT_CATEGORY_MENU_OPTIONS);
    }

    public static int getLoggedOutInput() {
        return getIntFrom(LOGGED_OUT_MENU_OPTIONS);
    }

    public static int getCustomerInput() {
        return getIntFrom(LOGGED_BUYER_MENU_OPTIONS);
    }

    public static int getAdminInput() {
        return getIntFrom(ADMIN_MENU_OPTIONS);
    }


    public static int getIntFrom(String[] opcoes) {
        String prompt = "Insert a value between " + 1 + " and " + opcoes.length;
        String msgValorInvalido = "Invalid value! " + prompt;
        return Input.getIntegerFromMenu(opcoes, 1, opcoes.length, prompt,
                msgValorInvalido, true);
    }

    public static class ProductEditor {

        public static void editAlbum(Album album, Bookstore bookstore) {
            boolean changesInProgress = true;
            while (changesInProgress) {
                Printer.printProduct(album, album.getGenre(), "Albums");
                switch (getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                        "3 - Change stock", "4 - Change author", "5 - Change genre", "6 - Change record label", "7 - Finish changes"})) {
                    case 1 -> album.setName(Input.getProductName("Albums"));
                    case 2 -> album.setPrice(Input.getProductPrice("Albums"));
                    case 3 -> album.setQuantity(Input.getProductQuantity());
                    case 4 -> album.setAuthor(Input.getProductAuthor("Albums"));
                    case 5 -> {
                        String oldGenre = album.getGenre();
                        int genreTypeNumber = Menu.getIntFrom(getGenreTypeArray("Albums"));
                        String newGenreType = GENRE_TYPE_ARRAYS.get("Albums")[genreTypeNumber - 1];
                        if (newGenreType.equals(oldGenre)) {
                            Printer.printFormattedMesage(album.getName() + " is already registered as a " + newGenreType + " album");
                        } else {
                            album.setGenre(newGenreType);
                            bookstore.getDatabase().transferProduct(oldGenre, newGenreType, album);
                            Printer.printFormattedMesage("This product's ID has been changed to: " + album.getID());
                        }
                    }
                    case 6 -> album.setRecordLabel(Input.getRecordLabel());
                    case 7 -> changesInProgress = false;
                }
            }
        }

        public static void editBook(Book book, Bookstore bookstore) {
            boolean changesInProgress = true;
            while (changesInProgress) {
                Printer.printProduct(book, book.getGenre(), "Books");
                switch (getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                        "3 - Change stock", "4 - Change author", "5 - Change genre", "6 - Change publisher", "7 - Finish changes"})) {
                    case 1 -> book.setName(Input.getProductName("Books"));
                    case 2 -> book.setPrice(Input.getProductPrice("Books"));
                    case 3 -> book.setQuantity(Input.getProductQuantity());
                    case 4 -> book.setAuthor(Input.getProductAuthor("Books"));
                    case 5 -> {
                        String oldGenre = book.getGenre();
                        int genreTypeNumber = Menu.getIntFrom(getGenreTypeArray("Books"));
                        String newGenreType = GENRE_TYPE_ARRAYS.get("Books")[genreTypeNumber - 1];
                        if (newGenreType.equals(oldGenre)) {
                            Printer.printFormattedMesage(book.getName() + " is already registered as a " + newGenreType + " book");
                        } else {
                            book.setGenre(newGenreType);
                            bookstore.getDatabase().transferProduct(oldGenre, newGenreType, book);
                            Printer.printFormattedMesage("This product's ID has been changed to: " + book.getID());
                        }
                    }
                    case 6 -> book.setPublisher(Input.getPublisher());
                    case 7 -> changesInProgress = false;
                }
            }
        }

        public static void editFilm(Film film, Bookstore bookstore) {
            boolean changesInProgress = true;
            while (changesInProgress) {
                Printer.printProduct(film, film.getGenre(), "Films");
                switch (getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                        "3 - Change stock", "4 - Change studio", "5 - Change director", "6 - Change genre", "7 - Change producer", "8 - Finish changes"})) {
                    case 1 -> film.setName(Input.getProductName("Films"));
                    case 2 -> film.setPrice(Input.getProductPrice("Films"));
                    case 3 -> film.setQuantity(Input.getProductQuantity());
                    case 4 -> film.setStudio(Input.getStudio("Films"));
                    case 5 -> film.setDirectors(Input.getDirector());
                    case 6 -> {
                        String oldGenre = film.getGenre();
                        int genreTypeNumber = Menu.getIntFrom(getGenreTypeArray("Films"));
                        String newGenreType = GENRE_TYPE_ARRAYS.get("Films")[genreTypeNumber - 1];
                        if (newGenreType.equals(oldGenre)) {
                            Printer.printFormattedMesage(film.getName() + " is already registered as a " + newGenreType + " film");
                        } else {
                            film.setGenre(newGenreType);
                            bookstore.getDatabase().transferProduct(oldGenre, newGenreType, film);
                            Printer.printFormattedMesage("This product's ID has been changed to: " + film.getID());
                        }
                    }
                    case 7 -> film.setProducer(Input.getProducer());
                    case 8 -> changesInProgress = false;
                }
            }
        }

        public static void editGame(Game game, Bookstore bookstore) {
            boolean changesInProgress = true;
            while (changesInProgress) {
                Printer.printProduct(game, game.getGenre(), "Games");
                switch (getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                        "3 - Change stock", "4 - Change distribuitor", "5 - Change genre", "6 - Change studio", "7 - Finish changes"})) {
                    case 1 -> game.setName(Input.getProductName("Games"));
                    case 2 -> game.setPrice(Input.getProductPrice("Games"));
                    case 3 -> game.setQuantity(Input.getProductQuantity());
                    case 4 -> game.setDistribuitor(Input.getDistribuitor());
                    case 5 -> {
                        String oldGenre = game.getGenre();
                        int genreTypeNumber = Menu.getIntFrom(getGenreTypeArray("Games"));
                        String newGenreType = GENRE_TYPE_ARRAYS.get("Games")[genreTypeNumber - 1];
                        if (newGenreType.equals(oldGenre)) {
                            Printer.printFormattedMesage(game.getName() + " is already registered as a " + newGenreType + " game");
                        } else {
                            game.setGenre(newGenreType);
                            bookstore.getDatabase().transferProduct(oldGenre, newGenreType, game);
                            Printer.printFormattedMesage("This product's ID has been changed to: " + game.getID());
                        }
                    }
                    case 6 -> game.setStudio(Input.getStudio("Games"));
                    case 7 -> changesInProgress = false;
                }
            }
        }

        public static void editToy(Toy toy, Bookstore bookstore) {
            boolean changesInProgress = true;
            while (changesInProgress) {
                Printer.printProduct(toy, toy.getType(), "Toys");
                switch (getIntFrom(new String[]{"1 - Change name", "2 - Change price",
                        "3 - Change stock", "4 - Change distribuitor", "5 - Change genre", "6 - Change studio", "7 - Finish changes"})) {
                    case 1 -> toy.setName(Input.getProductName("Toys"));
                    case 2 -> toy.setPrice(Input.getProductPrice("Toys"));
                    case 3 -> toy.setQuantity(Input.getProductQuantity());
                    case 5 -> {
                        String oldGenre = toy.getType();
                        int genreTypeNumber = Menu.getIntFrom(getGenreTypeArray("Toys"));
                        String newGenreType = GENRE_TYPE_ARRAYS.get("Toys")[genreTypeNumber - 1];
                        if (newGenreType.equals(oldGenre)) {
                            Printer.printFormattedMesage(toy.getName() + " is already registered as a " + newGenreType + " toy");
                        } else {
                            toy.setType(newGenreType);
                            bookstore.getDatabase().transferProduct(oldGenre, newGenreType, toy);
                            Printer.printFormattedMesage("This product's ID has been changed to: " + toy.getID());
                        }
                    }
                    case 7 -> changesInProgress = false;
                }
            }
        }

    }
}



