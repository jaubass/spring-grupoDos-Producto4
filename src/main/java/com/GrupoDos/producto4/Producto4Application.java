package com.GrupoDos.producto4;

import com.GrupoDos.producto4.model.User;
import com.GrupoDos.producto4.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.GrupoDos.producto4.model.Restaurant;
import com.GrupoDos.producto4.repository.RestaurantRepository;


@SpringBootApplication
public class Producto4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Producto4Application.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		User user1 = new User(null, "Marcus", "marcus@mail.com", "1234", "777666555", "NY", "08987");
		repository.save(user1);
		
		//Creamos restaurante
		RestaurantRepository repository2 = context.getBean(RestaurantRepository.class);		
		Restaurant restaurant1  = new Restaurant(null, "Casa Pepe", "pepefood@gmail.com", 999999999, "C/Pepe 10", "Linares", 99999, "pepefood.com");
		repository2.save(restaurant1);
		
		System.out.println(repository.findAll().size());
		// repository.deleteById(1L);



	}

}
