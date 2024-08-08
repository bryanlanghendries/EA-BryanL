package com.bryanlanghendries.repository.entities;

import com.bryanlanghendries.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.ProductDto;

import javax.validation.constraints.Size;

@Entity
@Table(name="product")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "category")
    private ProductCategory category;

    @NonNull
    @Column(name = "price")
    private float price;

    @NonNull
    @Column(name = "description")
    private String description;
}
