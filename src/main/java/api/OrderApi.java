package api;
import dto.ProductResponse;
import dto.SimpleResponse;
import entities.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "Orders API", description = "API for order CRUD methods")
public class OrderApi {

    private final ProductService productService;

    //Добавление продукта
    @PostMapping("created/product")
    @Operation(summary = "Created orders", description = "Создание продукта")
    public SimpleResponse createProduct(@RequestBody ProductResponse productResponse) {
        return productService.createProduect(productResponse);
    }

    // Получение всех продуктов
    @GetMapping("getAllProducts")
    @Operation(summary = "Products get", description = "Get all products")

    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> orders = productService.getAllProducts();
        return ResponseEntity.ok(orders);
    }

    // Получение конкретного продукта
    @GetMapping("/product/{id}")
    @Operation(summary = "get product", description = "Get product by User id")
    public ProductResponse getProductByID(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Обновление продукта
    @GetMapping("/product/{id}/update")
    @Operation(summary = "Get ", description = "Update Product")
    public SimpleResponse updateProductByID(@PathVariable Long id, @RequestBody ProductResponse productResponse) {
        return productService.updateProduct(productResponse, id);
    }
        /*
    * ### **Product Service (Управление продуктами)**

*
*
- `POST /products` — добавить новый продукт
- `GET /products/{id}` — получить информацию о продукте
- `PUT /products/{id}` — обновить информацию о продукте
- `DELETE /products/{id}` — удалить продукт
- `GET /products` — получить список всех продуктов

Далее мы можем приступить к созданию структуры проекта, настройки API Gateway и интеграции сервисов. Ты хочешь, чтобы я написал код сразу или пошагово разобрали процесс?
    * */

}
