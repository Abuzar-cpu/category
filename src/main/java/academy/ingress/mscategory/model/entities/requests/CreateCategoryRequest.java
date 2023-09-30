package academy.ingress.mscategory.model.entities.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCategoryRequest {

  private String name;
  private Long parentId;
  private Boolean isFavorite;
}
