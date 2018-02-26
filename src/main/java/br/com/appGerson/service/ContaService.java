package br.com.appGerson.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.appGerson.entity.Conta;
import br.com.appGerson.repository.ContaRepository;

@Stateless
public class ContaService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	ContaRepository contaRepository;
	
	public List<Conta>  listAll(){
		return contaRepository.listAll();
	}

	public void salvar(Conta conta) {
		contaRepository.salvar(conta);
		
	}
	public void update(Conta conta) {
		contaRepository.update(conta);		
	}

	public void deletar(Conta contaDlt) {
		contaRepository.deletar(contaDlt);
		
	}

	
}
