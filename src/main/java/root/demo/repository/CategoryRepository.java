package root.demo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import root.demo.model.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category save(Category category);

    List<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long id);
}
