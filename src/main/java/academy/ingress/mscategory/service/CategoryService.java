package academy.ingress.mscategory.service;

import static academy.ingress.mscategory.model.entities.constants.ExceptionMessages.CATEGORY_NOT_FOUND_ID;
import static academy.ingress.mscategory.model.entities.constants.ExceptionMessages.CATEGORY_NOT_FOUND_NAME;
import static academy.ingress.mscategory.util.CategoryMapperUtil.CATEGORY_MAPPER_UTIL;

import academy.ingress.mscategory.exception.NotFoundException;
import academy.ingress.mscategory.model.entities.Category;
import academy.ingress.mscategory.model.entities.requests.CreateCategoryRequest;
import academy.ingress.mscategory.model.entities.requests.UpdateCategoryRequest;
import academy.ingress.mscategory.model.entities.responses.GetCategoryResponse;
import academy.ingress.mscategory.model.entities.responses.SaveCategoryResponse;
import academy.ingress.mscategory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public SaveCategoryResponse create(CreateCategoryRequest request) {
    Category parent = null;
    if (request.getParentId() != null) {
      parent = this.categoryRepository.findById(request.getParentId()).orElseThrow(
          () -> new NotFoundException(
              String.format(String.valueOf(CATEGORY_NOT_FOUND_ID), request.getParentId())));
    }

    var category = Category.builder()
        .name(request.getName())
        .parent(parent)
        .isFavorite(request.getIsFavorite())
        .isVisible(true)
        .build();

    var saved = this.categoryRepository.save(category);

    return CATEGORY_MAPPER_UTIL.mapEntityToSaveResponse(saved);
  }

  public GetCategoryResponse getCategoryById(Long id) {
    var category = this.categoryRepository.getCategoryByIdAndIsVisible(id, true).orElseThrow(
        () -> new NotFoundException(String.format(String.valueOf(CATEGORY_NOT_FOUND_ID), id))
    );
    return CATEGORY_MAPPER_UTIL.mapEntityToGetresponse(category);
  }

  public GetCategoryResponse getCategoryByName(String name) {
    var category = this.categoryRepository.getCategoryByName(name).orElseThrow(
        () -> new NotFoundException(String.format(String.valueOf(CATEGORY_NOT_FOUND_NAME), name)));

    return CATEGORY_MAPPER_UTIL.mapEntityToGetresponse(category);
  }

  public Category update(Long id, UpdateCategoryRequest category) {
    Category categoryToUpdate = this.categoryRepository.findById(id).orElseThrow(
        () -> new NotFoundException(String.format(String.valueOf(CATEGORY_NOT_FOUND_ID), id)));
    categoryToUpdate.setName(
        category.getName() == null ? categoryToUpdate.getName() : category.getName());
    categoryToUpdate.setIsFavorite(
        category.getIsFavorite() == null ? categoryToUpdate.getIsFavorite()
            : category.getIsFavorite());
    categoryToUpdate.setIsVisible(category.getIsVisible() == null ? categoryToUpdate.getIsVisible()
        : category.getIsVisible());
    categoryToUpdate.setParent(category.getParentId() == null ? categoryToUpdate.getParent()
        : this.pGetCategoryById(category.getParentId()));

    return this.categoryRepository.save(categoryToUpdate);
  }

  private Category pGetCategoryById(Long id) {
    return this.categoryRepository.getCategoryByIdAndIsVisible(id, true).orElseThrow(
        () -> new NotFoundException(String.format(String.valueOf(CATEGORY_NOT_FOUND_ID), id))
    );
  }
}
