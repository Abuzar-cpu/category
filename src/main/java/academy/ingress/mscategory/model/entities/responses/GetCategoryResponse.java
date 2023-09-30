package academy.ingress.mscategory.model.entities.responses;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCategoryResponse {

  private Long id;
  private String name;

  private Boolean isFavorite;
  private Boolean isVisible;
  private Set<GetCategoryResponse> children;
}
