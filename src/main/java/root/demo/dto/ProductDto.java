package root.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private Integer quantity;
    private Long categoryId;
}
