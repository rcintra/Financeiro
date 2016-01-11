package com.ccb.br.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.ccb.br.model.Lancamento;
import com.ccb.br.repository.Lancamentos;
import com.ccb.br.util.Transactional;

public class CadastroLancamentos implements Serializable {

	private static final long serialVersionUID = 6433616296694864629L;
	
	@Inject
	private Lancamentos lancamentos;

	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException { 
		if (lancamento.getDataPagamento() != null 
				&& lancamento.getDataPagamento().after(new Date())) {
				throw new NegocioException(
					"Data de pagamento não pode ser uma data futura.");
			}
			this.lancamentos.adicionar(lancamento);
		}
}