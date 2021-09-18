package root.demo.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import root.demo.dto.CategoryDto;
import root.demo.dto.PageDto;
import root.demo.model.Category;
import root.demo.model.Product;
import root.demo.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController {

    private final CategoryService categoryService;

    @RequestMapping(value = "/category/save",method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto){
       Category category = categoryService.save(categoryDto);
        if (category.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/category/findall",method = RequestMethod.POST)
    public List<Category> findAll(@RequestBody PageDto pageDto){
        return categoryService.findAll(pageDto.getPageN(),pageDto.getPageS());
    }

    @RequestMapping(value = "/category/update",method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody CategoryDto categoryDto){
        categoryService.update(categoryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/category/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(category, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
    }
}
