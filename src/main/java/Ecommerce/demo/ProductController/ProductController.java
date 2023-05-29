package Ecommerce.demo.ProductController;

import Ecommerce.demo.Model.Product;
import Ecommerce.demo.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> optionalProduct = productService.viewProductById(id);

        if (optionalProduct.isPresent()) {
            Product viewById = optionalProduct.get();
            return new ResponseEntity<>(viewById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id ,Product product){
      Product update =productService.updateProduct(id,product);
      return new ResponseEntity<Product>(update,HttpStatus.OK);

    }
}