package root.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import root.demo.dto.OrdersDto;
import root.demo.dto.PageDto;
import root.demo.model.Orders;
import root.demo.service.OrdersService;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersController {

    private final OrdersService ordersService;

    @RequestMapping(value = "/orders/save", method = RequestMethod.POST)
    public void saveOrders(@RequestBody Orders orders) {
        ordersService.save(orders);
    }

    @RequestMapping(value = "/orders/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Orders order = ordersService.findById(id);
        if (order == null) {
            return new ResponseEntity<>(order, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/orders/findall",method = RequestMethod.POST)
    public List<Orders> findAll(@RequestBody PageDto pageDto){
        return ordersService.findAll(pageDto.getPageN(),pageDto.getPageS());
    }

    @RequestMapping(value = "/orders/update",method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody OrdersDto ordersDto){
        ordersService.update(ordersDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
