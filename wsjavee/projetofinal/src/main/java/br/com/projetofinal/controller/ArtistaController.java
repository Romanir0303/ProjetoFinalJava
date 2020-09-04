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

import br.com.projetofinal.dao.ArtistaDAO;
import br.com.projetofinal.model.Artista;

@RestController //apontar para tomcast
@CrossOrigin("*")
public class ArtistaController {
	
	@Autowired	
	private ArtistaDAO dao;
	
	@GetMapping("/artista/{id}")
	public ResponseEntity<Artista> getArtista(@PathVariable int id) {
		Artista resultado = dao.findById(id).orElse(null);
		if(resultado==null) {
			return ResponseEntity.status(404).build();
			
			
		}
		return ResponseEntity.ok(resultado);
	}
	
   @GetMapping("/artistas")
   public ResponseEntity<List<Artista>>getAllArtista(){
	   ArrayList<Artista> resultado = (ArrayList<Artista>) dao.findAll();
	   if ( resultado.size()==0) {
		   return ResponseEntity.status(404).build();
		   
	   }
	   return ResponseEntity.ok(resultado);
	   
   }
   
   @GetMapping("/pornacionalidade/{nacionalidade}")
   public ResponseEntity<List<Artista>>  getArtistaNacionalidade(@PathVariable String nacionalidade){
	   ArrayList<Artista> lista = (ArrayList<Artista>) dao.findByNacionalidade(nacionalidade);
	   if ( lista.size()==0) {
		   return ResponseEntity.status(404).build();
		  
	   }
	   return ResponseEntity.ok(lista);
   }
   
   @PostMapping("/novoartista")
   public ResponseEntity<Artista> add (@RequestBody Artista artista){
	   try {
	   Artista resultado = dao.save(artista);
	   return ResponseEntity.ok(resultado);
	   }catch (Exception e) {
		   e.printStackTrace();
		   return  ResponseEntity.status(500).build();
	   }
	   
	   
   }
}
