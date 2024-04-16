package com.workintech.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.workintech.backend.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Code can not be null")
    @NotBlank(message = "Code can not be blank")
    @Column(name = "code")
    private String code;

    @NotNull(message = "Gender should be female or male")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Column (name ="img" )
    private String img;

    @NotNull
    @Column (name = "rating")
    private Double rating;

    @NotNull
    @Column(name = "title")
    private String title;

    @JsonBackReference
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
