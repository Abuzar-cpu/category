package academy.ingress.mscategory.model.entities.constants;

import lombok.Getter;

@Getter
public enum ExceptionMessages {
  INTERNAL_SERVER_ERROR("unknown exception occurred"),
  CATEGORY_NOT_FOUND_ID("requested category with id %s not found"),
  CATEGORY_NOT_FOUND_NAME("requested category with name %s not found"),
  CATEGORY_ALREADY_EXISTS("category with name %s already exists");
  private final String message;

  ExceptionMessages(String message) {
    this.message = message;
  }
}
