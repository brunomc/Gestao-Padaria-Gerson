package br.com.appGerson.service;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.appGerson.entity.Unidade;
import br.com.appGerson.repository.UnidadeRepository;
@Stateless
public class UnidadeService {
	@Inject
	UnidadeRepository unidadeRepository;
	
	public void update(Unidade f) throws ExecutionException {
		unidadeRepository.update(f);
	}
	
	public Unidade listById(Long l) throws ExecutionException {
		return unidadeRepository.listById(l);
	}
	public List<Unidade> listAll(){
		return unidadeRepository.listAll();
	}
	public void salvar(Unidade unidade) {
		unidadeRepository.salvar(unidade);		
	}
}





