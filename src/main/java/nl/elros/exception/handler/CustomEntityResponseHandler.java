package nl.elros.exception.handler;

import nl.elros.exception.ResponseException;
import nl.elros.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseException> handleAllException(Exception ex, WebRequest request) {
        ResponseException responseException = new ResponseException(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ResponseException> handleUnsupportedMathOperationException(
            UnsupportedMathOperationException unsupportedMathOperationException,
            WebRequest request) {
        ResponseException responseException = new ResponseException(
                LocalDateTime.now(),
                unsupportedMathOperationException.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }
}
