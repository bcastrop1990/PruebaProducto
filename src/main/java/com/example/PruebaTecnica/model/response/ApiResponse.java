package com.example.PruebaTecnica.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
  private String code;
  private String message;
  private T data;
}
