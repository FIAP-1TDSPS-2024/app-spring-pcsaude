package br.com.pcsaude.exceptions;

public class UniqueKeyDuplicadaException extends RuntimeException {
    public UniqueKeyDuplicadaException(String message) {
        super(message);
    }
}
