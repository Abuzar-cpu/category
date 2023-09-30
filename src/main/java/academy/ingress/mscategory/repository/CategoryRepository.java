package academy.ingress.mscategory.repository;

import academy.ingress.mscategory.model.entities.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public class CategoryRepository {
public interface CategoryRepository extends JpaRepository<Category, Long> {

  @EntityGraph(value = "category-children")
  Optional<Category> getCategoryByIdAndIsVisible(Long id, Boolean isVisible);

  Optional<Category> getCategoryByName(String name);
}
