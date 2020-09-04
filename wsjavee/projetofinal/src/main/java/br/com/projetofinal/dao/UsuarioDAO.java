package br.com.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.model.Usuario;

/*
 * CRUD = Create  Read Update Delete
 * DAO = Data Acess Ojtect = o CRUD SEMPRE deve estar no DAO.
 */

public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{
	
	public Usuario findByEmailAndSenha(String email, String senha); //localiza por essa linha e coluna
	
	public Usuario findByRacfAndSenha(String racf, String senha);	
		
}
