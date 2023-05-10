package com.GrupoDos.producto4;

import com.GrupoDos.producto4.model.MenuItem;
import com.GrupoDos.producto4.model.User;
import com.GrupoDos.producto4.repository.MenuItemRepository;
import com.GrupoDos.producto4.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.GrupoDos.producto4.model.Restaurant;
import com.GrupoDos.producto4.repository.RestaurantRepository;

import java.util.Optional;


@SpringBootApplication
public class Producto4Application {

	public static void main(String[] args) {
		// Context
		ApplicationContext context = SpringApplication.run(Producto4Application.class, args);

		// Users
		UserRepository repoUser = context.getBean(UserRepository.class);
		User user1 = new User(null, "Marcus", "marcus@uoc.com", "1234", "777666555", "NY", "08987");
		User user2 = new User(null, "Jau", "jau@uoc.com", "12", "123456789", "BCN", "08016");
		repoUser.save(user1);
		repoUser.save(user2);

		// Restaurants
		RestaurantRepository repoRestaurants = context.getBean(RestaurantRepository.class);
		Restaurant restaurant1  = new Restaurant(null, "Casa Pepe", "pepefood@gmail.com", "999999999", "C/Pepe 10", "Linares", "99999", "pepefood.com");
		repoRestaurants.save(restaurant1);

		// Menu Items
		// Create menuItems, if they don't exist
		MenuItemRepository repoMenu = context.getBean(MenuItemRepository.class);
		Optional<MenuItem> optMenuItem = repoMenu.findById(1L);
		if (optMenuItem.isEmpty()) {

			Restaurant restaurant = repoRestaurants.findById(1L).get();

			MenuItem ensaladaCaprese = new MenuItem( null, "Ensalada Caprese", "Tomates, mozzarella fresca y albahaca", 10.99, "Entrantes ", restaurant);
			MenuItem bruschetta = new MenuItem(null, "Bruschetta de tomate y albahaca", "Rebanadas de pan tostado, tomates, ajo y albahaca", 8.99, "Entrantes  ", restaurant);
			MenuItem arancini = new MenuItem(null, "Arancini de risotto", "Bolitas de risotto rellenas de queso mozzarella y fritas", 12.99, "Entrantes  ", restaurant);
			MenuItem minestrone = new MenuItem(null, "Minestrone", "Sopa de verduras con pasta y frijoles", 9.99, "Entrantes  ", restaurant);
			MenuItem parmigiana = new MenuItem(null, "Parmigiana di melanzane", "Berenjenas fritas con salsa de tomate, mozzarella y parmesano", 16.99, "Platos principales  ", restaurant);
			// Otros ejemplos de platos principales:
			MenuItem pizzaMargherita = new MenuItem(null, "Pizza Margherita", "Mozzarella, tomate y albahaca", 14.99, "Platos principales  ", restaurant);
			MenuItem lasagna = new MenuItem(null, "Lasagna alla bolognese", "Lasagna con carne picada, salsa boloñesa y queso parmesano", 18.99, "Platos principales  ", restaurant);
			MenuItem spaghettiCarbonara = new MenuItem(null, "Spaghetti alla carbonara", "Spaghetti con huevo, panceta, queso pecorino y pimienta negra", 17.99, "Platos principales  ", restaurant);
			MenuItem ravioli = new MenuItem(null, "Ravioli di ricotta e spinaci", "Ravioli rellenos de ricotta y espinacas con salsa de tomate", 20.99, "Platos principales  ", restaurant);
			MenuItem risotto = new MenuItem(null, "Risotto ai funghi", "Risotto con champiñones, queso parmesano y vino blanco", 19.99, "Platos principales  ", restaurant);
			MenuItem tiramisu = new MenuItem(null, "Tiramisú", "Bizcochos de soletilla empapados en café, crema de mascarpone y cacao en polvo", 8.99, "Postres  ", restaurant);
			MenuItem pannaCotta = new MenuItem(null, "Panna cotta", "Flan de nata con coulis de frutos rojos", 7.99, "Postres  ", restaurant);
			MenuItem cannoli = new MenuItem(null, "Cannoli", "Tubos de masa frita rellenos de ricotta y decorados con frutas confitadas", 9.99, "Postres  ", restaurant);
			MenuItem gelato = new MenuItem(null, "Gelato", "Helado italiano de varios sabores", 6.99, "Postres  ", restaurant);
			MenuItem affogato = new MenuItem(null, "Affogato al caffè", "Helado de vainilla con un expreso caliente", 7.99, "Postres  ", restaurant);

			repoMenu.save(ensaladaCaprese);
			repoMenu.save(bruschetta);
			repoMenu.save(arancini);
			repoMenu.save(minestrone);
			repoMenu.save(parmigiana);
			repoMenu.save(pizzaMargherita);
			repoMenu.save(lasagna);
			repoMenu.save(spaghettiCarbonara);
			repoMenu.save(ravioli);
			repoMenu.save(risotto);
			repoMenu.save(tiramisu);
			repoMenu.save(pannaCotta);
			repoMenu.save(cannoli);
			repoMenu.save(gelato);
			repoMenu.save(affogato);
		}

		System.out.println("\nI am ready to serve!");

	}

}
