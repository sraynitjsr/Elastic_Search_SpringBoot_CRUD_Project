import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
