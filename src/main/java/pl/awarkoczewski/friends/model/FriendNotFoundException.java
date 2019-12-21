package pl.awarkoczewski.friends.model;

public class FriendNotFoundException extends RuntimeException {


    public FriendNotFoundException(String message) {
        super(message);
    }
}
