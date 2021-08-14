package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED , reason = "Person Data Already Present")
public class PersonAlreadyExistException extends Exception {


}
