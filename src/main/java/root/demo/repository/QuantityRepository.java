package root.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;
import root.demo.model.Quantity;

import java.util.Optional;

@Repository
public interface QuantityRepository extends CrudRepository<Quantity,Long> {

    Optional<Quantity> findById(Long id);
}
