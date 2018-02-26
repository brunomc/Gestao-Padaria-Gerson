package br.com.appGerson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.appGerson.entity.Unidade;
import br.com.appGerson.service.UnidadeService;

@ViewScoped
@ManagedBean
public class UnidadeBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	UnidadeService unidadeService;
	
	private Unidade unidade;
	
	@PostConstruct
    public void init() {
		unidade = new Unidade();
    }
	public void salvar() {
		unidadeService.salvar(unidade);
		
	}
	public List<Unidade> listAll() {
		return unidadeService.listAll();
		
	}
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	

}
