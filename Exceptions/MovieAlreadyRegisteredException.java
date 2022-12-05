package Exceptions;

public class MovieAlreadyRegisteredException extends Exception{
    public MovieAlreadyRegisteredException(String msg){
        super(msg);
    }
}
