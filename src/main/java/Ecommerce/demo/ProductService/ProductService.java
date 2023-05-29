package Ecommerce.demo.ProductService;
import Ecommerce.demo.Model.Product;
import Ecommerce.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> findAllProduct(){
        return productRepository.findAll();

    }
    public Optional<Product> viewProductById(int pid) {
        return productRepository.findById(pid);
    }
    public void deleteProduct(int pid){
        productRepository.deleteById(pid);
    }
    public Product updateProduct(int pid, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(pid);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setLive(product.isLive());
            existingProduct.setImageName(product.getImageName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setStock(product.isStock());
            return productRepository.save(existingProduct);
        } else {
            // Handle the case where the product with the given ID is not found
            throw new IllegalArgumentException("Product not found with ID: " + pid);
        }
    }



}

