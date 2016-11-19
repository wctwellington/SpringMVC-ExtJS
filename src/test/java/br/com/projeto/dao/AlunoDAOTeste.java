package br.com.projeto.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.projeto.model.Aluno;

public class AlunoDAOTeste {

	private Aluno aluno;
	
	private AlunoDAO alunoDAO;

	public AlunoDAOTeste() { 
		this.aluno = new Aluno(); 
		this.alunoDAO = new AlunoDAO();
	}
	
	@Ignore
	public void createAluno() {
		aluno.setNome("Wellington Cruz Tavares");
		aluno.setTelefone("(11) 2566-8492");
		aluno.setEndereco("Est. Dom João Nery, 2433");
		alunoDAO.create(aluno);
	}
	
	@Ignore
	public void updateAluno() {
		aluno = alunoDAO.read(new Long(14));
		aluno.setNome("Everton Cruz Tavares");
		aluno.setEndereco("Rua Big Boys, 145");
		aluno.setTelefone("(11) 2512-1212");
		alunoDAO.create(aluno);
	}
	
	@Ignore
	public void readAluno() {
		aluno = alunoDAO.read(new Long(5));
		System.out.println(aluno.toString());
	}
	
	@Ignore
	public void deleteAluno() {
		aluno = alunoDAO.read(new Long(5));
		alunoDAO.delete(aluno);
	}
	
	@Test
	public void lerAlunos() {
		List<Aluno> alunos = alunoDAO.readAll();
		for(Aluno a : alunos) {
			System.out.println(a.toString());
		}
	}

}
