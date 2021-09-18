package root.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import root.demo.dto.PageDto;
import root.demo.dto.ProductDto;
import root.demo.model.Product;
import root.demo.service.ProductService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/product/findall", method = RequestMethod.POST)
    public ResponseEntity<?> findAll(@RequestBody PageDto pageDto) {
        int pageN;
        int pageS;
        if (pageDto == null) {
            pageN = 1;
            pageS = 5;
        } else {
            pageN = pageDto.getPageN();
            pageS = pageDto.getPageS();
        }
        return new ResponseEntity<>(productService.findAllByPage(pageN, pageS), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(product, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) {
        Product product = productService.save(productDto);
        if (product.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody ProductDto productDto) {
         productService.update(productDto);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
