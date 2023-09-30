package academy.ingress.mscategory.util.exceptionModels;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ErrorDateResponse<T> extends ErrorResponse {

  private T data;

  public ErrorDateResponse(String message, T data) {
    super(message);
    this.data = data;
  }
}
