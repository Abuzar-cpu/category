package academy.ingress.mscategory.util.exceptionModels;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ErrorResponse extends Response {

  private Boolean success;

  public ErrorResponse(String message) {
    super(message);
    this.success = false;
  }
}
