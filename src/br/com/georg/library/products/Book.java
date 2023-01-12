package br.com.georg.library.products;

import br.com.georg.library.utilities.HashMapTools;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Book extends Product {

    private String genre;

    private String author;

    private String publisher;


    private static String[] genreArray = new String[] {
            "Adventure stories", "Classics", "Crime",
            "Fairy tales, fables, and folk tales",
            "Fantasy", "Historical fiction", "Horror",
            "Humour and satire", "Literary fiction",
            "Mystery", "Poetry", "Plays", "Romance",
            "Science fiction", "Short stories",
            "Thrillers", "War", "Women’s fiction",
            "Young adult", "Autobiography and memoir",
            "Biography", "Essays", "Non-fiction novel",
            "Self-help", "Psychology", "Geology",
            "Chemistry", "Astronomy", "Zoology",
            "Mathematics and logic", "Programming", "Data Science"};

    private static HashMap<Integer,String> genres = HashMapTools.initializeGenresOrTypesHashMap(genreArray);

    public Book(String name, BigDecimal price, Integer quantity, Integer genre, String author, String publisher) {
        super(name, price, quantity);
        this.genre = genres.get(genre);
        this.author = author;
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public static HashMap<Integer, String> getGenres() {
        return genres;
    }

    public static String[] getGenreArray() {
        return genreArray;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public static void setGenres(HashMap<Integer, String> genres) {
        Book.genres = genres;
    }

    public static void setGenreArray(String[] genreArray) {
        Book.genreArray = genreArray;
    }
}
