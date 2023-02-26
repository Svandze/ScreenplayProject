package co.com.example.exceptions;


public class ItemNotFoundException extends AssertionError {
    public ItemNotFoundException (Throwable cause){
        super(cause);
    }

    public ItemNotFoundException (String message, Throwable cause){
        super(message,cause);
    }
}
