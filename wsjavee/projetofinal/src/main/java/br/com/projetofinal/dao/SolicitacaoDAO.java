package br.com.projetofinal.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projetofinal.model.Solicitacao;

public interface SolicitacaoDAO extends CrudRepository<Solicitacao,Integer>{
		
		public  List<Solicitacao> findByStatus(String status );
	
}
