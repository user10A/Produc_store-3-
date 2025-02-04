package service;

import dto.ProductRequest;
import dto.ProductResponse;
import dto.SimpleResponse;
import entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
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

    SimpleResponse createProduect(ProductResponse productResponse);
    ProductResponse getProductById(Long id);
    SimpleResponse updateProduct(ProductResponse productResponse, Long id);
    SimpleResponse deleteProduct(Long id);
    List<Product> getAllProducts();

}
