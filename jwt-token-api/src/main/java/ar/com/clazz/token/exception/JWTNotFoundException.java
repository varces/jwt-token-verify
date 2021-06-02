package ar.com.clazz.token.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Cesar Vargas
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class JWTNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JWTNotFoundException(String message) {
        super(message);
    }

}