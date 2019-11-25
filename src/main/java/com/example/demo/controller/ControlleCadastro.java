package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.model.Professor;
import com.example.demo.controller.resposity.CrudRepository;

@Controller
public class ControlleCadastro {
	@Autowired
	CrudRepository crudRepository;


	
	@RequestMapping("/cad")
	public String home(Model model) {
		model.addAttribute("professor", crudRepository.findAll());
		return "cadastro.html";
	}
	
	
	@PostMapping("/cadastro")
	public Object salvar(@Valid Professor professor, RedirectAttributes attributes) {
			
		crudRepository.save(professor);
		attributes.addFlashAttribute("mensagen","Cadastrado com sucesso.");
		return "redirect:/cad";
	}
	
	
		
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		crudRepository.deleteById(id);
		return "redirect:/cad";
		
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("professor", crudRepository.findById(id));
		return "editar.html";
		
	}
}
	
