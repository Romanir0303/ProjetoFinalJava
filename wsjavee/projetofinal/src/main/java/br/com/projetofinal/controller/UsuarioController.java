package br.com.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.UsuarioDAO;
import br.com.projetofinal.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired	
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")	// chamar pelo brouser
	public ResponseEntity<List<Usuario>> getAllUsers(){
		ArrayList<Usuario> lista = (ArrayList<Usuario>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);		
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUser(@PathVariable int id) {
		Usuario resposta = dao.findById(id).orElse(null);
		if (resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> logar(@RequestBody Usuario user){
		Usuario resposta = dao.findByEmailAndSenha(user.getEmail(), user.getSenha());
		if(resposta==null) {
			resposta = dao.findByRacfAndSenha(user.getRacf(), user.getSenha());
			if(resposta==null) {
			return ResponseEntity.status(401).build();
			}
		}
		return ResponseEntity.ok(resposta);
	}
	
}
