package br.com.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.MusicaDao;
import br.com.projetofinal.model.Musica;

@RestController
@CrossOrigin("*")
public class MusicaController {
	
	@Autowired	
	private MusicaDao dao;
	
	   @PostMapping("/novamusica")
	   public ResponseEntity<Musica> add (@RequestBody Musica musica){
		   try {
		   Musica resultado = dao.save(musica);
		   return ResponseEntity.ok(resultado);
		   }catch (Exception e) {
			   e.printStackTrace();
			   return  ResponseEntity.status(500).build();
		   }

}
	   }

