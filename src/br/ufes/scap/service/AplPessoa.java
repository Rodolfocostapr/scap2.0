package br.ufes.scap.service;

import java.util.List;

import br.ufes.scap.domain.Pessoa;

public interface AplPessoa {
	void salvar(Pessoa novoUsuario);

	Pessoa buscaMatricula(String matricula);

	List<Pessoa> buscaNome(String nome, String sobreNome);
}