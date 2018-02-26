package br.com.appGerson.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.com.appGerson.entity.Conta;
import br.com.appGerson.entity.Unidade;
import br.com.appGerson.service.ContaService;
import br.com.appGerson.service.UnidadeService;

@ManagedBean
@SessionScoped
public class ContaBean {
	@Inject
	ContaService contaService;
	@Inject
	UnidadeService unidadeService;
	
	private Conta conta;
	private Conta contaEdit;
	private List<Conta> contas;
	private List<String> tipos;
	private List<String> status;
	private List<Unidade> unidades;
	private Unidade unidade;


	@PostConstruct
    public void init() {
		try {
			contas = contaService.listAll();
			conta = new Conta();
			contaEdit = new Conta();
			unidade = new Unidade();
			unidades = unidadeService.listAll();
			System.out.println(unidades.get(0));
			tipos = new ArrayList<String>();
			status = new ArrayList<String>();
			tipos.add("PAGAR");
			tipos.add("RECEBER");
			status.add("Em Aberto");
			status.add("Finalizado");
		} catch (ExceptionInInitializerError e) {
			
		}
		
    }
	public void salvarUnidade() {
		unidadeService.salvar(unidade);
		init();
	}
	public void salvar(){
		if(conta!= null) {
			contaService.salvar(conta);
			contas = contaService.listAll();
			conta = new Conta();
		}else {
			
		}
	}
	public void populaEdit(Conta conta) {
		if(conta != null) {
			 contaEdit = conta;
		     RequestContext.getCurrentInstance().execute("PF('dlg3').show();");
		     RequestContext.getCurrentInstance().update("formEditar");
			
		}
	}
	public void update() throws ExecutionException{
		if(contaEdit!= null && contaEdit.getId()!=null) {
			    contaEdit.setBla(contaEdit.getUnidade().getBalance());
			    if(contaEdit.getStatus().equals("Finalizado")) {
				    if(contaEdit.getTipo().equals("PAGAR")) {
				    	if(contaEdit.getUnidade().getBalance() > 0 && contaEdit.getUnidade().getBalance() >= contaEdit.getValor()) {
					    	contaEdit.setBlp(contaEdit.getBla()-contaEdit.getValor());
					    	contaEdit.getUnidade().setBalance(contaEdit.getBla()-contaEdit.getValor());
					    	unidadeService.update(contaEdit.getUnidade());
				    	}
				    }else {
				    	contaEdit.setBlp(contaEdit.getBla()+contaEdit.getValor());
				    	contaEdit.getUnidade().setBalance(contaEdit.getBla()+contaEdit.getValor());
				    	unidadeService.update(contaEdit.getUnidade());
				    }
			    }
				contaService.update(contaEdit);
		}
		
	}
	
	public void deletar(Conta contaDlt){
		if(contaDlt!= null) {
			contaService.deletar(contaDlt);
			contas = contaService.listAll();
		}else {
		}
		
	}
	
	public List<Conta> listAll(){
		return contaService.listAll();
	}
	public List<Unidade> listAllUnd() {
		return unidadeService.listAll();
		
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public List<String> getTipos() {
		return tipos;
	}


	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public Conta getContaEdit() {
		return contaEdit;
	}

	public void setContaEdit(Conta contaEdit) {
		this.contaEdit = contaEdit;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
}
