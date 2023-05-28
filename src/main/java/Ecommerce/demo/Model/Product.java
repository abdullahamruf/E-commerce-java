package Ecommerce.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private String ProductPrice ;
    private boolean stock ;
    private String quantity ;
    private String description;
    private boolean live;
    private String imageName;
}
