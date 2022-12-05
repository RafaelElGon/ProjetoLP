package Entities;

import Exceptions.AccountAlreadyExistsException;
import Exceptions.InexistantAccountException;
import Exceptions.InexistantMovieException;
import Exceptions.MovieAlreadyRegisteredException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BlockMoviesApplication {
    public static void main(String[] args) {
        boolean exit = false;
        BlockMoviesInterface sysBlockMovie = new BlockMovies();

        while(!exit){
            String menu = JOptionPane.showInputDialog("""
                    >> MENU DE OPÇÕES <<
                    1. Mostrar os filmes do site
                    2. Pesquisar filmes por ano
                    3. Cadastrar uma conta
                    4. Cadastrar um filme
                    5. Remover uma conta
                    6. Pesquisar filmes por classificação
                    7. Remover um filme
                    8. Salvar os cadastros
                    9. Sair""");

            switch (menu){
                case "1" -> {
                    try {

                        for (Movie m : sysBlockMovie.getMovies()) {
                            System.out.println(m);
                        }
                    } catch(InexistantMovieException e){
                        System.out.println(e.getMessage());
                    }
                }
                case "2" -> {
                    String releaseDate = JOptionPane.showInputDialog("Digite o ano para a pesquisa");
                    List<Movie> moviesFromDate = sysBlockMovie.returnMoviesFromDate(releaseDate);
                    for (Movie m: moviesFromDate){
                        System.out.println(m);
                    }
                }
                case "3" -> {
                    String accLogin = JOptionPane.showInputDialog("Digite o login para cadastro");
                    String accPassword = JOptionPane.showInputDialog("Digite a senha para cadastro");
                    String acc2FA = JOptionPane.showInputDialog("Digite o fator de autenticação para cadastro");

                    BlockAccount acc = new BlockAccount(accLogin, accPassword, acc2FA);
                    try {
                        sysBlockMovie.registerAccount(acc);
                    } catch (AccountAlreadyExistsException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Conta cadastrada com sucesso.");
                }
                case "4" -> {
                    String movieName, duration, MPArating, releaseDate;
                    double scoring;

                    movieName = JOptionPane.showInputDialog("Digite o nome do filme");
                    duration = JOptionPane.showInputDialog("Digite a duração do filme");
                    MPArating = JOptionPane.showInputDialog("Digite a classificação indicativa do filme");
                    releaseDate = JOptionPane.showInputDialog("Digite o ano de lançamento do filme");
                    scoring = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do filme"));
                    Movie movie = new Movie(movieName, duration, scoring, MPArating, releaseDate);
                    try{
                        sysBlockMovie.registerMovie(movie);
                    } catch (MovieAlreadyRegisteredException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    System.out.println("Filme registrado com sucesso.");
                }
                case "5" -> {
                    String login = JOptionPane.showInputDialog("Digite o login da conta que deseja apagar");
                    String pw = JOptionPane.showInputDialog("Digite a senha da conta que deseja apagar");
                    String _2FA = JOptionPane.showInputDialog("Digite o código de autenticação da conta para confirmar");

                    try{
                        for(BlockAccount acc: sysBlockMovie.getAccounts()){
                            if(acc.getLogin().equals(login) && acc.getPassword().equals(pw)
                                    && acc.getTwoFA().equals(_2FA)){
                                sysBlockMovie.deleteAccount(acc);
                            }
                        }
                    } catch (InexistantAccountException | NullPointerException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    System.out.println("Conta removida com successo.");
                }
                case "6" -> {
                    String MPArating = JOptionPane.showInputDialog("Digite a classificação indicativa");
                    List<Movie> MPAratingMovies = new ArrayList<>();
                    try {
                        for (Movie m : sysBlockMovie.getMovies()) {
                            if (m.getRating().equals(MPArating)) {
                                MPAratingMovies.add(m);
                            }
                        }
                        for (Movie m : MPAratingMovies) {
                            System.out.println(m.toString());
                        }
                    } catch(InexistantMovieException e){
                        System.out.println(e.getMessage());
                    }
                }
                case "7" -> {
                    String movieName = JOptionPane.showInputDialog("Digite o nome do filme");
                    double scoring = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do filme"));

                    try{
                        for (Movie m : sysBlockMovie.getMovies()) {
                            if (movieName.equals(m.getName()) && scoring == m.getScoring()) {
                                sysBlockMovie.deleteMovie(m);
                            }
                        }
                    } catch (InexistantMovieException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case "8" -> {
                    //TODO: Salvar os cadastros
                }
                case "9" -> exit = true;
                default -> JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}