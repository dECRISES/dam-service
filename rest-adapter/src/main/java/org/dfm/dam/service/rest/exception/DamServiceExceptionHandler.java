package org.dfm.dam.service.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.dfm.dam.service.domain.exception.DamServiceNotFoundException;

@RestControllerAdvice(basePackages = {"org.dfm.dam.service"})
public class DamServiceExceptionHandler {

  @ExceptionHandler(value = DamServiceNotFoundException.class)
  public final ResponseEntity<DamServiceExceptionResponse> handleDamServiceNotFoundException(final WebRequest request) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DamServiceExceptionResponse.builder().message("DamService not found").path(((ServletWebRequest) request).getRequest().getRequestURI()).build());
  }
}
