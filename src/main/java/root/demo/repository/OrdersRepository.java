package root.demo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import root.demo.model.Orders;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders,Long> {

    public List<Orders> findAll(Pageable pageable);
}
