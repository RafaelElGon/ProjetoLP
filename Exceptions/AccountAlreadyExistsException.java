package Exceptions;

public class AccountAlreadyExistsException extends Exception{
    public AccountAlreadyExistsException(String msg){
        super(msg);
    }
}
