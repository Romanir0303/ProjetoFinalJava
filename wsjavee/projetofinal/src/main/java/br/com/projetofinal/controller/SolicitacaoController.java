package br.com.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.SolicitacaoDAO;
import br.com.projetofinal.model.Solicitacao;


@RestController
@CrossOrigin("*")
public class SolicitacaoController {
	
	
		@Autowired	
		private SolicitacaoDAO dao;
		
		   @PostMapping("/novasolicitacao")
		   public ResponseEntity<Solicitacao> add (@RequestBody Solicitacao solicitacao){
			   try {
			   Solicitacao resultado = dao.save(solicitacao);
			   return ResponseEntity.ok(resultado);
			   }catch (Exception e) {
				   e.printStackTrace();
				   return  ResponseEntity.status(500).build();
			   }}
			   
			   @PostMapping("/alteracaostatus")
			   public ResponseEntity<Solicitacao> alterarStatus (@RequestBody Solicitacao solicitacao){
				   try {
				   Solicitacao resultado = dao.findById(solicitacao.getNumSeq()).orElse(null);
				   if (resultado != null) {
					   resultado.setStatus(solicitacao.getStatus());
					   dao.save(resultado);
				   }
				   return ResponseEntity.ok(resultado);
				   }catch (Exception e) {
					   e.printStackTrace();
					   return  ResponseEntity.status(403).build();
				   } }
				   
				   @GetMapping("/porstatus/{status}")
				   public ResponseEntity<List<Solicitacao>>  getStatus(@PathVariable String status){
					   List<Solicitacao> lista;
				       
				        if (status.toUpperCase().equals("TODAS")) {
				            lista = (List<Solicitacao>) dao.findAll();
				        } else {
				            lista = dao.findByStatus(status);
				        }
					   if ( lista == null ) {
						   return ResponseEntity.status(404).build();
						  
					   }
					   
					   return ResponseEntity.ok(lista);
				   }
				   

			  
			   
			   }
		   


