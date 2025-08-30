package br.edu.infnet.arthurbarcellos_PB.model.domain;

import java.util.Date;

public abstract class Model {
	Long id;
	Date criadoEm;
	Date atualizadoEm;
	
	public void salvar() {}
	
	public void atualizar(Long id) {}
	
	public boolean deletar(Long id) {
		return false;
	}

}
