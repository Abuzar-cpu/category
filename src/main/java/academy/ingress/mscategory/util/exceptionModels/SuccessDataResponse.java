package academy.ingress.mscategory.util.exceptionModels;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SuccessDataResponse<T> extends SuccessResponse {

  private T data;

  public SuccessDataResponse(String message, T data) {
    super(message);
    this.data = data;
  }
}
