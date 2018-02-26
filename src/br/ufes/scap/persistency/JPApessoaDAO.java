package br.ufes.scap.persistency;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import org.springframework.stereotype.Repository;

import br.ufes.scap.domain.Pessoa;

@Repository("pessoaDAO")
public class JPApessoaDAO extends BaseDAO<Integer, Pessoa> implements PessoaDAO {

	@Override
	public Pessoa buscaMatricula(String matricula) {

		Pessoa pessoa = new Pessoa();
		try {
			Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.matricula = " + matricula);
			pessoa = (Pessoa) q.getSingleResult();
			return pessoa;
		} catch (NoResultException e1) {
			System.out.println("Pessoa inexistente");
		} catch (NonUniqueResultException e2) {
			System.out.println("Mais de uma pessoa cadastada com a mesma matricula");
		} catch (QueryTimeoutException e3) {
			System.out.println("Query timmed out");
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public Pessoa buscaId(Long id_pessoa) {
		Pessoa pessoa = new Pessoa();
		try {
			Query q = entityManager.createQuery("SELECT a FROM Pessoa a WHERE a.id_pessoa = " + id_pessoa);
			pessoa = (Pessoa) q.getSingleResult();
			return pessoa;
		} catch (NoResultException e1) {
			System.out.println("Pessoa inexistente");
		} catch (QueryTimeoutException e3) {
			System.out.println("Query timmed out");
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Pessoa> listaProfessores() {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try {
			Query q = entityManager.createQuery("SELECT a FROM Pessoa a WHERE a.tipoPessoa = 1");
			lista = q.getResultList();
			return lista;
		} catch (NoResultException e1) {
			System.out.println("Pessoa inexistente");
		} catch (QueryTimeoutException e3) {
			System.out.println("Query timmed out");
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Pessoa> buscaNome(String nome, String sobreNome) {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try {
			Query q = entityManager.createQuery(
					"SELECT a FROM Pessoa a WHERE a.nome = '" + nome + "' AND a.sobreNome = '" + sobreNome + "'");
			lista = q.getResultList();
			return lista;
		} catch (NoResultException e1) {
			System.out.println("Pessoa inexistente");
		} catch (QueryTimeoutException e3) {
			System.out.println("Query timmed out");
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		return null;
	}

}
