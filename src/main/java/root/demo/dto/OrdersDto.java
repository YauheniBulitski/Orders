package root.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OrdersDto {

    private Long id;
    private LocalDate date;
}
