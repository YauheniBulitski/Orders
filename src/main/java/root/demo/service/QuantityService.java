package root.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.demo.model.Quantity;
import root.demo.repository.QuantityRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuantityService {

    private final QuantityRepository quantityRepository;

    public void save(Quantity quantity){
        quantityRepository.save(quantity);
    }

    public Quantity findById(Long id){
        return quantityRepository.findById(id).orElse(null);
    }
}
