package br.com.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.PdvDAO;
import br.com.projetofinal.model.Pdv;

@RestController //apontar para tomcast
@CrossOrigin("*")
public class PdvController {
	
	
	@Autowired	
	private PdvDAO dao;
	
	@GetMapping("/pdv/{id}")
	public ResponseEntity<Pdv> getPdv(@PathVariable int id) {
		Pdv resultado = dao.findById(id).orElse(null);
		if(resultado==null) {
			return ResponseEntity.status(404).build();
			
			
		}
		return ResponseEntity.ok(resultado);
	}
	
   @GetMapping("/pdvs")
   public ResponseEntity<List<Pdv>>getAllPdv(){
	   ArrayList<Pdv> resultado = (ArrayList<Pdv>) dao.findAll();
	   if ( resultado.size()==0) {
		   return ResponseEntity.status(404).build();
		   
	   }
	   return ResponseEntity.ok(resultado);
	   
   }
   

}


