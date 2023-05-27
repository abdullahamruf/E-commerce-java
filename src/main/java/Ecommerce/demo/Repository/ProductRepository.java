package Ecommerce.demo.Repository;

import Ecommerce.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
