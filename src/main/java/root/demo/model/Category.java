package root.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Builder
@ToString(exclude = {"products"})
@AccessType(AccessType.Type.FIELD)
@Entity
@Table(name = "category")

public class Category extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch=FetchType.EAGER)
    private List<Product> products;
}
