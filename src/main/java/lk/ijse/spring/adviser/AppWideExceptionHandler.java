package lk.ijse.spring.adviser;

import lk.ijse.spring.util.StandardResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(RuntimeException ex){
        StandardResponce responce = new StandardResponce(500, "Error", ex.getMessage());
        return new ResponseEntity(responce, HttpStatus.OK);
    }
}
