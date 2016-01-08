package com.ccb.br.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class NomesBean {

	private String nome;
	private List<String> nomes = new ArrayList<String>();
	
	private HtmlInputText inputNome;
	private HtmlCommandButton botaoAdicionar;
	
	public void adicionar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (nome.isEmpty() || nome.trim().isEmpty()) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validação.",
					"Por favor, preencher o campo nome.");
			context.addMessage(null, mensagem);
			return;
		}
		
		this.nomes.add(nome);
		
		if (this.nomes.size() > 3) {
			this.inputNome.setDisabled(true);
			this.botaoAdicionar.setDisabled(true);
			this.botaoAdicionar.setValue("Muitos nomes adicionados...");
		}
		
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
				"Cliente " + this.nome + " cadastrado com sucesso.");
		context.addMessage(null, mensagem);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getNomes() {
		return nomes;
	}

	public HtmlInputText getInputNome() {
		return inputNome;
	}

	public void setInputNome(HtmlInputText inputNome) {
		this.inputNome = inputNome;
	}

	public HtmlCommandButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
		this.botaoAdicionar = botaoAdicionar;
	}
	
}
