package com.ferrosac.exception;

import javax.persistence.EntityNotFoundException;

public class ParamNotFound extends EntityNotFoundException {
    public ParamNotFound(String message) {
        super(message);
    }
}
