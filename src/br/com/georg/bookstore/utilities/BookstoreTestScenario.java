package br.com.georg.bookstore.utilities;

import br.com.georg.bookstore.products.*;
import br.com.georg.bookstore.service.Bookstore;

import java.math.BigDecimal;

public class BookstoreTestScenario {

    public static void populateBookstore(Bookstore bookstore) {
        for (Object[][] productDataMatrix: ProductList.productData) {
            for (Object[] productData : productDataMatrix) {
                String productCategory = (String) productData[0];
                String productGenre = (String) productData[3];
                Product newProduct = null;
                switch (productCategory) {
                    case "Albums" -> {
                        newProduct = new Album((String) productData[1], (BigDecimal) productData[2], (String) productData[3], (String) productData[4], (String) productData[5], (int) productData[6]);
                    }
                    case "Books" -> {
                        newProduct = new Book((String) productData[1], (BigDecimal) productData[2], (String) productData[3], (String) productData[4], (String) productData[5], (int) productData[6]);
                    }
                    case "Films" -> {
                        newProduct = new Film((String) productData[1], (BigDecimal) productData[2], (String) productData[3], (String) productData[4], (String) productData[5], (String) productData[6], (int) productData[7]);
                    }
                    case "Games" -> {
                        newProduct = new Game((String) productData[1], (BigDecimal) productData[2], (String) productData[3], (String) productData[4], (String) productData[5], (int) productData[6]);
                    }
                    case "Toys" -> {
                        newProduct = new Toy((String) productData[1], (BigDecimal) productData[2], (String) productData[3], (int) productData[4]);
                    }
                }
                bookstore.addProduct(productCategory, productGenre, newProduct);
            }
        }
    }
    public static class ProductList {



        public static Object[][] albumData = new Object[][] {
//              {String name, BigDecimal price, String genre, String author, String recordLabel, int quantity}

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Pop", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Pop", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Hip hop", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Hip hop", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Rock", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Rock", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Rhythm and blues", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Rhythm and blues", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Soul", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Soul", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Reggae", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Reggae", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Country", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Country", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Funk", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Funk", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Folk", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Folk", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Middle Eastern", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Middle Eastern", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Jazz", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Jazz", "Author", "Record Label", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Disco", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Disco", "Author", "Record Label", 100},

                {"Albums", "The Complete Recordings on Deutsche Grammophon", BigDecimal.valueOf(169.99), "Classical", "Martha Argerich", "Orpheus", 100},
                {"Albums", "Symphony No. 3 (Symphony of Sorrowful Songs); 3 Olden Style Pieces", BigDecimal.valueOf(169.99), "Classical", "Henryk Mikołaj Górecki", "NAXOS", 100},

                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Electronic", "Author", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Electronic", "Author", "Record Label", 100},

                {"Albums", "Bossa Nova", BigDecimal.valueOf(169.99), "Latin American Music", "Antônio Carlos Jobim", "Record Label", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Latin American Music", "Author", "Record Label", 100},

                {"Albums", "Hoodoo Man Blues", BigDecimal.valueOf(169.99), "Blues", "Junior Wells", "Delmark", 100},
                {"Albums", "Hard Again", BigDecimal.valueOf(169.99), "Blues", "Muddy Waters", "Blue Sky Records", 100},

                {"Albums", "Deep Breakfast", BigDecimal.valueOf(169.99), "New-age", "Ray Lynch", "Music West", 100},
                {"Albums", "Shepherd Moons", BigDecimal.valueOf(169.99), "New-age", "Enya", "Reprise ", 100},

                {"Albums", "Memeza", BigDecimal.valueOf(169.99), "African music", "Brenda Fassie", "CCP Records", 100},
                {"Albums", "Zombie", BigDecimal.valueOf(169.99), "African music", "Fela Kuti", "Polydor Records", 100},

                {"Albums", "There Is More", BigDecimal.valueOf(169.99), "Christian music", "Hillsong Music and Capitol Christian Music Group", "Hillsong Music, Capitol CMG", 100},
                {"Albums", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Christian music", "Author", "Record Label", 100},

                {"Albums", "One", BigDecimal.valueOf(169.99), "Islamic music", "Maher Zain", "Awakening Records", 100},
                {"Albums", "Barakah", BigDecimal.valueOf(169.99), "Islamic music", "Sami Yusuf", "Andante Records", 100},

                {"Albums", "Wrongful Meeting", BigDecimal.valueOf(169.99), "Asian music", "Kim Gun-mo", "Line Production", 100},
                {"Albums", "BE", BigDecimal.valueOf(169.99), "Asian music", "BTS", "Big Hit Entertainment", 100},

                {"Albums", "More Specials", BigDecimal.valueOf(169.99), "Ska", "The Specials", "Chrysalis Records", 100},
                {"Albums", "New York Fever", BigDecimal.valueOf(169.99), "Ska", "The Toasters", "Moon Ska Records", 100},

        };

        public static Object[][] bookData = new Object[][] {
//              {String name, BigDecimal price, String genre, String author, String publisher, int quantity}

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure stories", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure stories", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Classics", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Classics", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Crime", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Crime", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fairy tales, fables, and folk tales", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fairy tales, fables, and folk tales", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fantasy", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Fantasy", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Historical fiction", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Historical fiction", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Humour and satire", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Humour and satire", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Poetry", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Poetry", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Plays", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Plays", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science fiction", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science fiction", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Short stories", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Short stories", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thrillers", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thrillers", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "War", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "War", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Women’s fiction", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Women’s fiction", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Young adult", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Young adult", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Autobiography and memoir", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Autobiography and memoir", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Biography", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Biography", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Essays", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Essays", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Non-fiction novel", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Non-fiction novel", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Self-help", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Self-help", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Psychology", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Psychology", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Geology", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Geology", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Chemistry", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Chemistry", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Astronomy", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Astronomy", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Zoology", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Zoology", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mathematics and logic", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mathematics and logic", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Programming", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Programming", "Author", "Publisher", 100},

                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Data Science", "Author", "Publisher", 100},
                {"Books", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Data Science", "Author", "Publisher", 100},

        };

        public static Object[][] filmData = new Object[][] {
//              {String name, BigDecimal price, String genre, String studio, String director, String producer, int quantity}
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Adventure", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Comedy", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Drama", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Horror", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Mystery", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Romance", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Thriller", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Western", "Studio", "Director", "Producer", 100},

                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
                {"Films", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Science Fiction", "Studio", "Director", "Producer", 100},
        };

        public static Object[][] gameData = new Object[][] {
//              {String name, BigDecimal price, String genre, String distribuitor, String studio, int quantity}
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "First Person Shooter", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action-Adventure", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Survival", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Puzzle", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Role-Playing", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "MMO", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sports", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Sandbox", "Distribuitor", "Studio", 100},

                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100},
                {"Games", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", "Distribuitor", "Studio", 100}
        };


        public static Object[][] toyData = new Object[][] {
//              {String name, BigDecimal price, int quantity, String genre}

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action figure", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Action figure", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Animal", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Animal", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Car and radio controlled", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Car and radio controlled", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Construction", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Construction", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Creative", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Creative", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Doll", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Doll", 100},

                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", 100},
                {"Toys", "Lego Porche 911 RSR 42096", BigDecimal.valueOf(169.99), "Educational", 100},

                {"Toys", "Lego Porche 911 RSR - 42096", BigDecimal.valueOf(169.99), "Electronic", 100},
                {"Toys", "Lego Hogwarts Castle - 71043 ", BigDecimal.valueOf(469.99), "Electronic", 100},

                {"Toys", "Perpetual Motion Desktop Gadget", BigDecimal.valueOf(35.36), "Executive", 100},
                {"Toys", "Golden Winged Fidget Spinner", BigDecimal.valueOf(57.99), "Executive", 100},

                {"Toys", "Theo Klein Miele Petit Gourmet Play Kitchen", BigDecimal.valueOf(89.99), "Food-related", 100},
                {"Toys", "So Slime DIY Slimelicious Factory", BigDecimal.valueOf(31.99), "Food-related", 100},

                {"Toys", "CubicFun Titanic 3D", BigDecimal.valueOf(36.99), "Puzzle", 100},
                {"Toys", "Starry Night Vincent Van Gogh Jigsaw - 5070cm", BigDecimal.valueOf(12.99), "Puzzle", 100},

                {"Toys", "KidzLab Anti-Gravity Maglev", BigDecimal.valueOf(43.99), "Science and optical", 100},
                {"Toys", "NATIONAL GEOGRAPHIC Break Open 10 Premium Geodes", BigDecimal.valueOf(34.99), "Science and optical", 100},

                {"Toys", "Baby Einstein Take Along Tunes", BigDecimal.valueOf(9.99), "Sound and music", 100},
                {"Toys", "Hape Mighty Echo Microphone", BigDecimal.valueOf(11.99), "Sound and music", 100}
        };

        public static Object[][][] productData = new Object[][][] {
                albumData, bookData, filmData, gameData, toyData
        };
    }
}