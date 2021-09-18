package root.demo.model;

import lombok.*;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Builder
@AccessType(AccessType.Type.FIELD)
@Entity
@ToString(exclude = {"products"})
@Table(name = "orders")

public class Orders extends BaseEntity<Long>{

    @Column(name = "date", nullable = false)
    private LocalDate localDate;

    @ManyToMany(cascade = CascadeType.REMOVE,fetch=FetchType.EAGER)
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
