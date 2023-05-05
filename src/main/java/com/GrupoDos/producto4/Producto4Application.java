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

		User user1 = new User(null, "Marcus", "marcus@mail.com", "1234", "777666555", "NY", "08987");
		repository.save(user1);
		System.out.println(repository.findAll().size());
		// repository.deleteById(1L);



	}

}
