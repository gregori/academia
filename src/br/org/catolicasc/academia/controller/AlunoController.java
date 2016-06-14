package br.org.catolicasc.academia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.org.catolicasc.academia.model.Aluno;
import br.org.catolicasc.academia.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	AlunoService service;
	
	@Autowired
	MessageSource messageSource;
	
	/*
	 * Este método lista todos os alunos
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listaAlunos(Model model) {
		List<Aluno> alunos = service.findAll();
		model.addAttribute("alunos", alunos);
		return "aluno/list";
	}
	
	/*
	 * Este método mostra o formulário para adição de usuários
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String novoAlunoForm(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		model.addAttribute("edicao", false);
		return "aluno/formAluno";
	}
	
	/*
	 * Este método será chamado ao enviar o formulário de criação
	 * de usuário, lidando com o método POST
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String gravaAluno(@Valid Aluno aluno, BindingResult resultado,
			Model model) {
		if (resultado.hasErrors()) {
			return "aluno/formAluno";
		}
		
		service.save(aluno);
		model.addAttribute("sucesso", "Aluno " + aluno.getNome() + " cadastrado com sucesso!");
		return "aluno/sucesso";
	}
	
	/*
	 * Este método mostra o formulário de edição de usuário
	 */
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editaAlunoForm(@PathVariable Long id, Model model) {
		Aluno aluno = service.findById(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("edicao", true);
		return "aluno/formAluno";
	}
	
	/*
	 * Esse chamado lida com a submissão POST da edição de usuário
	 */
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String gravaAlunoEdicao(@Valid Aluno aluno, @PathVariable Long id,
			BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			return "aluno/formAluno";
		}
		service.update(aluno);
		model.addAttribute("sucesso", "Aluno " + aluno.getNome() + " foi atualizado com sucesso.");
		return "aluno/sucesso";
	}
	
	/*
	 * Este método vai apagar um aluno pelo seu CPF (podia ser pelo ID também)
	 */
	@RequestMapping(value = { "/delete/{cpf}" }, method = RequestMethod.GET)
	public String apagaAluno(@PathVariable Long cpf) {
		service.deleteAlunoByCPF(cpf);
		return "redirect:/aluno/list";
	}
	
	
}
