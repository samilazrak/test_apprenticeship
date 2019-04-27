package fr.unice.polytech.apprenticeship.test.exceptions;

public class MissingMandatoryInformationsException extends Exception {

    public MissingMandatoryInformationsException() {
        super("Name, Age and Country are mandatory - Job is optional");
    }
}
