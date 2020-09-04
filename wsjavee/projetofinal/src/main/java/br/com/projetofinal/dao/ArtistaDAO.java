package br.com.projetofinal.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.model.Artista;

	
	
	public interface ArtistaDAO extends CrudRepository<Artista,Integer>{
				
		public  List<Artista> findByNacionalidade(String nacionalidade );
		
			
	}
	


