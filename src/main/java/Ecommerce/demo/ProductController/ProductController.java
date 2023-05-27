package Ecommerce.demo.ProductController;

import Ecommerce.demo.Model.Product;
import Ecommerce.demo.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/create/product")
    public Product createProduct(@RequestBody Product  product) {
        return productService.createProduct(product);


    }
    @GetMapping("product/view")
    public List<Product> findAll (){
        return  productService.findAllProduct();
    }

}
