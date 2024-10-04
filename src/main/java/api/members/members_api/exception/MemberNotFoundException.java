package api.members.members_api.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String msg) {
        super(msg); 
    }
}