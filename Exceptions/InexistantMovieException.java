package Exceptions;

public class InexistantMovieException extends Exception{
    public InexistantMovieException(String msg){
        super(msg);
    }
}
