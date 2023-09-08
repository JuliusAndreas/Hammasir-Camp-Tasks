package restaurant.manager.kitchenapplication;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class FoodReservedDTO {
    private Integer foodId;
    private String foodName;
    private Integer quantity;
}
