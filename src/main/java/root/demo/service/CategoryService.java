package root.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import root.demo.dto.CategoryDto;
import root.demo.model.Category;
import root.demo.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Category save(CategoryDto categoryDto) {
        return categoryRepository.save(Category.builder()
                .name(categoryDto.getName())
                .build());
    }

    public List<Category> findAll(int pageN, int pageSize) {
        Pageable pageable = PageRequest.of(pageN, pageSize);
        return categoryRepository.findAll(pageable);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void update(CategoryDto categoryDto){
        Category category=findById(categoryDto.getId());
        if(category!=null){
            if(categoryDto.getName()!=null){
                category.setName(categoryDto.getName());
            }
            categoryRepository.save(category);
        }

    }
}
