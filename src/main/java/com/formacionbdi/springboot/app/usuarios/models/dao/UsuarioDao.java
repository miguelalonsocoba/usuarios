package com.formacionbdi.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.formacionbdi.springboot.app.usuarios.models.entity.Usuario;

/**
 * Interface que hereda para realizar la gestion hacia la BD.
 */
@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

	/**
	 * Realiza una consulta JPA a la tabla Usuario dependiendo de su UserName.
	 * Utiliza las palabras clave de JPA por Method.
	 * 
	 * @param String username
	 * @return Class Usuario
	 */
	public Usuario findByUsername(String username);

	/**
	 * Methodo que busca un usuario. Se implementa con la etiqueta @Query y se
	 * define el query. La consulta se realiza a nivel de Entity no a nivel de las
	 * tablas.
	 * 
	 * @param username
	 * @return
	 */
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);

}
