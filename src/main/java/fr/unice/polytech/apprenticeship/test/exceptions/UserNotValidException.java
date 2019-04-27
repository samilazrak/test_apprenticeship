package fr.unice.polytech.apprenticeship.test.exceptions;

public class UserNotValidException extends Exception {

    public UserNotValidException() {
        super("You must live in France and be an adult (>18) to register");
    }
}
