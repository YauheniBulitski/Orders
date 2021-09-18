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
@AccessType(AccessType.Type.FIELD)
@Entity
@Table(name = "product")
public class Product extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "product")
    private Quantity quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Orders> orders;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
