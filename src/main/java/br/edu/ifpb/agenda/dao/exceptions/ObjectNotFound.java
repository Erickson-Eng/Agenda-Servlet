package br.edu.ifpb.agenda.dao.exceptions;

public class ObjectNotFound extends RuntimeException{
    public ObjectNotFound(String message) {
        super(message);
    }
}
