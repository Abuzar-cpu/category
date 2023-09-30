package academy.ingress.mscategory.util;

import academy.ingress.mscategory.model.entities.Category;
import academy.ingress.mscategory.model.entities.responses.GetCategoryResponse;
import academy.ingress.mscategory.model.entities.responses.SaveCategoryResponse;
import java.util.stream.Collectors;

public enum CategoryMapperUtil {
  CATEGORY_MAPPER_UTIL;

  public SaveCategoryResponse mapEntityToSaveResponse(Category category) {
    return SaveCategoryResponse.builder()
        .name(category.getName())
        .parentId(category.getParent() != null ? category.getParent().getId() : null)
        .isFavorite(category.getIsFavorite() != null && category.getIsFavorite())
        .isVisible(category.getIsVisible())
        .build();
  }

  public GetCategoryResponse mapEntityToGetresponse(Category category) {
    return GetCategoryResponse.builder()
        .children(category.getChildren().stream().map(CATEGORY_MAPPER_UTIL::mapEntityToGetresponse)
            .collect(
                Collectors.toSet()))
        .id(category.getId())
        .name(category.getName())
        .isFavorite(category.getIsFavorite() != null && category.getIsFavorite())
        .isVisible(category.getIsVisible())
        .build();
  }
}
