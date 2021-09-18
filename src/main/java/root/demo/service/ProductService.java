package root.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import root.demo.dto.ProductDto;
import root.demo.model.Product;
import root.demo.model.Quantity;
import root.demo.repository.ProductRepository;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository productRepository;
    private final QuantityService quantityService;
    private final CategoryService categoryService;

    public List<Product> findAllByPage(int pageN, int pageSize) {
        Pageable pageable = PageRequest.of(pageN, pageSize);
        List<Product> products = productRepository.findAll(pageable);
        return products;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product save(ProductDto productDto) {
        Product product = productRepository.save(Product.builder()
                .name(productDto.getName())
                .category(categoryService.findById(productDto.getCategoryId()))
                .build());

        quantityService.save(Quantity.builder()
                .quantity(productDto.getQuantity())
                .product(product)
                .build());
        return product;
    }

    @Transactional
    public void update(ProductDto productDto) {
        Product product = findById(productDto.getId()).orElse(null);
        if (product != null) {
            if (productDto.getName() != null) {
                product.setName(productDto.getName());
            }
            if (productDto.getCategoryId() != null) {
                productDto.setCategoryId(productDto.getCategoryId());
            }
            productRepository.save(product);
        }
    }
}
