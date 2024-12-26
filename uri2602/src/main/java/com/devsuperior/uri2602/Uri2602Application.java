package com.devsuperior.uri2602;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerDTO;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	private CustomerRepository repository;

	public Uri2602Application(CustomerRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerDTO> list = repository.searchByState("rs");
		System.out.println("----------RESULTADO----------");
		list.forEach(obj -> System.out.println(obj.getName()));
	}
}
