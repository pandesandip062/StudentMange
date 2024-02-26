package Test.demo.Student.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> recordNotFound(RecordNotFoundException e){
        return new ResponseEntity<Object>("Employee Id not present in table", HttpStatus.NOT_FOUND);
    }
}
