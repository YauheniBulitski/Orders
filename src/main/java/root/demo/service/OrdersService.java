package root.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import root.demo.dto.OrdersDto;
import root.demo.model.Orders;
import root.demo.repository.OrdersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public void save(Orders orders) {
        ordersRepository.save(orders);
    }

    public Orders findById(Long id){
        return ordersRepository.findById(id).orElse(null);
    }

    public List<Orders> findAll(int pageN,int pageS){
        Pageable pageable= PageRequest.of(pageN,pageS);
        return ordersRepository.findAll(pageable);
    }

    public void update(OrdersDto ordersDto){
        Orders orders=findById(ordersDto.getId());
        if(ordersDto.getDate()!=null){
            orders.setLocalDate(ordersDto.getDate());
        }
        save(orders);
    }
}
