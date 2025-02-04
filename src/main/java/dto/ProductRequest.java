package dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long orderId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
}
