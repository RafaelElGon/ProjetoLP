package Exceptions;

public class InexistantAccountException extends Exception{
    public InexistantAccountException(String msg){
        super(msg);
    }
}
