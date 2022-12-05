package Entities;

import Exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class BlockMovies implements BlockMoviesInterface{
    private List<Movie> movies;
    private List<BlockAccount> accounts;

    public BlockMovies(List<Movie> movies) {
       this.movies = movies;
    }
    public BlockMovies(){
        this.movies = new ArrayList<>();
    }

    public void registerAccount(BlockAccount Account) throws AccountAlreadyExistsException{
        if(this.accounts.size() == 0){
            this.accounts.add(Account);
        } else {
            if(this.accounts.contains(Account)){
                throw new AccountAlreadyExistsException("Essa conta já foi cadastrada");
            }
            else {
                this.accounts.add(Account);
            }
        }
    }
    public void deleteAccount(BlockAccount Account) throws InexistantAccountException {
        if(this.accounts == null || this.accounts.size() == 0){
            System.out.println("Não há contas para serem apagadas.");
            throw new NullPointerException("Não há contas para serem apagadas.");
        } else{
            if(this.accounts.contains(Account)){
                this.accounts.remove(Account);
            } else {
                throw new InexistantAccountException("Conta não cadastrada, não é possível apagá-la.");
            }
        }
    }
    public void registerMovie(Movie movie) throws MovieAlreadyRegisteredException {
        if(this.movies.size() == 0){
            this.movies.add(movie);
        }
        else{
            if(this.movies.contains(movie)){
                throw new MovieAlreadyRegisteredException("Filme já foi cadastrado.");
                }
            else {
                this.movies.add(movie);
            }
        }
    }
    public void deleteMovie(Movie movie) throws InexistantMovieException {
        if(this.movies.size() == 0){
          throw new InexistantMovieException("Não há filmes cadastrados");
        }
        else{
            if(this.movies.contains(movie)){
                this.movies.remove(movie);
                }
            else {
                throw new InexistantMovieException("Filme não está cadastrado.");
            }
        }
    }
    public List<Movie> getMovies() throws InexistantMovieException{
        if (this.movies == null || this.movies.size() == 0) {
            throw new InexistantMovieException("Não há filmes cadastrados");
        }
        return this.movies;
    }
    public List<BlockAccount> getAccounts(){
        return this.accounts;
    }
    public List<Movie> returnMoviesFromDate(String releaseDate) {
        List<Movie> moviesFromDate = new ArrayList<>();
        for(Movie m: this.movies){
            if(m.getReleaseDate().equals(releaseDate)){
                moviesFromDate.add(m);
            }
        }
        return moviesFromDate;
    }
}
