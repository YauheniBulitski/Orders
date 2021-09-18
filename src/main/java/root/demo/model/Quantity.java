package root.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Builder
@ToString(exclude = {"product"})
@AccessType(AccessType.Type.FIELD)
@Entity
@Table(name = "quantity")
public class Quantity extends BaseEntity<Long>{

    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

}
