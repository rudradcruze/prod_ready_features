package org.rudradcruze.prod_ready_features.prod_ready_features.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}