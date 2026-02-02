package com.awsmembermanager;

import com.awsmembermanager.CustomExceptions.MemberHasNoProfileException;
import com.awsmembermanager.CustomExceptions.MemberNotFoundException;
import com.awsmembermanager.CustomExceptions.ProfileDownloadUrlException;
import com.awsmembermanager.CustomExceptions.ProfileUploadException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleMemberNotFoundException(MemberNotFoundException e) {
        return getResponseForError(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MemberHasNoProfileException.class)
    public ResponseEntity<ProblemDetail> handleMemberNotFoundException(MemberHasNoProfileException e) {
        return getResponseForError(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProfileUploadException.class)
    public ResponseEntity<ProblemDetail> handleProfileUploadException(ProfileUploadException e) {
        return getResponseForError(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProfileDownloadUrlException.class)
    public ResponseEntity<ProblemDetail> handleProfileDownloadUrlException(ProfileDownloadUrlException e) {
        return getResponseForError(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ProblemDetail> getResponseForError(Exception e, HttpStatus status) {
        ProblemDetail detail = ProblemDetail.forStatus(status);
        detail.setProperty("message", e.getMessage());
        return ResponseEntity.status(status).body(detail);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleValidationException(MethodArgumentNotValidException e) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        Map<String, String> validationErrors = new HashMap<>();

        var errors = e.getBindingResult().getAllErrors();

        for (final ObjectError error : errors) {
            if (error instanceof FieldError fieldError) {
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            } else {
                validationErrors.put(error.getObjectName(), error.getDefaultMessage());
            }
        }

        detail.setProperty("validationErrors", validationErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(detail);
    }
}
