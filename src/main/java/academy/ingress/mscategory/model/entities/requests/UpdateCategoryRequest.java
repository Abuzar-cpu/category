package academy.ingress.mscategory.model.entities.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UpdateCategoryRequest {

  private String name;
  private Long parentId;
  private Boolean isFavorite;
  private Boolean isVisible;
}
