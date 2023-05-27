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
        Optional<Product> findById = productRepository.findById(pid);
        return findById;
    }


}

