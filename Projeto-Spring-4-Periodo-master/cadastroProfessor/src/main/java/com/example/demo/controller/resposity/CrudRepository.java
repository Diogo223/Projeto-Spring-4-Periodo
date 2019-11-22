package com.example.demo.controller.resposity;

import org.springframework.ui.Model;

import com.example.demo.controller.model.Professor;

public interface CrudRepository extends org.springframework.data.repository.CrudRepository<Professor, Long>{

	void findById(Integer id);

	void save(Model model);

}
