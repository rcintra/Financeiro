package com.ccb.br.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ccb.br.model.Pessoa;

public class Pessoas implements Serializable {

	private static final long serialVersionUID = 3253054482349405921L;
	private EntityManager manager;
	
	@Inject
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todas() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}
}
