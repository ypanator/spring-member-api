package api.members.members_api.exception;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(String msg) {
        super(msg);
    }
}
