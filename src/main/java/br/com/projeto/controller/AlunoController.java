package br.com.projeto.controller;

import java.util.List;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projeto.dao.AlunoDAO;
import br.com.projeto.model.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Inject
	private AlunoDAO alunoDao;
	
	@RequestMapping(value = "/salvarAluno", method = RequestMethod.POST)
	@ResponseBody
	public String salvarAluno(@RequestBody Aluno aluno) {
		try {
			alunoDao.create(aluno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "Aluno salvo com sucesso";
	}
	
	@RequestMapping(value = "/deletarAluno", method = RequestMethod.POST)
	@ResponseBody
	public String deletarAluno(@RequestBody Aluno aluno) {
		try {
			alunoDao.delete(aluno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "Aluno deletado com sucesso";
	}
	
	@RequestMapping(value = "/lerAlunos")
	@ResponseBody
	 public String lerAlunos() {
		try {
			JSONObject jsonRetorno = new JSONObject();
			JSONArray arrayAlunos = new JSONArray();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			List<Aluno> listAlunos = alunoDAO.readAll();
			for (Aluno aluno : listAlunos) {
				JSONObject jsonObject = new JSONObject(aluno);
				arrayAlunos.put(jsonObject);
			}

			jsonRetorno.put("listaDeAlunos", arrayAlunos);
			jsonRetorno.put("success", true);
				
			return jsonRetorno.toString();
							
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
