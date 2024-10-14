package api.members.members_api.exception;

public class UserAlreadyRegisteredException extends RuntimeException{
    public UserAlreadyRegisteredException(String msg) {
        super(msg);
    }
}
