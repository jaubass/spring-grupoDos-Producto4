package com.grupodos.producto4;

import com.grupodos.producto4.model.MenuItem;
import com.grupodos.producto4.model.Restaurant;
import com.grupodos.producto4.model.User;
import com.grupodos.producto4.model.Vehicle;
import com.grupodos.producto4.repository.MenuItemRepository;
import com.grupodos.producto4.repository.RestaurantRepository;
import com.grupodos.producto4.repository.UserRepository;
import com.grupodos.producto4.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final VehicleRepository vehicles;

    private final UserRepository users;

    private final PasswordEncoder passwordEncoder;

    private final RestaurantRepository restaurants;

    private final MenuItemRepository menuRepo;

    @Override
    public void run(String... args) {
        log.debug("initializing vehicles data...");
        Arrays.asList("moto", "car").forEach(v -> this.vehicles.saveAndFlush(Vehicle.builder().name(v).build()));

        log.debug("printing all vehicles...");
        this.vehicles.findAll().forEach(v -> log.debug(" Vehicle :" + v.toString()));

        this.users.save(User.builder()
                .username("user")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER"))
                .build()
        );

        this.users.save(User.builder()
                .username("admin")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build()
        );

        log.debug("printing all users...");
        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));

        // Add Restaurants to database
        this.restaurants.save(
                new Restaurant("Casa Pepe", "pepefood@gmail.com", "999999999", "C/Pepe 10", "Linares", "99999", "pepefood.com")
        );
        this.restaurants.save(
                new Restaurant("Casa Juan", "Juanfood@gmail.com", "999999998", "C/Juan 10", "Guarromán", "99998", "juanfood.com")
        );


        // Add MenuItems to DB
        Restaurant restaurant = this.restaurants.getReferenceById(1L);

        MenuItem ensaladaCaprese = new MenuItem("Ensalada Caprese", "Tomates, mozzarella fresca y albahaca", 10.99, "Entrantes", restaurant);
        MenuItem bruschetta = new MenuItem("Bruschetta de tomate y albahaca", "Rebanadas de pan tostado, tomates, ajo y albahaca", 8.99, "Entrantes", restaurant);
        MenuItem arancini = new MenuItem("Arancini de risotto", "Bolitas de risotto rellenas de queso mozzarella y fritas", 12.99, "Entrantes", restaurant);
        MenuItem minestrone = new MenuItem("Minestrone", "Sopa de verduras con pasta y frijoles", 9.99, "Entrantes", restaurant);
        MenuItem parmigiana = new MenuItem("Parmigiana di melanzane", "Berenjenas fritas con salsa de tomate, mozzarella y parmesano", 16.99, "Platos principales", restaurant);
        // Otros ejemplos de platos principales:
        MenuItem pizzaMargherita = new MenuItem("Pizza Margherita", "Mozzarella, tomate y albahaca", 14.99, "Platos principales", restaurant);
        MenuItem lasagna = new MenuItem("Lasagna alla bolognese", "Lasagna con carne picada, salsa boloñesa y queso parmesano", 18.99, "Platos principales", restaurant);
        MenuItem spaghettiCarbonara = new MenuItem("Spaghetti alla carbonara", "Spaghetti con huevo, panceta, queso pecorino y pimienta negra", 17.99, "Platos principales", restaurant);
        MenuItem ravioli = new MenuItem("Ravioli di ricotta e spinaci", "Ravioli rellenos de ricotta y espinacas con salsa de tomate", 20.99, "Platos principales", restaurant);
        MenuItem risotto = new MenuItem("Risotto ai funghi", "Risotto con champiñones, queso parmesano y vino blanco", 19.99, "Platos principales", restaurant);
        MenuItem tiramisu = new MenuItem("Tiramisú", "Bizcochos de soletilla empapados en café, crema de mascarpone y cacao en polvo", 8.99, "Postres", restaurant);
        MenuItem pannaCotta = new MenuItem("Panna cotta", "Flan de nata con coulis de frutos rojos", 7.99, "Postres", restaurant);
        MenuItem cannoli = new MenuItem("Cannoli", "Tubos de masa frita rellenos de ricotta y decorados con frutas confitadas", 9.99, "Postres", restaurant);
        MenuItem gelato = new MenuItem("Gelato", "Helado italiano de varios sabores", 6.99, "Postres", restaurant);
        MenuItem affogato = new MenuItem("Affogato al caffè", "Helado de vainilla con un expreso caliente", 7.99, "Postres", restaurant);

        this.menuRepo.save(ensaladaCaprese);
        this.menuRepo.save(bruschetta);
        this.menuRepo.save(arancini);
        this.menuRepo.save(minestrone);
        this.menuRepo.save(parmigiana);
        this.menuRepo.save(pizzaMargherita);
        this.menuRepo.save(lasagna);
        this.menuRepo.save(spaghettiCarbonara);
        this.menuRepo.save(ravioli);
        this.menuRepo.save(risotto);
        this.menuRepo.save(tiramisu);
        this.menuRepo.save(pannaCotta);
        this.menuRepo.save(cannoli);
        this.menuRepo.save(gelato);
        this.menuRepo.save(affogato);

    }
}
