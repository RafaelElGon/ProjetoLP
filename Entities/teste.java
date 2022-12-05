package Entities;

public class teste {
    public static void main(String[] args) {
        Movie movie = new Movie("bucetação", "12:12:12", 0.0, "Gay", "1821");

        System.out.println(movie.getName());
        System.out.println(movie.getDuration());
        System.out.println(movie.getScoring());
        System.out.println(movie.getRating());
        System.out.println(movie.getReleaseDate());
        System.out.println(movie);
    }
}
