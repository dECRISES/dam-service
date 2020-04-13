package org.dfm.dam.service.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DamServiceExceptionResponse {

  private String message;

  private String path;
}
