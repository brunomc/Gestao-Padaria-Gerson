package br.com.appGerson.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.appGerson.entity.Unidade;
@Stateless
public class UnidadeRepository {
	@PersistenceContext
	EntityManager em;
	public List<Unidade> listAll(){
		TypedQuery<Unidade> query  = em.createQuery("select f from Unidade f",Unidade.class);
		return query.getResultList();
	}
	public Unidade listById(long id) {
		TypedQuery<Unidade> query  = em.createQuery("select f from Unidade f where id=:id",Unidade.class);
		query.setParameter(":id", id);
		System.out.println("oj");
		return query.getSingleResult();
	}
	public void update(Unidade f) {
		Object c=em.merge(f);
		em.persist(c);
		
	}
	
	public void salvar(Unidade unidade) {
		em.persist(unidade);
		
	}
	

}
