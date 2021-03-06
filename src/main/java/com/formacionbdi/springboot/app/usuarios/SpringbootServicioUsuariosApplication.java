package com.formacionbdi.springboot.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Se agrega la etiqueta de @EntityScan para que el contexto de Spring Data JPA
 * pueda encontrar las Entitys.
 * 
 * @author ACER 141119
 *
 */
@EntityScan({ "com.formacionbdi.springboot.app.commons.usuarios.models.entity" })
@SpringBootApplication
public class SpringbootServicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioUsuariosApplication.class, args);
	}

}
