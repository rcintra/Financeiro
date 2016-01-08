package com.ccb.br.model;

import javax.persistence.Persistence;

public class InitDataBase {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("Financeiro");
	}
}
