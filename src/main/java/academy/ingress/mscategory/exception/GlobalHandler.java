package academy.ingress.mscategory.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import academy.ingress.mscategory.model.entities.constants.ExceptionMessages;
import academy.ingress.mscategory.util.exceptionModels.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
@Slf4j
public class GlobalHandler {

  @ExceptionHandler
  @ResponseStatus(INTERNAL_SERVER_ERROR)
  public ErrorResponse handle(Exception e) {
    log.error("Error occurred: ", e);
    return new ErrorResponse(ExceptionMessages.INTERNAL_SERVER_ERROR.getMessage());
  }

  @ExceptionHandler
  @ResponseStatus(NOT_FOUND)
  public ErrorResponse handle(NotFoundException e) {
    log.error("Not found: ", e);
    return new ErrorResponse(e.getMessage());
  }

  @ExceptionHandler
  @ResponseStatus(INTERNAL_SERVER_ERROR)
  public ErrorResponse handle(AlreadyExistsException e) {
    log.error("Already exists: ", e);
    return new ErrorResponse(e.getMessage());
  }

}
