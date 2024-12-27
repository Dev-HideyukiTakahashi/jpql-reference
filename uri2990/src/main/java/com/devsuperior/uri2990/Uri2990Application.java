package com.devsuperior.uri2990;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<EmpregadoDeptProjection> list = repository.search1();
		List<EmpregadoDeptDTO> dto = list.stream().map(x -> new EmpregadoDeptDTO(x)).toList();
		System.out.println("----------RESULTADO SQL----------");
		dto.forEach(obj -> System.out.println(obj));
		List<EmpregadoDeptDTO> list2 = repository.search2();
		System.out.println("----------RESULTADO JPQL----------");
		list2.forEach(obj -> System.out.println(obj));
	}
}
