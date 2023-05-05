package com.GrupoDos.producto4;

import com.GrupoDos.producto4.model.User;
import com.GrupoDos.producto4.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Producto4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Producto4Application.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		User user1 = new User(null, "Marcus", "marcus@uoc.com", "1234", "777666555", "NY", "08987");
		User user2 = new User(null, "Jau", "jau@uoc.com", "12", "123456789", "BCN", "08016");

		repository.save(user1);
		repository.save(user2);
		System.out.println(repository.findAll().size());
		// repository.deleteById(1L);



	}

}
