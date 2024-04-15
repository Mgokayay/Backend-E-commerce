package com.workintech.backend.entity;

import com.workintech.backend.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category",schema = "ecommercebackend")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column (name ="img" )
    private String img;

    @Column (name = "rating")
    private Double rating;

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "category")
    private List<Product> products;
    //private List<Product> products = new ArrayList<>() bu da yapılabilirdi null check için


    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }

}
