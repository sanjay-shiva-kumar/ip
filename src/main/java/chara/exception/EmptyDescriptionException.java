package chara.exception;

public class EmptyDescriptionException extends CharaException {
    public EmptyDescriptionException(String what) {
        super("Add a description! I'm not a mind reader...");
    }
}