package br.org.catolicasc.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.org.catolicasc.academia.model.Presenca;

import br.org.catolicasc.academia.service.PresencaService;

@Controller
@RequestMapping("/presenca")

public class PresencaController {
	@Autowired
	PresencaService service;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listaPresenca(Model model) {
		List<Presenca> presencas = service.findAll();
		model.addAttribute("presencas", presencas);
		return "presenca/lista";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String novaPresencaForm(Model model) {
		Presenca presenca = new Presenca();
		model.addAttribute("presenca", presenca);
		model.addAttribute("edicao", false);
		return "presenca/formPresenca";
	}

	@RequestMapping(value = { "/ver/{id}" }, method = RequestMethod.GET)
	public String verPresencaForm(@PathVariable Long id, Model model) {
		Presenca presenca = service.findById(id);
		model.addAttribute("presenca", presenca);
		model.addAttribute("ver", true);
		return "presenca/formVerPresenca";
	}

}