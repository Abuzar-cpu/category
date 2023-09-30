package academy.ingress.mscategory.util.exceptionModels;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SuccessResponse extends Response {

  private Boolean success;

  public SuccessResponse(String message) {
    super(message);
    this.success = true;
  }
}
