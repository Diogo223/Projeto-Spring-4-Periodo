package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.model.Professor;
import com.example.demo.controller.resposity.CrudRepository;

@Controller
public class ControlleCadastro {
	@Autowired
	CrudRepository crudRepository;

	
	 @GetMapping("/userCad")
	  public String login( Model model) {
		model.addAttribute("professor", crudRepository.findAll());
	    return "cadastroUser.html";
	  }
	 @GetMapping("/cadastroUsers")
		public Object salvarUser(@Valid Professor professor, BindingResult result, RedirectAttributes attributes) {
			if (result.hasErrors()) {
				
	 		}
			crudRepository.save(professor);
			attributes.addFlashAttribute("mensagen","Cadastrado com sucesso.");
			return "/userCad";
		}
	 @GetMapping("/sobre")
	  public String sobre() {
	    return "sobre.html";
	  }
	@GetMapping("/cad")
	public String home(Model model) {
		model.addAttribute("professor", crudRepository.findAll());
		return "cadastro.html";
	}
	 
	@GetMapping("/cadastro")
	public Object salvar(@Valid Professor professor, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			
 		}
		crudRepository.save(professor);
		attributes.addFlashAttribute("mensagen","Cadastrado com sucesso.");
		return "redirect:/userCad";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
		crudRepository.deleteById(id);	
		attributes.addFlashAttribute("txt","Excluído com sucesso.");
		return "redirect:/cad";
		
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
		model.addAttribute("professor", crudRepository.findById(id));
		attributes.addFlashAttribute("texto","Editado com sucesso.");
		return "editar";	
	}	
	
	@GetMapping("/user")
	public String usHome(Model user) {
		user.addAttribute("professor", crudRepository.findAll());
		return "cadastro.html";
	}
	 
	@GetMapping("/cadUser")
	public Object usSalvar(@Valid Professor professor, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			
 		}
		crudRepository.save(professor);
		attributes.addFlashAttribute("mensagen","Cadastrado com sucesso.");
		return "redirect:/user";
	}
		  
	
}
	
