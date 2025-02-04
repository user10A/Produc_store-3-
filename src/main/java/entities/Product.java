package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@Builder(builderClassName = "Product_Builder")
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "products",
        indexes = {
                @Index(name = "idx_product_id", columnList = "Id"), // Индекс по product Id
                @Index(name = "idx_product_name", columnList = "productName"), // Индекс по productName
                @Index(name = "idx_product_price", columnList = "productPrice"), // Индекс по productPrice
                @Index(name = "idx_product_order_id", columnList = "orderId") // Индекс по orderId
        }
)@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_gen")
    @SequenceGenerator(name = "user_gen",sequenceName = "user_seq", allocationSize = 1)//, initialValue = 100
    private Long id;
    private Long orderId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;

}
