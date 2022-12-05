package Entities;

import Exceptions.*;

import java.util.List;

public interface BlockMoviesInterface {

    void registerAccount(BlockAccount Account) throws AccountAlreadyExistsException;
    //cadastra uma conta

    void deleteAccount(BlockAccount Account) throws InexistantAccountException;
    //deleta uma conta

    void registerMovie(Movie movie) throws MovieAlreadyRegisteredException;

    void deleteMovie(Movie movie) throws InexistantMovieException;
    List<Movie> getMovies () throws InexistantMovieException;
    //retorna os filmes em um arrayList

    List<BlockAccount> getAccounts();
    List<Movie> returnMoviesFromDate (String releaseDate);
    //retorna os filmes que lançaram no ano dado
}
