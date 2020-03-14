package com.formacionbdi.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

/**
 * Interface que hereda para realizar la gestion hacia la BD. Muestra dos
 * maneras de realizar metodos para acceder a la base de datos.
 */
@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

	/**
	 * Realiza una consulta JPA a la tabla Usuario dependiendo de su UserName.
	 * Utiliza las palabras clave de JPA por Method.
	 * 
	 * URL: para acceder a este metodo.
	 * http://localhost:8090/api/usuarios/usuarios/search/buscar-username?nombre=admin
	 * 
	 * @param String username
	 * @return Class Usuario
	 */
	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param("username") String username);

	/**
	 * Methodo que busca un usuario. Se implementa con la etiqueta @Query y se
	 * define el query. La consulta se realiza a nivel de Entity no a nivel de las
	 * tablas.
	 * 
	 * URR: para acceder a este metodo.
	 * http://localhost:8090/api/usuarios/usuarios/search/obtenerPorUsername?username=admin
	 * 
	 * @param username
	 * @return
	 */
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);

}
