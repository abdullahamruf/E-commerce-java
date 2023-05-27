package Ecommerce.demo.ProductController;

import Ecommerce.demo.Model.Product;
import Ecommerce.demo.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);


    }

    @GetMapping("product/view")
    public List<Product> findAll() {
        return productService.findAllProduct();
    }


    @GetMapping("product/view/{id}")
    public Optional<Product> findById(@PathVariable int id) {
        return productService.viewProductById(id);
    }

}