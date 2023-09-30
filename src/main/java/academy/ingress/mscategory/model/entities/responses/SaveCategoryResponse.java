package academy.ingress.mscategory.model.entities.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveCategoryResponse {

  private String name;
  private Long parentId;
  private Boolean isFavorite;
  private Boolean isVisible;
}
