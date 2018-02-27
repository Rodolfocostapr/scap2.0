package br.ufes.scap.persistency;

import java.util.List;

import br.ufes.scap.domain.Pessoa;

public interface PessoaDAO {

	public Pessoa buscaMatricula(String Matricula);

	public Pessoa buscaId(Long id_pessoa);

	public List<Pessoa> buscaNome(String nome, String sobreNome);

	public List<Pessoa> listaProfessores();

	public void salvar(Pessoa pessoa);
}
