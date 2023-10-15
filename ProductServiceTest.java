import com.example.elasticsearchspringbootcrud.model.Product;
import com.example.elasticsearchspringbootcrud.repository.ProductRepository;
import com.example.elasticsearchspringbootcrud.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    public void testFindProductById() {
        Product product = new Product();
        product.setId("1");
        product.setName("Sample Product");
        product.setPrice(9.99);

        when(productRepository.findById("1")).thenReturn(Optional.of(product));

        Optional<Product> result = productService.findById("1");

        assertEquals(product, result.get());
    }

    @Test
    public void testFindAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("1", "Product 1", 19.99));
        productList.add(new Product("2", "Product 2", 29.99));

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.findAll();

        assertEquals(productList, result);
    }
}
