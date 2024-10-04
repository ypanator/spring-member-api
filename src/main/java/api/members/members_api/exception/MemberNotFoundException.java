package api.members.members_api.exception;

public class MemberNotFoundException extends RuntimeException {
    MemberNotFoundException(String msg) { super(msg); }
}