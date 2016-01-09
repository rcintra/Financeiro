package com.ccb.br.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.ccb.br.model.Lancamento;
import com.ccb.br.repository.Lancamentos;
import com.ccb.br.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Lancamento> lancamentos;

	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		Lancamentos lancamentos = new Lancamentos(manager);
		
		this.lancamentos = lancamentos.todos();
		
		manager.close();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
