package com.bryanlanghendries.seeder;

import com.bryanlanghendries.enums.ProductCategory;
import com.bryanlanghendries.repository.database.DbProductEntityRepository;
import com.bryanlanghendries.repository.database.DbUserEntityRepository;
import com.bryanlanghendries.repository.entities.ProductEntity;
import com.bryanlanghendries.repository.entities.UserEntity;
import com.bryanlanghendries.services.AuthService;
import com.bryanlanghendries.services.UserService;
import org.openapitools.model.UserInput;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(DbProductEntityRepository productRepository, DbUserEntityRepository userRepository, AuthService authService) {
        return args -> {
            if (productRepository.count() == 0) {
                productRepository.save(new ProductEntity("Premium Dog Food", ProductCategory.FOOD, 49.99f, "High-quality food for dogs"));
                productRepository.save(new ProductEntity("Luxury Cat Bed", ProductCategory.HABITAT, 89.99f, "Comfortable and stylish cat bed"));
                productRepository.save(new ProductEntity("Bird Cage Decor", ProductCategory.DECOR, 29.99f, "Decorative items for bird cages"));
                productRepository.save(new ProductEntity("Reptile Habitat Kit", ProductCategory.HABITAT, 139.99f, "Complete habitat kit for reptiles"));
                productRepository.save(new ProductEntity("Organic Catnip", ProductCategory.FOOD, 15.99f, "Organic catnip for playful cats"));
                productRepository.save(new ProductEntity("Dog Training Treats", ProductCategory.FOOD, 25.99f, "Treats for dog training and rewards"));
                productRepository.save(new ProductEntity("Bird Feeder", ProductCategory.DECOR, 18.99f, "Feeder to attract and feed wild birds"));
                productRepository.save(new ProductEntity("Hamster Wheel", ProductCategory.HABITAT, 12.99f, "Wheel for hamsters to exercise"));

            }

            if (userRepository.count() == 0) {
                authService.register(new UserInput("Pol", "Pier", "Pol@gmail.com", "test"));
                authService.register(new UserInput("Jane", "Doe", "jane.doe@example.com", "anotherpassword"));
            }
        };
    }
}
