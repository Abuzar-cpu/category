package academy.ingress.mscategory.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import academy.ingress.mscategory.model.entities.Category;
import academy.ingress.mscategory.model.entities.requests.CreateCategoryRequest;
import academy.ingress.mscategory.model.entities.requests.UpdateCategoryRequest;
import academy.ingress.mscategory.model.entities.responses.GetCategoryResponse;
import academy.ingress.mscategory.model.entities.responses.SaveCategoryResponse;
import academy.ingress.mscategory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @ResponseStatus(CREATED)
  @PostMapping("")
  public SaveCategoryResponse create(@RequestBody CreateCategoryRequest category) {

    return this.categoryService.create(category);
  }

  @PutMapping("/{id}")
  @ResponseStatus(OK)
  public Category update(@PathVariable Long id, @RequestBody UpdateCategoryRequest category) {

    return this.categoryService.update(id, category);
  }

  @GetMapping("/id/{id}")
  @ResponseStatus(OK)
  public GetCategoryResponse getCategory(@PathVariable Long id) {
    return this.categoryService.getCategoryById(id);
  }

  @GetMapping("/name/{name}")
  @ResponseStatus(OK)
  public GetCategoryResponse getCategory(@PathVariable String name) {
    return this.categoryService.getCategoryByName(name);
  }
}
