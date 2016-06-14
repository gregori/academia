package br.org.catolicasc.academia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.org.catolicasc.academia.model.Matricula;
import br.org.catolicasc.academia.service.MatriculaService;

@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	MatriculaService service;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listaMatriculas(Model model) {
//		List<Matricula> matriculas = service.findAll();
//		model.addAttribute("matriculas", matriculas);
		return "aluno/list";
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String novaMatriculaForm(Model model) {
		Matricula matricula = new Matricula();
		model.addAttribute("matricula", matricula);
		model.addAttribute("edicao", false);
		return "matricula/formMatricula";
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String gravaMatricula(@Valid Matricula matricula, BindingResult resultado,
			Model model) {
		if (resultado.hasErrors()) {
			return "matricula/formMatricula";
		}
		
		service.save(matricula);
		model.addAttribute("sucesso", "Matricula cadastrada com sucesso!");
		return "matricula/sucesso";
	}
	
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editaMatriculaForm(@PathVariable long id, Model model) {
		Matricula matricula = service.findById(id);
		model.addAttribute("matricula", matricula);
		model.addAttribute("edicao", true);
		return "matricula/formMatricula";
	}
	
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String gravaMatriculaEdicao(@Valid Matricula matricula, @PathVariable int id,
			BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			return "matricula/formMatricula";
		}
		service.update(matricula);
		model.addAttribute("sucesso", "Matricula foi atualizado com sucesso.");
		return "matricula/sucesso";
	}
	
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String apagaMatricula(@PathVariable long id) {
		service.delete(id);
		return "redirect:/matricula/list";
	}
	
	

}
