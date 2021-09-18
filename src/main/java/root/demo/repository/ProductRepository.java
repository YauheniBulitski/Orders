package root.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import root.demo.model.Product;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long id);

    Product save(Product product);
}
