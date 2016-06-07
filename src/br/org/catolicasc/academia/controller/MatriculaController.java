package br.org.catolicasc.academia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.catolicasc.academia.dao.MatriculaDAO;
import br.org.catolicasc.academia.model.Matricula;

@RequestMapping("/matricula")
public class MatriculaController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		MatriculaDAO matricula = new MatriculaDAO();
		List<Matricula> matriculas = matricula.findAll();
		return new ModelAndView("matricula/index").addObject("matriculas", matriculas);
	}
	

}
