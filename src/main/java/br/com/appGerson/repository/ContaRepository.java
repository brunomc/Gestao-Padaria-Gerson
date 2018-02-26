package br.com.appGerson.repository;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.appGerson.entity.Conta;

@Stateful
public class ContaRepository {
	@PersistenceContext
	EntityManager em;
	public List<Conta> listAll(){
		TypedQuery<Conta> query  = em.createQuery("select f from Conta f",Conta.class);
		return query.getResultList();
	}
	public void salvar(Conta conta) {
		em.persist(conta);
		
	}
	public void update(Conta conta) {
		Object c=em.merge(conta);
		em.persist(c);
	}
	
	public void deletar(Conta contaDlt) {
		Object c=em.merge(contaDlt);
		em.remove(c);
	}
	
}
